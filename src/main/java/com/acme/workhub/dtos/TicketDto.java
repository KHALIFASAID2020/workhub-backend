package com.acme.workhub.dtos;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TicketDto(
        UUID id,
        UUID projectId,
        UUID reporterId,
        UUID assigneeId,
        String type,
        String priority,
        String status,
        String title,
        LocalDate dueDate,
        OffsetDateTime createdAt
) {}