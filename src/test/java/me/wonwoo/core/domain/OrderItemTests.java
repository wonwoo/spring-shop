package me.wonwoo.core.domain;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
public class OrderItemTests {

  @Test
  public void cancelTest() {
    Item item = new Item("shoes", 1000L, 40, new Category());
    OrderItem orderItem = new OrderItem(item, null, 1000, 2);
    orderItem.cancel();
    assertThat(item.getStockQuantity()).isEqualTo(40);
  }

  @Test
  public void totalPriceTest() {
    Item item = new Item("shoes", 1000L, 40, new Category());
    OrderItem orderItem = new OrderItem(item, null, 1000, 2);
    assertThat(orderItem.getTotalPrice()).isEqualTo(2000);
  }
}