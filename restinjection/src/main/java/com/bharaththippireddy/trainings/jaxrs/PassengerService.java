package com.bharaththippireddy.trainings.jaxrs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import com.bharathippireddy.trainings.jaxrs.dto.Passenger;
import com.bharathippireddy.trainings.jaxrs.dto.PassengerList;

@Path("/Passenger")
@Produces("application/xml")
public class PassengerService {

	PassengerList passengersList = new PassengerList();

	public PassengerService() {
		init();
	}

	public void init() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setId(123);
		passenger.setName("Bharath");
		passengers.add(passenger);
		passengersList.setPassengers(passengers);
	}

	@GET
	public PassengerList getPassengers(@QueryParam("start") int start, @QueryParam("size") int size, @HeaderParam("agent") String agent, @Context HttpHeaders headers) {

		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> names = cookies.keySet();
		for (String name: names) {
			Cookie cookie = cookies.get(name);
			System.out.println("Cookie Value==>" + cookie.getValue());
		}

		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> headerNameSet = requestHeaders.keySet();

		for (String eachHeader: headerNameSet) {
			System.out.print(headers.getHeaderString(eachHeader));
			System.out.println("");
		}

		System.out.println("Start: " + start);
		System.out.println("Size: " + size);

		System.out.println(agent);
		return passengersList;
	}

	@POST
	public void addPassenger(@FormParam("firstname") String firstName, @FormParam("lastname") String lastName) {
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
	}

}
