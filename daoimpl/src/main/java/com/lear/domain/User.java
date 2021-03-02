package com.lear.domain;

import java.io.Serializable;

/**
 * @author 93553
 */
public class User implements Serializable {
    private int userid;
    private String phone;
    private String password;
    private String identitycard;
    private String name;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", identitycard='" + identitycard + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
