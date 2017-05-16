package me.wonwoo.core.repository;

import me.wonwoo.core.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByName(String name);
}
