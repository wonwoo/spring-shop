package me.wonwoo.core.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
public class Account extends BaseEntity {

  private String name;

  @OneToMany(mappedBy = "account")
  private Set<Order> orders;

  @Embedded
  private Address address;

  Account() {

  }

  public Account(String name, Set<Order> orders, Address address) {
    this.name = name;
    this.orders = orders;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
