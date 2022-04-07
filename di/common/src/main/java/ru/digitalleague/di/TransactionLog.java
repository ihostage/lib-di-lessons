package ru.digitalleague.di;

public interface TransactionLog {

  void logChargeResult(ChargeResult result);

  void logConnectException(UnreachableException e);
}
