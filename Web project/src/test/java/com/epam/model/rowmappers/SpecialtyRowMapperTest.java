package com.epam.model.rowmappers;

import com.epam.model.dto.university.Specialty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SpecialtyRowMapperTest {
    @Mock
    private ResultSet resultSet;
    private Specialty correctObj;

    @Before
    public void init() {
        correctObj = new Specialty(1L, 2L, "SpecialtyName", "Description", 3L);
    }

    @Test
    public void mapShouldReturnCorrectObj() throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getLong("facultyId")).thenReturn(2L);
        Mockito.when(resultSet.getString("name_en")).thenReturn("SpecialtyName");
        Mockito.when(resultSet.getString("description_en")).thenReturn("Description");
        Mockito.when(resultSet.getLong("admissionId")).thenReturn(3L);
        SpecialtyRowMapper specialtyRowMapper = new SpecialtyRowMapper();
        Specialty resultSpecialty = specialtyRowMapper.map(resultSet);
        Assert.assertEquals(correctObj, resultSpecialty);
    }
}