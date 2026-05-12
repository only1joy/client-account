package com.example.clientaccount.service;

import com.example.clientaccount.dto.ClientRequest;
import com.example.clientaccount.dto.ClientResponse;
import java.util.List;

public interface ClientService {
    ClientResponse create(ClientRequest request);
    List<ClientResponse> getAll();
    ClientResponse getById(Long id);
    ClientResponse update(Long id, ClientRequest request);
    void delete(Long id);
}
