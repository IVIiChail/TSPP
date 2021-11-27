package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MemberUnitTest {

    @Test
    public void setNameTest() {
        Member member = new Member("misha@gmail.com","Mis","Krivov",new Vector<Day>(2));
        member.setName("Misha");
        String name = "Misha";
        Assert.assertEquals(member.getName(),name);
    }

    @Test
    public void getNameTest() {
        Member member = new Member("misha@gmail.com","Mis","Krivov",new Vector<Day>(2));
        member.setName("Misha");
        String name = "Misha";
        String value = member.getName();
        Assert.assertEquals(value,name);
    }

    @Test
    public void setLastnameTest() {
        Member member = new Member("misha@gmail.com","Mis","Kriv",new Vector<Day>(2));
        member.setLastname("Krivov");
        String lastname = "Krivov";
        Assert.assertEquals(member.getLastname(),lastname);
    }

    @Test
    public void getLastnameTest() {
        Member member = new Member("misha@gmail.com","Mis","Kriv",new Vector<Day>(2));
        member.setLastname("Krivov");
        String lastname = "Krivov";
        String value = member.getLastname();
        Assert.assertEquals(value,lastname);
    }

    @Test
    public void readMemberNotNullUnitTest(){
        Member member = new Member();
        //DatabaseHandler databaseHandler = new DatabaseHandler();
        Assert.assertNotNull(member.readMember());
    }

    @Test
    public void readWithConditionsMounthUnitTest() throws SQLException {
        Member temp = new Member();

        temp = temp.readAllInformationForMemberForMounth(11);

        String month = temp.getArray_of_days().get(0).getMounth();

        Assert.assertEquals(month,"11");
    }

    @Test
    public void readAllInformationForMemberForMounth_CheckMonthInArray_UnitTest() throws SQLException {
        Member temp = new Member();
        temp = temp.readAllInformationForMemberForMounth(11);

        String month1 = temp.getArray_of_days().get(0).getMounth();
        String month2 = temp.getArray_of_days().get(1).getMounth();

        Assert.assertEquals(month1,month2);
    }

}
