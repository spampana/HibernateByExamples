package com.sdnext.hibernate.tutorial.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sdnext.hibernate.tutorial.OneAddressType.Address1;
import com.sdnext.hibernate.tutorial.OneAddressType.UserDetails1;

public class HibernateTestDemo1 {
    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        UserDetails1 user1 = new UserDetails1(); //create first user
        UserDetails1 user2 = new UserDetails1(); //create second user
              
        user1.setUserName("Dinesh Rajput");
        user2.setUserName("Anamika Rajput");
        
        Address1 address1 = new Address1(); //create first value type object for  entity type object user1
        address1.setStreet("K Block House No. 403");
        address1.setCity("Mangol Puri");
        address1.setState("New Delhi");
        address1.setPincode("110083");
        user1.setAddress(address1);
        
        Address1 address2 = new Address1();//create second value type object for  entity type object user2
        address2.setStreet("Film City");
        address2.setCity("Noida");
        address2.setState("UP");
        address2.setPincode("201301");
        user2.setAddress(address2);
        
        user1.setDob(new Date());
        user1.setPhone("+91-9953423462");
        
        user2.setDob(new Date());
        user2.setPhone("+91-9973423462");
        
        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory(); //create a session factory object
        Session session = sessionFactory.openSession(); // create session object from session factory
        session.beginTransaction(); //begin transaction for this session
        
        session.save(user1); //save the first user 
        session.save(user2); //save the second user
        
        session.getTransaction().commit(); //commit the transaction the session
        session.close(); //close the session
    }
}