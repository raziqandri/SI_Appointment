package com.example.appointment.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @NotNull
    @Column(name = "flag_group", nullable = false)
    @JsonIgnore
    private int flagGroup;

    @Column(name="tgl_rujukan", nullable = true)
    private Date tanggalRujukan;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="status", referencedColumnName="id", nullable=false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    private StatusPasienModel statusPasien;

    @OneToMany(mappedBy="pasien", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JsonIgnore
    private List<LabPasienModel> pasienLab;

    @OneToMany(mappedBy="pasien", fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JsonIgnore
    private List<TagihanPasienModel> pasienTagihan;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_poli_rujukan", referencedColumnName="id", nullable=true)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    private PoliRujukanModel poliRujukan;

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

    public int getFlagGroup() {
        return flagGroup;
    }

    public void setFlagGroup(int flagGroup) {
        this.flagGroup = flagGroup;
    }

    public Date getTanggalRujukan() {
        return tanggalRujukan;
    }

    public void setTanggalRujukan(Date tanggalRujukan) {
        this.tanggalRujukan = tanggalRujukan;
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

    public PoliRujukanModel getPoliRujukan() {
        return poliRujukan;
    }

    public void setPoliRujukan(PoliRujukanModel poliRujukan) {
        this.poliRujukan = poliRujukan;
    }
}
