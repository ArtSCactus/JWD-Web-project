package com.epam.message;

import com.epam.model.dto.entity.NewsFeedItem;
import com.epam.model.dto.entity.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author ArtSCactus
 * @version 1.0
 * @see MessageGenerator
 */
public class MessageGeneratorTest {
    private static final String PARAM_REGEXP = "\\$\\{\\?}";
    private NewsFeedItem correctGeneratedAdmissionCompletionMessage;
    private NewsFeedItem correctGeneratedAdmissionResumeMessage;
    private NewsFeedItem correctGeneratedAdmissionStartMessage;
    private List<Student> studentList;

    @Before
    public void init() {
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("message/templates");
        String admissionCompletionMessage = resourceBundle.getString("admission.completion.message");
        String admissionCompletionTitle = resourceBundle.getString("admission.completion.title");
        admissionCompletionMessage = admissionCompletionMessage.replaceFirst(PARAM_REGEXP, "param1");
        admissionCompletionMessage = admissionCompletionMessage.replaceFirst(PARAM_REGEXP, "param2");
        admissionCompletionMessage = admissionCompletionMessage.replaceFirst(PARAM_REGEXP,
                "name1 surname1 patronymic1\nname2 surname2 patronymic2\nname3 surname3 patronymic3\n");
        correctGeneratedAdmissionCompletionMessage = new NewsFeedItem(null, admissionCompletionTitle,
                admissionCompletionMessage,
                Date.valueOf(LocalDate.now()));

        String admissionResumeTitle = resourceBundle.getString("admission.resume.title");
        String admissionResumeMessage = resourceBundle.getString("admission.resume.message");
        admissionResumeMessage = admissionResumeMessage.replaceFirst(PARAM_REGEXP, "facultyName");
        admissionResumeMessage = admissionResumeMessage.replaceFirst(PARAM_REGEXP, "specialtyName");
        correctGeneratedAdmissionResumeMessage = new NewsFeedItem(null, admissionResumeTitle, admissionResumeMessage,
        Date.valueOf(LocalDate.now()));

        String admissionStartTitle = resourceBundle.getString("admission.start.title");
        String admissionStartMessage = resourceBundle.getString("admission.start.message");
        admissionStartMessage = admissionStartMessage.replaceFirst(PARAM_REGEXP, "facultyName");
        admissionStartMessage = admissionStartMessage.replaceFirst(PARAM_REGEXP, "specialtyName");
        admissionStartMessage = admissionStartMessage.replaceFirst(PARAM_REGEXP, "10");
        correctGeneratedAdmissionStartMessage = new NewsFeedItem(null, admissionStartTitle, admissionStartMessage,
                Date.valueOf(LocalDate.now()));

        studentList = new ArrayList<>();
        studentList.add(new Student(null, null, null, null, null, null,
                "name1", "surname1", "patronymic1"));
        studentList.add(new Student(null, null, null, null, null, null,
                "name2", "surname2", "patronymic2"));
        studentList.add(new Student(null, null, null, null, null, null,
                "name3", "surname3", "patronymic3"));
    }

    @Test
    public void shouldReturnCorrectAdmissionCompletionNewsFeedItem() {
        MessageGenerator generator = new MessageGenerator();
        NewsFeedItem item = generator.generateAdmissionCompletionMessage("param1", "param2",
                studentList);
        Assert.assertEquals(correctGeneratedAdmissionCompletionMessage, item);
    }

    @Test
    public void shouldReturnCorrectAdmissionResumeNewsFeedItem() {
        MessageGenerator generator = new MessageGenerator();
        NewsFeedItem item = generator.generateAdmissionResumeMessage("facultyName", "specialtyName");
        Assert.assertEquals(correctGeneratedAdmissionResumeMessage, item);
    }

    @Test
    public void shouldReturnCorrectAdmissionStartNewsFeedItem(){
        MessageGenerator generator = new MessageGenerator();
        NewsFeedItem item = generator.generateAdmissionStartMessage("facultyName", "specialtyName", "10");
        Assert.assertEquals(correctGeneratedAdmissionStartMessage, item);
    }

}

