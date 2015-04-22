/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Georgina
 */
public class Partner {
    private int paID;
    private String partnerName;
    private String country;

    public Partner(int paID, String partnerName, String country) {
        this.paID = paID;
        this.partnerName = partnerName;
        this.country = country;
    }

    public int getPaID() {
        return paID;
    }

    public void setPaID(int paID) {
        this.paID = paID;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Partner: " + "paID = " + paID + ", partnerName = " + partnerName + ", country = " + country ;
    }
    
    
}
