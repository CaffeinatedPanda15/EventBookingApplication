package za.ac.cput.controller;

import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.repository.PaymentRepository;
import java.util.Date;

public class PaymentController {
    public static void main(String[] args) {
        // Get repository instance
        PaymentRepository repository = PaymentRepository.getRepository();

        // Create a payment using the factory
        Payment payment1 = PaymentFactory.createPayment(
                1,
                500.00,
                new Date(),
                "Credit Card",
                Payment.Status.Successful
        );

        Payment payment2 = PaymentFactory.createPayment(
                2,
                300.00,
                new Date(),
                "Cash",
                Payment.Status.Pending
        );

        // Save payments to repository
        repository.create(payment1);
        repository.create(payment2);

        // Display all payments
        System.out.println("All Payments:");
        repository.getAll().forEach(System.out::println);

        // Read a payment
        System.out.println("\nReading Payment ID 1:");
        System.out.println(repository.read(1));

        // Update a payment
        Payment updatedPayment = new Payment.Builder()
                .copy(payment2)
                .withStatus(Payment.Status.Successful)
                .build();
        repository.update(updatedPayment);
        System.out.println("\nAfter Update:");
        repository.getAll().forEach(System.out::println);

        // Delete a payment
        repository.delete(1);
        System.out.println("\nAfter Deletion:");
        repository.getAll().forEach(System.out::println);
    }
}

