package net.codejava.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worker_id;

    private String name;
    private String surname;
    private String patronymic;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayDate;
    private String education;
    private String position;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getId() {
        return worker_id;
    }

    public void setId(Long id) {
        this.worker_id = id;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDay(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Date getEmployDate() {
        return employDate;
    }

    public void setEmployDate(Date employDate) {
        this.employDate = employDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
