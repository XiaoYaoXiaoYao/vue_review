package com.liandi.todoback.bean;

import java.util.ArrayList;

public class TengytTodo {
    private Integer id;

    private String datetime;

    private String ttime;

    private Integer looptype;

    private String week;
    private ArrayList<String> checkWeeks;

    private Integer useTime;

    private Integer grade;

    private String content;

    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public Integer getLooptype() {
        return looptype;
    }

    public void setLooptype(Integer looptype) {
        this.looptype = looptype;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public ArrayList<String> getCheckWeeks() {
        return checkWeeks;
    }

    public void setCheckWeeks(ArrayList<String> checkWeeks) {
        this.checkWeeks = checkWeeks;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}