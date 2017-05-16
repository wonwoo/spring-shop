package me.wonwoo.core.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity {

  private Account account;

  private LocalDateTime regDate;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<OrderItem> orderItems;

  private OrderStatus status;

  Order() {

  }

  public Order(Account account, LocalDateTime regDate, Set<OrderItem> orderItems, OrderStatus status) {
    this.account = account;
    this.regDate = regDate;
    this.orderItems = orderItems;
    this.status = status;
  }

  public void cancel() {
    if(this.status == OrderStatus.CANCEL) {
      throw new IllegalArgumentException("already cancel status");
    }
    this.setStatus(OrderStatus.CANCEL);
    orderItems.forEach(OrderItem::cancel);
  }

  public int getTotalPrice() {
    return orderItems.stream().mapToInt(OrderItem::getTotalPrice).sum();
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }

  public Set<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(Set<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
