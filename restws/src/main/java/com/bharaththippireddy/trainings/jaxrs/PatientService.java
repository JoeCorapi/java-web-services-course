package com.bharaththippireddy.trainings.jaxrs;

import javax.ws.rs.core.Response;

public interface PatientService {

	Patient getPatient(String id);

	Response updatePatient(Patient patient);

	Response addPatient(Patient patient);

	Response deletePatients(String id);

	Prescription getPrescription(String prescriptionId);

}