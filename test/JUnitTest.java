/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yagizaydinaksar
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    
 @Test
    public void ProjectTest(){
    int test0 = 0;
    String test1 = "Test1"; 
    String test2 = "Test2";
    float test3 = 3;
    String test4 = "Test4";
    String test5 = "Test5";
    String test6 = "Test6";
    String test7 = "Test7";
    String test8 = "Test8";
    String test9 = "Test9";
    String test10 = "Test10";
    int test11 = 11;
    Project test = new Project(0,"Test1","Test2",3,"Test4","Test5","Test6","Test7","Test8","Test9","Test10",11);
    int tester0 = test.getProjectID();
    String tester1 = test.getActivityDescription();
    String tester2 = test.getComments();
    float tester3 = test.getCost();
    String tester4 = test.getMDFBudget();
    String tester5 = test.getExecutionQuarter();
    String tester6 = test.getStartDate();
    String tester7 = test.getEndDate();
    String tester8 = test.getObjAndResult();
    String tester9 = test.getRequiredPOE();
    String tester10 = test.getStatus();
    int tester11 = test.getPaID();
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 0)", test0 == tester0);
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 1)", test1.equals(tester1));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 2)", test2.equals(tester2));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 3)", test3 == tester3);
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 4)", test4.equals(tester4));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 5)", test5.equals(tester5));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 6)", test6.equals(tester6));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 7)", test7.equals(tester7));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 8)", test8.equals(tester8));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 9)", test9.equals(tester9));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 10)", test10.equals(tester10));
    Assert.assertTrue("Oppps, there is a problem! (Project - Test 11)", test11 == tester11);
}
 @Test
  public void PartnerTest(){
    int test0 = 0;
    String test1 = "Test1"; 
    String test2 = "Test2";
    Partner test = new Partner (0,"Test1","Test2");
    int tester0 = test.getPaID();
    String tester1 = test.getPartnerName();
    String tester2 = test.getCountry();
    Assert.assertTrue("Oppps, there is a problem! (Partner - Test 0)", test0 == tester0);
    Assert.assertTrue("Oppps, there is a problem! (Partner - Test 1)", test1.equals(tester1));
    Assert.assertTrue("Oppps, there is a problem! (Partner - Test 2)", test2.equals(tester2));
  }  
  
 @Test
    public void UserTest(){
    String test0 = "Test0"; 
    String test1 = "Test1";  
    String test2 = "Test2";
    User test = new User("Test0","Test1","Test2");
    String tester0 = test.getName();
    String tester1 = test.getPassword();
    String tester2 = test.getUserType();
    Assert.assertTrue("Oppps, there is a problem! (User - Test 0)", test0.equals(tester0));
    Assert.assertTrue("Oppps, there is a problem! (User - Test 1)", test1.equals(tester1));
    Assert.assertTrue("Oppps, there is a problem! (User - Test 2)", test2.equals(tester2));
}

}
