package com.corapi.joe.trainings.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class PatientServiceClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/patientservice/patients/123");
        Response response = target.request().get();
        System.out.println(response.getStatus());
    }
}

