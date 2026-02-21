package com.example.shop;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiscountServiceTest {

    @Test
    public void testNoDiscountWhenCodeNull() {
        DiscountService service = new DiscountService();

        double result = service.applyDiscount(100.0, null);

        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void testNoDiscountWhenCodeBlank() {
        DiscountService service = new DiscountService();

        double result = service.applyDiscount(100.0, "");

        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void testStudentDiscount() {
        DiscountService service = new DiscountService();

        double result = service.applyDiscount(100.0, "STUDENT10");

        assertEquals(90.0, result, 0.001);
    }

    @Test
    public void testBlackFridayDiscount() {
        DiscountService service = new DiscountService();

        double result = service.applyDiscount(100.0, "BLACKFRIDAY");

        assertEquals(70.0, result, 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDiscountThrowsException() {
        DiscountService service = new DiscountService();
        service.applyDiscount(100.0, "INVALID");
    }
    
    @Test
    public void testUnknownDiscountReturnsSubtotal() {
        DiscountService service = new DiscountService();
        double result = service.applyDiscount(100.0, "UNKNOWN");

        assertEquals(100.0, result, 0.001);
    }

}
