package com.newtodos.newtodos.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class users {
    @Id
    private long userid;
    @Column
    private String username;
    @Column(name="pass_word")
    private String password;

    
    public users(long userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public users(){
        
    }

    @Override
    public String toString() {
        return "users [userid=" + userid + ", username=" + username + ", password=" + password + "]";
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
