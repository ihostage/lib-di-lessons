package ru.digitalleague.commons.beanutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

  private String firstName;

  private String lastName;

  private final Map<String, Address> addresses = new HashMap<>();

  private final List<Employee> subordinates = new ArrayList<>(10);

  public Address getAddress(String type) {
    return addresses.get(type);
  }

  public void setAddress(String type, Address address) {
    addresses.put(type, address);
  }

  public Employee getSubordinate(int index) {
    return subordinates.get(index);
  }

  public void setSubordinate(int index, Employee subordinate) {
    if (index >= subordinates.size()) {
      subordinates.add(index, subordinate);
    } else {
      subordinates.set(index, subordinate);
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", addresses=" + addresses +
        ", subordinates=" + subordinates +
        '}';
  }
}
