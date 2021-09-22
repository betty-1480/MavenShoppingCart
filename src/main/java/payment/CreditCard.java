package payment;

public class CreditCard implements PaymentStrategy{
    @Override
    public void makePayment(){
        System.out.println("This payment is made using a credit card");
    }
}
