package ru.digitalleague.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Dog extends Pet {

  private int weight;

  @JsonCreator
  public Dog(String name, int weight) {
    super(name);
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Dog{" +
        "weight=" + weight +
        ", name='" + name + '\'' +
        '}';
  }
}
