package com.example.shop;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderServiceTest {

    @Test
    public void testProcessValidOrder() {
        OrderItem item = new OrderItem("Book", 2, 10.0);
        Order order = new Order();
        order.addItem(item);

        OrderService service = new OrderService();

        double result = service.processOrder(order, "STUDENT10", "card");

        assertEquals(OrderStatus.PAID, order.getStatus());
        assertTrue(result > 0);
    }

    @Test
    public void testInvalidPaymentCancelsOrder() {
        OrderItem item = new OrderItem("Book", 1, 10.0);
        Order order = new Order();
        order.addItem(item);

        OrderService service = new OrderService();

        double result = service.processOrder(order, "STUDENT10", "crypto");

        assertEquals(OrderStatus.CANCELLED, order.getStatus());
        assertEquals(0.0, result, 0.001);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testAddItemAfterOrderProcessedThrowsException() {
        Order order = new Order();
        OrderItem item = new OrderItem("Book", 1, 10.0);

        // Simulate processed order
        order.setStatus(OrderStatus.PAID);

        order.addItem(item);
    }

}
