package com.company;

import java.util.Vector;

interface Builder{
    public abstract void setEmail(String email);
    public abstract void setName(String name);
    public abstract void setLastname(String lastname);
    public abstract void setArray_of_days(Vector<Day> array_of_days);
    public abstract Member GetResult();
}

public class MemberBuilder implements Builder {
    private String name;
    private String lastname;
    private Vector<Day> array_of_days;
    private String email;

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setArray_of_days(Vector<Day> array_of_days) {
        this.array_of_days = array_of_days;
    }

    @Override
    public Member GetResult() {
        return new Member(email,name,lastname,array_of_days);
    }
}
