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

    public PasienModel getPasien() {
        return pasien;
    }

    public void setPasien(PasienModel pasien) {
        this.pasien = pasien;
    }
}
