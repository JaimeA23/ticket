package com.example.ticket.controllers;

import java.util.ArrayList;
import com.example.ticket.models.TicketModel;
import com.example.ticket.services.TicketService;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping(path = "/all")
    public ArrayList<TicketModel> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping(path = "/{id}")
    public JSONArray getTicketById(@PathVariable("id") Long id) {
        return this.ticketService.getById(id);
    }

    @PostMapping(path = "/save")
    public JSONArray saveTicket(@RequestBody TicketModel ticket) {
        return this.ticketService.saveTicket(ticket);
    }

    @PostMapping(path = "/edit")
    public JSONArray editTicket(@RequestBody TicketModel ticket) {
        return this.ticketService.editTicket(ticket);
    }

    @DeleteMapping(path = "delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.ticketService.deleteTicket(id);
        if (ok) {
            return "Se eliminó el Ticket con id=  " + id;
        } else {
            return "No pudo eliminar el Ticket con id=  " + id;
        }
    }

}