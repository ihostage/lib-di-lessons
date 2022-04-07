package ru.digitalleague.di;

import java.time.LocalDateTime;

public class DatabaseTransactionLog implements TransactionLog {

  @Override
  public void logChargeResult(ChargeResult result) {
    System.out.printf("%s: %s\n", LocalDateTime.now(), result);
  }

  @Override
  public void logConnectException(UnreachableException e) {
    System.out.printf("%s: %s\n", LocalDateTime.now(), e.getMessage());
  }
}
