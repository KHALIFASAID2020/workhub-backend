package com.acme.workhub.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity @Table(name="employee")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {
    public enum Role { ADMIN, USER, SUPERADMIN }
    @Id @GeneratedValue private UUID id;
    @Column(nullable=false, unique=true, length=60) private String username;
    @Column(nullable=false, unique=true, length=254) private String email;
    @Column(name="password_hash", nullable=false, length=255) private String passwordHash;
    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private Role role;
    @Column(name="first_name", length=60) private String firstName;
    @Column(name="last_name", length=60) private String lastName;
    @Column(nullable=false) private boolean active = true;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="department_id")
    private Department department;

    @Column(name="created_at", nullable=false) private OffsetDateTime createdAt;
    @PrePersist void pre(){ if(createdAt==null) createdAt=OffsetDateTime.now(); }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}