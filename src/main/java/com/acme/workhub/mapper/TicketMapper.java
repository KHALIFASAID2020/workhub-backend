package com.acme.workhub.mapper;
import com.acme.workhub.domain.Ticket;
import com.acme.workhub.dtos.TicketDto;
public final class TicketMapper {
    private TicketMapper() {}
    public static TicketDto toDto(Ticket t) {
        return new TicketDto(
                t.getId(),
                t.getProject()!=null ? t.getProject().getId() : null,
                t.getReporter()!=null ? t.getReporter().getId() : null,
                t.getAssignee()!=null ? t.getAssignee().getId() : null,
                t.getType().name(),
                t.getPriority().name(),
                t.getStatus().name(),
                t.getTitle(),
                t.getDueDate(),
                t.getCreatedAt()
        );
    }
}