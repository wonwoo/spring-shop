package me.wonwoo.core.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
public class OrderItem extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  private Item item;

  @ManyToOne(fetch = FetchType.LAZY)
  private Order order;

  private int orderPrice;

  private int count;

  OrderItem() {

  }

  public OrderItem(Item item, Order order, int orderPrice, int count) {
    this.item = item;
    this.order = order;
    this.orderPrice = orderPrice;
    this.count = count;
    this.item.removeStock(count);
  }

  public void cancel() {
    getItem().addStock(count);
  }

  public int getTotalPrice() {
    return getOrderPrice() * getCount();
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public int getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(int orderPrice) {
    this.orderPrice = orderPrice;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
