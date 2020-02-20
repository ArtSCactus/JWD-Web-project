package com.epam.model.rowmappers;

import com.epam.model.dto.entity.NewsFeedItem;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class NewsRowMapper implements RowMapper<NewsFeedItem> {
    private static final String ID_COL = "id";
    private static final String TITLE_COL = "title";
    private static final String TEXT_COL = "text";
    private static final String DATE_COL = "date";
    @Override
    public NewsFeedItem map(ResultSet resultSet) throws SQLException {
        return new NewsFeedItem(resultSet.getLong(ID_COL),
                resultSet.getString(TITLE_COL),
                resultSet.getString(TEXT_COL),
                resultSet.getDate(DATE_COL));
    }
}
