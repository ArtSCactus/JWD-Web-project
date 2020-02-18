package com.epam.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountDataValidatorTest {
    private AccountDataValidator validator = new AccountDataValidator();
    @DataProvider(name="logins")
    public Object[][] getLogins(){
        return new Object[][]{
            {"NickName",true},
                {"Inco$$ectNick name", false},
                {"Wrong%symbols^*)_here", false},
                {"Hey_this_is_normal_nickname", false}, //out of bounds (more than 20 symbols)
                {"Normal_too95", true},
                {"Absolutely_norm_nick", true}
        };
    }
    @DataProvider(name = "mailboxes")
    public Object[][] getMailboxes(){
        return new Object[][]{
                {"mailbox@email.com", true},
                {"Not$%@mail.", false}
        };
    }

    @DataProvider(name="Total points")
    public Object[][] getLimits(){
        return new Object[][]{
                {-10L, false},
                {0L, false},
                {50L, true},
                {450L, false},
                {401L, false},
                {400L, true},
                {399L, true}
        };
    }

    @DataProvider(name="Passwords")
    public Object[][] getPasswords(){
        return new Object[][]{
                {"", false},
                {"12345678", true},
                {"fgkndgadj!@#$%^&", true},
                {null, false}

        };
    }

    @DataProvider(name = "Names")
    public Object[][] getNames(){
        return new Object[][]{
                {"", false},
                {"11", true},
                {"123456789101112131415161718192021",false},
                {"!@#$%^&*", false},
                {"Correct", true},
                {"Correct too", true}
        };
    }

    @Test(dataProvider = "logins")
    public void shouldValidateLoginsCorrectly(String login, boolean correctResult) {
        boolean log = validator.isLoginValid(login);
        Assert.assertEquals(log, correctResult);
    }

    @Test(dataProvider = "mailboxes")
    public void shouldValidateMailboxesCorrectly(String mailbox, boolean correctResult) {
        boolean log = validator.isMailBoxValid(mailbox);
        Assert.assertEquals(log, correctResult);
    }

    @Test(dataProvider = "Total points")
    public void shouldValidateTotalPointsCorrectly(Long totalPoints, boolean correctResult) {
        boolean log = validator.isTotalPointsValid(totalPoints);
        Assert.assertEquals(log, correctResult);
    }

    @Test(dataProvider = "Passwords")
    public void testIsPasswordCorrect(String password, boolean correctResult) {
        boolean log = validator.isPasswordCorrect(password);
        Assert.assertEquals(log, correctResult);
    }

    @Test(dataProvider = "Names")
    public void testIsNameCorrect(String name, boolean correctResult) {
        boolean log = validator.isNameCorrect(name);
        Assert.assertEquals(log, correctResult);
    }

}