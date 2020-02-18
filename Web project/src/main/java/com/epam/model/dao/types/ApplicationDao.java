package com.epam.model.dao.types;

import com.epam.model.dto.entity.Admission;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.dto.entity.Application;
import com.epam.model.rowmappers.ApplicationRowMapper;
import com.epam.model.rowmappers.table.ApplicationTableRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ApplicationDao extends AbstractDao<Application> implements Dao<Application> {

    public ApplicationDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Application> getById(Long id) {
        List<Application> values = super.executeQuery(getSelectRequest("get_application_by_id"),
                new ApplicationRowMapper(), id);
        if (!values.isEmpty()) {
            return Optional.of(values.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Application> getAll() {
        return super.executeQuery(getSelectRequest("get_all_applications"),
                new ApplicationRowMapper());
    }

    public List<Application> getAllForTable() {
        return super.executeQuery(getSelectRequest("get_all_applications_for_table"),
                new ApplicationTableRowMapper());
    }

    @Override
    public int save(Application item) {
        return super.executeUpdate(getPutRequest("insert_odku_into_applications"),
                item.getId(),
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getAccountId(),
                item.getStatus().getMessage(),
                item.getFilingDate(),
                item.getAdmissionId());
    }

    @Override
    public void removeById(Long id) {

    }

    public List<Application> getEnrolledApplications(Admission admission) {
        return super.executeQuery(getSelectRequest("get_account_id_from_enrolled_applications"), new ApplicationRowMapper(),
                admission.getFacultyId(),
                admission.getSpecialtyId(),
                admission.getId(),
                admission.getStart(),
                admission.getEnd(),
                admission.getAmountOfStudents());
    }

    public List<Application> getByAccountId(Long id) {
        return super.executeQuery(getSelectRequest("get_applications_by_account_id"), new ApplicationRowMapper(), id);
    }

    public List<Application> getAppliedApplication(Long id) {
        return super.executeQuery(getSelectRequest("get_applied_applications_by_account_id"), new ApplicationRowMapper(), id);
    }

    public Optional<Application> getByAccountIdAndSpecialtyId(Long accountId, Long specialtyId) {
        List<Application> applicationList =
                super.executeQuery(getSelectRequest("get_applications_by_account_id_and_specialty_id"),
                        new ApplicationRowMapper(), accountId, specialtyId);
        if (applicationList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(applicationList.get(0));
        }
    }
}
