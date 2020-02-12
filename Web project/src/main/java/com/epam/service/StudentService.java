package com.epam.service;

import com.epam.model.dto.entity.Student;
import com.epam.model.dao.common.DaoFactory;
import com.epam.model.dao.helper.DaoManager;
import com.epam.model.dao.types.StudentDao;

import java.util.List;
import java.util.Optional;

public class StudentService {
    public Optional<Student> getStudentById(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            return studentDao.getById(id);
        }
    }

    public void enrollStudent(Student student){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            studentDao.save(student);
        }
    }

    public void enrollStudents(List<Student> studentList){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            for (Student student : studentList){
                studentDao.save(student);
            }
        }
    }

    public List<Student> getStudentForTable(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            return studentDao.getAllForTable();
        }
    }

    public Optional<Student> getById(Long id){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            return studentDao.getById(id);
        }
    }

    public List<Student> getStudentList(){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            return studentDao.getAll();
        }
    }

    public int update(Student student){
        try(DaoManager dao = DaoFactory.createDaoManager()){
            StudentDao studentDao = dao.getStudentDao();
            return studentDao.save(student);
        }
    }

}
