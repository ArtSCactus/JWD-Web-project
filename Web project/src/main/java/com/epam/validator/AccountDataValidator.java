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
    private static final Pattern MAILBOX_PATTERN = Pattern.compile("(\\w){3,30}\\@(\\w){2,15}\\.(com|ru|by|net|)");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[А-Яа-яA-Za-z0-9\\s]{2,20}$");
    private static final Pattern LOGIN_PATTERN = Pattern.compile("^[A-za-z0-9_-]{2,20}$");
    public boolean isLoginValid(String login) {
        if (login == null){
            return false;
        }
        if (login.isEmpty()) {
            return false;
        }
        Matcher matcher = LOGIN_PATTERN.matcher(login.replaceAll("\\s+",""));
        if (matcher.matches()) {
            AccountService service = new AccountService();
            Optional<Account> possibleCollision = service.getByLogin(login);
            return !possibleCollision.isPresent();
        } else {
            return false;
        }
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

    public boolean isNameCorrect(String name){
        if (name == null || name.isEmpty()){
            return false;
        }
        Matcher matcher = NAME_PATTERN.matcher(name);
        return matcher.matches();
    }

    public boolean validateAll(String login, String password, String mailbox, String totalPoints,
                               String firstName,
                               String secondName,
                               String thirdName){
        return isLoginValid(login)
                & isMailBoxValid(mailbox)
                & isTotalPointsValid(totalPoints)
                & isPasswordCorrect(password)
                & isNameCorrect(firstName)
                & isNameCorrect(secondName)
                & isNameCorrect(thirdName);
    }
}
