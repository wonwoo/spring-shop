package me.wonwoo.core.repository;

import me.wonwoo.core.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
