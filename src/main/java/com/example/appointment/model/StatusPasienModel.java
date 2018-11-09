package com.example.appointment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "status_pasien")
public class StatusPasienModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max=255)
    @Column(name="jenis", nullable=false)
    private String jenis;

    @OneToMany(mappedBy="statusPasien", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JsonIgnore
    private List<PasienModel> pasienStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public List<PasienModel> getPasienStatus() {
        return pasienStatus;
    }

    public void setPasienStatus(List<PasienModel> pasienStatus) {
        this.pasienStatus = pasienStatus;
    }
}
