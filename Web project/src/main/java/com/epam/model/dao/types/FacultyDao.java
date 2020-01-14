package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.Faculty;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class FacultyDao extends AbstractDao<Faculty> implements Dao<Faculty> {
    private static final String GET_BY_ID_REQ = "select * from faculties where id = ?";
    private static final String GET_ALL_REQ = "select * from faculties";

    public FacultyDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Faculty> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Faculty> getAll(String sql) {
        return null;
    }

    @Override
    public void save(Faculty item) {

    }

    @Override
    public void update(Long id, Object... params) {

    }

    @Override
    public void removeById(Long id) {

    }
}
