package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.university.Faculty;
import com.epam.model.rowmappers.FacultyRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class FacultyDao extends AbstractDao<Faculty> implements Dao<Faculty> {

    public FacultyDao(Connection connection) {
        super(connection);
    }


    @Override
    public Optional<Faculty> getById(Long id) {
        List<Faculty> faculties =
                super.executeQuery(getSelectRequest("get_faculty_by_id"), new FacultyRowMapper(), id);
        if (!faculties.isEmpty()){
            return Optional.of(faculties.get(0));
        } else {
            return Optional.empty();

        }
    }

    @Override
    public List<Faculty> getAll() {
        return super.executeQuery(getSelectRequest("get_all_faculties"), new FacultyRowMapper());
    }

    @Override
    public int save(Faculty item) {
        return 0;
    }

    @Override
    public void removeById(Long id) {

    }

    public Optional<Faculty> getByName(String name){
        List<Faculty> faculties = super.executeQuery(getSelectRequest("get_faculty_by_name"), new FacultyRowMapper(), name);
        if (faculties.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(faculties.get(0));
        }
    }
}
