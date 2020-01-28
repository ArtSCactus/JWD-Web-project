package com.epam.dto.entity;

import com.epam.dto.Identifiable;

import java.util.Objects;

public class Account implements Identifiable {
    public static final String TABLE_NAME = "accounts";
    private String login;
    private String password;
    private String mailbox;
    private Long id;
    private boolean isAdmin;
    private boolean isBlocked;

    public Account(Long id, String login, String password, String mailbox) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
        this.isAdmin=false;
    }

    public Account(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin=false;
    }

    public Account(String login, String password, String mailbox, Long id, boolean isAdmin, boolean isBlocked) {
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
        this.id = id;
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

        public Builder withAdminStatus(boolean status){
            account.isAdmin=status;
            return this;
        }

        public Builder withBlockStatus(boolean status){
            account.isBlocked=status;
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
                Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getMailbox(), getId(), isAdmin(), isBlocked());
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", id=" + id +
                ", isAdmin=" + isAdmin +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
