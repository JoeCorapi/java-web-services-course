package com.bharath.ws.trainings.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bharath.ws.trainings.*;

public class CustomersOrdersWSImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentCustomerId;

	public CustomersOrdersWSImpl() {
		init();
	}

	public void init() {
		List<Order> orders = new ArrayList<Order>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		Product product = new Product();
		product.setDescription("IPhone");
		product.setId("1");
		product.setQuantity(BigInteger.valueOf(3));
        Order order2 = new Order();
        order2.setId(BigInteger.valueOf(2));
        Product product2 = new Product();
        product2.setDescription("IPad");
        product2.setId("2");
        product2.setQuantity(BigInteger.valueOf(1));

		order.getProduct().add(product);
		order2.getProduct().add(product2);

		orders.add(order);
		orders.add(order2);
		customerOrders.put(BigInteger.valueOf(++currentCustomerId), orders);
	}

	@Override
    public GetOrdersResponse getOrders(GetOrdersRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orders = customerOrders.get(customerId);

        GetOrdersResponse response = new GetOrdersResponse();
        List<Order> responseOrders = response.getOrder();
        responseOrders.addAll(orders);

        return response;
    }

	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customerOrders.get(customerId);
        orders.remove(0);

		DeleteOrdersResponse response = new DeleteOrdersResponse();
		List<Order> responseOrders = response.getOrder();
		responseOrders.addAll(orders);

		return response;

	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		Order order = request.getOrder();

		List<Order> currentOrders = customerOrders.get(request.getCustomerId());
		currentOrders.add(order);

		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
		createOrdersResponse.setResult(true);

		return createOrdersResponse;
	}
}
