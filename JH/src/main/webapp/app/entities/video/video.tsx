import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, getSortState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSort, faSortUp, faSortDown } from '@fortawesome/free-solid-svg-icons';
import { ASC, DESC, SORT } from 'app/shared/util/pagination.constants';
import { overrideSortStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities } from './video.reducer';

export const Video = () => {
  const dispatch = useAppDispatch();

  const pageLocation = useLocation();
  const navigate = useNavigate();

  const [sortState, setSortState] = useState(overrideSortStateWithQueryParams(getSortState(pageLocation, 'id'), pageLocation.search));

  const videoList = useAppSelector(state => state.video.entities);
  const loading = useAppSelector(state => state.video.loading);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        sort: `${sortState.sort},${sortState.order}`,
      }),
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?sort=${sortState.sort},${sortState.order}`;
    if (pageLocation.search !== endURL) {
      navigate(`${pageLocation.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [sortState.order, sortState.sort]);

  const sort = p => () => {
    setSortState({
      ...sortState,
      order: sortState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handleSyncList = () => {
    sortEntities();
  };

  const getSortIconByFieldName = (fieldName: string) => {
    const sortFieldName = sortState.sort;
    const order = sortState.order;
    if (sortFieldName !== fieldName) {
      return faSort;
    } else {
      return order === ASC ? faSortUp : faSortDown;
    }
  };

  return (
    <div>
      <h2 id="video-heading" data-cy="VideoHeading">
        <Translate contentKey="jhApp.video.home.title">Videos</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="jhApp.video.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/video/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="jhApp.video.home.createLabel">Create new Video</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {videoList && videoList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="jhApp.video.id">ID</Translate> <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                </th>
                <th className="hand" onClick={sort('title')}>
                  <Translate contentKey="jhApp.video.title">Title</Translate> <FontAwesomeIcon icon={getSortIconByFieldName('title')} />
                </th>
                <th className="hand" onClick={sort('description')}>
                  <Translate contentKey="jhApp.video.description">Description</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('description')} />
                </th>
                <th className="hand" onClick={sort('releaseYear')}>
                  <Translate contentKey="jhApp.video.releaseYear">Release Year</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('releaseYear')} />
                </th>
                <th className="hand" onClick={sort('classification')}>
                  <Translate contentKey="jhApp.video.classification">Classification</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('classification')} />
                </th>
                <th className="hand" onClick={sort('duration')}>
                  <Translate contentKey="jhApp.video.duration">Duration</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('duration')} />
                </th>
                <th className="hand" onClick={sort('episode')}>
                  <Translate contentKey="jhApp.video.episode">Episode</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('episode')} />
                </th>
                <th className="hand" onClick={sort('season')}>
                  <Translate contentKey="jhApp.video.season">Season</Translate> <FontAwesomeIcon icon={getSortIconByFieldName('season')} />
                </th>
                <th className="hand" onClick={sort('rating')}>
                  <Translate contentKey="jhApp.video.rating">Rating</Translate> <FontAwesomeIcon icon={getSortIconByFieldName('rating')} />
                </th>
                <th className="hand" onClick={sort('videoURL')}>
                  <Translate contentKey="jhApp.video.videoURL">Video URL</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('videoURL')} />
                </th>
                <th className="hand" onClick={sort('imageURL')}>
                  <Translate contentKey="jhApp.video.imageURL">Image URL</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('imageURL')} />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {videoList.map((video, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/video/${video.id}`} color="link" size="sm">
                      {video.id}
                    </Button>
                  </td>
                  <td>{video.title}</td>
                  <td>{video.description}</td>
                  <td>{video.releaseYear}</td>
                  <td>{video.classification}</td>
                  <td>{video.duration}</td>
                  <td>{video.episode}</td>
                  <td>{video.season}</td>
                  <td>
                    <Translate contentKey={`jhApp.Rating.${video.rating}`} />
                  </td>
                  <td>{video.videoURL}</td>
                  <td>{video.imageURL}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/video/${video.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`/video/${video.id}/edit`} color="primary" size="sm" data-cy="entityEditButton">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        onClick={() => (window.location.href = `/video/${video.id}/delete`)}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="jhApp.video.home.notFound">No Videos found</Translate>
            </div>
          )
        )}
      </div>
    </div>
  );
};

export default Video;
