package com.xl.ye.bean;

public class NolSysDate {

    private String todayDate;

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    @Override
    public String toString() {
        return "NolSysDate{" +
                "todayDate='" + todayDate + '\'' +
                '}';
    }
}
