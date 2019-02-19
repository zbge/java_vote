package com.vote.jdbc.domain;

public class Answer {
/*****
 Created by IntelliJ IDEA.
 Author: mushan
 Date: 2018/12/13 19:28
 Version 1.0
 Description: 答案所具有的属性
 *****/

    private int id;
    private int problem;
    private String option;
    private int count;
    private boolean delete;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProblem(int problem) {
        this.problem = problem;
    }

    public int getProblem() {
        return problem;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
