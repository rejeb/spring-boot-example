package com.posc.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Person implements Serializable {

  private final String firstName;

  private final LocalDateTime dateOfBirth;

  private final UUID id;

  private final String lastName;

  private final String gender;

  private Person() {

    firstName = null;
    dateOfBirth = null;
    id = null;
    lastName = null;
    gender = null;
  }

  private Person(Builder builder) {
    this.firstName = builder.firstName;
    this.dateOfBirth = builder.dateOfBirth;
    this.id = builder.id;
    this.lastName = builder.lastName;
    this.gender = builder.gender;
  }

  /**
   * Get firstName
   *
   * @return firstName
   */

  public String getFirstName() {
    return firstName;
  }

  /**
   * Get dateOfBirth
   *
   * @return dateOfBirth
   */

  public LocalDateTime getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Get id
   *
   * @return id
   */

  public UUID getId() {
    return id;
  }

  /**
   * Get lastName
   *
   * @return lastName
   */

  public String getLastName() {
    return lastName;
  }

  /**
   * Get gender
   *
   * @return gender
   */

  public String getGender() {
    return gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Person))
      return false;
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) && Objects.equals(dateOfBirth,
                                                                         person.dateOfBirth) && Objects
      .equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(gender,
                                                                                            person.gender);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, dateOfBirth, id, lastName, gender);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Person{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", dateOfBirth=").append(dateOfBirth);
    sb.append(", id=").append(id);
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", gender='").append(gender).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public static Builder builder(){
    return new Builder();
  }

  public static class Builder{

    private String firstName;
    private LocalDateTime dateOfBirth;
    private UUID id;
    private String lastName;
    private String gender;

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder dateOfBirth(LocalDateTime dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder id(UUID id) {
      this.id = id;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
