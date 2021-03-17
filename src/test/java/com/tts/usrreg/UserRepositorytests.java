package com.tts.usrreg;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.tts.usrreg.User;
import com.tts.usrreg.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositorytests {
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    // test methods go below
    
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("John_Harden@prpc-inc.com");
        user.setPassword("jhChangeMe!");
        user.setFirstName("John");
        user.setLastName("Harden");
         
        User savedUser = repo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getId());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }
    
    @Test
    public void testFindUserbyEmail() {
    	String email = "It@mail.com";
    	
    	User user = repo.findByEmail(email);
    	
    	assertThat(user).isNotNull();
    }
}   


