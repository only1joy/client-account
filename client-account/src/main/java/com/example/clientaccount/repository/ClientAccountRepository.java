package com.example.clientaccount.repository;

import com.example.clientaccount.entity.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {
}
