package com.alianza.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alianza.demo.dominio.Client;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, String>, JpaSpecificationExecutor<Client> {

    Optional<Client> findBySharedKey(String sharedKey);

    @Query(value = "DELETE FROM CLIENTS WHERE shared_key :sharedKey ", nativeQuery = true)
    void deleteBySharedKey(@Param("sharedKey") String sharedKey);

}
