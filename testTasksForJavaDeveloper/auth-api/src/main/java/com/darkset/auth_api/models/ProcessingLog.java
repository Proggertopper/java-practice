package com.darkset.auth_api.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "processing_log")
@Data
public class ProcessingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn()
    private User user;

    @Column(name = "input_text")
    private String inputText;

    @Column(name = "output_text")
    private String outputText;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
