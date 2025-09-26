package com.acme.workhub.repository;
import com.acme.workhub.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findByProjectIdAndStatus(UUID projectId, Ticket.Status status);
}

