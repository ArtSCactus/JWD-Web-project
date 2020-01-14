package com.epam.model.entity;

import java.util.Objects;

public class User implements Identifiable {
    public static final String TABLE_NAME = "accounts";
    private String login;
    private String password;
    private String mailbox;
    private Long id;

    public User(Long id, String login, String password, String mailbox) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mailbox = mailbox;
    }

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    private User() {

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

    /**
     * Builder, that allows building entity object step by step.
     * Also, this class is nested and static to make easy to find it.
     */
    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder withId(Long id) {
            user.id = id;
            return this;
        }

        public Builder withLogin(String login) {
            user.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            user.password = password;
            return this;
        }

        public Builder withMailbox(String mailbox) {
            user.mailbox = mailbox;
            return this;
        }

        public User build() {
            return user;
        }
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                Objects.equals(getMailbox(), user.getMailbox());
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
