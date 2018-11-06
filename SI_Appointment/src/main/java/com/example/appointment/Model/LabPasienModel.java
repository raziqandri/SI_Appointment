package com.example.appointment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "lab_pasien")
public class LabPasienModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "jenis", nullable = false)
    private String jenis;

    @NotNull
    @Size(max = 255)
    @Column(name = "hasil", nullable = false)
    private String hasil;

    @NotNull
    @Column(name="tanggal_pengajuan")
    private Date tanggal_pengajuan;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_pasien", referencedColumnName="id", nullable=false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private PasienModel pasien;

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

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public Date getTanggal_pengajuan() {
        return tanggal_pengajuan;
    }

    public void setTanggal_pengajuan(Date tanggal_pengajuan) {
        this.tanggal_pengajuan = tanggal_pengajuan;
    }

    public PasienModel getPasien() {
        return pasien;
    }

    public void setPasien(PasienModel pasien) {
        this.pasien = pasien;
    }
}
