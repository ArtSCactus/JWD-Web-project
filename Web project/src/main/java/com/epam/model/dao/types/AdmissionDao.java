package com.epam.model.dao.types;

import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.dto.entity.Admission;
import com.epam.model.rowmappers.AdmissionRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class AdmissionDao extends AbstractDao<Admission> implements Dao<Admission> {
    private static final String INSERT_ODKU = "insert into admissions (id, start, end, facultyId, specialtyId, required_students, status)\n" +
            "values (?, ?, ?, ?, ?, ?, ?)" +
            "on duplicate key update id=values(id)," +
            "                        start=values(start)," +
            "                        end = values(end)," +
            "                        facultyId=values(facultyId)," +
            "                        specialtyId = values(specialtyID)," +
            "                        required_students=values(required_students)," +
            "                        status = values (status);";
    private static final String GET_ALL_REQ = "select id, start, end, facultyId, specialtyId, required_students, status from admissions";
    private static final String GET_BY_ID_REQ = "select * from admissions where id = ?";


    public AdmissionDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Admission> getById(Long id) {
        List<Admission> admissionList = super.executeQuery(GET_BY_ID_REQ, new AdmissionRowMapper(), id);
        if (admissionList.isEmpty()) {
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
    public int save(Admission item) {
        return super.executeUpdate(INSERT_ODKU,
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
