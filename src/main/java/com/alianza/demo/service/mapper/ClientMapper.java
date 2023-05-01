package com.alianza.demo.service.mapper;

import org.mapstruct.Mapper;

import com.alianza.demo.dominio.Client;
import com.alianza.demo.service.dto.ClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {
    

    
}
