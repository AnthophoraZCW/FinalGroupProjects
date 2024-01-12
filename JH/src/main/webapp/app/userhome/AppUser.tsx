import React from 'react';
import './AppUser.scss';
import {Translate} from "react-jhipster";
import {useLocation, useNavigate} from "react-router-dom";
import {useAppDispatch} from "app/config/store";
import Row from "./Row";
import requests from "./requests";

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
      <h1>
        Howdy this is the User Homepage
      </h1>
      <Row title = "Action" fetchUrl={requests.fetchAction} />
      <Row title = "Romance" fetchUrl={requests.fetchRomance}/>
      <Row title = "Comedy" fetchUrl={requests.fetchComedy}/>
    </div>
    </>
  );
}

export default AppUser;
