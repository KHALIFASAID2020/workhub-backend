package com.acme.workhub.repository;

import com.acme.workhub.AbstractIT;
import com.acme.workhub.domain.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketRepositoryIT extends AbstractIT {

    @Autowired
    TicketRepository ticketRepo;

    @Autowired
    ProjectRepository projectRepo;

    @Test
    void shouldFindOpenTicketsForCoreProject() {
        var prj = projectRepo.findByCode("PRJ-CORE").orElseThrow();
        var list = ticketRepo.findByProjectIdAndStatus(prj.getId(), Ticket.Status.OPEN);
        Assertions.assertFalse(list.isEmpty(), "Il devrait y avoir au moins 1 ticket OPEN");
    }
}
