//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.IPaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final IPaymentService service;

    @Autowired
    public PaymentController(IPaymentService service) {
        this.service = service;
    }

    // Create a payment
    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    // Read a payment by ID
    @GetMapping("/read/{id}")
    public Payment read(@PathVariable("id") int paymentID) {
        return service.read(paymentID);
    }

    // Update a payment
    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return service.update(payment);
    }

    // Delete a payment by ID
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int paymentID) {
        return service.delete(paymentID);
    }

    // Get all payments
    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return service.getAll();
    }
}
