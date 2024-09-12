package Inheritance.InheritanceChallenge;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }
    @Override
    public double collectPay() {
        return annualSalary / 12;
    }
    public void retire() {
        terminate();
        this.isRetired = true;
    }
}
