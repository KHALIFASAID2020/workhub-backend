package com.acme.workhub.controllers;

import com.acme.workhub.domain.Ticket;
import com.acme.workhub.dtos.TicketDto;
import com.acme.workhub.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/tickets")
    public Page<TicketDto> all(Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/projects/{projectId}/tickets")
    public List<TicketDto> byProject(
            @PathVariable UUID projectId,
            @RequestParam(defaultValue = "OPEN") Ticket.Status status
    ) {
        return service.byProjectAndStatus(projectId, status);
    }
}
