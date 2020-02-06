package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.university.Specialty;
import com.epam.model.rowmappers.SpecialtyRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SpecialtyDao extends AbstractDao<Specialty> implements Dao<Specialty> {
    private ResourceBundle resourcesGet;
    private ResourceBundle resourcesPut;

    public SpecialtyDao(Connection connection) {
        super(connection);
        resourcesGet = ResourceBundle.getBundle("sql requests/get");
        resourcesPut = ResourceBundle.getBundle("sql requests/put");
    }

    @Override
    public Optional<Specialty> getById(Long id) {
        List<Specialty> resultList = super.executeQuery(resourcesGet.getString("get_student_by_id"), new SpecialtyRowMapper(), id);
        if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(resultList.get(0));
        }
    }

    @Override
    public List<Specialty> getAll() {
        return super.executeQuery(resourcesGet.getString("get_all_specialties"), new SpecialtyRowMapper());
    }

    @Override
    public int save(Specialty item) {
        return 0;
    }

    @Override
    public void removeById(Long id) {

    }

    public Optional<Specialty> getByName(String name) {
        List<Specialty> specialties = super.executeQuery(resourcesGet.getString("get_specialty_by_name"),
                new SpecialtyRowMapper(), name);
        if (specialties.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(specialties.get(0));
        }
    }
}
