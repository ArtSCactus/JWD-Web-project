package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.Application;
import com.epam.model.rowmappers.ApplicationRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ApplicationDao extends AbstractDao<Application> implements Dao<Application> {
    private static final String INSERT_ODKU_STATEMENT_ROW = "INSERT INTO applications " +
            "(id, facultyId, specialtyId, accountId, status, date) VALUES (?, ?,?, ?, ?, ?)" +
            " on duplicate key update id=values(id), facultyId=values(facultyId), specialtyId=values(specialtyId)," +
            " accountId=values(accountId), status=values(status), date=values(date);";
    private static final String GET_ALL_APPLICATIONS_REQ = "select * from applications";
    private static final String GET_APPLICATION_BY_ID_REQ = "select * from applications where id=?";

    public ApplicationDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Application> getById(Long id) {
        List<Application> values =super.executeQuery(GET_APPLICATION_BY_ID_REQ, new ApplicationRowMapper(), id);
        if (!values.isEmpty()){
            return Optional.of(values.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Application> getAll() {
        return super.executeQuery(GET_ALL_APPLICATIONS_REQ, new ApplicationRowMapper());
    }

    @Override
    public void save(Application item) {
        super.executeUpdate(INSERT_ODKU_STATEMENT_ROW,
                item.getId(),
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getAccountId(),
                item.getStatus().getMessage(),
                item.getFilingDate());
    }

    @Override
    public void removeById(Long id) {

    }
}
