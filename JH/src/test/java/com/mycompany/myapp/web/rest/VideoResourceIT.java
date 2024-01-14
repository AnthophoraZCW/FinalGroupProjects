package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.domain.enumeration.Rating;
import com.mycompany.myapp.repository.VideoRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link VideoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class VideoResourceIT {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_RELEASE_YEAR = 1;
    private static final Integer UPDATED_RELEASE_YEAR = 2;

    private static final String DEFAULT_CLASSIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_CLASSIFICATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_DURATION = 1;
    private static final Integer UPDATED_DURATION = 2;

    private static final Integer DEFAULT_EPISODE = 1;
    private static final Integer UPDATED_EPISODE = 2;

    private static final Integer DEFAULT_SEASON = 1;
    private static final Integer UPDATED_SEASON = 2;

    private static final Rating DEFAULT_RATING = Rating.G;
    private static final Rating UPDATED_RATING = Rating.TV_Y;

    private static final String DEFAULT_VIDEO_URL = "AAAAAAAAAA";
    private static final String UPDATED_VIDEO_URL = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_URL = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/videos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVideoMockMvc;

    private Video video;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Video createEntity(EntityManager em) {
        Video video = new Video()
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION)
            .releaseYear(DEFAULT_RELEASE_YEAR)
            .classification(DEFAULT_CLASSIFICATION)
            .duration(DEFAULT_DURATION)
            .episode(DEFAULT_EPISODE)
            .season(DEFAULT_SEASON)
            .rating(DEFAULT_RATING)
            .videoURL(DEFAULT_VIDEO_URL)
            .imageURL(DEFAULT_IMAGE_URL);
        return video;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Video createUpdatedEntity(EntityManager em) {
        Video video = new Video()
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .releaseYear(UPDATED_RELEASE_YEAR)
            .classification(UPDATED_CLASSIFICATION)
            .duration(UPDATED_DURATION)
            .episode(UPDATED_EPISODE)
            .season(UPDATED_SEASON)
            .rating(UPDATED_RATING)
            .videoURL(UPDATED_VIDEO_URL)
            .imageURL(UPDATED_IMAGE_URL);
        return video;
    }

    @BeforeEach
    public void initTest() {
        video = createEntity(em);
    }

    @Test
    @Transactional
    void createVideo() throws Exception {
        int databaseSizeBeforeCreate = videoRepository.findAll().size();
        // Create the Video
        restVideoMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(video)))
            .andExpect(status().isCreated());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeCreate + 1);
        Video testVideo = videoList.get(videoList.size() - 1);
        assertThat(testVideo.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testVideo.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testVideo.getReleaseYear()).isEqualTo(DEFAULT_RELEASE_YEAR);
        assertThat(testVideo.getClassification()).isEqualTo(DEFAULT_CLASSIFICATION);
        assertThat(testVideo.getDuration()).isEqualTo(DEFAULT_DURATION);
        assertThat(testVideo.getEpisode()).isEqualTo(DEFAULT_EPISODE);
        assertThat(testVideo.getSeason()).isEqualTo(DEFAULT_SEASON);
        assertThat(testVideo.getRating()).isEqualTo(DEFAULT_RATING);
        assertThat(testVideo.getVideoURL()).isEqualTo(DEFAULT_VIDEO_URL);
        assertThat(testVideo.getImageURL()).isEqualTo(DEFAULT_IMAGE_URL);
    }

    @Test
    @Transactional
    void createVideoWithExistingId() throws Exception {
        // Create the Video with an existing ID
        video.setId(1L);

        int databaseSizeBeforeCreate = videoRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restVideoMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(video)))
            .andExpect(status().isBadRequest());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllVideos() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        // Get all the videoList
        restVideoMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(video.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].releaseYear").value(hasItem(DEFAULT_RELEASE_YEAR)))
            .andExpect(jsonPath("$.[*].classification").value(hasItem(DEFAULT_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].duration").value(hasItem(DEFAULT_DURATION)))
            .andExpect(jsonPath("$.[*].episode").value(hasItem(DEFAULT_EPISODE)))
            .andExpect(jsonPath("$.[*].season").value(hasItem(DEFAULT_SEASON)))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING.toString())))
            .andExpect(jsonPath("$.[*].videoURL").value(hasItem(DEFAULT_VIDEO_URL)))
            .andExpect(jsonPath("$.[*].imageURL").value(hasItem(DEFAULT_IMAGE_URL)));
    }

    @Test
    @Transactional
    void getVideo() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        // Get the video
        restVideoMockMvc
            .perform(get(ENTITY_API_URL_ID, video.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(video.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.releaseYear").value(DEFAULT_RELEASE_YEAR))
            .andExpect(jsonPath("$.classification").value(DEFAULT_CLASSIFICATION))
            .andExpect(jsonPath("$.duration").value(DEFAULT_DURATION))
            .andExpect(jsonPath("$.episode").value(DEFAULT_EPISODE))
            .andExpect(jsonPath("$.season").value(DEFAULT_SEASON))
            .andExpect(jsonPath("$.rating").value(DEFAULT_RATING.toString()))
            .andExpect(jsonPath("$.videoURL").value(DEFAULT_VIDEO_URL))
            .andExpect(jsonPath("$.imageURL").value(DEFAULT_IMAGE_URL));
    }

    @Test
    @Transactional
    void getNonExistingVideo() throws Exception {
        // Get the video
        restVideoMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingVideo() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        int databaseSizeBeforeUpdate = videoRepository.findAll().size();

        // Update the video
        Video updatedVideo = videoRepository.findById(video.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedVideo are not directly saved in db
        em.detach(updatedVideo);
        updatedVideo
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .releaseYear(UPDATED_RELEASE_YEAR)
            .classification(UPDATED_CLASSIFICATION)
            .duration(UPDATED_DURATION)
            .episode(UPDATED_EPISODE)
            .season(UPDATED_SEASON)
            .rating(UPDATED_RATING)
            .videoURL(UPDATED_VIDEO_URL)
            .imageURL(UPDATED_IMAGE_URL);

        restVideoMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedVideo.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedVideo))
            )
            .andExpect(status().isOk());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
        Video testVideo = videoList.get(videoList.size() - 1);
        assertThat(testVideo.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testVideo.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testVideo.getReleaseYear()).isEqualTo(UPDATED_RELEASE_YEAR);
        assertThat(testVideo.getClassification()).isEqualTo(UPDATED_CLASSIFICATION);
        assertThat(testVideo.getDuration()).isEqualTo(UPDATED_DURATION);
        assertThat(testVideo.getEpisode()).isEqualTo(UPDATED_EPISODE);
        assertThat(testVideo.getSeason()).isEqualTo(UPDATED_SEASON);
        assertThat(testVideo.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testVideo.getVideoURL()).isEqualTo(UPDATED_VIDEO_URL);
        assertThat(testVideo.getImageURL()).isEqualTo(UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void putNonExistingVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(
                put(ENTITY_API_URL_ID, video.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(video))
            )
            .andExpect(status().isBadRequest());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(video))
            )
            .andExpect(status().isBadRequest());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(video)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateVideoWithPatch() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        int databaseSizeBeforeUpdate = videoRepository.findAll().size();

        // Update the video using partial update
        Video partialUpdatedVideo = new Video();
        partialUpdatedVideo.setId(video.getId());

        partialUpdatedVideo
            .title(UPDATED_TITLE)
            .releaseYear(UPDATED_RELEASE_YEAR)
            .season(UPDATED_SEASON)
            .rating(UPDATED_RATING)
            .videoURL(UPDATED_VIDEO_URL)
            .imageURL(UPDATED_IMAGE_URL);

        restVideoMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVideo.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedVideo))
            )
            .andExpect(status().isOk());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
        Video testVideo = videoList.get(videoList.size() - 1);
        assertThat(testVideo.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testVideo.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testVideo.getReleaseYear()).isEqualTo(UPDATED_RELEASE_YEAR);
        assertThat(testVideo.getClassification()).isEqualTo(DEFAULT_CLASSIFICATION);
        assertThat(testVideo.getDuration()).isEqualTo(DEFAULT_DURATION);
        assertThat(testVideo.getEpisode()).isEqualTo(DEFAULT_EPISODE);
        assertThat(testVideo.getSeason()).isEqualTo(UPDATED_SEASON);
        assertThat(testVideo.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testVideo.getVideoURL()).isEqualTo(UPDATED_VIDEO_URL);
        assertThat(testVideo.getImageURL()).isEqualTo(UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void fullUpdateVideoWithPatch() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        int databaseSizeBeforeUpdate = videoRepository.findAll().size();

        // Update the video using partial update
        Video partialUpdatedVideo = new Video();
        partialUpdatedVideo.setId(video.getId());

        partialUpdatedVideo
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .releaseYear(UPDATED_RELEASE_YEAR)
            .classification(UPDATED_CLASSIFICATION)
            .duration(UPDATED_DURATION)
            .episode(UPDATED_EPISODE)
            .season(UPDATED_SEASON)
            .rating(UPDATED_RATING)
            .videoURL(UPDATED_VIDEO_URL)
            .imageURL(UPDATED_IMAGE_URL);

        restVideoMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedVideo.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedVideo))
            )
            .andExpect(status().isOk());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
        Video testVideo = videoList.get(videoList.size() - 1);
        assertThat(testVideo.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testVideo.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testVideo.getReleaseYear()).isEqualTo(UPDATED_RELEASE_YEAR);
        assertThat(testVideo.getClassification()).isEqualTo(UPDATED_CLASSIFICATION);
        assertThat(testVideo.getDuration()).isEqualTo(UPDATED_DURATION);
        assertThat(testVideo.getEpisode()).isEqualTo(UPDATED_EPISODE);
        assertThat(testVideo.getSeason()).isEqualTo(UPDATED_SEASON);
        assertThat(testVideo.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testVideo.getVideoURL()).isEqualTo(UPDATED_VIDEO_URL);
        assertThat(testVideo.getImageURL()).isEqualTo(UPDATED_IMAGE_URL);
    }

    @Test
    @Transactional
    void patchNonExistingVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, video.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(video))
            )
            .andExpect(status().isBadRequest());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(video))
            )
            .andExpect(status().isBadRequest());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamVideo() throws Exception {
        int databaseSizeBeforeUpdate = videoRepository.findAll().size();
        video.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restVideoMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(video)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Video in the database
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteVideo() throws Exception {
        // Initialize the database
        videoRepository.saveAndFlush(video);

        int databaseSizeBeforeDelete = videoRepository.findAll().size();

        // Delete the video
        restVideoMockMvc
            .perform(delete(ENTITY_API_URL_ID, video.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Video> videoList = videoRepository.findAll();
        assertThat(videoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
