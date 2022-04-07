package ru.digitalleague.di;

public class ChargeResult {

  private final boolean success;

  private final String declineMessage;

  public ChargeResult(boolean success) {
    this(success, null);
  }

  public ChargeResult(boolean success, String declineMessage) {
    this.success = success;
    this.declineMessage = declineMessage;
  }

  public boolean wasSuccessful() {
    return success;
  }

  public String getDeclineMessage() {
    return declineMessage;
  }

  @Override
  public String toString() {
    return "ChargeResult{" +
        "success=" + success +
        ", declineMessage='" + declineMessage + '\'' +
        '}';
  }
}
