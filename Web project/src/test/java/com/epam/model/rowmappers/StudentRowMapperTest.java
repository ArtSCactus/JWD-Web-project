package com.epam.model.rowmappers;

import com.epam.model.dto.entity.Student;
import com.epam.model.dto.entity.StudentStatus;
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
import java.time.LocalDate;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentRowMapperTest {
    @Mock
    private ResultSet resultSet;
    private Student correctObj;

    @Before
    public void init() {
        correctObj = new Student.Builder()
                .withId(1L)
                .withAccountId(1L)
                .withFacultyId(2L)
                .withSpecialtyId(3L)
                .withEnrollmentDate(Date.valueOf("2020-01-10"))
                .withStudentStatus(StudentStatus.ENROLLED)
                .build();
    }

    @Test
    public void mapShouldReturnCorrectValue() throws SQLException {
        StudentRowMapper studentRowMapperTest = new StudentRowMapper();
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getLong("accountId")).thenReturn(1L);
        Mockito.when(resultSet.getLong("facultyId")).thenReturn(2L);
        Mockito.when(resultSet.getLong("specialtyId")).thenReturn(3L);
        Mockito.when(resultSet.getDate("enrollmentDate")).thenReturn(Date.valueOf("2020-01-10"));
        Mockito.when(resultSet.getString("status")).thenReturn("enrolled");
        Student resultObj = studentRowMapperTest.map(resultSet);
        Assert.assertEquals(correctObj, resultObj);
    }

}
