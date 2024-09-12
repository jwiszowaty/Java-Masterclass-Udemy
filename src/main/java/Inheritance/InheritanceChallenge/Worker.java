package Inheritance.InheritanceChallenge;

import java.time.LocalDate;
import java.time.Period;

public class Worker {
    private String name, birthDate, endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(this.birthDate);
        return Period.between(birthDate, today).getYears();
    }
    public double collectPay() {
        return 0.0;
    }
    public void terminate() {
        this.endDate = LocalDate.now().toString();
    }
}
