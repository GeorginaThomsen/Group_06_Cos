/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.InputStream;

/**
 *
 * @author Georgina:
 */
public class POE {

    private int projectID;
    private String type;
    private InputStream data;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputStream getData() {
        return data;
    }

    public void setData(InputStream data) {
        this.data = data;
    }

    public POE(int projectID, String type, InputStream data) {
        this.projectID = projectID;
        this.type = type;
        this.data = data;
    }

}
