package ru.digitalleague.di;

public class BankCreditCardProcessor implements CreditCardProcessor {

  @Override
  public ChargeResult charge(CreditCard creditCard, Long amount) throws UnreachableException {
    if (creditCard == null) throw new UnreachableException("Couldn't connect to Bank");
    if (amount >= 10_000L) return new ChargeResult(false, "You haven't $" + amount);
    return new ChargeResult(true);
  }
}
