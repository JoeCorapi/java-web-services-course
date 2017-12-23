package com.corapi.joe.trainings.rest.client;

import com.bharaththippireddy.trainings.jaxrs.Patient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PatientServiceClient {

    private static final String PATIENT_SERVICE_URL = "http://localhost:8080/services/patientservice";

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id",123);
        Patient patient = target.request().get(Patient.class);
        System.out.println(patient.getName());

        WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path("/patients");

        patient.setName("Joe");
        Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
        System.out.println(updateResponse.getStatus());
        updateResponse.close();

        Patient newPatient = new Patient();
        newPatient.setName("Corapi");

        WebTarget potTarget = client.target(PATIENT_SERVICE_URL).path("patients");
        Patient postResponse = potTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML_TYPE), Patient.class);
        System.out.println(postResponse.getId());

        WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 128);
        Response deleteResponse = deleteTarget.request().delete();
        System.out.println(deleteResponse.getStatus());

        client.close();
    }
}

