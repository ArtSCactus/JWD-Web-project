package com.epam.model.rowmappers;


import com.epam.model.dto.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class AccountRowMapperTest {
    @Mock
    private ResultSet resultSet;
    private Account correctAccount;

    @Before
    public void init() {
        correctAccount = new Account.Builder()
                .withId(1L)
                .withLogin("Login")
                .withPassword("Password")
                .withMailbox("mailbox@mail.com")
                .withName("Name")
                .withSecondName("Surname")
                .withThirdName("Patronymic")
                .withAppliedApplications(null)
                .withAdminStatus(true)
                .withBlockStatus(false)
                .withStudentId(null)
                .withTotalPoints(400)
                .build();
    }
    @Test
    public void mapMethodShouldReturnCorrectObject() throws SQLException {
        AccountRowMapper accountRowMapper = new AccountRowMapper();
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getString("login")).thenReturn("Login");
        Mockito.when(resultSet.getString("password")).thenReturn("Password");
        Mockito.when(resultSet.getString("mailbox")).thenReturn("mailbox@mail.com");
        Mockito.when(resultSet.getString("name")).thenReturn("Name");
        Mockito.when(resultSet.getString("surname")).thenReturn("Surname");
        Mockito.when(resultSet.getString("patronymic")).thenReturn("Patronymic");
        Mockito.when(resultSet.getBoolean("adminStatus")).thenReturn(true);
        Mockito.when(resultSet.getBoolean("blockStatus")).thenReturn(false);
        Mockito.when(resultSet.getLong("studentId")).thenReturn(0L);
        Mockito.when(resultSet.getInt("totalPoints")).thenReturn(400);
       Account resultAccount = accountRowMapper.map(resultSet);
        resultAccount.setStudentId(null); // because of Mockito cannot return null value when Number type is using, but real
        // ResultSet can do it
        Assert.assertEquals(resultAccount, correctAccount);
    }
}