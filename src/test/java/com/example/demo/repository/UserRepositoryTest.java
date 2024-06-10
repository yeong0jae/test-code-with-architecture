package com.example.demo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.UserStatus;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void UserRepository_가_제대로_연결되었다(){
		// given
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail("kyj91032@naver.com");
		userEntity.setAddress("인천광역시");
		userEntity.setNickname("kyj91032");
		userEntity.setStatus(UserStatus.ACTIVE);
		userEntity.setCertificationCode("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");

		// when
		UserEntity result = userRepository.save(userEntity);

		// then
		assertThat(result.getId()).isNotNull();
	}
}
