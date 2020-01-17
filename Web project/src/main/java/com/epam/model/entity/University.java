package com.epam.model.entity;

import com.epam.service.UniversityService;
import exceptions.service.ServiceException;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class University {
    private static University university;
    private static ReentrantLock LOCK = new ReentrantLock();
    private List<Faculty> facultyList;

    public static University getInstance() {
        if (university == null) {
            LOCK.lock();
            if (university == null) {
                UniversityService service = new UniversityService();
                university = new University();
                try {
                    university.facultyList = service.initFaculties();
                } catch (ServiceException e) {
                    throw new RuntimeException("An error occurred in University service while" +
                            " creating University instance", e);
                } finally {
                    LOCK.unlock();
                }
            }
        }
        return university;
    }

    public  List<Faculty> getFaculties() {
        return facultyList;
    }
}
