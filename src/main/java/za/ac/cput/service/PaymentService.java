package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.eventrepositories.IPaymentRepository;

import java.util.List;
import java.util.Optional;

public class PaymentService implements IPaymentService {

    private static PaymentService service = null;
    private static IPaymentRepository repository;  //interface, not concrete

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
    public boolean delete(int paymentID) {
        return repository.delete(paymentID);
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}
