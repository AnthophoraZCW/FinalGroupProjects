package com.mycompany.myapp.service;


import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    private VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public Video create(Video video) {
        return repository.save(video);
    }

    public Video readById(Long id) {
        return repository.findById(id).get();
    }

    public List<Video> readAll() {
        Iterable<Video> allVideo = repository.findAll();
        List<Video> videoList = new ArrayList<>();
        allVideo.forEach(videoList::add);
        return videoList;
    }

    public Video update(Long id, Video newVideoData) {
        Video videoInDatabase = this.readById(id);
        videoInDatabase.setTitle(newVideoData.getTitle());
        videoInDatabase.setDescription(newVideoData.getDescription());
        videoInDatabase.setReleaseYear(newVideoData.getReleaseYear());
        videoInDatabase.setClassification(newVideoData.getClassification());
        videoInDatabase.setDuration(newVideoData.getDuration());
        videoInDatabase.setEpisode(newVideoData.getEpisode());
        videoInDatabase.setSeason(newVideoData.getSeason());
        videoInDatabase.setRating(newVideoData.getRating());
        videoInDatabase.setVideoURL(newVideoData.getVideoURL());
        videoInDatabase = repository.save(videoInDatabase);
        return videoInDatabase;
    }

    public Video deleteById(Long id) {
        Video videoToBeDeleted = this.readById(id);
        repository.delete(videoToBeDeleted);
        return videoToBeDeleted;

    }
}
