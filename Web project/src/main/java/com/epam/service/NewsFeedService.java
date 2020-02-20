package com.epam.service;

import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.NewsDao;
import com.epam.model.dto.entity.NewsFeedItem;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class NewsFeedService {
    public List<NewsFeedItem> getAllNews() {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            NewsDao newsDao = dao.getNewsDao();
            return newsDao.getAll();
        }
    }

    public Optional<NewsFeedItem> getById(Long id) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            NewsDao newsDao = dao.getNewsDao();
            return newsDao.getById(id);
        }
    }

    public int update(NewsFeedItem item) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            NewsDao newsDao = dao.getNewsDao();
            return newsDao.save(item);
        }
    }

    public void createNewsItem(String title, String text) {
        try (DaoManager dao = DaoFactory.createDaoManager()) {
            NewsFeedItem item = new NewsFeedItem(null, title, text, Date.valueOf(LocalDate.now()));
            NewsDao newsDao = dao.getNewsDao();
            newsDao.save(item);
        }
    }
}
