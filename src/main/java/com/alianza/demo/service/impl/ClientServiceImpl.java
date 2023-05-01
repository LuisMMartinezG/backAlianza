package com.alianza.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alianza.demo.repository.JpaClientRepository;
import com.alianza.demo.service.ClientService;
import com.alianza.demo.service.dto.ClientDTO;
import com.alianza.demo.service.mapper.ClientMapper;


@Service
public class ClientServiceImpl implements ClientService {
    
    private final JpaClientRepository clientRepository;
    private final ClientMapper clientMapper;
    
    public ClientServiceImpl(JpaClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }
    

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toDomain(clientDTO)));
    }

    @Override   
    public List<ClientDTO> findAll() {
       return clientMapper.toDto(clientRepository.findAll());
    }

    @Override
    public void delete(String sharedKey) {
        clientRepository.deleteBySharedKey(sharedKey);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) throws Exception {
        return clientMapper.toDto(clientRepository.save(clientMapper.toDomain(clientDTO)));
    }

    @Override
    public Optional<ClientDTO> findBySharedKey(String sharedKey) {
        return clientRepository.findBySharedKey(sharedKey).map(clientMapper::toDto);
    }
    
}
