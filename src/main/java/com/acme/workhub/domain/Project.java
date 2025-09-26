package com.acme.workhub.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.*;
import java.util.UUID;

@Entity @Table(name="project")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Project {
    public enum Status { PLANNED, ACTIVE, ON_HOLD, DONE }
    @Id @GeneratedValue private UUID id;
    @Column(nullable=false, unique=true, length=20) private String code;
    @Column(nullable=false, length=160) private String name;
    @Column(length=1024) private String description;
    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private Status status = Status.PLANNED;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Employee owner;

    private LocalDate startDate, endDate;

    @Column(name="created_at", nullable=false)
    private OffsetDateTime createdAt;
    @PrePersist void pre(){ if(createdAt==null) createdAt=OffsetDateTime.now(); }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
