package net.codejava;


import java.time.LocalDate;
import java.time.Period;

public class AgeTest {
    public static void main(String[] args) {
        LocalDate birthdayDate = LocalDate.of(2011,6,12);
        System.out.println(birthdayDate);
        System.out.println(LocalDate.now());
        System.out.println(Period.between(birthdayDate, LocalDate.now()).getYears());

    }
}
