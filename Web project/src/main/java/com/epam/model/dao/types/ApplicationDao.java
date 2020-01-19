package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.StudentApplication;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ApplicationDao extends AbstractDao<StudentApplication> implements Dao<StudentApplication> {
    private static final String INSERT_STATEMENT_ROW = "INSERT INTO selection_committee.applications " +
            "(id, facultyId, accountId, admissionId, specialtyId, status, date) VALUES" +
            " ('?', '?', '?', '?', '?', '?', '?');";

    public ApplicationDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<StudentApplication> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<StudentApplication> getAll() {
        return null;
    }

    @Override
    public void save(StudentApplication item) {
    }

    @Override
    public void removeById(Long id) {

    }
}
