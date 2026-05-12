package com.example.clientaccount.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Table(name = "client_account")
@Data
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "create_dttm", nullable = false, updatable = false)
    private Instant createDttm;

    @Column(name = "modify_dttm", nullable = false)
    private Instant modifyDttm;

    @PrePersist
    protected void onCreate() {
        createDttm = Instant.now();
        modifyDttm = Instant.now();
        if (status == null) {
            status = "ACTIVE";
        }
    }

    @PreUpdate
    protected void onUpdate() {
        modifyDttm = Instant.now();
    }
}
