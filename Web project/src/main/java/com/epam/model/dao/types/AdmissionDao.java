package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.entity.Admission;
import com.epam.model.rowmappers.AdmissionRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdmissionDao extends AbstractDao<Admission> implements Dao<Admission> {
    private ResourceBundle resourcesGet;
    private ResourceBundle resourcesPut;

    public AdmissionDao(Connection connection) {
        super(connection);
        resourcesGet = ResourceBundle.getBundle("sql/get");
        resourcesPut = ResourceBundle.getBundle("sql/put");
    }

    @Override
    public Optional<Admission> getById(Long id) {
        List<Admission> admissionList = super.executeQuery(resourcesGet.getString("get_admission_by_id"),
                new AdmissionRowMapper(), id);
        if (admissionList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(admissionList.get(0));
        }
    }

    @Override
    public List<Admission> getAll() {
        return super.executeQuery(resourcesGet.getString("get_all_admissions"), new AdmissionRowMapper());
    }

    @Override
    public int save(Admission item) {
        return super.executeUpdate(resourcesPut.getString("insert_odku_into_admissions"),
                item.getId(),
                item.getStart(),
                item.getEnd(),
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getAmountOfStudents(),
                item.isActive());
    }

    @Override
    public void removeById(Long id) {
    }
}
