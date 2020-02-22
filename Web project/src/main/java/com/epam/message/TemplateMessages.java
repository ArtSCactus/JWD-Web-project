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
    private ResourceBundle messageTemplates;

    public TemplateMessages() {
        messageTemplates = PropertyResourceBundle.getBundle(MESSAGE_TEMPLATES_PATH);
    }

    public NewsFeedItem getAdmissionCompletionMessage(String facultyName,
                                                      String specialtyName,
                                                      List<Account> enrolledStudents) {
        String fullNamesList = convertStudentObjListToParamString(enrolledStudents);
        String preparedMessage = prepareMessage(messageTemplates.getString("admission.completion.message"),
                facultyName, specialtyName, fullNamesList);
        NewsFeedItem news = new NewsFeedItem(null, messageTemplates.getString("admission.completion.title"),
                preparedMessage, Date.valueOf(LocalDate.now()));
        return news;
    }

    public NewsFeedItem getAdmissionResumeMessage(String facultyName, String specialtyName) {
        String preparedMessage = prepareMessageForAdmissionResume(messageTemplates.getString("admission.resume.message"),
                facultyName, specialtyName);
        NewsFeedItem news = new NewsFeedItem(null, messageTemplates.getString("admission.resume.title"),
                preparedMessage, Date.valueOf(LocalDate.now()));
        return news;
    }

    public NewsFeedItem getAdmissionStartMessage(String ...params) {
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

    public String getEnrollmentEmailTitle(){
      return  messageTemplates.getString("mail.enrollment.title");
    }

    public String getEnrollmentEmailMessage(String ...params){
        return prepareMessage(messageTemplates.getString("mail.enrollment.message"), params);
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