package com.epam.model.dao.types;

import com.epam.dto.entity.Student;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.rowmappers.StudentRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class StudentDao extends AbstractDao<Student> implements Dao<Student> {
    private static final String INSERT_ODKU_REQ = "insert into students (id, accountId, facultyId, specialtyId, enrollmentDate)\n" +
            "values (?, ?, ?, ?, ?)\n" +
            "on duplicate key update id=values(id),\n" +
            "                        accountId=values(accountId),\n" +
            "                        facultyId=values(facultyId),\n" +
            "                        specialtyId= values(specialtyId),\n" +
            "                        enrollmentDate=values(enrollmentDate);";
    private static final String GET_BY_ID_REQ = "select id, accountId, facultyId, " +
            "specialtyId, enrollmentDate from students where id = ?";
    private static final String GET_ALL_REQ = "select id, accountId, facultyId, specialtyId, enrollmentDate " +
            "from students";


    public StudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Student> getById(Long id) {
        List<Student> studentList = super.executeQuery(GET_BY_ID_REQ, new StudentRowMapper(), id);
        if (studentList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(studentList.get(0));
        }
    }

    @Override
    public List<Student> getAll() {
        return super.executeQuery(GET_ALL_REQ, new StudentRowMapper());
    }

    @Override
    public int save(Student item) {
        return super.executeUpdate(INSERT_ODKU_REQ,
                item.getId(),
                item.getAccountId(),
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getEnrollmentDate());
    }

    @Override
    public void removeById(Long id) {

    }
}
