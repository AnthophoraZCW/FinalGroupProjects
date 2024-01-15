package com.mycompany.myapp.config;

import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VideoConfigurerTest {

    @Test
    public void initData_ShouldInsertSampleVideo() throws Exception {
        // Mock the VideoRepository
        VideoRepository videoRepository = Mockito.mock(VideoRepository.class);

        // Create an instance of VideoConfig
        VideoConfig videoConfig = new VideoConfig();

        // Call the initData method with the mocked repository
        videoConfig.initData(videoRepository).run();

        // Verify that the save method of VideoRepository is called exactly 31x with the expected Video objects
        Mockito.verify(videoRepository, Mockito.times(31)).save(Mockito.any(Video.class));
    }
}
