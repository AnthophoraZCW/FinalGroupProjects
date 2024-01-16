import React from 'react';
import './cssfiles/AppUser.scss';
import {Translate} from "react-jhipster";
import {useLocation, useNavigate} from "react-router-dom";
import {useAppDispatch} from "app/config/store";
import Row from "./Row";
import requests from "./requests";
import Banner from "./Banner";
import Navi from "./Navi";
//page to reroute login.users
function AppUser(){
  const dispatch = useAppDispatch();
  const pageLocation = useLocation();
  const navigate = useNavigate();
  const routeToUserHome = () => {
    const path = `/userhome`;
    try{
      navigate(path);
    }
    catch(err){
      console.log(err);
    }
  }
  routeToUserHome();
  return(
    <>
    <div className ="AppUser">
      {/* <Navi/> */}
      {/* <Banner/> */}
      <div className='header-container'>
      <h1 style={{ fontSize: '100px' }}>
        Welcome to VLA
      </h1>
      <img src="/content/images/VLALogo.png" alt="Logo" />
      </div>
      <Row categoryTitle = "Action" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Romance" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Comedy" fetchUrl={requests.fetchComedy}/>
      <Row categoryTitle = "Fantasy" fetchUrl={requests.fetchFantasy} />
      <Row categoryTitle = "Animation" fetchUrl={requests.fetchAnimation}/>
      <Row categoryTitle = "Horror" fetchUrl={requests.fetchHorror}/>
      <Row categoryTitle = "Sci-Fi" fetchUrl={requests.fetchSciFi} />
      <Row categoryTitle = "Drama" fetchUrl={requests.fetchDrama}/>
      <Row categoryTitle = "Adventure" fetchUrl={requests.fetchAdventure}/>
      <Row categoryTitle = "Crime" fetchUrl={requests.fetchCrime} />
      <Row categoryTitle = "Thriller" fetchUrl={requests.fetchThriller}/>
      <Row categoryTitle = "Music" fetchUrl={requests.fetchMusic}/>
      <Row categoryTitle = "Family" fetchUrl={requests.fetchFamily} />
      <Row categoryTitle = "Sports" fetchUrl={requests.fetchSport}/>
      <Row categoryTitle = "Biography" fetchUrl={requests.fetchBio}/>
    </div>
    </>
  );
}

export default AppUser;
