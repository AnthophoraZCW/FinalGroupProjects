import React, {useState, useEffect} from 'react';
import axios from './axios';
import './cssfiles/Row.scss';
import {Link} from 'react-router-dom';
import { Button } from 'reactstrap';
import { useNavigate } from 'react-router-dom';

function Row( {categoryTitle, fetchUrl} ) {
  const [videos, setVideos] = useState([]);
  useEffect(() => {     //   'http://localhost:8080'
    //async function to fetch data into 
    async function fetchData(){
      const request = await axios.get(fetchUrl);
      // console.log(request);
      setVideos(request.data.videos);
      return request;
    }
    fetchData();
  }, []);

    // console.log(videos);
   
   if(!videos)
     return (
       <>
         <p>fetching videos...</p>
       </>
     );

  // const { title, backdrop_path } = 
  const navigate = useNavigate();
  return(
    <div className = "row">
      {/*   title */}
      <h2 className='title_style'>{categoryTitle}</h2>
      <div className="row_images">
        {videos.map(video => (
          // <Button tag={Link} to='/video/${video.id}'/>
          <img 
          key={video.id}
          className='row_image' 
          src={video.imageURL} 
          alt={video.title}
          onClick={() => navigate(`/video/${video.id}`)}
          style={{ cursor: 'pointer'}}
          />
          // </Button>
        ))}
      </div>
      {/* write code for clicking image take to video page */}
      </div>
  )
}

export default Row
