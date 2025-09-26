package com.acme.workhub;

import com.acme.workhub.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkhubBackendApplication implements CommandLineRunner {

    public WorkhubBackendApplication(TicketRepository tickets) {
        this.tickets = tickets;
    }

    public static void main(String[] args) {
		SpringApplication.run(WorkhubBackendApplication.class, args);
	}
	private final TicketRepository tickets;

	@Override
	public void run(String... args) throws Exception {
		long count = tickets.count();
		System.out.println(">>> Tickets au démarrage: " + count);
	}
}
