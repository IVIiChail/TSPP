package com.company;

public class Day {
    private String year;
    private String mounth;
    private String day;
    private String start;
    private String finish;

    public Day(String year, String mounth, String day, String start, String finish) {
        this.year = year;
        this.mounth = mounth;
        this.day = day;
        this.start = start;
        this.finish = finish;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMounth() {
        return mounth;
    }

    public void setMounth(String mounth) {
        this.mounth = mounth;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
}
