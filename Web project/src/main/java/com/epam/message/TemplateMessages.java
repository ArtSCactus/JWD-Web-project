package com.epam.message;

import com.epam.model.dto.entity.Account;
import com.epam.model.dto.entity.NewsFeedItem;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author ArtSCactus
 * @version 1.1
 */
public class TemplateMessages {
    private static final String MESSAGE_TEMPLATES_PATH = "message/templates";
    private static final String PARAM_REGEXP = "\\$\\{\\?}";
    private static final String PARAM_STRING = "${?}";
    private static final String ADMISSION_COMPLETION_MSG = "admission.completion.message";
    private static final String ADMISSION_COMPLETION_TITLE = "admission.completion.title";
    private static final String ADMISSION_RESUME_MSG = "admission.resume.message";
    private static final String ADMISSION_RESUME_TITLE="admission.resume.title";
    private static final String ADMISSION_START_TITLE = "admission.start.title";
    private static final String ADMISSION_START_MSG = "admission.start.message";
    private static final String MAIL_ENROLLMENT_TITLE = "mail.enrollment.title";
    private static final String MAIL_ENROLLMENT_MSG = "mail.enrollment.message";
    private ResourceBundle messageTemplates;

    public TemplateMessages() {
        messageTemplates = PropertyResourceBundle.getBundle(MESSAGE_TEMPLATES_PATH);
    }

    public NewsFeedItem getAdmissionCompletionMessage(String facultyName,
                                                      String specialtyName,
                                                      List<Account> enrolledStudents) {
        String fullNamesList = convertStudentObjListToParamString(enrolledStudents);
        String preparedMessage = prepareMessage(messageTemplates.getString(ADMISSION_COMPLETION_MSG),
                facultyName, specialtyName, fullNamesList);
        return new NewsFeedItem(null, messageTemplates.getString(ADMISSION_COMPLETION_TITLE),
                preparedMessage, Date.valueOf(LocalDate.now()));
    }

    public NewsFeedItem getAdmissionResumeMessage(String facultyName, String specialtyName) {
        String preparedMessage = prepareMessageForAdmissionResume(messageTemplates.getString(ADMISSION_RESUME_MSG),
                facultyName, specialtyName);
        return new NewsFeedItem(null, messageTemplates.getString(ADMISSION_RESUME_TITLE),
                preparedMessage, Date.valueOf(LocalDate.now()));
    }

    public NewsFeedItem getAdmissionStartMessage(String... params) {
        String preparedMessage = prepareMessage(messageTemplates.getString(ADMISSION_START_MSG), params);
        return new NewsFeedItem(null, messageTemplates.getString(ADMISSION_START_TITLE),
                preparedMessage, Date.valueOf(LocalDate.now()));
    }


    private String prepareMessage(String messageTemplate, String... params) {
        int index = 0;
        while (messageTemplate.contains(PARAM_STRING) & index < params.length) {
            messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, params[index++]);
        }
        return messageTemplate;
    }

    public String getEnrollmentEmailTitle() {
        return messageTemplates.getString(MAIL_ENROLLMENT_TITLE);
    }

    public String getEnrollmentEmailMessage(String... params) {
        return prepareMessage(messageTemplates.getString(MAIL_ENROLLMENT_MSG), params);
    }

    private String prepareMessageForAdmissionResume(String messageTemplate, String facultyName, String specialtyName) {
        messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, facultyName);
        messageTemplate = messageTemplate.replaceFirst(PARAM_REGEXP, specialtyName);
        return messageTemplate;
    }

    private String convertStudentObjListToParamString(List<Account> students) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (Account account : students) {
            builder.append(account.getName());
            builder.append(" ");
            builder.append(account.getSurname());
            builder.append(" ");
            builder.append(account.getPatronymic()).append("\n");
        }
        return builder.toString();
    }
}