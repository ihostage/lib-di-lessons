package ru.digitalleague.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import javax.inject.Provider;
import ru.digitalleague.di.BillingService;
import ru.digitalleague.di.CreditCard;
import ru.digitalleague.di.CreditCardProcessor;
import ru.digitalleague.di.PayPal;
import ru.digitalleague.di.PizzaOrder;

public class GuiceApp {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new BillingModule());
    BillingService billingService = injector.getInstance(BillingService.class);

    Provider<CreditCard> creditCardProvider = injector.getProvider(CreditCard.class);

    System.out.println(billingService.chargeOrder(new PizzaOrder(100), creditCardProvider.get()));
    System.out.println(billingService.chargeOrder(new PizzaOrder(2000), creditCardProvider.get()));
    System.out.println(billingService.chargeOrder(new PizzaOrder(12000), creditCardProvider.get()));
    System.out.println(billingService.chargeOrder(new PizzaOrder(100), null));

    checkSingleton(injector);
  }

  private static void checkSingleton(Injector injector) {
    System.out.println("\n\n\n\nSingleton check: ");
    System.out.println(injector.getInstance(CreditCardProcessor.class));
    System.out.println(injector.getInstance(CreditCardProcessor.class));
    System.out.println(injector.getInstance(CreditCardProcessor.class));
    System.out.println();
    System.out.println(injector.getInstance(Key.get(CreditCardProcessor.class, PayPal.class)));
    System.out.println(injector.getInstance(Key.get(CreditCardProcessor.class, PayPal.class)));
    System.out.println(injector.getInstance(Key.get(CreditCardProcessor.class, PayPal.class)));
  }

}
