package za.ac.cput.controller;

/**
 * PaymentControllerTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import za.ac.cput.domain.Payments;
import za.ac.cput.service.PaymentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")  // This can be used if you have a separate profile for testing
class PaymentControllerTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentController paymentController;

    private Payments payment;

    @BeforeEach
    void setUp() {
        payment = new Payments.Builder()
                .setPayment_id(1L)
                .setOrder_id(1001L)
                .setPayment_date(LocalDate.of(2024, 7, 23))
                .setPayment_amount(500.00)
                .setPayment_method("Credit Card")
                .setPayment_status("Completed")
                .build();
    }

    @Test
    void testCreatePayment() {
        ResponseEntity<Payments> response = paymentController.createPayment(payment);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(payment.getPayment_id(), response.getBody().getPayment_id());
    }

    @Test
    void testReadPayment() {
        // Create a payment first so it exists in the database
        paymentService.create(payment);
        ResponseEntity<Payments> response = paymentController.readPayment(payment.getPayment_id());
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(payment.getPayment_id(), response.getBody().getPayment_id());
    }

    @Test
    void testUpdatePayment() {
        // Create a payment to update
        paymentService.create(payment);
        Payments updatedPayment = new Payments.Builder()
                .setPayment_id(payment.getPayment_id())
                .setOrder_id(1001L)
                .setPayment_date(LocalDate.of(2024, 8, 1))  // New date
                .setPayment_amount(600.00)  // New amount
                .setPayment_method("Credit Card")
                .setPayment_status("Pending")
                .build();

        ResponseEntity<Payments> response = paymentController.updatePayment(updatedPayment);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(600.00, response.getBody().getPayment_amount());
    }

    @Test
    void testDeletePayment() {
        // Create a payment to delete
        paymentService.create(payment);
        ResponseEntity<Void> response = paymentController.deletePayment(payment.getPayment_id());
        assertEquals(204, response.getStatusCodeValue());
        Optional<Payments> deletedPayment = paymentService.read(payment.getPayment_id());
        assertTrue(deletedPayment.isEmpty());
    }

    @Test
    void testGetAllPayments() {
        // Create multiple payments
        Payments payment1 = new Payments.Builder()
                .setPayment_id(2L)
                .setOrder_id(1002L)
                .setPayment_date(LocalDate.of(2024, 7, 23))
                .setPayment_amount(300.00)
                .setPayment_method("Debit Card")
                .setPayment_status("Completed")
                .build();

        paymentService.create(payment);
        paymentService.create(payment1);

        ResponseEntity<List<Payments>> response = paymentController.getAllPayments();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().size() >= 2);
    }
}
