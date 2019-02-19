package com.vote.jdbc.domain;

import java.util.List;

public class Problem {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/13 19:26
 Version 1.0
 Description: 问题所具有的属性
 *****/

    private int id;
    private int describe;
    private String content;
    private boolean delete;
    private List<Answer> answers;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescribe(int describe) {
        this.describe = describe;
    }

    public int getDescribe() {
        return describe;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
