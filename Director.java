package com.company;

import java.util.Vector;

public class Director extends Member{
    public Director(String email, String name, String lastname, Vector<Day> array_of_days) {
        super(email, name, lastname, array_of_days);
    }
}
