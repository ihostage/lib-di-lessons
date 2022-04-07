package ru.digitalleague.di;

public class PizzaOrder {

  private final long amount;

  public PizzaOrder(long amount) {
    this.amount = amount;
  }

  public long getAmount() {
    return amount;
  }
}
