package com.bharaththippireddy.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PatientServiceImpl implements PatientService {
	private long currentId = 123;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient) {
        System.out.println("...invoking addPatient( " + patient.getName() +")");
        patient.setId(++currentId);
        patients.put(patient.getId(), patient);
        return Response.ok(patient).build();
	}

	public Patient getPatient(String id) {
        System.out.println("...invoking getPatient id(" + id +")");
		return patients.get(Long.parseLong(id));
	}

	public Response updatePatient(Patient updatedPatient) {
        System.out.println("...invoking updatePatient( " + updatedPatient.getName() +")");

        Patient currentPatient = patients.get(updatedPatient.getId());
        Response response;
        if (currentPatient != null) {
            patients.put(currentPatient.getId(), updatedPatient);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }
        return response;
	}

	public Response deletePatients(String id) {
        System.out.println("...invoking deleteatient id( " + id +")");

        Long patientID = Long.parseLong(id);
        Patient patient = patients.get(patientID);
        Response response = null;

        if (patient != null) {
            patients.remove(patientID);
            response = Response.ok().build();
        } else {
            response =  Response.notModified().build();
        }
		return response;
	}

	public Prescription getPrescription(String prescriptionId) {
		long id = Long.parseLong(prescriptionId);
		Prescription prescription = prescriptions.get(id);
		return prescription;
	}

}
