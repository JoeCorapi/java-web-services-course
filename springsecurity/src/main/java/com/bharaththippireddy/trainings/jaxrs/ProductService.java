package com.bharaththippireddy.trainings.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.security.access.annotation.Secured;

public interface ProductService {

	
	List<Product> getProducts();

	int addProduct(Product product);
}
