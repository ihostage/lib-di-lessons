package ru.digitalleague.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Cat extends Pet {

  private String color;

  @JsonCreator
  public Cat(String name, @JsonAlias("cat_color") String color) {
    super(name);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Cat{" +
        "color='" + color + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
