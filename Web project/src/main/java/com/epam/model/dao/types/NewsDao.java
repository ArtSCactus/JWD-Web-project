package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.entity.NewsFeedItem;
import com.epam.model.rowmappers.NewsRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class NewsDao extends AbstractDao<NewsFeedItem> implements Dao<NewsFeedItem> {

    public NewsDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<NewsFeedItem> getById(Long id) {
        List<NewsFeedItem> newsFeedItemList = super.executeQuery(getSelectRequest("get_news_by_id"),new NewsRowMapper());
        if (newsFeedItemList.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(newsFeedItemList.get(0));
        }
    }

    @Override
    public List<NewsFeedItem> getAll() {
        return super.executeQuery(getSelectRequest("get_all_news"), new NewsRowMapper());
    }

    @Override
    public int save(NewsFeedItem item) {
        return super.executeUpdate(getPutRequest("insert_odku_into_news"),
                item.getId(),
                item.getTitle(),
                item.getText(),
                item.getDate());
    }

    @Override
    public void removeById(Long id) {
    }
}
