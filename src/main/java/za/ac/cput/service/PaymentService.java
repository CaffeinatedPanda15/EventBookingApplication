// Muhammad Siddeeq Rabin
// STUDENT :221084096
// Group kN13

package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    private final IPaymentRepository repository;

    
    public PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(int paymentID) {
        Optional<Payment> optionalPayment = repository.findById(paymentID);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if(repository.existsById(payment.getPaymentID())) {
            return repository.save(payment);  
        }
        return null;
    }

    @Override
    public boolean delete(int paymentID) {
        if (repository.existsById(paymentID)) {
            repository.deleteById(paymentID);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}

