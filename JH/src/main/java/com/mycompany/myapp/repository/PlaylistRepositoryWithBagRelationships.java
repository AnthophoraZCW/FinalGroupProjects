package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Playlist;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface PlaylistRepositoryWithBagRelationships {
    Optional<Playlist> fetchBagRelationships(Optional<Playlist> playlist);

    List<Playlist> fetchBagRelationships(List<Playlist> playlists);

    Page<Playlist> fetchBagRelationships(Page<Playlist> playlists);
}
