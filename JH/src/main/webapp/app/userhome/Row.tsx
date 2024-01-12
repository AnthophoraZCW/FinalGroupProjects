import React, {useState, useEffect} from 'react';
import axios from './axios';


function Row( {title, fetchUrl} ) {
  const [videos, setVideos] = useState([]);
  useEffect(() => {
    async function fetchData(){
      const request = await axios.get(fetchUrl);
    //   'http://localhost:8080'
      setVideos(request.data.results);
      return request;
    }
    fetchData();
  }, [fetchUrl]);
  return(
    <div className = "row">
      {/*   title */}
      <h2>{title}</h2>
      <div className="row_names">
        {videos.map(video => (
          <img src={video.id} alt={video.title}/>
        ))}
      </div>
      {/* containt -> posters */}
      </div>
  )
}

export default Row
