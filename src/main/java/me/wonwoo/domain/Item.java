package me.wonwoo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
public class Item extends BaseEntity {

  private String name;

  private Long price;

  private int stockQuantity;

  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  Item(){

  }

  public Item(String name, Long price, int stockQuantity, Category category) {
    this.name = name;
    this.price = price;
    this.stockQuantity = stockQuantity;
    this.category = category;
  }

  public void addStock(int orderQuantity) {
    this.stockQuantity += orderQuantity;
  }

  public void removeStock(int orderQuantity) {
    int restStock = this.stockQuantity - orderQuantity;
    if (restStock < 0) {
      throw new IllegalArgumentException("need more stock");
    }
    this.stockQuantity = restStock;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
}
