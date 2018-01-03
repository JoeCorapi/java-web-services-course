package com.bharaththippireddy.trainings.jaxrs.client;

import com.bharaththippireddy.trainings.jaxrs.Check;
import com.bharaththippireddy.trainings.jaxrs.ChecksList;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CheckProcessorClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/checkservice/checks");

        AsyncInvoker asyncInvoker = target.request().async();

        ChecksList checksList = new ChecksList();
        ArrayList<Check> checks = new ArrayList<>();
        checks.add(new Check());
        checksList.setChecks(checks);

        Future<Boolean> future = asyncInvoker.post(Entity.entity(checksList, MediaType.APPLICATION_XML), new ChecksResponseCallbackHandler());
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        Future<Boolean> future = asyncInvoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML), Boolean.class);
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//
//            if(e.getCause() instanceof BadRequestException) {
//                BadRequestException bre = (BadRequestException) e.getCause();
//                System.out.println("Checks should be provided");
//            }
//            e.printStackTrace();
//        }
    }
}
