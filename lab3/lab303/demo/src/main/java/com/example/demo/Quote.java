package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "quote")
public class Quote {

    private long id;
    private String quote;
    private String role;
    private String show;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    public Quote() {
    }

    public Quote(String avaliacao) {

        this.quote = quote;
        this.role = role;
        this.show = show;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "quote", nullable = false)
    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "show", nullable = false)
    public String getShow() {
        return this.show;
    }

    public void setShow(String show) {
        this.show = show;
    }

}