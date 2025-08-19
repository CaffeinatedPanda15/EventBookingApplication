//Muhammad Siddeeq Rabin
//STUDENT :221084096
//Group kN13

package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    private static PaymentRepository repository = null;
    private List<Payment> paymentList;

    private PaymentRepository() {
        paymentList = new ArrayList<>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        paymentList.add(payment);
        return payment;
    }

    @Override
    public Payment read(int paymentID) {
        return paymentList.stream()
                .filter(p -> p.getPaymentID() == paymentID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment = read(payment.getPaymentID());
        if (oldPayment != null) {
            paymentList.remove(oldPayment);
            paymentList.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(int paymentID) {
        Payment payment = read(paymentID);
        if (payment != null) {
            paymentList.remove(payment);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return paymentList;
    }
}

