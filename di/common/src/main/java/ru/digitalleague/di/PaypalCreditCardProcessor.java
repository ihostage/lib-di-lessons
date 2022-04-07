package ru.digitalleague.di;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

  @Override
  public ChargeResult charge(CreditCard creditCard, Long amount) throws UnreachableException {
    if (creditCard == null) throw new UnreachableException("Couldn't connect to PayPal");
    if (amount >= 1000) return new ChargeResult(false, "You haven't $" + amount);
    return new ChargeResult(true);
  }

}
