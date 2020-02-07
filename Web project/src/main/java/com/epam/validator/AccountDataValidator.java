package com.epam.validator;

import com.epam.model.dto.entity.Account;
import com.epam.service.AccountService;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class AccountDataValidator {
    private static final Pattern MAILBOX_PATTERN = Pattern.compile("(\\w){3,30}\\@(\\w){3,15}\\.(com|ru|by|net|)");
    public boolean isLoginValid(String login) {
        if (login == null){
            return false;
        }
        if (login.isEmpty()) {
            return false;
        }
        AccountService service = new AccountService();
        Optional<Account> possibleCollision = service.getByLogin(login);
        return !possibleCollision.isPresent();
    }

    public boolean isMailBoxValid(String mailbox) {
        if (mailbox == null){
            return false;
        }
        //Mailbox is not necessary, so it can be empty
        if (mailbox.isEmpty()){
            return true;
        }
        Matcher matcher = MAILBOX_PATTERN.matcher(mailbox);
        return matcher.matches();
    }
    public boolean isTotalPointsValid(String totalPoints){
        if (totalPoints==null){
            return false;
        }
        try {
            long value = Long.parseLong(totalPoints);
            return value > 0 && value <= 400;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isTotalPointsValid(Long totalPoints){
        return totalPoints > 0 && totalPoints <= 400;
    }

    public boolean isPasswordCorrect(String password){
        if (password==null){
            return false;
        }
        return !password.isEmpty();
    }

    public boolean validateAll(String login, String password, String mailbox, String totalPoints){
        return isLoginValid(login) & isMailBoxValid(mailbox) & isTotalPointsValid(totalPoints) & isPasswordCorrect(password);
    }
}
