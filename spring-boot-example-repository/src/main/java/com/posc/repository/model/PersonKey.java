package com.posc.repository.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.cassandra.core.Ordering.DESCENDING;
import static org.springframework.cassandra.core.PrimaryKeyType.PARTITIONED;

@PrimaryKeyClass
public class PersonKey implements Serializable{

  @PrimaryKeyColumn(name = "first_name", type = PARTITIONED)
  private final String firstName;

  @PrimaryKeyColumn(name = "date_of_birth", ordinal = 0)
  private final LocalDateTime dateOfBirth;

  @PrimaryKeyColumn(name = "person_id", ordinal = 1, ordering = DESCENDING)
  private final UUID id;

  public PersonKey() {
    firstName = null;
    dateOfBirth = null;
    id = null;
  }

  public PersonKey(String firstName, LocalDateTime dateOfBirth, UUID id) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof PersonKey))
      return false;
    PersonKey personKey = (PersonKey) o;
    return Objects.equal(firstName, personKey.firstName) && Objects.equal(dateOfBirth,
                                                                          personKey.dateOfBirth) && Objects
      .equal(id, personKey.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(firstName, dateOfBirth, id);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
                      .add("firstName", firstName)
                      .add("dateOfBirth", dateOfBirth)
                      .add("id", id)
                      .toString();
  }
}
