package shoppingCart;


import com.google.inject.Provides;
import item.Item;
import main.LoggingHandler;
import payment.PayPal;
import payment.PaymentStrategy;

import javax.inject.Inject;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static payment.GuicePaymentModule.providePaymentStrategyProxy;

public class Cart{
    private Map<Item,Integer> cartItems;
    private PaymentStrategy paymentStrategy;

    @Inject
    public Cart(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }


    public synchronized void addItem(Item item, int quantity){
        if (cartItems==null)
            cartItems=new HashMap<>();
        if (cartItems.containsKey(item)){
            int oldQty=cartItems.get(item);
                cartItems.merge(item,oldQty,(a,b)->oldQty+quantity);
        }
        else
            cartItems.put(item,quantity);
    }

    public synchronized void removeItem(Item item, int quantity){
        if (cartItems!=null){
            if (cartItems.containsKey(item)){
                int oldQty=cartItems.get(item);
                if (oldQty>=quantity)
                cartItems.merge(item,oldQty,(a,b)->oldQty-quantity);
            }
        }
    }


/*@Inject
public void setPaymentStrategy(PaymentStrategy paymentStrategy){

    this.paymentStrategy=paymentStrategy;
}*/

    public void confirmPayment(){
        if (paymentStrategy==null)
            System.out.println("Select a payment method");
        paymentStrategy.makePayment();
    }

/*public void confirmPayment(){
   if (PaymentStrategy==null)
        System.out.println("Select a payment method");
    PaymentStrategy.get().makePayment();

}*/
}
