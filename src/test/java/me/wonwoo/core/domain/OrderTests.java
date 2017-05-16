package me.wonwoo.core.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
public class OrderTests {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void getTotalPriceTest() {

    Set<OrderItem> orderItems = new HashSet<>();
    Item item = new Item("shoes", 1000L, 40, new Category());
    Item item1 = new Item("shoes", 2000L, 20, new Category());
    orderItems.add(new OrderItem(item, null, 1000, 2));
    orderItems.add(new OrderItem(item1, null, 2000, 1));
    Order order = new Order(new Account(), LocalDateTime.now(), orderItems, OrderStatus.ORDER);
    assertThat(order.getTotalPrice()).isEqualTo(4000);

    assertThat(item.getStockQuantity()).isEqualTo(38);
    assertThat(item1.getStockQuantity()).isEqualTo(19);
  }

  @Test
  public void cancelTest() {
    Set<OrderItem> orderItems = new HashSet<>();
    Item item = new Item("shoes", 1000L, 40, new Category());
    Item item1 = new Item("shoes", 2000L, 20, new Category());
    orderItems.add(new OrderItem(item, null, 1000, 2));
    orderItems.add(new OrderItem(item1, null, 2000, 1));
    Order order = new Order(new Account(), LocalDateTime.now(), orderItems, OrderStatus.ORDER);
    order.cancel();
    assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL);
    assertThat(item.getStockQuantity()).isEqualTo(40);
    assertThat(item1.getStockQuantity()).isEqualTo(20);
  }

  @Test
  public void cancelIllegalArgumentExceptionTest() {
    exception.expect(IllegalArgumentException.class);
    Set<OrderItem> orderItems = new HashSet<>();
    Item item = new Item("shoes", 1000L, 40, new Category());
    Item item1 = new Item("shoes", 2000L, 20, new Category());
    orderItems.add(new OrderItem(item, null, 1000, 2));
    orderItems.add(new OrderItem(item1, null, 2000, 1));
    Order order = new Order(new Account(), LocalDateTime.now(), orderItems, OrderStatus.CANCEL);
    order.cancel();
  }
}