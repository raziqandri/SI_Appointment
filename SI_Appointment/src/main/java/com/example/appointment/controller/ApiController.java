package com.example.appointment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.appointment.model.DokterModel;
import com.example.appointment.model.LabPasienModel;
import com.example.appointment.model.PasienModel;
import com.example.appointment.model.StaffModel;
import com.example.appointment.model.TagihanPasienModel;
import com.example.appointment.repository.DokterDb;
import com.example.appointment.repository.LabPasienDb;
import com.example.appointment.repository.PasienDb;
import com.example.appointment.repository.StaffDb;
import com.example.appointment.repository.StatusPasienDb;
import com.example.appointment.repository.TagihanPasienDb;
import com.example.appointment.rest.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
public class ApiController {
    @Autowired
    DokterDb dokterDb;

    @Autowired
    LabPasienDb labPasienDb;

    @Autowired
    PasienDb pasienDb;

    @Autowired
    StaffDb staffDb;

    @Autowired
    StatusPasienDb statusPasienDb;

    @Autowired
    TagihanPasienDb tagihanPasienDb;

    @GetMapping(value = "/getAllPasienIGD")
    public BaseResponse<List<PasienModel>> getAllPasienIGD() {
        BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(pasienDb.findBystatusPasienJenisContaining("igd"));
        return response;
    }

    @GetMapping(value = "/getAllPasienRawatJalan")
    public BaseResponse<List<PasienModel>> getAllPasienRawatJalan() {
        BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(pasienDb.findBystatusPasienJenisContaining("rawat jalan"));
        return response;
    }

    @GetMapping(value = "/getPasien/{id}")
    public BaseResponse<PasienModel> getPasienById(@PathVariable("id") long id) {
        Optional<PasienModel> data = pasienDb.findById(id);
        BaseResponse<PasienModel> response = new BaseResponse<>();
        if (data.isPresent()) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(data.get());
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/getAllDokter")
    public BaseResponse<List<DokterModel>> getAllDokter() {
        BaseResponse<List<DokterModel>> response = new BaseResponse<List<DokterModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(dokterDb.findAll());
        return response;
    }

    @GetMapping(value = "/getDokter/{id}")
    public BaseResponse<DokterModel> getDokterById(@PathVariable("id") long id) {
        Optional<DokterModel> data = dokterDb.findById(id);
        BaseResponse<DokterModel> response = new BaseResponse<DokterModel>();
        if (data.isPresent()) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(data.get());
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/getAllStaffFarmasi")
    public BaseResponse<List<StaffModel>> getAllStaffFarmasi() {
        BaseResponse<List<StaffModel>> response = new BaseResponse<List<StaffModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(staffDb.findByJenis(0));
        return response;
    }

    @GetMapping(value = "/getAllStaffLab")
    public BaseResponse<List<StaffModel>> getAllStaffLab() {
        BaseResponse<List<StaffModel>> response = new BaseResponse<List<StaffModel>>();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(staffDb.findByJenis(1));
        return response;
    }

    @GetMapping(value = "/getStaff/{id}")
    public BaseResponse<StaffModel> getStaff(@PathVariable("id") long id) {
        Optional<StaffModel> data = staffDb.findById(id);
        BaseResponse<StaffModel> response = new BaseResponse<StaffModel>();
        if (data.isPresent()) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(data.get());
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @PostMapping(value = "/addBilling")
    public BaseResponse<TagihanPasienModel> addBilling(@RequestBody @Valid TagihanPasienModel billing, BindingResult bindingResult) {
        BaseResponse<TagihanPasienModel> response = new BaseResponse<TagihanPasienModel>();
        if (bindingResult.hasErrors()) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            tagihanPasienDb.save(billing);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(billing);
        }
        return response;
    }

    @PostMapping(value = "/addLabResult")
    public BaseResponse<LabPasienModel> addLabResult(@RequestBody @Valid LabPasienModel labResult, BindingResult bindingResult) {
        BaseResponse<LabPasienModel> response = new BaseResponse<LabPasienModel>();
        if (bindingResult.hasErrors()) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            labPasienDb.save(labResult);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(labResult);
        }
        return response;
    }

    @PostMapping(value = "/updatePasien")
    public BaseResponse<PasienModel> updatePasien(@RequestBody @Valid PasienModel pasien, BindingResult bindingResult) {
        BaseResponse<PasienModel> response = new BaseResponse<PasienModel>();
        if (bindingResult.hasErrors()) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            Optional<PasienModel> data = pasienDb.findById(pasien.getId());
            if (data.isPresent()) {
                pasien.setId(data.get().getId());
                pasienDb.save(pasien);
                response.setStatus(200);
                response.setMessage("success");
                response.setResult(pasien);
            } else {
                response.setStatus(404);
                response.setMessage("not found");
            }
        }
        return response;
    }
}