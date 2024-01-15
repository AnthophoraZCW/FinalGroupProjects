import React, {useEffect, useState} from 'react';
import { Link } from 'react-router-dom';
import { Translate } from 'react-jhipster';
import { Row, Col, Alert } from 'reactstrap';

import { useAppSelector } from 'app/config/store';
import axios from "axios";

export interface IVideoProps{
  isAuthenticated: boolean;
  isAdmin: boolean;
}
import Header from "app/shared/layout/header/header";

// you can have a function or lambda declaration for components
export const Video = (props: IVideoProps) => {
  const account = useAppSelector(state => state.authentication.account); // ? look it up
  const [videoId, setVideoId] = useState(0); // this how you make a variable for video id
// this is a use state - the state of the current component.
  const [videoTitle, setVideoTitle] = useState("no video Loaded");
  const [releaseYear, setReleaseYear] = useState(0);
  const [classification, setClassification] = useState("");
  const [duration, setDuration] = useState(0.0);
  const [episode, setEpisode] = useState(0);
  const [season, setSeason] = useState(0);
  const [rating, setRating] = useState(0);
  const [videoDescription, setVideoDescription] = useState("");
  const [videoUrl, setVideoUrl] = useState("");
  const [imageUrl, setImageUrl] = useState("");
  const [playList, setPlayList] = useState([]); // most of the time you want to set the type.
  const [playListId, setPlayListId] = useState(0);
  const [showAddComment, setShowAddComment] = useState(false);

  useEffect(() => {
      fetchPlayList()
    }, []
  );
  const fetchPlayList = async () => {
    try{
      const response = await
        axios.get("http://localhost:8080/api/playlists/" + playListId)
      setPlayList(response.data) // this is going to give you a response code (100- 500)
    }catch (e) {
      console.error(" Error fetching the playlist : " , e)
    }
  }


  const toggleAddComment = () => {
    setShowAddComment(!showAddComment); // this is my first toggle (on and off)
  }

  const handleAddToMyPlaylist = () => {

  }

  return (
    <>
      {/* <Header isAuthenticated={} isAdmin={} ribbonEnv={} isInProduction={} isOpenAPIEnabled={} currentLocale={}/> */}
      { props.isAuthenticated && (
        <div>
          <image>{imageUrl}</image>
          <h1 className="title">{videoTitle}</h1>
          <p> Release Year: {releaseYear}</p>
          <p> Classification: {classification}</p>
          <p>Duration: {duration} </p>
          <p>Episode: {episode}</p>
          <p>Season: {season}</p>
          <p>Rating: {rating}</p>
          <p>Description: {videoDescription}</p>
          <button>Play Video</button>
          <button onClick={handleAddToMyPlaylist}>Add to My Playlist</button>

          <button>Thumbs</button>
          <button onClick={toggleAddComment}>Add Comment</button>
          {showAddComment  && (
            <div>
              <input/>
            </div>
          ) }
          <h2>Comments</h2>
        </div>
      )}
    </>  /* //you need to have div or <> */
  )
};

export default Video;
