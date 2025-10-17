package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.eventrepositories.IPaymentRepository;
import za.ac.cput.service.Iservice.IPaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    private static PaymentService service = null;
    private static IPaymentRepository repository;

    private PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    public static PaymentService getService() {
        if (service == null) {
            service = new PaymentService(repository);
        }
        return service;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment> read(int paymentID) {
        return repository.findById(String.valueOf(paymentID));
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment delete(int paymentID) {
        Optional<Payment> payment = read(paymentID);
        if (payment.isPresent()) {
            repository.delete(payment.get());
            return payment.get();
        }
        return null;
    }


    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}
