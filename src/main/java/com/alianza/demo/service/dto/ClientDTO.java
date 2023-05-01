package com.alianza.demo.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientDTO implements Serializable {
    
    private String sharedKey;
    private String bussinessId;
    private String email;
    private Long phone;
    private LocalDate dataAdded;
    
}
