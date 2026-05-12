package com.example.clientaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClientRequest {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @Pattern(regexp = "^[MF]$", message = "Gender must be 'M' or 'F'")
    private String gender;
}