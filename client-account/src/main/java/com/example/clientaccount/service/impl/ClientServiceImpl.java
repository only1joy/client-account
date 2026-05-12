package com.example.clientaccount.service.impl;

import com.example.clientaccount.dto.ClientRequest;
import com.example.clientaccount.dto.ClientResponse;
import com.example.clientaccount.entity.ClientAccount;
import com.example.clientaccount.exception.ResourceNotFoundException;
import com.example.clientaccount.repository.ClientAccountRepository;
import com.example.clientaccount.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientAccountRepository repository;

    @Override
    @Transactional
    public ClientResponse create(ClientRequest request) {
        ClientAccount entity = new ClientAccount();
        entity.setFullName(request.getFullName());
        entity.setGender(request.getGender());
        ClientAccount saved = repository.save(entity);
        return toResponse(saved);
    }

    @Override
    public List<ClientResponse> getAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ClientResponse getById(Long id) {
        ClientAccount entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        return toResponse(entity);
    }

    @Override
    @Transactional
    public ClientResponse update(Long id, ClientRequest request) {
        ClientAccount entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        entity.setFullName(request.getFullName());
        entity.setGender(request.getGender());
        ClientAccount updated = repository.save(entity);
        return toResponse(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
        repository.deleteById(id);
    }
    public List<ClientAccount> getByStatus() {
        List<ClientAccount> repositoryALL = repository.findAll();
        List<ClientAccount> activeclients = new ArrayList<>();
        for (ClientAccount clientaccount : repositoryALL) {
            if ("ACTIVE".equals(clientaccount.getStatus()))
            activeclients.add(clientaccount);
        }
        return activeclients;
    }

    private ClientResponse toResponse(ClientAccount entity) {
        return ClientResponse.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .status(entity.getStatus())
                .createDttm(entity.getCreateDttm())
                .modifyDttm(entity.getModifyDttm())
                .build();
    }
}
