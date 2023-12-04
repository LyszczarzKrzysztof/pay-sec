package com.example.paysec.entity;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String urlToCloudinary;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Picture() {
    }

    public Picture(String description, String urlToCloudinary, User user) {
        this.description = description;
        this.urlToCloudinary = urlToCloudinary;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToCloudinary() {
        return urlToCloudinary;
    }

    public void setUrlToCloudinary(String urlToCloudinary) {
        this.urlToCloudinary = urlToCloudinary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
