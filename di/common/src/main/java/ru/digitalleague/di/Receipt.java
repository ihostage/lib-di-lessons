package ru.digitalleague.di;

public class Receipt {

  private final String data;

  private Receipt(String data) {
    this.data = data;
  }

  public static Receipt forSuccessfulCharge(Long amount) {
    return new Receipt("Pizza: " + amount);
  }

  public static Receipt forDeclinedCharge(String declineMessage) {
    return new Receipt("No Pizza: " + declineMessage);
  }

  public static Receipt forSystemFailure(String message) {
    return new Receipt("Service unavailable: " + message);
  }

  @Override
  public String toString() {
    return "Receipt{" +
        "data='" + data + '\'' +
        '}';
  }
}
