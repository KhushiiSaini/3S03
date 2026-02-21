package com.example.shop;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderItemTest {

    @Test
    public void testValidOrderItem() {
        OrderItem item = new OrderItem("Book", 2, 10.0);

        assertEquals(2, item.getQuantity());
        assertEquals(20.0, item.getTotalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityZeroThrowsException() {
        new OrderItem("Book", 0, 10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuantityNegativeThrowsException() {
        new OrderItem("Book", -1, 10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeUnitPriceThrowsException() {
        new OrderItem("Book", 1, -5.0);
    }
}
