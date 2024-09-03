package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testAdd(){
        assertEquals(4, 2+2);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "rahul",
            "anurag",
            "rohit"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name));
    }
}
