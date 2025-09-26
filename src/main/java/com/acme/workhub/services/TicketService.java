package com.acme.workhub.services;
import com.acme.workhub.domain.Ticket;
import com.acme.workhub.dtos.TicketDto;
import com.acme.workhub.mapper.TicketMapper;
import com.acme.workhub.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    public Page<TicketDto> list(Pageable pageable) {
        return repo.findAll(pageable).map(TicketMapper::toDto);
    }

    public List<TicketDto> byProjectAndStatus(UUID projectId, Ticket.Status status) {
        return repo.findByProjectIdAndStatus(projectId, status).stream().map(TicketMapper::toDto).toList();
    }
}