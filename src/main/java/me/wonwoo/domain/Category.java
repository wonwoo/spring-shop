package me.wonwoo.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by wonwoolee on 2017. 5. 15..
 */
@Entity
public class Category extends BaseEntity {

  private String name;

  @OneToMany(mappedBy = "category")
  private Set<Item> items;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }
}
