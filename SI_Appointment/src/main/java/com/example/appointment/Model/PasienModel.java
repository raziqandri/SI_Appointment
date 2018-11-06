package com.example.appointment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pasien")
public class PasienModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="status", referencedColumnName="id", nullable=false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private StatusPasienModel statusPasien;

    @OneToMany(mappedBy="pasien", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<LabPasienModel> pasienLab;

    @OneToMany(mappedBy="pasien", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<TagihanPasienModel> pasienTagihan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public StatusPasienModel getStatusPasien() {
        return statusPasien;
    }

    public void setStatusPasien(StatusPasienModel statusPasien) {
        this.statusPasien = statusPasien;
    }

    public List<LabPasienModel> getPasienLab() {
        return pasienLab;
    }

    public void setPasienLab(List<LabPasienModel> pasienLab) {
        this.pasienLab = pasienLab;
    }

    public List<TagihanPasienModel> getPasienTagihan() {
        return pasienTagihan;
    }

    public void setPasienTagihan(List<TagihanPasienModel> pasienTagihan) {
        this.pasienTagihan = pasienTagihan;
    }
}
