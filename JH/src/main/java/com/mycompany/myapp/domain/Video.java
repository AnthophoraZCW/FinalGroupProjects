package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.myapp.domain.enumeration.Rating;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Video.
 */
@Entity
@Table(name = "video")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "classification")
    private String classification;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "episode")
    private Integer episode;

    @Column(name = "season")
    private Integer season;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private Rating rating;

    @Column(name = "video_url")
    private String videoURL;

    @Column(name = "image_url")
    private String imageURL;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "video")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "video", "postedBy" }, allowSetters = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "videos")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "videos" }, allowSetters = true)
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "videos")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "videos", "userProfile" }, allowSetters = true)
    private Set<Playlist> playlists = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Video id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Video title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public Video description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return this.releaseYear;
    }

    public Video releaseYear(Integer releaseYear) {
        this.setReleaseYear(releaseYear);
        return this;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getClassification() {
        return this.classification;
    }

    public Video classification(String classification) {
        this.setClassification(classification);
        return this;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public Video duration(Integer duration) {
        this.setDuration(duration);
        return this;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEpisode() {
        return this.episode;
    }

    public Video episode(Integer episode) {
        this.setEpisode(episode);
        return this;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Integer getSeason() {
        return this.season;
    }

    public Video season(Integer season) {
        this.setSeason(season);
        return this;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Rating getRating() {
        return this.rating;
    }

    public Video rating(Rating rating) {
        this.setRating(rating);
        return this;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getVideoURL() {
        return this.videoURL;
    }

    public Video videoURL(String videoURL) {
        this.setVideoURL(videoURL);
        return this;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Video imageURL(String imageURL) {
        this.setImageURL(imageURL);
        return this;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        if (this.comments != null) {
            this.comments.forEach(i -> i.setVideo(null));
        }
        if (comments != null) {
            comments.forEach(i -> i.setVideo(this));
        }
        this.comments = comments;
    }

    public Video comments(Set<Comment> comments) {
        this.setComments(comments);
        return this;
    }

    public Video addComments(Comment comment) {
        this.comments.add(comment);
        comment.setVideo(this);
        return this;
    }

    public Video removeComments(Comment comment) {
        this.comments.remove(comment);
        comment.setVideo(null);
        return this;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        if (this.categories != null) {
            this.categories.forEach(i -> i.removeVideos(this));
        }
        if (categories != null) {
            categories.forEach(i -> i.addVideos(this));
        }
        this.categories = categories;
    }

    public Video categories(Set<Category> categories) {
        this.setCategories(categories);
        return this;
    }

    public Video addCategories(Category category) {
        this.categories.add(category);
        category.getVideos().add(this);
        return this;
    }

    public Video removeCategories(Category category) {
        this.categories.remove(category);
        category.getVideos().remove(this);
        return this;
    }

    public Set<Playlist> getPlaylists() {
        return this.playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        if (this.playlists != null) {
            this.playlists.forEach(i -> i.removeVideos(this));
        }
        if (playlists != null) {
            playlists.forEach(i -> i.addVideos(this));
        }
        this.playlists = playlists;
    }

    public Video playlists(Set<Playlist> playlists) {
        this.setPlaylists(playlists);
        return this;
    }

    public Video addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
        playlist.getVideos().add(this);
        return this;
    }

    public Video removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
        playlist.getVideos().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Video)) {
            return false;
        }
        return getId() != null && getId().equals(((Video) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Video{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", releaseYear=" + getReleaseYear() +
            ", classification='" + getClassification() + "'" +
            ", duration=" + getDuration() +
            ", episode=" + getEpisode() +
            ", season=" + getSeason() +
            ", rating='" + getRating() + "'" +
            ", videoURL='" + getVideoURL() + "'" +
            ", imageURL='" + getImageURL() + "'" +
            "}";
    }
}
