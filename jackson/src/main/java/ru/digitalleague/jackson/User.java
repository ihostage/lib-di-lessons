package ru.digitalleague.jackson;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import java.util.List;

@JsonNaming(SnakeCaseStrategy.class)
public class User {

  private String firstName;

  private String lastName;

  @JsonInclude(ALWAYS)
  private String nullable;

  @JsonProperty("birthday")
  private LocalDateTime birthDay;

  private Gender gender;

  @JsonIgnore
  private String transientField;

  private Address address;

  private List<Pet> pets;

  private Job job;

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

  public String getNullable() {
    return nullable;
  }

  public void setNullable(String nullable) {
    this.nullable = nullable;
  }

  public LocalDateTime getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(LocalDateTime birthDay) {
    this.birthDay = birthDay;
  }

  public boolean isSmart() {
    return true;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getTransientField() {
    return transientField;
  }

  public void setTransientField(String transientField) {
    this.transientField = transientField;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return "User{" +
        "\n\tfirstName='" + firstName + '\'' +
        "\n\tlastName='" + lastName + '\'' +
        "\n\tnullable='" + nullable + '\'' +
        "\n\tbirthDay=" + birthDay +
        "\n\tgender=" + gender +
        "\n\ttransientField='" + transientField + '\'' +
        "\n\taddress=" + address +
        "\n\tpets=" + pets +
        "\n\tjob=" + job +
        "\n}";
  }
}
