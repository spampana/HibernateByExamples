package com.sdnext.hibernate.tutorial.TwoAddressType;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_TABLE2")
public class UserDetails2 
{
    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int    userId;
    
    @Column(name="USER_NAME")
    private String userName;
    
    @Column(name="DOB")
    private Date joinDate;
    
    @Column(name="ADDRESS")
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
    @AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
    @AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
    @AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE"))})
    private Address2 homeAddress;
    
    @Embedded
    private Address2 permanentAddress;
    
    @Column(name="Phone")
      private String phone;
    
    public int getUserId() {
        return userId;
    }
    public Address2 getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(Address2 homeAddress) {
        this.homeAddress = homeAddress;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Address2 getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address2 permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone= phone;
    }
    
    public String toString()
    {
        return "[User Name: "+userName+"\n Permanent Address: "+permanentAddress+"\n Home Address: "+homeAddress+"\n Date of Birth: "+joinDate+"\n Phone: "+phone+"]";
    }
}