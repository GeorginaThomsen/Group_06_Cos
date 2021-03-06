package datasource;

import domain.POE;
import domain.Project;
import domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
        preStatement.setString(10, p.getStatus());
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
                + "where partnerID = ?";

        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQLProject1);
        try {
            //=== Get partner

            preStatement = con.prepareStatement(SQLProject1);

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

        String SQLProject = "update project set Status = ? where ProjectID = ? ";
        //updating project

        PreparedStatement preStatement = null;

        preStatement = con.prepareStatement(SQLProject);
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

    //When we change/update our DB we should also change this accordingly.
    //Georgina:
    public User login(String username, String password, String userType, Connection con) {
        User user = null;
        try {
            String sql = "SELECT * FROM UserTable WHERE Username = ? AND Password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

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

    //Ben:
    public boolean insertComments(int projectID, String comments, Connection con) throws SQLException {
        int TuplesInserted = 0;
        String SQLProject = "insert into Comments values(?,?)";
        PreparedStatement preStatement = null;

        preStatement = con.prepareStatement(SQLProject);

        preStatement.setInt(1, projectID);
        preStatement.setString(2, comments);

        TuplesInserted = preStatement.executeUpdate();

        return TuplesInserted == 1;//If there is one tuple then it succeded and is true
    }

    //Ben:
    public boolean upDateComments(int projectID, String comments, Connection con) throws SQLException {
        int TuplesInserted = 0;
        String SQLProject = "update  Comments set comments = ? where projectID = ? ";
        PreparedStatement preStatement = null;
        String previous = getComments(projectID, con);
        preStatement = con.prepareStatement(SQLProject);

        preStatement.setString(1, previous + " ::: " + comments);
        preStatement.setInt(2, projectID);

        TuplesInserted = preStatement.executeUpdate();

        return TuplesInserted == 1;//If there is one tuple then it succeded and is true
    }

    public boolean checkForComments(int projectID, Connection con) throws SQLException {
        int comments = 0;
        String SQL = "select * from comments where projectid = ?  ";
        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(SQL);
        preStatement.setInt(1, projectID);

        comments = preStatement.executeUpdate();

        return comments == 1;
    }

    public String getComments(int projectID, Connection con) throws SQLException {
        String comments = "";
        try {
            String SQL = "select comments from comments where projectID = ? ";
            PreparedStatement preStatement = null;
            preStatement = con.prepareStatement(SQL);
            preStatement.setInt(1, projectID);
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                comments = rs.getString("COMMENTS");
            }

            return comments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //added by ben:                 
    public boolean editProject(int pno, String column, String edit, Connection con) throws SQLException {

        int TuplesUpdated = 0;

        String SQLProject = "update project set " + column + " = ? where ProjectID = ? ";
        //updating project

        PreparedStatement preStatement = null;

        preStatement = con.prepareStatement(SQLProject);
        preStatement.setString(1, edit);
        preStatement.setInt(2, pno);     // primary key value

        TuplesUpdated = preStatement.executeUpdate();

        return TuplesUpdated == 1;
    }

    public boolean editCost(int pno, String column, float edit, Connection con) throws SQLException {

        int TuplesUpdated = 0;

        String SQLProject = "update project set " + column + " = ? where ProjectID = ? ";
        //updating project

        PreparedStatement preStatement = null;

        preStatement = con.prepareStatement(SQLProject);
        preStatement.setFloat(1, edit);
        preStatement.setInt(2, pno);     // primary key value

        TuplesUpdated = preStatement.executeUpdate();

//          getPendingProjects(con);
        return TuplesUpdated == 1;
    }

    //Ben:
    public int getPartnerID(String partnerName, Connection con) throws SQLException {
        int partnerID = 0;
        try {
            String SQL = "select PartnerID from PartnerEmployee where username = ? ";
            PreparedStatement preStatement = null;
            preStatement = con.prepareStatement(SQL);
            preStatement.setString(1, partnerName);
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                partnerID = rs.getInt("PartnerID");
            }

            return partnerID;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    //Georgina:
    public void savePOE(POE poe, Connection con) throws SQLException {
        String sql = "INSERT INTO POETABLE(ProjectID, Type, POE) VALUES(?, ?, ?)";
        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(sql);

        preStatement.setInt(1, poe.getProjectID());
        preStatement.setString(2, poe.getType());
        preStatement.setBlob(3, poe.getData());

        preStatement.executeUpdate();
    }
//  Georgina:

    public void getPOE(int projectID, Connection con, HttpServletResponse response) throws SQLException, IOException {
        String sql = "SELECT * FROM POETABLE WHERE projectID  = ?";
        PreparedStatement preStatement = null;
        preStatement = con.prepareStatement(sql);
        preStatement.setInt(1, projectID);

        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {

            response.setContentType(rs.getString("TYPE"));
            try (OutputStream out = response.getOutputStream()) {
                InputStream in = rs.getBinaryStream("POE");
                int count = 0;
                byte[] buffer = new byte[1024];
                do {
                    count = in.read(buffer);
                    out.write(buffer, 0, count);
                } while (count == 1024);
            }
        }

    }
}
