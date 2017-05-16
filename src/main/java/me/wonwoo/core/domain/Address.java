package me.wonwoo.core.domain;

import javax.persistence.Embeddable;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Embeddable
public class Address {

  private String city;
  private String street;
  private String zipcode;

  Address() { //why jpa why?
  }

  public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getZipcode() {
    return zipcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Address address = (Address) o;

    if (city != null ? !city.equals(address.city) : address.city != null) return false;
    if (street != null ? !street.equals(address.street) : address.street != null) return false;
    return zipcode != null ? zipcode.equals(address.zipcode) : address.zipcode == null;
  }

  @Override
  public int hashCode() {
    int result = city != null ? city.hashCode() : 0;
    result = 31 * result + (street != null ? street.hashCode() : 0);
    result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
    return result;
  }
}
