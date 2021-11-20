package com.company;

public class Department {
    private Accountant accountant;
    private Employer employers[];
    private int number;

    public Department(Accountant accountant, Employer[] employers, int number) {
        this.accountant = accountant;
        this.employers = employers;
        this.number = number;
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public Employer[] getEmployers() {
        return employers;
    }

    public void setEmployers(Employer[] employers) {
        this.employers = employers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
