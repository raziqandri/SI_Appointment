package com.example.appointment.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tagihan_pasien")
public class TagihanPasienModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "jumlah_tagihan", nullable = false)
    private Double jumlahTagihan;

    @NotNull
    @Column(name="tanggal_tagihan")
    private Date tanggalTagihan;

    @NotNull
    @Column(name = "flag_group", nullable = false)
    @JsonIgnore
    private int flagGroup;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pasien", referencedColumnName="id", nullable=false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    private PasienModel pasien;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getJumlahTagihan() {
        return jumlahTagihan;
    }

    public void setJumlahTagihan(Double jumlahTagihan) {
        this.jumlahTagihan = jumlahTagihan;
    }

    public Date getTanggalTagihan() {
        return tanggalTagihan;
    }

    public void setTanggalTagihan(Date tanggalTagihan) {
        this.tanggalTagihan = tanggalTagihan;
    }

    public int getFlagGroup() {
        return flagGroup;
    }

    public void setFlagGroup(int flagGroup) {
        this.flagGroup = flagGroup;
    }

    public PasienModel getPasien() {
        return pasien;
    }

    public void setPasien(PasienModel pasien) {
        this.pasien = pasien;
    }
}
