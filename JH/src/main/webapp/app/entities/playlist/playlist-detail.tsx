import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './playlist.reducer';

export const PlaylistDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const playlistEntity = useAppSelector(state => state.playlist.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="playlistDetailsHeading">
          <Translate contentKey="jhApp.playlist.detail.title">Playlist</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{playlistEntity.id}</dd>
          <dt>
            <Translate contentKey="jhApp.playlist.videos">Videos</Translate>
          </dt>
          <dd>
            {playlistEntity.videos
              ? playlistEntity.videos.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {playlistEntity.videos && i === playlistEntity.videos.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/playlist" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/playlist/${playlistEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default PlaylistDetail;
