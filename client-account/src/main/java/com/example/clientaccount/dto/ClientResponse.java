package com.example.clientaccount.dto;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class ClientResponse {
    private Long id;
    private String fullName;
    private String gender;
    private String status;
    private Instant createDttm;
    private Instant modifyDttm;
}
