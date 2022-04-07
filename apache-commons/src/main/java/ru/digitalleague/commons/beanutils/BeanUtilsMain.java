package ru.digitalleague.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsMain {

  public static void main(String[] args) throws Exception {
    Address moscow = new Address();
    moscow.setCity("Moscow");

    Employee petr = new Employee();
    petr.setFirstName("Petr");

    Object ivan = new Employee();

    PropertyUtils.setProperty(ivan, "firstName", "Ivan");
    System.out.println(
        "First Name: " + PropertyUtils.getProperty(ivan, "firstName")
    );

    PropertyUtils.setIndexedProperty(ivan, "subordinate", 0, petr);
    System.out.println(
        "Subordinate: " + PropertyUtils.getIndexedProperty(ivan, "subordinate[0]")
    );

    PropertyUtils.setMappedProperty(petr, "address", "home", moscow);
    System.out.println(
        "Address: " + PropertyUtils.getMappedProperty(petr, "address(home)")
    );

    PropertyUtils.setNestedProperty(petr, "address(home).street", "Mira");
    System.out.println(
        "Street: " + PropertyUtils.getNestedProperty(ivan, "subordinate[0].address(home).street")
    );

    System.out.println(ivan);
  }

}
