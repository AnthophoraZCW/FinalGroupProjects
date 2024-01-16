import React, {useState, useEffect} from 'react'
import axios from './axios';
import requests from './requests';

function Banner() {
    const [video, setVideo] = useState([]);
    useEffect(() => {
        async function fetchData() {
            const request = await axios.get(requests.fetchAll);
            // setsvideo to random video from the list
            setVideo(
                request.data[
                    Math.floor(Math.random() * request.data.length -1)
                ]
            );
            return request;
        }
        fetchData();
    }, []);
    if (!video) {
        return <div>Loading...</div>;
    }
  return (
    <header className='banner'style={{backgroundSize: "cover",backgroundImage: `url("")`,backgroundPosition: "center center"}}>{/* background image */}
        <div className='banner_contents'> 
           
      {/* title */}
      {/* div > 2 buttons */}
      {/* description */}
      </div>
    </header>
      )
}

export default Banner
