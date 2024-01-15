import React, {useEffect, useState} from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './video.reducer';
import axios from "axios";

export const VideoDetail = () => {
  const dispatch = useAppDispatch();

  const videoEntity = useAppSelector(state => state.video.entity);
  const [url,setUrl]= useState("");

  const { id } = useParams<'id'>();

  useEffect(() => {
    const fetchEnitiy = async () => {
     try{
       // dispatch(getEntity(id));
       const response = await
         axios.get("http://localhost:8080/api/videos/" + id)
       setUrl(response.data.videoURL);
     } catch (e){
       console.error(" error fetching ", e);
     }
    }
  fetchEnitiy();
  }, []);

console.log(url);
  return (
    <Row>
      <Col md="8">
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
          {url && (

          <video height="640" width="720" controls>
            <source src={url} type="video/mp4"/>
          </video>

        )}
<p>comments go here</p>

      </dl>
      <Button tag={Link} to="/video" replace color="info" data-cy="entityDetailsBackButton">
        <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/video/${videoEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default VideoDetail;
