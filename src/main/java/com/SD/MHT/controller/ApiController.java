package com.SD.MHT.controller;

import com.SD.MHT.Dao.MHTDaoImpl;
import com.SD.MHT.entity.*;
import com.SD.MHT.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    @Autowired
    private MHTDaoImpl mhtDao;
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private LabService labService;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private VisitService visitService;


    @PostMapping("/patient/addPatientHospitalVisitData")
    public ResponseEntity<String> addPatientHospitalVisitData(@RequestBody Map<String, String> requestBody) {
        try {
            String patient_id = requestBody.get("patient_id");
            if ((patientService.getPatientById(Long.parseLong(patient_id))).equals("No Data Found")) {
                Response responseBody = new Response("Failed", "Invalid data", "Invalid Patient ID");
                return ResponseEntity.ok(responseBody.toString());
            }
            System.out.println(patient_id);
            String doctor_id = requestBody.get("doctor_id");
            if ((doctorService.getDoctorById(Long.parseLong(doctor_id))).equals("No Data Found")) {
                Response responseBody = new Response("Failed", "Invalid data", "Invalid Doctor ID");
                return ResponseEntity.ok(responseBody.toString());
            }
            System.out.println(doctor_id);

            String hospital_id = requestBody.get("hospital_id");
            if ((hospitalService.getHospitalById(Long.parseLong(hospital_id))).equals("No Data Found")) {
                Response responseBody = new Response("Failed", "Invalid data", "Invalid Hospital ID");
                return ResponseEntity.ok(responseBody.toString());
            }
            System.out.println(hospital_id);
            String visit_date = requestBody.get("visit_date");
            String issue = requestBody.get("issue");
            String diagnosis = requestBody.get("diagnosis");
            String test_suggested = requestBody.get("suggested_test");



            // Assuming you have a method in your service to add visit data
            String visit_id = visitService.addPatientHospitalVisitData(patient_id, hospital_id, doctor_id, visit_date, issue, diagnosis, test_suggested);
            System.out.println("visit_id:"+visit_id);
            String[] suggestedTestsList = test_suggested.split(", ");
            System.out.println(Arrays.toString(suggestedTestsList));
            for(String suggestedTest : suggestedTestsList){
                System.out.println(suggestedTest);
                patientService.insertTestDetailsInDB(visit_id, suggestedTest, patient_id, "Test Suggested!");
            }
            Response responseBody = new Response("000", "Patient Visit Details Added Successfully", "null");

            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Patient visit details addition failed");
            return ResponseEntity.ok(responseBody.toString());
        }

    }

    @PostMapping("/doctor/addDoctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        try {
            doctorService.addDoctor(doctor);
            Response responseBody = new Response("000", "Doctor Details Added Successfully", doctor.toString());
            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Doctor details addition failed");
            return ResponseEntity.ok(responseBody.toString());
        }

    }

    @PostMapping("/patient/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody Map<String, String> requestBody) {
        try {
            String name = requestBody.get("name");
            String dob = requestBody.get("date_of_birth");
            String gender = requestBody.get("gender");
            String contact_no = requestBody.get("contact_no");
            String mail_id = requestBody.get("mail_id");
            // Extract other patient fields similarly
            Patient patient = new Patient(name, dob, gender, contact_no, mail_id); // Create Patient object with extracted
            // fields
            patientService.addPatient(patient);
            Response responseBody = new Response("000", "Patient Details Added Successfully", patient.toString());
            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Patient details addition failed");
            return ResponseEntity.ok(responseBody.toString());
        }

    }

    @PostMapping("/lab/addLab")
    public ResponseEntity<String> addLab(@RequestBody Map<String, String> requestBody) {
        try {
            String name = requestBody.get("name");
            String address = requestBody.get("address");
            String contact_info = requestBody.get("contact_info");
            // Extract other lab fields similarly
            Labs lab = new Labs(name, address, contact_info); // Create Labs object with extracted fields
            labService.addLab(lab);
            Response responseBody = new Response("000", "Lab Details Added Successfully", lab.toString());
            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Lab details addition failed");
            return ResponseEntity.ok(responseBody.toString());
        }

    }

    @PostMapping("/hospital/addHospital")
    public ResponseEntity<String> addHospital(@RequestBody Map<String, String> requestBody) {
        try {
            String name = requestBody.get("name");

            String address = requestBody.get("address");
            String contact_info = requestBody.get("contact_info");
            // Extract other hospital fields similarly
            Hospitals hospital = new Hospitals(name, address, contact_info); // Create Hospitals object with extracted
            // fields
            hospitalService.addHospital(hospital);
            Response responseBody = new Response("000", "Hospital Details Added Successfully", hospital.toString());
            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Hospital details addition failed");
            return ResponseEntity.ok(responseBody.toString());
        }

    }

    @GetMapping("/doctor/getDoctorDetails/{id}")
    public ResponseEntity<String> getDoctorDetails(@PathVariable Long id) {
        String description = doctorService.getDoctorById(id).toString();
        String responseString = null;
        Response responseBody = null;
        if (description.equals("No Data Found")) {
            responseBody = new Response("Err", "No Data Found", "Doctor with given ID not Found");
            responseString = responseBody.toString();
        } else {
            responseBody = new Response("00", "Success", description);
            responseString = responseBody.toString2();
        }
        return ResponseEntity.ok(responseString);
    }

    @GetMapping("/patient/getPatientDetails/{id}")
    public ResponseEntity<String> getPatientDetails(@PathVariable Long id) {
        String description = patientService.getPatientById(id).toString();
        Response responseBody = null;
        String responseString = null;
        if (description.equals("No Data Found")) {
            responseBody = new Response("Err", "No Data Found", "Patient with given ID not Found");
            responseString = responseBody.toString();
        } else {
            responseBody = new Response("00", "Success", description);
            responseString = responseBody.toString2();
        }
        return ResponseEntity.ok(responseString);
    }

    @GetMapping("/lab/getLabDetails/{id}")
    public ResponseEntity<String> getLabDetails(@PathVariable Long id) {
        String description = labService.getLabById(id).toString();
        Response responseBody = null;
        String responseString = null;
        if (description.equals("No Data Found")) {
            responseBody = new Response("Err", "No Data Found", "Lab with given ID not Found");
            responseString = responseBody.toString();
        } else {
            responseBody = new Response("00", "Success", description);
            responseString = responseBody.toString2();
        }
        return ResponseEntity.ok(responseString);
    }

    @GetMapping("/hospital/getHospitalDetails/{id}")
    public ResponseEntity<String> getHospitalDetails(@PathVariable Long id) {
        String description = hospitalService.getHospitalById(id).toString();
        String responseString = null;
        Response responseBody = null;
        if (description.equals("No Data Found")) {
            responseBody = new Response("Err", "No Data Found", "Hospital with given ID not Found");
            responseString = responseBody.toString();
        } else {
            responseBody = new Response("00", "Success", description);
            responseString = responseBody.toString2();
        }

        return ResponseEntity.ok(responseString);
    }

    @GetMapping("/patient/getPatientHistory/{id}")
    public ResponseEntity<String> getPatientHistory(@PathVariable Long id) {
        String patientFlag = patientService.getPatientById(id).toString();
        Response responseBody = null;
        String responseString;
        if (patientFlag.equals("No Data Found")) {
            responseBody = new Response("Err", "No Data Found", "Patient with given ID not Found");
            responseString = responseBody.toString();
        } else {
            String description = patientService.getHistory(id).toString();
            responseBody = new Response("00", "Success", description);
            responseString = responseBody.toString2();
        }


        return ResponseEntity.ok(responseString);
    }


    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        String description = "Welcome to SD MHT!!";

        Response responseBody = new Response("00", "Success", description);

        return ResponseEntity.ok(responseBody.toString());
    }
    @PutMapping("/lab/updateMedicalTestDetails")
    public ResponseEntity<String> updateMedTestDetailsByLab(@RequestBody Map<String, String> requestBody) {
        try {
            String testResultId = requestBody.get("test_result_id");
            if ((labService.getTestResultId(Long.parseLong(testResultId))).equals("No Data Found")) {
                Response responseBody = new Response("Failed", "Invalid data", "Invalid Test Result ID");
                return ResponseEntity.ok(responseBody.toString());
            }
            String labId = requestBody.get("lab_id");
            if ((labService.getLabById(Long.parseLong(labId ))).equals("No Data Found")) {
                Response responseBody = new Response("Failed", "Invalid data", "Invalid Lab ID");
                return ResponseEntity.ok(responseBody.toString());
            }
            //
            String reportId = requestBody.get("report_id");
            String result = requestBody.get("result");
            String testStatus = requestBody.get("test_status");
            mhtDao.updateMedTestDetailsByLab( labId,  reportId,  result,  testStatus,  testResultId);
            Response responseBody = new Response("000", "Success", "Updated test details successfully");
            return ResponseEntity.ok(responseBody.toString());
        } catch (Exception e) {
            Response responseBody = new Response("Err", "Invalid Request", "Invalid request parameter");
            return ResponseEntity.ok(responseBody.toString());
        }

    }
}
