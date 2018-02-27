package com.shhh.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    private String email;

    @Column(name="is_deleted")
    private byte isDeleted;

    private String password;

    private String username;
    
    @Column(name="current_lat")
    private Float currentLat;
    
    @Column(name="current_long")
    private Float currentLong;
    
    

    public Users() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getCurrentLat() {
      return currentLat;
    }

    public void setCurrentLat(Float currentLat) {
      this.currentLat = currentLat;
    }

    public Float getCurrentLong() {
      return currentLong;
    }

    public void setCurrentLong(Float currentLong) {
      this.currentLong = currentLong;
    }
    
    

}