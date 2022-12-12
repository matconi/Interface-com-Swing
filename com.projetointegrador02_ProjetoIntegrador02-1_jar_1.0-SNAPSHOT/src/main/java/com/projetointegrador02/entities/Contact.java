/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador02.entities;

/**
 *
 * @author Usuario
 */
public class Contact {
    private int id;
    private String contactName;
    private User currentId;
    private User contactId;
    
    public Contact(User currentId) {
        this.currentId = currentId;
    }
    
     public Contact(int id) {
        this.id = id;
    }
     
    public Contact(User currentId, User contactId) {
        this.currentId = currentId;
        this.contactId = contactId;      
    }
    
    public Contact(String contactName, User currentId, User contactId) {
        this.contactName = contactName;
        this.currentId = currentId;
        this.contactId = contactId;
    }
    //table
    public Contact(int id, String contactName, User contactId) { 
        this.id = id;
        this.contactId = contactId;
        this.contactName = contactName;
    }
    
     public Contact(String contactName, User contactId) { 
        this.contactId = contactId;
        this.contactName = contactName;
    }
    
    public Contact() {
        
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    public String getContactName() {
        return contactName;
    }
    
    public void setCurrentId(User currentId) {
        this.currentId = currentId;
    }
    
    public User getCurrentId() {
        return currentId;
    }
  
    public void setContactId(User contactId) {
        this.contactId = contactId;
    }
    
    public User getContactId() {
        return contactId;
    } 
    
}

