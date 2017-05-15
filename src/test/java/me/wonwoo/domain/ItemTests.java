package me.wonwoo.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by wonwoolee on 2017. 5. 15..
 */
public class ItemTests {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void addStockQuantityTest() {
    Item item = new Item("shoes", 1000L, 40, new Category());
    item.addStock(10);
    assertThat(item.getStockQuantity()).isEqualTo(50);
  }

  @Test
  public void removeStockQuantityTest() {
    Item item = new Item("shoes", 1000L, 40, new Category());
    item.removeStock(20);
    assertThat(item.getStockQuantity()).isEqualTo(20);
  }

  @Test
  public void removeStockQuantityIllegalArgumentExceptionTest() {
    exception.expect(IllegalArgumentException.class);
    Item item = new Item("shoes", 1000L, 40, new Category());
    item.removeStock(50);

  }
}