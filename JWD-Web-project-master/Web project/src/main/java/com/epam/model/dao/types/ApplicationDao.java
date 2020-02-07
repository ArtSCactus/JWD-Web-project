package com.epam.model.dao.types;

import com.epam.model.dto.entity.Admission;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.entity.Application;
import com.epam.model.rowmappers.ApplicationRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ApplicationDao extends AbstractDao<Application> implements Dao<Application> {
    private ResourceBundle resourcesGet;
    private ResourceBundle resourcesPut;

    public ApplicationDao(Connection connection) {
        super(connection);
        resourcesGet = ResourceBundle.getBundle("sql requests/get");
        resourcesPut = ResourceBundle.getBundle("sql requests/put");
    }

    @Override
    public Optional<Application> getById(Long id) {
        List<Application> values =super.executeQuery(resourcesGet.getString("get_application_by_id"),
                new ApplicationRowMapper(), id);
        if (!values.isEmpty()){
            return Optional.of(values.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Application> getAll() {
        return super.executeQuery(resourcesGet.getString("get_all_applications"),
                new ApplicationRowMapper());
    }

    @Override
    public int save(Application item) {
      return super.executeUpdate(resourcesPut.getString("insert_odku_into_applications"),
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

    public List<Application> getEnrolledApplications(Admission admission){
        return super.executeQuery(resourcesGet.getString("get_account_id_from_enrolled_applications"), new ApplicationRowMapper(),
                admission.getFacultyId(),
                admission.getSpecialtyId(),
                admission.getId(),
                admission.getStart(),
                admission.getEnd(),
                admission.getAmountOfStudents());
    }
}
