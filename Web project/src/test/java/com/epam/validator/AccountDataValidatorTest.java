package com.epam.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
    public Object[][] getObjects(){
        return new Object[][]{

        };
    }

    @Test(dataProvider = "logins")
    public void shouldValidateLoginsCorrectly(String login, boolean correctResult) {
        boolean log = validator.isLoginValid(login);
        Assert.assertEquals(validator.isLoginValid(login), correctResult);
    }

    @Test(dataProvider = "mailboxes")
    public void testIsMailBoxValid() {
    }

    @org.testng.annotations.Test
    public void testIsTotalPointsValid() {
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