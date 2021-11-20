package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Member extends User{
    private String name;
    private String lastname;
    private Vector<Day> array_of_days;

    public Member(String email, String name, String lastname, Vector<Day> array_of_days) {
        super(email);
        this.name = name;
        this.lastname = lastname;
        this.array_of_days = array_of_days;
    }

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Vector<Day> getArray_of_days() {
        return array_of_days;
    }

    public void setArray_of_days(Vector<Day> array_of_days) {
        this.array_of_days = array_of_days;
    }

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public void createMember(String name, String secondname, String email){
        String insert = "INSERT INTO " + Const.Member_Table + "(" +
                Const.Member_Name + ", " + Const.Member_SecondName + ", " + Const.Member_Email + ")"
                + "VALUES(?,?,?)";

        try {

            PreparedStatement prSt = databaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, secondname);
            prSt.setString(3, email);

            //prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(String secondname, String name, int id){
        String update = "UPDATE " + Const.Member_Table + "SET " + Const.Member_SecondName + " = " +
                secondname + " WHERE id = " + id;
        try {

            PreparedStatement prSt = databaseHandler.getDbConnection().prepareStatement(update);

            //prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteMember(int id){
        String delete = "DELETE FROM " + Const.Member_Table + " WHERE id = " + id;

        try{

            PreparedStatement prSt = databaseHandler.getDbConnection().prepareStatement(delete);

            //prSt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement readMember(){
        String read = "SELECT * FROM " + Const.Member_Table;

        PreparedStatement  prSt = null;
        try {
            prSt = databaseHandler.getDbConnection().prepareStatement(read);
            ResultSet resultSet = prSt.executeQuery(read);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString(Const.Member_Name);
                String secondname = resultSet.getString(Const.Member_SecondName);
                String email = resultSet.getString(Const.Member_Email);

            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return prSt;
    }

    public void addMemberDays(int id_member,Vector<Day> array_of_days){
        String insert = "INSERT INTO " + Const.Day_Table + "(" +
                Const.Day_IdMember + ", " + Const.Day_StartTime + ", " + Const.Day_FinishTime + ", " + Const.Day_Year +
                ", " + Const.Day_Mounth + ", " + Const.Day_Day + ")"
                + "VALUES(?,?,?,?,?,?)";

        try {

            for (Day temp : array_of_days) {
                PreparedStatement prSt = databaseHandler.getDbConnection().prepareStatement(insert);
                prSt.setInt(1, id_member);
                prSt.setString(2, temp.getStart());
                prSt.setString(3, temp.getFinish());
                prSt.setString(4, temp.getYear());
                prSt.setString(5, temp.getMounth());
                prSt.setString(6, temp.getDay());

                prSt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Vector<Day> readDays(){
        String read = "SELECT * FROM " + Const.Day_Table;

        PreparedStatement  prSt;
        Vector<Day> array_of_days = new Vector<>();
        try {
            prSt = databaseHandler.getDbConnection().prepareStatement(read);
            ResultSet resultSet = prSt.executeQuery(read);

            while (resultSet.next()) {
                Day temp;
                String year = resultSet.getString(Const.Day_Year);
                String mounth = resultSet.getString(Const.Day_Mounth);
                String day = resultSet.getString(Const.Day_Day);
                String start = resultSet.getString(Const.Day_StartTime);
                String finish = resultSet.getString(Const.Day_FinishTime);
                temp = new Day(year,mounth,day,start,finish);
                array_of_days.add(temp);

            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return array_of_days;
    }

    public Member readAllInformationForMemberForMounth(int condition){
        String read = "SELECT * FROM " + Const.Member_Table + " left join " + Const.Day_Table + " on members.id = days.id_member where days." + Const.Day_Mounth + " = " + condition; ;

        PreparedStatement  prSt;
        Member member = null;

        try {
            Vector<Day> days = new Vector<>();
            prSt = databaseHandler.getDbConnection().prepareStatement(read);
            ResultSet resultSet = prSt.executeQuery(read);

            String name = "";
            String secondname = "";
            String email = "";

            while (resultSet.next()) {
                Day temp;
                name = resultSet.getString(Const.Member_Name);
                secondname = resultSet.getString(Const.Member_SecondName);
                email = resultSet.getString(Const.Member_Email);
                String year = resultSet.getString(Const.Day_Year);
                String mounth = resultSet.getString(Const.Day_Mounth);
                String day = resultSet.getString(Const.Day_Day);
                String start = resultSet.getString(Const.Day_StartTime);
                String finish = resultSet.getString(Const.Day_FinishTime);
                temp = new Day(year,mounth,day,start,finish);
                days.add(temp);

            }

            member = new Member(email, name, secondname, days);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return member;
    }
}
