package com.epam.model.rowmappers;

import com.epam.model.dto.entity.NewsFeedItem;
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
public class NewsRowMapperTest {
    @Mock
    private ResultSet resultSet;
    private NewsFeedItem correctObj;

    @Before
    public void init() {
        correctObj = new NewsFeedItem(1L, "Title", "Text", Date.valueOf("2020-01-10"));
    }

    @Test
    public void shouldReturnCorrectObject() throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(1L);
        Mockito.when(resultSet.getString("title")).thenReturn("Title");
        Mockito.when(resultSet.getString("text")).thenReturn("Text");
        Mockito.when(resultSet.getDate("date")).thenReturn(Date.valueOf("2020-01-10"));
        NewsRowMapper rowMapper = new NewsRowMapper();
        NewsFeedItem resultObj = rowMapper.map(resultSet);
        Assert.assertEquals(resultObj, correctObj);
    }
}