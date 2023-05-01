package com.alianza.demo.dominio;

import java.io.Serializable;

import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
@Table(name = "clients")
public class Client implements Serializable  {
    
    @Id
    @Column(name = "shared_key")
    private String sharedKey;

    @Column(name = "name", length = 50)
    private String bussinessId;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", length = 11)
    private Long phone;

    @Column(name = "data_added")
    private LocalDate dataAdded;

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }

    public String getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(String bussinessId) {
        this.bussinessId = bussinessId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public LocalDate getDataAdded() {
        return dataAdded;
    }

    public void setDataAdded(LocalDate dataAdded) {
        this.dataAdded = dataAdded;
    }

    @Override
    public String toString() {
        return "Client [sharedKey=" + sharedKey + ", bussinessId=" + bussinessId + ", email=" + email + ", phone="
                + phone + ", dataAdded=" + dataAdded + "]";
    }
    
}
