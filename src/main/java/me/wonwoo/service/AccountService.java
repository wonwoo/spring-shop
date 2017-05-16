package me.wonwoo.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.wonwoo.core.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wonwoolee on 2017. 5. 16..
 */
@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional(readOnly = true)
public class AccountService {

  AccountRepository accountRepository;

  //TODO

}
