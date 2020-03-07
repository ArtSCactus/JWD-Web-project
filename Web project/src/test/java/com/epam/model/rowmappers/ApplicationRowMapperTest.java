package com.epam.model.rowmappers;

import com.epam.model.dto.entity.Application;
import com.epam.model.dto.entity.ApplicationStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationRowMapperTest {
    @Mock
    private ResultSet resultSet;
    private Application correctObj;

    @Before
    public void init() {
        correctObj = new Application.Builder()
                .withId(1L)
                .withFacultyId(2L)
                .withSpecialtyId(3L)
                .withAdmissionId(4L)
                .withAccountId(5L)
                .withDate(Date.valueOf("2020-01-10"))
                .withStatus(ApplicationStatus.ACCEPTED)
                .build();
    }

    @Test
    public void shouldReturnCorrectObj() throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getLong("facultyId")).thenReturn(2L);
        Mockito.when(resultSet.getLong("specialtyId")).thenReturn(3L);
        Mockito.when(resultSet.getLong("admissionId")).thenReturn(4L);
        Mockito.when(resultSet.getDate("date")).thenReturn(Date.valueOf("2020-01-10"));
        Mockito.when(resultSet.getString("status")).thenReturn("accepted");
        Mockito.when(resultSet.getLong("accountId")).thenReturn(5L);
        Application resultObj = new ApplicationRowMapper().map(resultSet);
        Assert.assertEquals(resultObj, correctObj);
    }
}