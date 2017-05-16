package me.wonwoo.core.repository;

import me.wonwoo.core.domain.Account;
import me.wonwoo.core.domain.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by wonwoolee on 2017. 5. 16..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void findOneTest() {
    Account account = entityManager.persist(
        new Account("1", "wonwoo", null,
            new Address("성남", "산성대로", "123-123")
        ));
    Account result = accountRepository.findOne(account.getId());
    assertThat(result.getLoginId()).isEqualTo("1");
    assertThat(result.getName()).isEqualTo("wonwoo");
    assertThat(result.getAddress()).isEqualTo(new Address("성남", "산성대로", "123-123"));
  }

  @Test
  public void findByLoginIdTest() {
    entityManager.persist(new Account("1", "wonwoo", null,
        new Address("성남", "산성대로", "123-123")));
    Account result = accountRepository.findByLoginId("1");
    assertThat(result.getLoginId()).isEqualTo("1");
    assertThat(result.getName()).isEqualTo("wonwoo");
    assertThat(result.getAddress()).isEqualTo(new Address("성남", "산성대로", "123-123"));
  }
}