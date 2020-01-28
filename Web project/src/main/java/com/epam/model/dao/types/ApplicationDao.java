package com.epam.model.dao.types;

import com.epam.dto.entity.Admission;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.dto.entity.Application;
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
    private static final String GET_ACCOUNT_ID_FROM_ENROLLED_APPLICATIONS_REQ = "select applications.*, accounts.totalPoints\n" +
            "from applications,\n" +
            "     accounts\n" +
            "where status = 'accepted'\n" +
            "  and facultyId = ?\n" +
            "  and specialtyId = ?\n" +
            "  and admissionId = ?\n" +
            "  and (date between ? and ?)\n" +
            "order by totalPoints desc\n" +
            "limit ?;";

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
    public int save(Application item) {
      return super.executeUpdate(INSERT_ODKU_STATEMENT_ROW,
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
        return super.executeQuery(GET_ACCOUNT_ID_FROM_ENROLLED_APPLICATIONS_REQ, new ApplicationRowMapper(),
                admission.getFacultyId(),
                admission.getSpecialtyId(),
                admission.getId(),
                admission.getStart(),
                admission.getEnd(),
                admission.getAmountOfStudents());
    }
}
