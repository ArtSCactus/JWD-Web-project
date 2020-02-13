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
                {"Hey_this_is_normal_nickname", true}, //out of bounds (more than 20 symbols)
                {"Normal_too95", true}
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

    @Test(dataProvider = "logins")
    public void shouldValidateLoginsCorrectly(String login, boolean correctResult) {
        boolean log = validator.isLoginValid(login);
        Assert.assertEquals(validator.isLoginValid(login), correctResult);
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

    @org.testng.annotations.Test
    public void testTestIsTotalPointsValid() {
    }

    @org.testng.annotations.Test
    public void testIsPasswordCorrect() {
    }

    @org.testng.annotations.Test
    public void testIsNameCorrect() {
    }

    @org.testng.annotations.Test
    public void testValidateAll() {
    }
}