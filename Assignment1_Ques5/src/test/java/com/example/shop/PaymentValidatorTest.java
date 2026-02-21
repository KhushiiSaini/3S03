package com.example.shop;

import static org.junit.Assert.*;
import org.junit.Test;

public class PaymentValidatorTest {

    @Test
    public void testCardIsValid() {
        PaymentValidator validator = new PaymentValidator();

        boolean result = validator.isPaymentMethodValid("card");

        assertTrue(result);
    }

    @Test
    public void testPaypalIsValid() {
        PaymentValidator validator = new PaymentValidator();

        boolean result = validator.isPaymentMethodValid("paypal");

        assertTrue(result);
    }

    @Test
    public void testCryptoIsInvalid() {
        PaymentValidator validator = new PaymentValidator();

        boolean result = validator.isPaymentMethodValid("crypto");

        assertFalse(result);
    }

    @Test
    public void testNullPaymentMethod() {
        PaymentValidator validator = new PaymentValidator();

        boolean result = validator.isPaymentMethodValid(null);

        assertFalse(result);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testUnknownPaymentMethodThrowsException() {
        PaymentValidator validator = new PaymentValidator();
        validator.isPaymentMethodValid("banktransfer");
    }

}
