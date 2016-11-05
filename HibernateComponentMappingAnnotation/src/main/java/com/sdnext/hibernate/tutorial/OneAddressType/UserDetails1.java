package com.sdnext.hibernate.tutorial.OneAddressType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_TABLE1")
public class UserDetails1 
{
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ID")
    private int    userId;
    
    @Column(name="USER_NAME") 
    private String userName;
    
    @Embedded //For value type object
    private Address1 address;
    
    @Column(name="USER_PHONE")
    private String phone;
    
    @Column(name="DOB")
    private Date dob;
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Address1 getAddress() {
        return address;
    }
    public void setAddress(Address1 address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getUserId() {
        return userId;
    }
    public String toString()
    {
        return "[User Name: "+userName+"User Id: "+userId+" User Address "+address+" Use phone " +phone+" ]";
    }
}