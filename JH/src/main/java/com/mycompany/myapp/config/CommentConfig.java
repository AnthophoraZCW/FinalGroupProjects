package com.mycompany.myapp.config;

import com.mycompany.myapp.domain.Comment;
import com.mycompany.myapp.domain.UserProfile;
import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.repository.CommentRepository;
import com.mycompany.myapp.repository.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommentConfig {

    @Bean
    public CommandLineRunner populateComments(CommentRepository commentRepository,
                                              UserProfileRepository userProfileRepository,
                                              VideoConfig videoConfig) {
        return args -> {
            // Retrieve sample user profile (assuming it already exists)
            UserProfile selectedUserProfile = userProfileRepository.findById(1L).orElse(null);

            if (selectedUserProfile != null) {
                // Retrieve list of sample videos from VideoConfig
                List<Video> sampleVideos = videoConfig.getSampleVideos();

                // Add comment data to the database for each video
                for (Video sampleVideo : sampleVideos) {
                    Comment comment = new Comment();
                    comment.setPost("Great video!");
                    comment.setThumbsUp(10);
                    comment.setVideo(videoConfi);
                    comment.setPostedBy(selectedUserProfile);

                    commentRepository.save(comment);
                }
            }
        };
    }
}
