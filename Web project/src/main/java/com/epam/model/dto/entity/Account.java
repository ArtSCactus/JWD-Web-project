package com.epam.model.dto.entity;

import com.epam.model.dto.Identifiable;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Account implements Serializable, Identifiable {
    public static final String TABLE_NAME = "accounts";
    private String login;
    private String password;
    private String mailbox;
    private String name;
    private String secondName;
    private String thirdName;
    private Integer totalPoints;
    private Long id;
    private Long studentId;
    private boolean isAdmin;
    private boolean isBlocked;
    private List<Application> appliedApplications;

    public Account(Long id, String login, String password, String mailbox) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
        this.isAdmin = false;
    }

    public Account(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin = false;
    }

    public Account(String login, String password, String mailbox, String name, String secondName, String thirdName,
                   Integer totalPoints, Long id, Long studentId, boolean isAdmin, boolean isBlocked) {
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
        this.name = name;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.totalPoints = totalPoints;
        this.id = id;
        this.studentId = studentId;
        this.isAdmin = isAdmin;
        this.isBlocked = isBlocked;
    }

    private Account() {

    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public String getMailbox() {
        return mailbox;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getStudentId() {

        return studentId;
    }

    public List<Application> getAppliedApplications() {
        return appliedApplications;
    }

    public void setAppliedApplications(List<Application> appliedApplications) {
        this.appliedApplications = appliedApplications;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Builder, that allows building entity object step by step.
     * Also, this class is nested and static to make easy to find it.
     */
    public static class Builder {
        private Account account;

        public Builder() {
            account = new Account();
        }

        public Builder withId(Long id) {
            account.id = id;
            return this;
        }

        public Builder withLogin(String login) {
            account.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            account.password = password;
            return this;
        }

        public Builder withMailbox(String mailbox) {
            account.mailbox = mailbox;
            return this;
        }

        public Builder withAdminStatus(boolean status) {
            account.isAdmin = status;
            return this;
        }

        public Builder withBlockStatus(boolean status) {
            account.isBlocked = status;
            return this;
        }

        public Builder withName(String name) {
            account.name = name;
            return this;
        }

        public Builder withSecondName(String secondName) {
            account.secondName = secondName;
            return this;
        }

        public Builder withThirdName(String thirdName) {
            account.thirdName = thirdName;
            return this;
        }

        public Builder withTotalPoints(Integer totalPoints) {
            account.totalPoints = totalPoints;
            return this;
        }

        public Builder withAppliedApplications(List<Application> appliedApplications){
            account.appliedApplications = appliedApplications;
            return this;
        }

        public Builder addAppliedApplication(Application application){
            account.appliedApplications.add(application);
            return this;
        }

        public Builder withStudentId(Long id){
            account.studentId = id;
            return this;
        }

        public Account build() {
            return account;
        }

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return isAdmin() == account.isAdmin() &&
                isBlocked() == account.isBlocked() &&
                Objects.equals(getLogin(), account.getLogin()) &&
                Objects.equals(getPassword(), account.getPassword()) &&
                Objects.equals(getMailbox(), account.getMailbox()) &&
                Objects.equals(getName(), account.getName()) &&
                Objects.equals(getSecondName(), account.getSecondName()) &&
                Objects.equals(getThirdName(), account.getThirdName()) &&
                Objects.equals(getTotalPoints(), account.getTotalPoints()) &&
                Objects.equals(getId(), account.getId()) &&
                Objects.equals(getStudentId(), account.getStudentId()) &&
                Objects.equals(getAppliedApplications(), account.getAppliedApplications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getMailbox(), getName(), getSecondName(), getThirdName(), getTotalPoints(), getId(), getStudentId(), isAdmin(), isBlocked(), getAppliedApplications());
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", totalPoints=" + totalPoints +
                ", id=" + id +
                ", studentId=" + studentId +
                ", isAdmin=" + isAdmin +
                ", isBlocked=" + isBlocked +
                ", appliedApplications=" + appliedApplications +
                '}';
    }
}
