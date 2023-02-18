package com.example.ticket.services;

import java.util.ArrayList;
import com.example.ticket.models.TicketModel;
import com.example.ticket.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.json.JSONArray;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public ArrayList<TicketModel> getTickets() {
        return (ArrayList<TicketModel>) ticketRepository.findAll();
    }

    public JSONArray saveTicket(TicketModel ticket) {
        String statusin = ticket.getStatus();

        JSONArray response = new JSONArray();

        if (ticket.getUser() == null) {

            response.put("Se requiere ingresar un usuario para generar el ticket");
            return response;

        }

        if (!"abierto".equals(statusin) && !"cerrado".equals(statusin)) {

            response.put("El estado solo puede ser abierto o cerrado");
            return response;

        }

        Date date = new Date();
        ticket.setCreated(date);
        ticket.setUpdated(date);

        response.put(ticketRepository.save(ticket));

        return response;
    }

    public JSONArray editTicket(TicketModel ticket) {

        JSONArray response = new JSONArray();

        if (ticket.getId() == null) {

            response.put("Se requiere el id del ticket a editar");

            return response;
        }

        Date date = new Date();

        try {

            TicketModel ticketOriginal = ticketRepository.findById(ticket.getId()).get();

            Date dateCreate = ticketOriginal.getCreated();
            String statusin = ticket.getStatus();

            if (ticket.getStatus() == null) {

                String statusOriginal = ticketOriginal.getStatus();
                ticket.setStatus(statusOriginal);

            } else if (!"abierto".equals(statusin) && !"cerrado".equals(statusin)) {

                response.put("El estado solo puede ser abierto o cerrado");
                return response;

            }

            if (ticket.getUser() == null) {

                String userOriginal = ticketOriginal.getUser();
                ticket.setUser(userOriginal);

            }

            ticket.setUpdated(date);
            ticket.setCreated(dateCreate);

            response.put(ticketRepository.save(ticket));

            return response;

        } catch (Exception e) {

            response.put("El ticket que se quiere editar no existe");

            return response;
        }

    }

    public JSONArray getById(Long id) {
        JSONArray response = new JSONArray();

        try {
            TicketModel result = ticketRepository.findById(id).get();
            response.put(result);
            return response;

        } catch (Exception e) {
            response.put("No existe un ticket con el id: " + id);
            return response;
        }

    }

    public boolean deleteTicket(Long id) {
        try {
            ticketRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
