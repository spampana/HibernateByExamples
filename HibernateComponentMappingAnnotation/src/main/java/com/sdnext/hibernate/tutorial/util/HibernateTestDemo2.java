package com.sdnext.hibernate.tutorial.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sdnext.hibernate.tutorial.TwoAddressType.Address2;
import com.sdnext.hibernate.tutorial.TwoAddressType.UserDetails2;




public class HibernateTestDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        UserDetails2 user = new UserDetails2(); //create an user is entity type object
        //user.setUserId(1);
        user.setUserName("Dinesh Rajput");
        
        Address2 address = new Address2(); //create an value type object of address class for home address
        address.setStreet("Block House No");
        address.setCity("MangolaPuri");
        address.setState("New Delhi");
        address.setPincode("110089");
        user.setHomeAddress(address); //set the home address
        
        Address2 address1 = new Address2();//create another value type object for the permanent address
        address1.setStreet("Film City");
        address1.setCity("Noida");
        address1.setState("UP");
        address1.setPincode("201301");
        user.setPermanentAddress(address1);//set the permanent address
        
        user.setJoinDate(new Date());
        user.setPhone("9999222211");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //create a session factory object
        Session session = sessionFactory.openSession(); //create a session object
        session.beginTransaction(); //transaction object start
        session.save(user); //  save the entity type object user to the database
        session.getTransaction().commit(); //commit the transaction object
        session.close(); //close the session
        }
}