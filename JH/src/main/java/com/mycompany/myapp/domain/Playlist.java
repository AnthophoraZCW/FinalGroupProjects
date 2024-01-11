package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * not an ignored comment
 */
@Schema(description = "not an ignored comment")
@Entity
@Table(name = "playlist")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rel_playlist__videos",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "videos_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "comments", "categories", "playlists" }, allowSetters = true)
    private Set<Video> videos = new HashSet<>();

    @JsonIgnoreProperties(value = { "playlist", "comments" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "playlist")
    private UserProfile userProfile;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Playlist id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Video> getVideos() {
        return this.videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Playlist videos(Set<Video> videos) {
        this.setVideos(videos);
        return this;
    }

    public Playlist addVideos(Video video) {
        this.videos.add(video);
        return this;
    }

    public Playlist removeVideos(Video video) {
        this.videos.remove(video);
        return this;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        if (this.userProfile != null) {
            this.userProfile.setPlaylist(null);
        }
        if (userProfile != null) {
            userProfile.setPlaylist(this);
        }
        this.userProfile = userProfile;
    }

    public Playlist userProfile(UserProfile userProfile) {
        this.setUserProfile(userProfile);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Playlist)) {
            return false;
        }
        return getId() != null && getId().equals(((Playlist) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Playlist{" +
            "id=" + getId() +
            "}";
    }

    public void setVideos(String videoURL) {
    }
}
