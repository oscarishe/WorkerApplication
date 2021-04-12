package net.codejava.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="sickleave")
public class Sickleave {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate end;
    public String reason;
    public Long identity;

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
