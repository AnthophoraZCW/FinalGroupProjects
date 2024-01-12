package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Playlist;
import com.mycompany.myapp.domain.Video;
import com.mycompany.myapp.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {
    private PlaylistRepository repository;

    @Autowired
    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }

    public Playlist create(Playlist playlist) {
        return repository.save(playlist);
    }

    public Playlist readById(Long id) {
        return repository.findById(id).get();
    }

    public List<Playlist> readAll() {
        Iterable<Playlist> allPlaylist = repository.findAll();
        List<Playlist> playlistList = new ArrayList<>();
        allPlaylist.forEach(playlistList::add);
        return playlistList;
    }

    public Playlist update(Long id, Video newPlaylistData) {
        Playlist playlistInDatabase = this.readById(id);
        playlistInDatabase.setId(newPlaylistData.getId());
        playlistInDatabase.setVideos(newPlaylistData.getVideoURL());
        playlistInDatabase = repository.save(playlistInDatabase);
        return playlistInDatabase;
    }

    public Playlist deleteById(Long id) {
        Playlist playlistToBeDeleted = this.readById(id);
        repository.delete(playlistToBeDeleted);
        return playlistToBeDeleted;
    }
}
