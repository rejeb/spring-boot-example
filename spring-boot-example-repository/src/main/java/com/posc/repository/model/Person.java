package com.posc.repository.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("person")
public class Person {

  @PrimaryKey
  private final PersonKey key;

  @Column("last_name")
  private final String lastName;

  @Column
  private final String gender;

  public Person() {
    key = null;
    lastName = null;
    gender = null;
  }

  public Person(final PersonKey key, final String lastName, final String gender) {
    this.key = key;
    this.lastName = lastName;
    this.gender = gender;
  }

  /**
   * Get key
   *
   * @return key
   */

  public PersonKey getKey() {
    return key;
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
    return Objects.equal(key, person.key) && Objects.equal(lastName,
                                                           person.lastName) && Objects.equal(gender,
                                                                                             person.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key, lastName, gender);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("key", key)
                      .add("lastName", lastName)
                      .add("gender", gender)
                      .toString();
  }
}

