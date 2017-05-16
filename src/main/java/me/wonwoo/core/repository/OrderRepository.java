package me.wonwoo.core.repository;

import me.wonwoo.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
