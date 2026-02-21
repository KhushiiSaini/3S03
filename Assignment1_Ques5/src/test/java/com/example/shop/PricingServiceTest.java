package com.example.shop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PricingServiceTest {

    private PricingService pricingService;

    @Before
    public void setUp() {
        pricingService = new PricingService();
    }

    @Test
    public void testCalculateSubtotalSingleItem() {
        Order order = new Order();
        order.addItem(new OrderItem("Book", 1, 50.0));

        double subtotal = pricingService.calculateSubtotal(order);

        assertEquals(50.0, subtotal, 0.001);
    }

    @Test
    public void testCalculateSubtotalMultipleItems() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, 10.0));
        order.addItem(new OrderItem("B", 1, 30.0));

        double subtotal = pricingService.calculateSubtotal(order);

        assertEquals(50.0, subtotal, 0.001);
    }

    @Test
    public void testCalculateSubtotalEmptyOrder() {
        Order order = new Order();

        double subtotal = pricingService.calculateSubtotal(order);

        assertEquals(0.0, subtotal, 0.001);
    }

    @Test
    public void testCalculateTaxNormal() {
        double tax = pricingService.calculateTax(100.0);

        assertEquals(20.0, tax, 0.001);
    }

    @Test
    public void testCalculateTaxZero() {
        double tax = pricingService.calculateTax(0.0);

        assertEquals(0.0, tax, 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTaxNegativeSubtotalThrowsException() {
        pricingService.calculateTax(-10.0);
    }

}
