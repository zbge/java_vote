package com.vote.jdbc.domain;

import java.util.Date;
import java.util.List;

public class Content {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/12 15:28
 Version 1.0
 Description: 文章所具有的属性
 *****/
    private int id;
    private int user;
    private String title;
    private String content;
    private int number;
    private boolean delete;
    private Date startTime;
    private Date endTime;
    private List<Problem> problems;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
