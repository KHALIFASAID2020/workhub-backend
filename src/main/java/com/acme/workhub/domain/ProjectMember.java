package com.acme.workhub.domain;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity @Table(name="project_member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMember {
    public enum MemberRole { MANAGER, CONTRIBUTOR, VIEWER }

    @EmbeddedId private Id id = new Id();

    @MapsId("projectId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

    @MapsId("employeeId")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name="member_role", nullable=false, length=20)
    private MemberRole memberRole;

    @Column(name="joined_at", nullable=false)
    private OffsetDateTime joinedAt = OffsetDateTime.now();

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MemberRole getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(MemberRole memberRole) {
        this.memberRole = memberRole;
    }

    public OffsetDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(OffsetDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Embeddable
    @EqualsAndHashCode
    public static class Id implements Serializable {
        private UUID projectId;
        private UUID employeeId;

        public UUID getProjectId() {
            return projectId;
        }

        public void setProjectId(UUID projectId) {
            this.projectId = projectId;
        }

        public UUID getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(UUID employeeId) {
            this.employeeId = employeeId;
        }
    }

}
