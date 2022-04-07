package ru.digitalleague.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import ru.digitalleague.di.BankCreditCardProcessor;
import ru.digitalleague.di.BillingService;
import ru.digitalleague.di.CreditCardProcessor;
import ru.digitalleague.di.DatabaseTransactionLog;
import ru.digitalleague.di.PayPal;
import ru.digitalleague.di.PaypalCreditCardProcessor;
import ru.digitalleague.di.RealBillingService;
import ru.digitalleague.di.TransactionLog;

@Module
abstract class BillingModule {

  @Binds
  @Singleton
  abstract BillingService bindBillingService(RealBillingService impl);

  @Provides
  static TransactionLog provideTransactionLog() {
    return new DatabaseTransactionLog();
  }

  @Provides
  @PayPal
  static CreditCardProcessor providePaypalCreditCardProcessor() {
    return new PaypalCreditCardProcessor();
  }

  @Provides
  @Singleton
  static CreditCardProcessor provideBankCreditCardProcessor() {
    return new BankCreditCardProcessor();
  }
}
