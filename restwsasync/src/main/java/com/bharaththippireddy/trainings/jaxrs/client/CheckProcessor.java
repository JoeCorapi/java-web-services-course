package com.bharaththippireddy.trainings.jaxrs.client;

import com.bharaththippireddy.trainings.jaxrs.ChecksList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CheckProcessor {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/checkservice/checks");

        AsyncInvoker asyncInvoker = target.request().async();
        Future<Boolean> future = asyncInvoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML), Boolean.class);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {

            if(e.getCause() instanceof BadRequestException) {
                BadRequestException bre = (BadRequestException) e.getCause();
                System.out.println("Checks should be provided");
            }
            e.printStackTrace();
        }
    }
}
