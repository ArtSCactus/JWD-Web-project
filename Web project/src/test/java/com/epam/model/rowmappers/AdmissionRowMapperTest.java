package com.epam.model.rowmappers;

import com.epam.model.dto.entity.Admission;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class AdmissionRowMapperTest {
    @Mock
private ResultSet resultSet;
    private Admission correctObj;
    @Before
    public void init(){
        correctObj = new Admission.Builder()
                .withId(1L)
                .withStart(Date.valueOf("2020-01-10"))
                .withEnd(Date.valueOf("2020-01-11"))
                .withFacultyId(2L)
                .withSpecialtyId(3L)
                .withAmountOfStudents(100)
                .withStatus(true)
                .build();
    }
    @Test
    public void map() throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getDate("start")).thenReturn(Date.valueOf("2020-01-10"));
        Mockito.when(resultSet.getDate("end")).thenReturn(Date.valueOf("2020-01-11"));
        Mockito.when(resultSet.getLong("facultyId")).thenReturn(2L);
        Mockito.when(resultSet.getLong("specialtyId")).thenReturn(3L);
        Mockito.when(resultSet.getInt("required_students")).thenReturn(100);
        Mockito.when(resultSet.getBoolean("status")).thenReturn(true);
        Admission resultObj = new AdmissionRowMapper().map(resultSet);
        Assert.assertEquals(resultObj, correctObj);
    }
}