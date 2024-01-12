package com.mycompany.myapp.config;

import com.mycompany.myapp.domain.Comment;
import com.mycompany.myapp.domain.UserProfile;
import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.repository.CommentRepository;
import com.mycompany.myapp.repository.UserProfileRepository;
import com.mycompany.myapp.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentConfig {

    @Bean
    public CommandLineRunner populateComments(CommentRepository commentRepository,
                                              VideoRepository videoRepository,
                                              UserProfileRepository userProfileRepository) {
        return args -> {
            // Retrieve sample video and user profiles (assuming they already exist)
            Video sampleVideo = videoRepository.findById(1L).orElse(null);
            UserProfile sampleUserProfile = userProfileRepository.findById(1L).orElse(null);

            if (sampleVideo != null && sampleUserProfile != null) {
                // Add comment data to the database
                Comment comment1 = new Comment();
                comment1.setPost("I wish the Southern Classic was still around! It's also cool that 02' alumni can say they were in this movie. ");
                comment1.setThumbsUp(1);
                comment1.setVideo(sampleVideo);
                comment1.setPostedBy(sampleUserProfile);

                Comment comment2 = new Comment();
                comment2.setPost("Interesting discussion.");
                comment2.setThumbsUp(5);
                comment2.setVideo(sampleVideo);
                comment2.setPostedBy(sampleUserProfile);

                commentRepository.save(comment1);
                commentRepository.save(comment2);

                // Add more comments as needed
            }
        };
    }
}
