import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getEntity } from './video.reducer';
import { useNavigate } from 'react-router-dom';
import 'app/userhome/cssfiles/videopreview.scss';

export const VideoDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();


  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  // Tev's HTML Functions
  function goBack() {
    window.history.back();
  }
  const navigate = useNavigate();
    const playVideo = () => {
    const videoUrl = "https://nexflixclonefinal.s3.amazonaws.com/Toy+Story+(1995)+Trailer+%231+%7C+Movieclips+Classic+Trailers.mp4";
    window.location.href = videoUrl;

    if (videoUrl) {
    // Check if a video URL is available
    window.open(videoUrl, "blank");
  } else {
    // Handle the case when there is no video URL
    alert("Error: No video available.");
  }
  }

    function openCommentModal() {
    // Basic example of a modal for comment input
    const comment = prompt("Add a comment (200 characters or less):");
    if (comment !== null && comment.length <= 200) {

    alert("Comment added: " + comment);
  } else if (comment !== null) {
    alert("Error: Comment must be 200 characters or less.");
  }
  }

    let thumbsUpClickCount = 0;

    function thumbsUpDown() {
    // Change button text based on click count
    const thumbsButton = document.getElementById("thumbsButton");
    thumbsUpClickCount++;
    if (thumbsUpClickCount === 1) {
    thumbsButton.innerText = "Thumbs Up";
  } else if (thumbsUpClickCount === 2) {
    thumbsButton.innerText = "Thumbs Down";
  } else {
    thumbsButton.innerText = "Thumbs";
    thumbsUpClickCount = 0;
  }
  }

  //   function addToPlaylist() {
  //   // Change image for the "Add to My Playlist" button
  //   const playlistButton = document.getElementById("playlistButton");
  //   playlistButton.src = "path/to/added-to-playlist-image.jpg";
  // }

    function goToGenrePage() {
    // Add your logic here
    window.location.href = "http://localhost:9000/userhome";
  }
  // end of Tev's HTML Functions

  
  const videoEntity = useAppSelector(state => state.video.entity);
  return (
    <Row>
      <center>
      <img src={videoEntity.imageURL} alt="Video Preview" className="video-image"/>
      </center>
      <h1 className="video-title">{videoEntity.title}</h1>
  {/* <Button class="play-button" tag={Link} to={videoEntity.videoURL}>Play Video</Button> */}
  
  {videoEntity.videoURL && (
    <video height="640" width="720" controls>
      <source src={videoEntity.videoURL} type="video/mp4"/>
    </video>
    )}
    <div className="video-details">
        <p>Release Year: {videoEntity.releaseYear}</p>
        <p>Classification: {videoEntity.classification}</p>
        <p>Duration: {videoEntity.duration} min</p>
        <p>Episode: {videoEntity.episode}</p>
        <p>Season: {videoEntity.season}</p>
        <p>Rating: {videoEntity.rating}</p>
      </div>
     <div className="video-description">
     <p>Description: {videoEntity.description}</p> 
 </div>


      {/* <Col md="8">
        <h2 data-cy="videoDetailsHeading">
          <Translate contentKey="jhApp.video.detail.title">Video</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{videoEntity.id}</dd>
          <dt>
            <span id="title">
              <Translate contentKey="jhApp.video.title">Title</Translate>
            </span>
          </dt>
          <dd>{videoEntity.title}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="jhApp.video.description">Description</Translate>
            </span>
          </dt>
          <dd>{videoEntity.description}</dd>
          <dt>
            <span id="releaseYear">
              <Translate contentKey="jhApp.video.releaseYear">Release Year</Translate>
            </span>
          </dt>
          <dd>{videoEntity.releaseYear}</dd>
          <dt>
            <span id="classification">
              <Translate contentKey="jhApp.video.classification">Classification</Translate>
            </span>
          </dt>
          <dd>{videoEntity.classification}</dd>
          <dt>
            <span id="duration">
              <Translate contentKey="jhApp.video.duration">Duration</Translate>
            </span>
          </dt>
          <dd>{videoEntity.duration}</dd>
          <dt>
            <span id="episode">
              <Translate contentKey="jhApp.video.episode">Episode</Translate>
            </span>
          </dt>
          <dd>{videoEntity.episode}</dd>
          <dt>
            <span id="season">
              <Translate contentKey="jhApp.video.season">Season</Translate>
            </span>
          </dt>
          <dd>{videoEntity.season}</dd>
          <dt>
            <span id="rating">
              <Translate contentKey="jhApp.video.rating">Rating</Translate>
            </span>
          </dt>
          <dd>{videoEntity.rating}</dd>
          <dt>
            <span id="videoURL">
              <Translate contentKey="jhApp.video.videoURL">Video URL</Translate>
            </span>
          </dt>
          <Link to= {videoEntity.videoURL}>
          <dd>{videoEntity.videoURL}</dd>
          </Link>
          <Button class="play-button" tag={Link} to={videoEntity.videoURL}>Play Video</Button>
          <dt>
            <span id="imageURL">
              <Translate contentKey="jhApp.video.imageURL">Image URL</Translate>
            </span>
          </dt>
          <Link to= {videoEntity.imageURL}> 
          <dd>{videoEntity.imageURL}</dd>
          </Link>
        </dl>
        <Button tag={Link} to="/video" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp; */}

        {/* uncomment code below for edit button back */}
        {/* <Button tag={Link} to={`/video/${videoEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button> */}
      {/* </Col> */}
    </Row>
  );
};

export default VideoDetail;
