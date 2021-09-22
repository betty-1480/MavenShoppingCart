package payment;

public class PayPal implements PaymentStrategy{
    @Override
    public void makePayment(){

        System.out.println("This payment is made using Paypal");
    }
}