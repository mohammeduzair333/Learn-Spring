package com.example.databasedemo.models;

import jakarta.persistence.*;


@Entity
@Table
public class Notes {
    @Id
    @GeneratedValue
    long id;
    @Column
    String text;
    @Column
    long date;

    public Notes( String text, long date){
        this.text = text;
        this.date = date;
    }

    public Notes() {

    }

    public long getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public long getDate() {

        return date;
    }

    public void setDate(long date) {

        this.date = date;
    }

    @Override
    public String toString() {
        return "Notes{" + "id=" +id + ", text='" + text + '\'' + ", date=" + date + '}';
    }
}
