package ru.digitalleague.di;

public interface CreditCardProcessor {

  ChargeResult charge(CreditCard creditCard, Long amount) throws UnreachableException;
}
