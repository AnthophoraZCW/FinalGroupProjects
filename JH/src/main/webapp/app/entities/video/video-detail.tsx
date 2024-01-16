import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getEntity } from './video.reducer';
import { useNavigate } from 'react-router-dom';
import 'app/userhome/cssfiles/videopreview.scss';
import Request from 'app/userhome/requests';
import axios from 'app/userhome/axios';
import { set } from 'lodash';

export const VideoDetail = () => {
  const dispatch = useAppDispatch();
  const { id } = useParams<'id'>();
  const [comments, setComments] = useState([]);
  const [user, setUser] = useState([]);
  
  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  // async function to set comments into array
  useEffect(() => {
    async function fetchData() {
      const request = await axios.get(Request.fetchComments);
      const videoEntityId: bigint = id as unknown as bigint;
      let temp = [];
      for(let i = 0; i < request.data.length; i++){
        let videoId = request.data[i].video.id;
        if(videoId == videoEntityId){
          temp.push(request.data[i]);
        }
      }
      setComments(temp);
      return request;
    }
    fetchData();
  }, []);
  console.log(comments);

  // async function to match user profile to comment
  // useEffect(() => {
  //   async function fetchData() {
  //     const request = await axios.get(Request.fetchUser);
  //     let temp = [];
  //     console.log(request.data);
  //     for(let i = 0; i < request.data.length; i++){
  //       let userId = request.data[i].id;
  //     comments.forEach(comment => {if(userId == comment.postedBy.id){
  //       temp.push(request.data[i]);
  //       console.log(request.data[i]);
  //     }
  //     });
  //       if(userId == temp){
  //         temp.push(request.data[i]);
  //         console.log(request.data[i]);
  //       }
  //     }
  //     setUser(temp);
  //     return request;
  //   }
  //   fetchData();
  // }, []);
//  console.log(user);

  // Tev's HTML Functions
  function goBack() {
    window.history.back();
  }
    function openCommentModal() {
    // Basic example of a modal for comment input
    const temp = Math.floor(Math.random() * 3)+1;
    const comment = prompt("Add a comment (200 characters or less):");
    if (comment !== null && comment.length <= 200) {
    // Check if comment is valid
    async function postComment() {
      try{
      const request = await axios.post(Request.fetchComments, {
        method: "POST",
        post: comment, 
        postedBy: {
          id: temp
        },
        thumbsup: null,
        video: {
          id: id
        },
      });
      return request;
    } catch(err){
      console.log(err);
    }
    }
    postComment();
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
    thumbsButton.innerText = "Like";
  } else if (thumbsUpClickCount === 2) {
    thumbsButton.innerText = "Dislike";
  } else {
    thumbsButton.innerText = "Mid";
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
        <div>{videoEntity.classification === 'TV Series' && (
        <p>Episode: {videoEntity.episode}</p> &&
        <p>Season: {videoEntity.season}</p>
        )}
        <p>Rating: {videoEntity.rating}</p>
        </div>
      </div>
     <div className="video-description">
     <p>Description: {videoEntity.description}</p> 
 </div>

    <div className='video-description'>
      Comments:
      
    {comments.map(comment => (
        <p key = {comment.id} className='video-comments'>
          User {comment.postedBy.id}: {comment.post}
        </p>
      ))}
    </div>
    <Button className="comment-button" onClick={thumbsUpDown} id="thumbsButton">Like</Button>
    <Button className="comment-button" onClick={openCommentModal}>Add a Comment</Button> 
    <Button onClick={goBack}>Back</Button> 

    </Row>
  );
};

export default VideoDetail;
