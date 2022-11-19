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
    private int currentId;
    private int contactId;
    
    public Contact(int contactId) {
        this.contactId = contactId;
    }
    
    public Contact(int currentId, int contactId) {
        this.currentId = currentId;
        this.contactId = contactId;      
    }
    
    public Contact(String contactName, int currentId, int contactId) {
        this.contactName = contactName;
        this.currentId = currentId;
        this.contactId = contactId;
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
    
    public String getcontactName() {
        return contactName;
    }
    
    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }
    
    public int getCurrentId() {
        return currentId;
    }
  
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    
    public int getContactId() {
        return contactId;
    } 
    
}

