/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Georgina:
 */
public class User {

    private int id;
    private String name;
    private String country;
    private String password;
    private String userType;

    public User(int id, String name, String country/* ,String UserType*/) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public User(String name, String password, String userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

}
