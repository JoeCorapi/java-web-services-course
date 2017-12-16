import com.bharath.ws.trainings.*;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrdersWSClient {

    public static void main(String[] args) {
        try {
            CustomerOrdersService service = new CustomerOrdersService(new URL(
                    "http://localhost:8080/services/customerOrders?wsdl"));
            CustomerOrdersPortType port = service.getCustomerOrdersPort();

            GetOrdersRequest request = new GetOrdersRequest();
            request.setCustomerId(BigInteger.valueOf(1));

            GetOrdersResponse response = port.getOrders(request);
            List<Order> orders = response.getOrder();
            for (Order order: orders) {
                List<Product> products = order.getProduct();
                for (Product product : products) {
                    System.out.println("Product Description " + product.getDescription());
                    System.out.println("Product Quantity " + product.getQuantity());
                }
            }

            DeleteOrdersRequest deleteOrdersRequest = new DeleteOrdersRequest();
            deleteOrdersRequest.setCustomerId(BigInteger.valueOf(1));

            DeleteOrdersResponse deleteOrdersResponse = port.deleteOrders(deleteOrdersRequest);
            List<Order> orders2 = deleteOrdersResponse.getOrder();
            for (Order order: orders2) {
                List<Product> products = order.getProduct();
                for (Product product : products) {
                    System.out.println("Product Description " + product.getDescription());
                    System.out.println("Product Quantity " + product.getQuantity());
                }
            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
