package ru.digitalleague.dagger;

import ru.digitalleague.di.BillingService;
import ru.digitalleague.di.CreditCard;
import ru.digitalleague.di.PizzaOrder;

public class DaggerApp {

  public static void main(String[] args) {
    BillingComponent component = DaggerBillingComponent.builder().build();
    BillingService billingService = component.billingService();

    CreditCard creditCard = new CreditCard();

    System.out.println(billingService.chargeOrder(new PizzaOrder(100), creditCard));
    System.out.println(billingService.chargeOrder(new PizzaOrder(2000), creditCard));
    System.out.println(billingService.chargeOrder(new PizzaOrder(12000), creditCard));
    System.out.println(billingService.chargeOrder(new PizzaOrder(100), null));

    checkSingleton(component);
  }

  private static void checkSingleton(BillingComponent component) {
    System.out.println("\n\n\n\nSingleton check: ");
    System.out.println(component.bankCreditCardProcessor());
    System.out.println(component.bankCreditCardProcessor());
    System.out.println(component.bankCreditCardProcessor());
    System.out.println();
    System.out.println(component.payPalCreditCardProcessor());
    System.out.println(component.payPalCreditCardProcessor());
    System.out.println(component.payPalCreditCardProcessor());
  }
}
