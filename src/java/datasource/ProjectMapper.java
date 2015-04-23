package datasource;

import domain.Partner;
import domain.Project;
import domain.User;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Georgina Thomsen
 */
public class ProjectMapper {

    //Georgina:
    public boolean insertProjects(Project p, Connection con) throws SQLException {
        int TuplesInserted = 0;
        String SQLProject = "insert into Project values(ProID.nextval,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preStatement = null;

        preStatement = con.prepareStatement(SQLProject);

        preStatement.setString(1, p.getActivityDescription());
        preStatement.setString(2, p.getComments());
        preStatement.setFloat(3, p.getCost());
        preStatement.setString(4, p.getMDFBudget());
        preStatement.setString(5, p.getExecutionQuarter());
        preStatement.setString(6, p.getStartDate());
        preStatement.setString(7, p.getEndDate());
        preStatement.setString(8, p.getObjAndResult());
        preStatement.setString(9, p.getRequiredPOE());
        preStatement.setString(10, "Pending");
        preStatement.setInt(11, p.getPaID());

        TuplesInserted = preStatement.executeUpdate();

        return TuplesInserted == 1;//If there is one tuple then it succeded and is true
    }

    public Project getProject(int pno, Connection con) throws SQLException {
        Project p = null;

        String SQLProject = //Getting project
                "select * "
                + "from project "
                + "where projectid = ?";
        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject);
        try {
            //=== Get project

            preStatement = con.prepareStatement(SQLProject);

            preStatement.setInt(1, pno);     // primary key value
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                p = new Project(pno,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }

        } catch (Exception e) {
            System.out.println("Fail 1 in ProjectMapper - getProject");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                preStatement.close();
            } catch (SQLException e) {
                System.out.println("Fail 2 in ProjectMapper - getProject");
                System.out.println(e.getMessage());
            }
        }
        return p;
    }
//     added by Ben: 

    public ArrayList<Project> getAllPartnerProjects(int paID, Connection con) throws SQLException {
        ArrayList<Project> details = new ArrayList();

        String SQLProject1
                = "select projectID "
                + "from project "
                + "where PartnerID = ?";

        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject1);
        try {
            //=== Get partner

            preStatement = con.prepareStatement(SQLProject1);

//              System.out.println("Got as far as this!!*********");
            preStatement.setInt(1, paID);
            ResultSet rs = preStatement.executeQuery();
            List projects = new ArrayList();
            while (rs.next()) {
                //adds the projectIDs to an arraylist

                projects.add(rs.getInt(1));
                //gets all the project details and add them to an arraylist

                details.add(getProject(rs.getInt(1), con));
            }

        } catch (Exception e) {
            System.out.println("Fail 1 in ProjectMapper - getAllPartnerProjects");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                preStatement.close();
            } catch (SQLException e) {
                System.out.println("Fail 2 in ProjectMapper - getAllPartnerProjects");
                System.out.println(e.getMessage());
            }
        }
        return (details);
    }

    public Project getCompleteProject(int pno, Connection con) throws SQLException {
        Project p = null;

        String SQLProject = //Getting project
                "select * "
                + "from project "
                + "where projectid = ?";
        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject);
        try {
            //=== Get project

            preStatement = con.prepareStatement(SQLProject);

            preStatement.setInt(1, pno);     // primary key value
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                p = new Project(pno,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getInt(12));
            }

        } catch (Exception e) {
            System.out.println("Fail 1 in ProjectMapper - getProject");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                preStatement.close();
            } catch (SQLException e) {
                System.out.println("Fail 2 in ProjectMapper - getProject");
                System.out.println(e.getMessage());
            }
        }
        return p;
    }

    public ArrayList<Project> readAllProjects(Connection con) throws SQLException {
        ArrayList<Project> details = new ArrayList();

        String SQLProject1
                = "select projectID "
                + "from project ";

        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject1);
        try {

            preStatement = con.prepareStatement(SQLProject1);

           
            ResultSet rs = preStatement.executeQuery();
            List projects = new ArrayList();
            while (rs.next()) {
                //adds the projectIDs to an arraylist
                projects.add(rs.getInt(1));
                //gets all the project details and add them to an arraylist
                details.add(getCompleteProject(rs.getInt(1), con));
            }

        } catch (Exception e) {
            System.out.println("Fail 1 in ProjectMapper - readAllProjects");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                preStatement.close();
            } catch (SQLException e) {
                System.out.println("Fail 2 in ProjectMapper - readAllProjects");
                System.out.println(e.getMessage());
            }
        }
        return (details);
    }

    public ArrayList<Project> getPendingProjects(Connection con) throws SQLException {
        ArrayList<Project> details = new ArrayList();

        String SQLProject1
                = "select projectID "
                + "from project "
                + "where status = 'Pending'";

        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject1);
        try {
            //=== Get partner

            preStatement = con.prepareStatement(SQLProject1);

//              System.out.println("Got as far as this!!*********");
            ResultSet rs = preStatement.executeQuery();
            List projects = new ArrayList();
            while (rs.next()) {
                //adds the projectIDs to an arraylist

                projects.add(rs.getInt(1));
                //gets all the project details and add them to an arraylist

                details.add(getCompleteProject(rs.getInt(1), con));
            }

        } catch (Exception e) {
            System.out.println("Fail 1 in ProjectMapper - getPendingProjects");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                preStatement.close();
            } catch (SQLException e) {
                System.out.println("Fail 2 in ProjectMapper - getPendingProjects");
                System.out.println(e.getMessage());
            }
        }
        return (details);
    }

    //added by ben:                 
    public boolean updateApproveProject(int pno, String approve, Connection con) throws SQLException {

        int TuplesUpdated = 0;
        System.out.println(pno);
        System.out.println(approve);

        String SQLProject = "update project set Status = ? where ProjectID = ? ";
        //updating project

        PreparedStatement preStatement = null;

        System.out.println("about to execute");
        preStatement = con.prepareStatement(SQLProject);
        System.out.println("executed");
        preStatement.setString(1, approve);
        preStatement.setInt(2, pno);     // primary key value

        TuplesUpdated = preStatement.executeUpdate();

//          getPendingProjects(con);
        return TuplesUpdated == 1;
    }

    public boolean updateCostProject(int pno, float cost, Connection con) throws SQLException {
        
        int TuplesUpdated = 0;
        
        String SQLCost = "update project set cost = ? where ProjectID = ?";
        PreparedStatement preStatement = null;
        
        preStatement = con.prepareStatement(SQLCost);
        preStatement.setFloat(1, cost);
        preStatement.setInt(2, pno);
        
        TuplesUpdated = preStatement.executeUpdate();
        
        return TuplesUpdated == 1;
    }

    //Georgina:
    public User login(String username, String password, String userType, Connection con) {
        User user = null;
        try {
            String sql = "SELECT * FROM UserTable WHERE Username = ? AND Password = ?";
//            String sql = "SELECT * FROM Partner WHERE PartnerName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                int id = rs.getInt("PARTNERID");
//                String name = rs.getString("PARTNERNAME");
//                String country = rs.getString("COUNTRY");
//                user = new User(id, name, country);
//            }
            if (rs.next()) {
                String usern = rs.getString("USERNAME");
                String pass = rs.getString("PASSWORD");
                String userTyp = rs.getString("USERTYPE");
                user = new User(usern, pass, userTyp);

            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
