package edu.iset.authent.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Pointage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDate date;

    private LocalTime heureArrive;

    private LocalTime heureDepart;

    private Double latitude;

    private Double longitude;

    @Column(name = "temps_veille")
    private Integer tempsVeille; // En minutes

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureArrive() {
        return heureArrive;
    }

    public void setHeureArrive(LocalTime heureArrive) {
        this.heureArrive = heureArrive;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getTempsVeille() {
        return tempsVeille;
    }

    public void setTempsVeille(Integer tempsVeille) {
        this.tempsVeille = tempsVeille;
    }
}
