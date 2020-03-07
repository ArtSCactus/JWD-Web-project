package com.epam.model.rowmappers;

import com.epam.model.dto.university.Faculty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FacultyRowMapperTest {
    @Mock
private ResultSet resultSet;
private Faculty correctObj;
@Before
public void init(){
    correctObj = new Faculty(1L, "Name", "Description");
}
    @Test
    public void map() throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getString("name")).thenReturn("Name");
        Mockito.when(resultSet.getString("description_en")).thenReturn("Description");
        Faculty resultObj = new FacultyRowMapper().map(resultSet);
        Assert.assertEquals(resultObj, correctObj);
    }
}