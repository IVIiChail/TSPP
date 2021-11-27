package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Builder builder = new MemberBuilder();
        Director director = new Director(builder);
        director.Construct().setLastname("Krivov");
        System.out.println(director.Construct().GetResult().getLastname());
    }
}
