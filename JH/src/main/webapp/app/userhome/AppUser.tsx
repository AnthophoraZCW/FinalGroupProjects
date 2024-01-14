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
    navigate(path);
  }
  routeToUserHome();
  return(
    <>
    <div className ="AppUser">
      {/* <Navi/> */}
      <Banner/>
      <h1>
        Howdy! Welcome to VLA (Netflix Clone)
      </h1>
      <h2> 
        
      </h2>
      <Row categoryTitle = "Action" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Romance" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Comedy" fetchUrl={requests.fetchComedy}/>
      <Row categoryTitle = "Fantasy" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Animation" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Horror" fetchUrl={requests.fetchComedy}/>
      <Row categoryTitle = "Sci-Fi" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Drama" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Adventure" fetchUrl={requests.fetchComedy}/>
      <Row categoryTitle = "Crime" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Thriller" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Music" fetchUrl={requests.fetchComedy}/>
      <Row categoryTitle = "Family" fetchUrl={requests.fetchAction} />
      <Row categoryTitle = "Sports" fetchUrl={requests.fetchRomance}/>
      <Row categoryTitle = "Biography" fetchUrl={requests.fetchComedy}/>
    </div>
    </>
  );
}

export default AppUser;
