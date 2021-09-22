package main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import item.Fruit;
import item.Item;
import item.Vegetable;
import payment.GuicePaymentModule;
import shoppingCart.Cart;


public class ShoppingCartMain {


    public static void main(String...args){

        Injector injector= Guice.createInjector(new GuicePaymentModule());

        Cart cart=injector.getInstance(Cart.class);//PaymentStrategy injected Cart object

        Item item1=new Vegetable("i001",10.00);
        Item item2=new Fruit("i002",20.00);
        cart.addItem(item1,10);
        cart.addItem(item2,2);


        cart.confirmPayment();
    }
}