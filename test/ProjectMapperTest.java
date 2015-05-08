/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datasource.*;
import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author yagizaydinaksar
 */
public class ProjectMapperTest {

    Project p;
    ProjectMapper pm;
    Connection con;

    public ProjectMapperTest() {
    }

    @Before
    public void setUp() {
        p = new Project(0, "Test1", "Test2", 3, "Test4", "Test5", "Test6", "Test7", "Test8", "Test9", "Test10", 11);
        con = DBCommunication.getInstance().getConnection();
        pm = new ProjectMapper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsertProjects() throws SQLException {
        boolean act = pm.insertProjects(p, con);
        boolean exp = true;
        assertTrue("Oppps, there is a problem! (insertProject - Test 0)", act == exp);
    }

    @Test
    public void testGetProject() throws SQLException {
        Project act = pm.getProject(1028, con);
        Project exp = new Project(1028, "Test1", "Test2", 3, "Test4", "Test5", "Test6", "Test7", "Test8", "Test9", "Test10", 11);
        String act1 = act.getActivityDescription();
        String exp1 = "Test1";
        float act2 = act.getCost();
        float exp2 = 3;
        assertTrue("Oppps, there is a problem! (getProject - Test 0)", act1.equals(exp1));
        assertTrue("Oppps, there is a problem! (getProject - Test 1)", act2 == exp2);

    }

    @Test
    public void testGetAllPartnerProjects() throws SQLException {
        ArrayList<Project> testact = pm.getAllPartnerProjects(11, con);
        Project act = testact.get(1);
        String act1 = act.getActivityDescription();
        String exp1 = "Test1";
        float act2 = act.getCost();
        float exp2 = 3;
        assertTrue("Oppps, there is a problem! (getAllPartnerProject - Test 0)", act1.equals(exp1));
        assertTrue("Oppps, there is a problem! (getAllPartnerProject - Test 1)", act2 == exp2);
    }

    @Test
    public void testGetCompleteProject() throws SQLException {
        Project act = pm.getCompleteProject(1028, con);
        Project exp = new Project(1028, "Test1", "Test2", 3, "Test4", "Test5", "Test6", "Test7", "Test8", "Test9", "Test10", 11);
        String act1 = act.getActivityDescription();
        String exp1 = "Test1";
        float act2 = act.getCost();
        float exp2 = 3;
        assertTrue("Oppps, there is a problem! (getCompleteProject - Test 0)", act1.equals(exp1));
        assertTrue("Oppps, there is a problem! (getCompleteProject - Test 1)", act2 == exp2);

    }

    @Test
    public void testReadAllProjects() throws SQLException {
        ArrayList<Project> testact = pm.readAllProjects(con);
        Project act = testact.get(10);
        String act1 = act.getActivityDescription();
        String exp1 = "Test1";
        String act2 = act.getComments();
        String exp2 = "Test2";
        float act3 = act.getCost();
        float exp3 = 3;
        assertTrue("Oppps, there is a problem! (readAllProjects - Test 0)", act1.equals(exp1));
        assertTrue("Oppps, there is a problem! (readAllProjects - Test 1)", act2.equals(exp2));
        assertTrue("Oppps, there is a problem! (readAllProjects - Test 2)", act3 == exp3);
    }

    @Test
    public void testGetPendingProjects() throws SQLException {
        ArrayList<Project> testact = pm.getPendingProjects(con);
        Project act = testact.get(1);
        String act1 = act.getStatus();
        String exp1 = "Pending";
        assertTrue("Oppps, there is a problem! (getPendingProjects - Test 0)", act1.equals(exp1));
    }

    @Test
    public void testUpdateApproveProject() throws SQLException {
        boolean act = pm.updateApproveProject(1028, "Approved", con);
        boolean exp = true;
        assertTrue("Oppps, there is a problem! (updateApproveProject - Test 0)", act == exp);
    }

    @Test
    public void testUpdateCostProject() throws SQLException {
        boolean act = pm.updateCostProject(1028, 3, con);
        boolean exp = true;
        float act1 = p.getCost();
        float exp1 = 3;
        assertTrue("Oppps, there is a problem! (updateCostProject - Test 0)", act == exp);
        assertTrue("Oppps, there is a problem! (updateCostProject - Test 1)", act1 == exp1);
    }

    @Test
    public void testUpDateComments() throws SQLException {
        boolean act = pm.upDateComments(1033, "COMMENT", con);
        System.out.println("SURE THIS ONE:" + act);
        assertTrue("Oppps, there is a problem! (upDateComments - Test 0)", act);
    }

    @Test
    public void testCheckForComments() throws SQLException {
        boolean act = pm.checkForComments(1033, con);
        assertTrue("Oppps, there is a problem! (updateCheckForComments - Test 0)", act);
    }

    @Test
    public void testGetComments() throws SQLException {
        String act = pm.getComments(1002, con);
        String exp = "New comment";
        assertTrue("Oppps, there is a problem! (getComments - Test 0)", act.equals(exp));
    }

    @Test
    public void testEditProject() throws SQLException {
        boolean act = pm.editProject(1028, "MDFBudget", "TestEdit", con);
        boolean exp = true;
        assertTrue("Oppps, there is a problem! (editProject - Test 0)", act == exp);

    }

    @Test
    public void testEditCost() throws SQLException {
        boolean act = pm.editCost(1028, "Cost", 3, con);
        boolean exp = true;
        assertTrue("Oppps, there is a problem! (editCost - Test 0)", act == exp);
    }

    @Test
    public void testGetPartnerID() throws SQLException {
        int act = pm.getPartnerID("User11", con);
        int exp = 11;
        assertTrue("Oppps, there is a problem! (getPartnerID - Test 0)", act == exp);
    }
}
