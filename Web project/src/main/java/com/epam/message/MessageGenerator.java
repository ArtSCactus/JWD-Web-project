package com.epam.message;

import com.epam.model.dto.entity.NewsFeedItem;
import com.epam.model.dto.entity.Student;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class MessageGenerator {
    private static final String MESSAGE_TEMPLATES_PATH = "message/templates";
    private static final String PARAM_REGEXP = "\\$\\{\\?}";
    private static final String PARAM_STRING = "${?}";
    private ResourceBundle messageTemplates;

    public MessageGenerator() {
        messageTemplates = PropertyResourceBundle.getBundle(MESSAGE_TEMPLATES_PATH);
    }

    public NewsFeedItem generateAdmissionCompletionMessage(String facultyName,
                                                           String specialtyName,
                                                           List<Student> enrolledStudents) {
        String fullNamesList = convertStudentObjListToParamString(enrolledStudents);
        String preparedMessage = prepareMessage(messageTemplates.getString("admission.completion.message"),
                facultyName, specialtyName, fullNamesList);
        NewsFeedItem news = new NewsFeedItem(null, messageTemplates.getString("admission.completion.title"),
                preparedMessage, Date.valueOf(LocalDate.now()));
        return news;
    }

    public NewsFeedItem generateAdmissionResumeMessage(String facultyName, String specialtyName) {
        String preparedMessage = prepareMessageForAdmissionResume(messageTemplates.getString("admission.resume.message"),
                facultyName, specialtyName);
        NewsFeedItem news = new NewsFeedItem(null, messageTemplates.getString("admission.resume.title"),
                preparedMessage, Date.valueOf(LocalDate.now()));
        return news;
    }

    public NewsFeedItem generateAdmissionStartMessage(String ...params) {
        String preparedMessage = prepareMessage(messageTemplates.getString("admission.start.message"), params);
        NewsFeedItem news = new NewsFeedItem(null, messageTemplates.getString("admission.start.title"),
                preparedMessage, Date.valueOf(LocalDate.now()));
        return news;
    }

    private String prepareMessage(String messageTemplate, String... params) {
        int index = 0;
        while (messageTemplate.contains(PARAM_STRING) & index < params.length) {
            messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, params[index++]);
        }
        return messageTemplate;
    }

    private String prepareMessageForAdmissionResume(String messageTemplate, String facultyName, String specialtyName) {
        messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, facultyName);
        messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, specialtyName);
        return messageTemplate;
    }

    private String convertStudentObjListToParamString(List<Student> students) {
        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append(student.getName());
            builder.append(" ");
            builder.append(student.getSurname());
            builder.append(" ");
            builder.append(student.getPatronymic()).append("\n");
        }
        return builder.toString();
    }
}