package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

//  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
// instead of this we can use @Slf4j Annotation provided by lombok.it will inject req instance automatically.
    public boolean saveNewUser(User user)  //set to unique user in user class
    {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e){
//          logger.info("hahahaahahahaha"); //logger used with Loggerfactory
            log.error("Error occurred for {} :", user.getUserName(), e); //log used with @Slf4j Annotation
            return false;
        } 
    }

    public void saveAdmin(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> getEntryById(ObjectId id)
    {
        return userRepository.findById(id);
    }

//    public void deleteByUserName(String userName)
//    {
//        userRepository.deleteByUserName(userName);
//    }

    public User findByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }
}
