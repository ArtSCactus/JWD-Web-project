package com.epam.model.dto.entity;

import com.epam.model.dto.Identifiable;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class News implements Identifiable, Serializable {
    private Long id;
    private String title;
    private String text;
    private Date date;

    public News(Long id, String title, String text, Date date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(getId(), news.getId()) &&
                Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getText(), news.getText()) &&
                Objects.equals(getDate(), news.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getText(), getDate());
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
