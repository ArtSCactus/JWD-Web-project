package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.dto.university.Specialty;
import com.epam.model.rowmappers.SpecialtyRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SpecialtyDao extends AbstractDao<Specialty> implements Dao<Specialty> {
    private ResourceBundle resources;

    public SpecialtyDao(Connection connection) {
        super(connection);
        resources = ResourceBundle.getBundle("sql requests/get");
    }

    @Override
    public Optional<Specialty> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getAll() {
        return super.executeQuery(resources.getString("get_all_specialties"), new SpecialtyRowMapper());
    }

    @Override
    public int save(Specialty item) {
        return 0;
    }

    @Override
    public void removeById(Long id) {

    }
}
