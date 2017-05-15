package me.wonwoo.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
public class Account extends BaseEntity {

  private String username;

  private String password;

  private String name;

  @OneToMany(mappedBy = "account")
  private Set<Order> orders;

  @Embedded
  private Address address;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
