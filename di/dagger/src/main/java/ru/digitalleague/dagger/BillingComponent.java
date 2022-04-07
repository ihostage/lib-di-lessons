package ru.digitalleague.dagger;

import dagger.Component;
import javax.inject.Singleton;
import ru.digitalleague.di.BillingService;
import ru.digitalleague.di.CreditCardProcessor;
import ru.digitalleague.di.PayPal;

@Singleton
@Component(modules = {BillingModule.class})
public interface BillingComponent {

  BillingService billingService();

  @PayPal
  CreditCardProcessor payPalCreditCardProcessor();

  CreditCardProcessor bankCreditCardProcessor();

}
