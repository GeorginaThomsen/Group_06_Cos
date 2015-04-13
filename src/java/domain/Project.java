package domain;

import java.util.Date;

/**
 *
 * @author Cookie
 */
public class Project {
    private int ProjectID;
    private String ActivityDescription;
    private String Comments;
    private float Cost;
    private String MDFBudget;
    private String ExecutionQuarter;
    private String StartDate;
    private String EndDate;
    private String ObjAndResult;
    private String RequiredPOE;

    //Made a constructor:
    public Project(int ProjectID, String ActivityDescription, String Comments, float Cost, String MDFBudget, String ExecutionQuarter, String StartDate, String EndDate, String ObjAndResult, String RequiredPOE) {
//        this.ProjectID = ProjectID;
        this.ActivityDescription = ActivityDescription;
        this.Comments = Comments;
        this.Cost = Cost;
        this.MDFBudget = MDFBudget;
        this.ExecutionQuarter = ExecutionQuarter;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.ObjAndResult = ObjAndResult;
        this.RequiredPOE = RequiredPOE;
    }
    //And getters and setters:
    
    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }
    public String getActivityDescription() {
        return ActivityDescription;
    }

    public void setActivityDescription(String ActivityDescription) {
        this.ActivityDescription = ActivityDescription;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public float getCost() {
        return Cost;
    }

    public void setCost(float Cost) {
        this.Cost = Cost;
    }

    public String getMDFBudget() {
        return MDFBudget;
    }

    public void setMDFBudget(String MDFBudget) {
        this.MDFBudget = MDFBudget;
    }

    public String getExecutionQuarter() {
        return ExecutionQuarter;
    }

    public void setExecutionQuarter(String ExecutionQuarter) {
        this.ExecutionQuarter = ExecutionQuarter;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public String getObjAndResult() {
        return ObjAndResult;
    }

    public void setObjAndResult(String ObjAndResult) {
        this.ObjAndResult = ObjAndResult;
    }

    public String getRequiredPOE() {
        return RequiredPOE;
    }

    public void setRequiredPOE(String RequiredPOE) {
        this.RequiredPOE = RequiredPOE;
    }

    @Override
    public String toString() {
        return "Project{" + "ProjectID=" + ProjectID + ", ActivityDescription=" + ActivityDescription + ", Comments=" + Comments + ", Cost=" + Cost + ", MDFBudget=" + MDFBudget + ", ExecutionQuarter=" + ExecutionQuarter + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", ObjAndResult=" + ObjAndResult + ", RequiredPOE=" + RequiredPOE + '}';
    }

}
