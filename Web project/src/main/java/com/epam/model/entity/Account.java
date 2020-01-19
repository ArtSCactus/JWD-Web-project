package com.epam.model.entity;

import java.util.Objects;

public class Account implements Identifiable {
    public static final String TABLE_NAME = "accounts";
    private String login;
    private String password;
    private String mailbox;
    private Long id;
    private boolean isAdmin;

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

    public Account(String login, String password, String mailbox, Long id, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
        this.id = id;
        this.isAdmin = isAdmin;
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
        return getLogin().equals(account.getLogin()) &&
                getPassword().equals(account.getPassword()) &&
                Objects.equals(getMailbox(), account.getMailbox());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getMailbox());
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
