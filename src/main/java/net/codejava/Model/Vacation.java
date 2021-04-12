package net.codejava.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
public class Vacation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long identity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
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
}
