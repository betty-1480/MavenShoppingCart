package payment;

public class GiftCard implements PaymentStrategy{
    @Override
    public void makePayment() {
        System.out.println("This payment is made using a gift card");
    }
}
