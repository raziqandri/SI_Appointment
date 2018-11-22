package com.example.appointment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@RestController
@RequestMapping("/api")
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

    @GetMapping(value = "/{groupId}/getAllPasien")
    public BaseResponse<List<PasienModel>> getAllPasien(@PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pasienDb.findByFlagGroup(groupId));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/{groupId}/getAllPasienIGD")
    public BaseResponse<List<PasienModel>> getAllPasienIGD(
            @PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pasienDb.findByFlagGroupAndStatusPasienJenisIsContaining(groupId, "IGD"));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/{groupId}/getAllPasienRawatJalan")
    public BaseResponse<List<PasienModel>> getAllPasienRawatJalan(
            @PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(pasienDb.findByFlagGroupAndStatusPasienJenisIsContaining(groupId, "Rawat Jalan"));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/getPasien/{id}")
    public BaseResponse<PasienModel> getPasienById(@PathVariable(name = "id", required = true) long id) {
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

	@GetMapping(value = "/getPasien")
    public Object getListPasien(@RequestParam(required = true, name = "listId") List<Long> listId, 
    		@RequestParam(required = true, name = "resultType") String resultType) {
    	BaseResponse<List<PasienModel>> response = new BaseResponse<List<PasienModel>>();
        List<PasienModel> data = pasienDb.findByIdIn(listId);
        if (data.size() != 0) {
        	switch (resultType) {
                case "Map":
                    BaseResponse<Map<Long, PasienModel>> responseMap = new BaseResponse<Map<Long, PasienModel>>();
                    Map<Long, PasienModel> dataMap = new HashMap<Long, PasienModel>();
                    for (PasienModel p : data) {
                        dataMap.put(p.getId(), p);
                    }
                    responseMap.setStatus(200);
                    responseMap.setMessage("success");
                    responseMap.setResult(dataMap);
                    return responseMap;
                case "List":
                    response.setStatus(200);
                    response.setMessage("success");
                    response.setResult(data);
                    break;
                default:
                    response.setStatus(500);
                    response.setMessage("error data");
                    break;
        	}
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/{groupId}/getAllDokter")
    public BaseResponse<List<DokterModel>> getAllDokter(@PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<DokterModel>> response = new BaseResponse<List<DokterModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(dokterDb.findByFlagGroup(groupId));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/getDokter/{id}")
    public BaseResponse<DokterModel> getDokterById(@PathVariable(name = "id", required = true) long id) {
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

    @GetMapping(value = "/getDokter")
    public Object getListDokter(@RequestParam(required = true, name = "listId") List<Long> listId, 
    		@RequestParam(required = true, name = "resultType") String resultType) {
    	BaseResponse<List<DokterModel>> response = new BaseResponse<List<DokterModel>>();
        List<DokterModel> data = dokterDb.findByIdIn(listId);
        if (data.size() != 0) {
        	switch (resultType) {
                case "Map":
                    BaseResponse<Map<Long, DokterModel>> responseMap = new BaseResponse<Map<Long, DokterModel>>();
                    Map<Long, DokterModel> dataMap = new HashMap<Long, DokterModel>();
                    for (DokterModel d : data) {
                        dataMap.put(d.getId(), d);
                    }
                    responseMap.setStatus(200);
                    responseMap.setMessage("success");
                    responseMap.setResult(dataMap);
                    return responseMap;
                case "List":
                    response.setStatus(200);
                    response.setMessage("success");
                    response.setResult(data);
                    break;
                default:
                    response.setStatus(500);
                    response.setMessage("error data");
                    break;
        	}
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/{groupId}/getAllStaffFarmasi")
    public BaseResponse<List<StaffModel>> getAllStaffFarmasi(
            @PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<StaffModel>> response = new BaseResponse<List<StaffModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(staffDb.findByJenisAndFlagGroup(0, groupId));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/{groupId}/getAllStaffLab")
    public BaseResponse<List<StaffModel>> getAllStaffLab(@PathVariable(name = "groupId", required = true) int groupId) {
        BaseResponse<List<StaffModel>> response = new BaseResponse<List<StaffModel>>();
        if (groupId > 0 && groupId <= 6) {
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(staffDb.findByJenisAndFlagGroup(1, groupId));
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @GetMapping(value = "/getStaff/{id}")
    public BaseResponse<StaffModel> getStaff(@PathVariable(name = "id", required = true) long id) {
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

    @GetMapping(value = "/getStaff")
    public Object getListStaf(@RequestParam(required = true, name = "listId") List<Long> listId, 
    		@RequestParam(required = true, name = "resultType") String resultType) {
    	BaseResponse<List<StaffModel>> response = new BaseResponse<List<StaffModel>>();
        List<StaffModel> data = staffDb.findByIdIn(listId);
        if (data.size() != 0) {
        	switch (resultType) {
                case "Map":
                    BaseResponse<Map<Long, StaffModel>> responseMap = new BaseResponse<Map<Long, StaffModel>>();
                    Map<Long, StaffModel> dataMap = new HashMap<Long, StaffModel>();
                    for (StaffModel s : data) {
                        dataMap.put(s.getId(), s);
                    }
                    responseMap.setStatus(200);
                    responseMap.setMessage("success");
                    responseMap.setResult(dataMap);
                    return responseMap;
                case "List":
                    response.setStatus(200);
                    response.setMessage("success");
                    response.setResult(data);
                    break;
                default:
                    response.setStatus(500);
                    response.setMessage("error data");
                    break;
        	}
        } else {
            response.setStatus(404);
            response.setMessage("not found");
        }
        return response;
    }

    @PostMapping(value = "/{groupId}/addBilling")
    public BaseResponse<TagihanPasienModel> addBilling(@PathVariable(name = "groupId", required = true) int groupId,
            @RequestBody @Valid TagihanPasienModel billing, BindingResult bindingResult) {
        BaseResponse<TagihanPasienModel> response = new BaseResponse<TagihanPasienModel>();
        if (bindingResult.hasErrors() || (groupId < 1 || groupId > 6)) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            billing.setFlagGroup(groupId);
            tagihanPasienDb.save(billing);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(billing);
        }
        return response;
    }

    @PostMapping(value = "/{groupId}/addLabResult")
    public BaseResponse<LabPasienModel> addLabResult(@PathVariable(name = "groupId", required = true) int groupId,
            @RequestBody @Valid LabPasienModel labResult, BindingResult bindingResult) {
        BaseResponse<LabPasienModel> response = new BaseResponse<LabPasienModel>();
        if (bindingResult.hasErrors() || (groupId < 1 || groupId > 6)) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            labResult.setFlagGroup(groupId);
            labPasienDb.save(labResult);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(labResult);
        }
        return response;
    }

    @PostMapping(value = "/{groupId}/updatePasien")
    public BaseResponse<PasienModel> updatePasien(@PathVariable(name = "groupId", required = true) int groupId,
            @RequestBody @Valid PasienModel pasien, BindingResult bindingResult) {
        BaseResponse<PasienModel> response = new BaseResponse<PasienModel>();
        if (bindingResult.hasErrors() || (groupId < 1 || groupId > 6)) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
            Optional<PasienModel> data = pasienDb.findById(pasien.getId());
            if (data.isPresent()) {
                if (data.get().getFlagGroup() != groupId) {
                    response.setStatus(403);
                    response.setMessage("forbidden");
                } else {
                    pasien.setId(data.get().getId());
                    pasien.setFlagGroup(groupId);
                    pasienDb.save(pasien);
                    response.setStatus(200);
                    response.setMessage("success");
                    response.setResult(pasien);
                }
            } else {
                response.setStatus(404);
                response.setMessage("not found");
            }
        }
        return response;
    }
}