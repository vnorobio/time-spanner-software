package com.neytor.timespannersoftware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;


@Entity
@Table(name = "dates")
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_id")
    private Long id;

    private String code;

    private LocalDate date;

    private Integer year;

    private Integer semester;

    private Integer month;

    @Column(name = "fortnight_of_month")
    private Integer fortnightOfMonth;

    @Column(name = "fortnight_of_year")
    private Integer fortnightOfYear;

    @Column(name = "week_of_month")
    private Integer weekOfMonth;

    @Column(name = "week_of_year")
    private Integer weekOfYear;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "day_of_month")
    private Integer dayOfMonth;

    @Column(name = "day_of_year")
    private Integer dayOfYear;

    @Column(name = "is_holiday")
    private Boolean isHoliday;

    public DateEntity() {
    }

    public DateEntity(Long id, String code, LocalDate date, Integer year, Integer semester, Integer month, Integer fortnightOfMonth, Integer fortnightOfYear, Integer weekOfMonth, Integer weekOfYear, Integer dayOfWeek, Integer dayOfMonth, Integer dayOfYear, Boolean isHoliday) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.year = year;
        this.semester = semester;
        this.month = month;
        this.fortnightOfMonth = fortnightOfMonth;
        this.fortnightOfYear = fortnightOfYear;
        this.weekOfMonth = weekOfMonth;
        this.weekOfYear = weekOfYear;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.dayOfYear = dayOfYear;
        this.isHoliday = isHoliday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getFortnightOfMonth() {
        return fortnightOfMonth;
    }

    public void setFortnightOfMonth(Integer fortnightOfMonth) {
        this.fortnightOfMonth = fortnightOfMonth;
    }

    public Integer getFortnightOfYear() {
        return fortnightOfYear;
    }

    public void setFortnightOfYear(Integer fortnightOfYear) {
        this.fortnightOfYear = fortnightOfYear;
    }

    public Integer getWeekOfMonth() {
        return weekOfMonth;
    }

    public void setWeekOfMonth(Integer weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public Integer getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(Integer weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(Integer dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public Boolean getHoliday() {
        return isHoliday;
    }

    public void setHoliday(Boolean holiday) {
        isHoliday = holiday;
    }
}
