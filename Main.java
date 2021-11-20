package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        Vector<Day> temp = new Vector<>();
        temp = databaseHandler.readDays();
        System.out.println(temp);
    }
}
