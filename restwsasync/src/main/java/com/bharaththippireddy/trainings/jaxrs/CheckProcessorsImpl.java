package com.bharaththippireddy.trainings.jaxrs;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

public class CheckProcessorsImpl {

    @POST
    @Path("/checks")
    public void processChecks(@Suspended final AsyncResponse response, ChecksList checks){

        new Thread() {
            public void run(){
                response.resume(true);
            }
        }.start();
    }

}
