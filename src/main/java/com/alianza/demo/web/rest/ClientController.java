package com.alianza.demo.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.demo.service.ClientService;
import com.alianza.demo.service.dto.ClientDTO;




@RestController
@RequestMapping("/api")
public class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);
    
    private final ClientService clientService;   


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * {@code POST  /clients} : Crear un nuevo cliente.
     *
     * @param clientDTO the clientDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new clientDTO, or with status {@code 400 (Bad Request)} if the client has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        log.debug("REST request to save Client : {}", clientDTO);  
        ClientDTO client = clientService.save(clientDTO);
        URI location = URI.create(String.format("/clients/%s", client.getSharedKey()));
        return ResponseEntity.created(location).body(client);
    }

    @GetMapping("/clients/{sharedKey}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable String sharedKey) {
        log.debug("REST request to get client : {}", sharedKey);
        Optional<ClientDTO> oClientDTO = clientService.findBySharedKey(sharedKey);
        if(oClientDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oClientDTO.get());
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        log.debug("REST request to get all clients");
        List<ClientDTO> clients = clientService.findAll();
        log.info("--- clientes {}", clients);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return ResponseEntity.ok().headers(headers).body(clients);
    }

    @PutMapping("/clients")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) { 

        log.debug("REST request to update Cliente : {}", clientDTO);
        if (Objects.isNull(clientDTO)) {
            return ResponseEntity.badRequest().build();
        }
        if (clientDTO.getSharedKey() == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            ClientDTO result = clientService.update(clientDTO); 
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return null;
        }        
    
    }

    @DeleteMapping("/clients/{sharedKey}")
    public ResponseEntity<String> deleteClient(@PathVariable String sharedKey) {
        log.debug("REST request to delete client : {}", sharedKey);
        clientService.delete(sharedKey);
        return ResponseEntity.ok("Deleted entity");
    }

    
}
