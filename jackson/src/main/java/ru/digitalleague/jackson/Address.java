package ru.digitalleague.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Address {

  private String city;

  private String street;

  @JsonCreator
  public Address(String address) {
    String[] addr = address.split(",", 2);
    this.city = addr[0].trim();
    this.street = addr[1].trim();
  }

  @JsonValue
  public String getFullAddress() {
    return city + ", " + street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public String toString() {
    return "Address{" +
        "city='" + city + '\'' +
        ", street='" + street + '\'' +
        '}';
  }
}
