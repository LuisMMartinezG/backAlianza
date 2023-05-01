package com.alianza.demo.service;

import java.util.List;
import java.util.Optional;

import com.alianza.demo.service.dto.ClientDTO;

public interface ClientService {

    ClientDTO save(ClientDTO clientDTO);

    List<ClientDTO> findAll();

    void delete(String sharedKey);

    ClientDTO update(ClientDTO clientDTO) throws Exception;

    Optional<ClientDTO> findBySharedKey(String sharedKey);
    
}
