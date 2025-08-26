package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

public class PaymentService implements IPaymentService {

    private static PaymentService service = null;
    private IPaymentRepository repository;  //interface, not concrete

    private PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    public static PaymentService getService(IPaymentRepository repository) {
        if (service == null) {
            service = new PaymentService(repository);
        }
        return service;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.create(payment);
    }

    @Override
    public Payment read(int paymentID) {
        return repository.read(paymentID);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.update(payment);
    }

    @Override
    public boolean delete(int paymentID) {
        return repository.delete(paymentID);
    }

    @Override
    public List<Payment> getAll() {
        return repository.getAll();
    }
}
