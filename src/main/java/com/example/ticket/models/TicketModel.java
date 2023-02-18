package com.example.ticket.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private String user;
    private String status;
    private Date created_at;
    private Date updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created_at;
    }

    public void setCreated(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated() {
        return updated_at;
    }

    public void setUpdated(Date updated_at) {
        this.updated_at = updated_at;
    }

}
