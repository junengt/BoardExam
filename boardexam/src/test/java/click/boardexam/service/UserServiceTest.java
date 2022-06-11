package click.boardexam.service;

import click.boardexam.domain.User;
import click.boardexam.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() throws Exception {
        //given: 이런 게 주어졌을 때
        User user = new User();
        user.setUid("blahblah");
        user.setNickname("june");
        user.setPassword("password123");
        User save = userRepository.save(user);

        assertThat(user).isNotNull();
        assertThat(user.getUid()).isEqualTo("blahblah");
        assertThat(user.getNickname()).isEqualTo("june");
        assertThat(user.getPassword()).isEqualTo("password123");
    }

}