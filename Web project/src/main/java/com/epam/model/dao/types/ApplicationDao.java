package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.Application;
import com.epam.model.rowmappers.ApplicationRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ApplicationDao extends AbstractDao<Application> implements Dao<Application> {
    private static final String INSERT_STATEMENT_ROW = "INSERT INTO selection_committee.applications " +
            "(facultyId, specialtyId, accountId, status, date) VALUES" +
            " (?, ?, ?, ?, ?);";
    private static final String GET_ALL_APPLICATIONS_REQ = "select * from applications";

    public ApplicationDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Application> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Application> getAll() {
        return super.executeQuery(GET_ALL_APPLICATIONS_REQ, new ApplicationRowMapper());
    }

    @Override
    public void save(Application item) {
        super.executeUpdate(INSERT_STATEMENT_ROW,
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getAccountId(),
                item.getStatus(),
                item.getFilingDate());
    }

    @Override
    public void removeById(Long id) {

    }
}
