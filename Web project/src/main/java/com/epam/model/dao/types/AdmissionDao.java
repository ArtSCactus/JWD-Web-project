package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.Admission;
import com.epam.model.rowmappers.AdmissionRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AdmissionDao extends AbstractDao<Admission> implements Dao<Admission> {
    private static final String INSERT_ODKU = "insert int ";
    private static final String GET_ALL_REQ = "select * from admissions";
    private static final String GET_BY_ID_REQ = "select * from admissions where id = ?";

    protected AdmissionDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Admission> getById(Long id) {
        List<Admission> admissionList = super.executeQuery(GET_BY_ID_REQ, new AdmissionRowMapper(), id);
        if (admissionList.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(admissionList.get(0));
        }
    }

    @Override
    public List<Admission> getAll() {
        return super.executeQuery(GET_ALL_REQ, new AdmissionRowMapper());
    }

    @Override
    public void save(Admission item) {

    }

    @Override
    public void removeById(Long id) {

    }
}
