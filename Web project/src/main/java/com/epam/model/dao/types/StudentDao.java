package com.epam.model.dao.types;

import com.epam.model.dto.entity.Student;
import com.epam.model.dao.common.AbstractDao;
import com.epam.model.dao.common.Dao;
import com.epam.model.rowmappers.StudentRowMapper;
import com.epam.model.rowmappers.table.StudentTableRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentDao extends AbstractDao<Student> implements Dao<Student> {
    private ResourceBundle resourcesGet;
    private ResourceBundle resourcePut;

    public StudentDao(Connection connection) {
        super(connection);
        resourcesGet = ResourceBundle.getBundle("sql/get");
        resourcePut = ResourceBundle.getBundle("sql/put");
    }

    @Override
    public Optional<Student> getById(Long id) {
        List<Student> studentList = super.executeQuery(resourcesGet.getString("get_student_by_id"), new StudentRowMapper(), id);
        if (studentList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(studentList.get(0));
        }
    }

    @Override
    public List<Student> getAll() {
        return super.executeQuery(resourcesGet.getString("get_all_students"), new StudentRowMapper());
    }

    public List<Student> getAllForTable() {
        return super.executeQuery(resourcesGet.getString("get_all_students_for_table"), new StudentTableRowMapper());
    }

    @Override
    public int save(Student item) {
        return super.executeUpdate(resourcePut.getString("insert_odku_into_students"),
                item.getId(),
                item.getAccountId(),
                item.getFacultyId(),
                item.getSpecialtyId(),
                item.getEnrollmentDate(),
                item.getStatus().getMessage());
    }

    @Override
    public void removeById(Long id) {

    }
}
