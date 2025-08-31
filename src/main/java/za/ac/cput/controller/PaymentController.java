//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.IPaymentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final IPaymentService service;

    @Autowired
    public PaymentController(IPaymentService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }


    @GetMapping("/read/{id}")
    public Optional<Payment> read(@PathVariable("id") int paymentID) {
        return service.read(paymentID);
    }


    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return service.update(payment);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int paymentID) {
        return service.delete(paymentID);
    }


    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return service.getAll();
    }
}
