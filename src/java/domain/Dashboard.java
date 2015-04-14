/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Ben & Peter 
 */
public class Dashboard {
        private int prjNo;
        private int partnerNo;
    
        private ArrayList<Project> projectDetails;
        
        public Dashboard(int pr, int pa){
            prjNo  = pr;
            partnerNo = pa;
            projectDetails = new ArrayList<Project>();
        }

    public int getPrjNo() {
        return prjNo;
    }

    public void setPrjNo(int prjNo) {
        this.prjNo = prjNo;
    }

    public int getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(int partnerNo) {
        this.partnerNo = partnerNo;
    }

  public void addDetail(Project pd)
    {
        projectDetails.add(pd);
    }
    String detailsToString(){
         String res = "";
        for (int i = 0; i < projectDetails.size(); i++)
        {
            res += projectDetails.get(i).toString() + "\n";
        }
        return res;
    }    
 public String[][] details()
    {
        String[][] res = new String[projectDetails.size()][9];
        for (int i = 0; i < projectDetails.size(); i++)
        {
            res[i][0] = projectDetails.get(i).getActivityDescription() + "";
            res[i][1] = projectDetails.get(i).getComments() + "";
            res[i][2] = projectDetails.get(i).getCost() + "";
            res[i][3] = projectDetails.get(i).getMDFBudget() + "";
            res[i][4] = projectDetails.get(i).getExecutionQuarter() + "";
            res[i][5] = projectDetails.get(i).getStartDate() + "";
            res[i][6] = projectDetails.get(i).getEndDate() + "";
            res[i][7] = projectDetails.get(i).getObjAndResult() + "";
            res[i][8] = projectDetails.get(i).getRequiredPOE() + "";

        }
        return res;
    }
 public String toString()
    {
        return "Project Number: " + prjNo +  "Partner Number: " +   partnerNo+ "" ;
    }
}