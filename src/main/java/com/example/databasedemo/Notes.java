package com.example.databasedemo;

import jakarta.persistence.*;


@Entity
@Table
public class Notes {
    @Id
    @GeneratedValue
    long textlineno;
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

    public long getTextlineno() {
        return textlineno;
    }

    public void setTextlineno(int textlineno) {
        this.textlineno = textlineno;
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
        return "Notes{" + "textlineno=" + textlineno + ", text='" + text + '\'' + ", date=" + date + '}';
    }
}
