package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.entity.university.Specialty;
import com.epam.model.rowmappers.SpecialtyRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class SpecialtyDao extends AbstractDao<Specialty> implements Dao<Specialty> {
   private static final String GET_ALL_SPEC_REQ = "select * from specialties";
  public SpecialtyDao(Connection connection){
      super(connection);
  }
    @Override
    public Optional<Specialty> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Specialty> getAll() {
        return super.executeQuery(GET_ALL_SPEC_REQ, new SpecialtyRowMapper());
    }

    @Override
    public void save(Specialty item) {

    }
    @Override
    public void removeById(Long id) {

    }
}
