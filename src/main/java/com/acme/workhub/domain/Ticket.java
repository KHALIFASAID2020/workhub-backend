package com.acme.workhub.domain;
import jakarta.persistence.*; import lombok.*; import java.time.*; import java.util.UUID;

@Entity @Table(name="ticket")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Ticket {
    public enum Type { BUG, TASK, STORY }
    public enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
    public enum Status { OPEN, IN_PROGRESS, DONE, CANCELLED }

    @Id @GeneratedValue private UUID id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="project_id", nullable=false) private Project project;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="reporter_id", nullable=false) private Employee reporter;
    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="assignee_id") private Employee assignee;

    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private Type type;
    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private Priority priority = Priority.MEDIUM;
    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private Status status = Status.OPEN;

    @Column(nullable=false, length=200) private String title;
    @Column(columnDefinition="text") private String description;
    private LocalDate dueDate;

    @Column(name="created_at", nullable=false) private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name="updated_at") private OffsetDateTime updatedAt;
    @PreUpdate void up(){ updatedAt = OffsetDateTime.now(); }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getReporter() {
        return reporter;
    }

    public void setReporter(Employee reporter) {
        this.reporter = reporter;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
