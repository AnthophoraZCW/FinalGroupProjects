import React from 'react';
import './AppUser.scss';
import {Translate} from "react-jhipster";
import {useLocation, useNavigate} from "react-router-dom";
import {useAppDispatch} from "app/config/store";
import {Row} from "reactstrap";

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
      <Row title = "Action"/>
      <Row title = "Romance"/>
      <Row title = "Comedy"/>
    </div>
    </>
  );
}

export default AppUser;
