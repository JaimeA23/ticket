package com.example.ticket.repositories;

import com.example.ticket.models.TicketModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TicketModel, Long> {

}