package com.acme.workhub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="department")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Department {
    @Id
    @GeneratedValue private UUID id;
    @Column(nullable = false,unique = true,length = 1200)
    private String name;
    @Column(length = 512)
    private String description;
    @Column(name = "created_at",nullable = false)
    private OffsetDateTime createdAt;
    @PrePersist
    void pre(){
        if(createdAt == null)createdAt = OffsetDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
