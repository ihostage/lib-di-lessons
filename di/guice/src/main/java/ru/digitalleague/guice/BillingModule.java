package ru.digitalleague.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import javax.inject.Singleton;
import ru.digitalleague.di.BankCreditCardProcessor;
import ru.digitalleague.di.BillingService;
import ru.digitalleague.di.CreditCardProcessor;
import ru.digitalleague.di.DatabaseTransactionLog;
import ru.digitalleague.di.PayPal;
import ru.digitalleague.di.PaypalCreditCardProcessor;
import ru.digitalleague.di.RealBillingService;
import ru.digitalleague.di.TransactionLog;

public class BillingModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(TransactionLog.class).to(DatabaseTransactionLog.class);
    bind(BillingService.class).to(RealBillingService.class).in(Singleton.class);
  }

  @PayPal
  @Provides
  static CreditCardProcessor providePaypalCreditCardProcessor() {
    return new PaypalCreditCardProcessor();
  }

  @Singleton
  @Provides
  static CreditCardProcessor provideBankCreditCardProcessor() {
    return new BankCreditCardProcessor();
  }
}
