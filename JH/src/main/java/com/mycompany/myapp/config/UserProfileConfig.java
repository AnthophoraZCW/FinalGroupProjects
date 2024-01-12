package com.mycompany.myapp.config;

import com.mycompany.myapp.domain.UserProfile;
import com.mycompany.myapp.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserProfileConfig {

    @Bean
    public CommandLineRunner populateUserProfile(UserProfileRepository userProfileRepository) {
        return args -> {
            // Add user profile data to the database
            UserProfile userProfile1 = new UserProfile();
            userProfile1.setUserName("Error404");
            userProfile1.setFirstName("Cesily");
            userProfile1.setLastName("Waters");
            userProfile1.setEmail("ceslondon96@icloud.com");


            UserProfile userProfile2 = new UserProfile();
            userProfile2.setUserName("TevTag");
            userProfile2.setFirstName("Tevin");
            userProfile2.setLastName("Glover");
            userProfile2.setEmail("tevwork.tg@gmail.com");


            UserProfile userProfile3 = new UserProfile();
            userProfile3.setUserName("BetaLoc");
            userProfile3.setFirstName("Loc");
            userProfile3.setLastName("Pham");
            userProfile3.setEmail("beta.locpham@gmail.com");

            userProfileRepository.save(userProfile1);
            userProfileRepository.save(userProfile2);
            userProfileRepository.save(userProfile3);
        };
    }
}

