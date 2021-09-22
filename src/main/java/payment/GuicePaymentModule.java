package payment;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import main.LoggingHandler;

import java.lang.reflect.Proxy;

public class GuicePaymentModule extends AbstractModule {
/*    @Override
    public void configure(){

        bind(PaymentStrategy.class).toProvider(PaymentStrategyProvider.class);
    }*/

    @SuppressWarnings("unchecked")
    // method to initialise Proxy instance
    private static <T> T wrapWithLoggingProxy(T target, Class<T> klass) {
        return (T) Proxy.newProxyInstance(
                klass.getClassLoader(),
                new Class<?>[] {klass},
                new LoggingHandler(target));  //the invocation handler to dispatch method invocations to a proxy instance
    }

    @Provides
    @Singleton
    public static PaymentStrategy providePaymentStrategyProxy(PaymentStrategy paymentStrategy){
        return wrapWithLoggingProxy(new GiftCard(), PaymentStrategy.class);
    }

}
