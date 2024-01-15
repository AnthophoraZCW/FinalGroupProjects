import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICategory } from 'app/shared/model/category.model';
import { getEntities as getCategories } from 'app/entities/category/category.reducer';
import { IPlaylist } from 'app/shared/model/playlist.model';
import { getEntities as getPlaylists } from 'app/entities/playlist/playlist.reducer';
import { IVideo } from 'app/shared/model/video.model';
import { Rating } from 'app/shared/model/enumerations/rating.model';
import { getEntity, updateEntity, createEntity, reset } from './video.reducer';

export const VideoUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const categories = useAppSelector(state => state.category.entities);
  const playlists = useAppSelector(state => state.playlist.entities);
  const videoEntity = useAppSelector(state => state.video.entity);
  const loading = useAppSelector(state => state.video.loading);
  const updating = useAppSelector(state => state.video.updating);
  const updateSuccess = useAppSelector(state => state.video.updateSuccess);
  const ratingValues = Object.keys(Rating);

  const handleClose = () => {
    navigate('/video');
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getCategories({}));
    dispatch(getPlaylists({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  // eslint-disable-next-line complexity
  const saveEntity = values => {
    if (values.id !== undefined && typeof values.id !== 'number') {
      values.id = Number(values.id);
    }
    if (values.releaseYear !== undefined && typeof values.releaseYear !== 'number') {
      values.releaseYear = Number(values.releaseYear);
    }
    if (values.duration !== undefined && typeof values.duration !== 'number') {
      values.duration = Number(values.duration);
    }
    if (values.episode !== undefined && typeof values.episode !== 'number') {
      values.episode = Number(values.episode);
    }
    if (values.season !== undefined && typeof values.season !== 'number') {
      values.season = Number(values.season);
    }

    const entity = {
      ...videoEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          rating: 'G',
          ...videoEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="jhApp.video.home.createOrEditLabel" data-cy="VideoCreateUpdateHeading">
            <Translate contentKey="jhApp.video.home.createOrEditLabel">Create or edit a Video</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="video-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField label={translate('jhApp.video.title')} id="video-title" name="title" data-cy="title" type="text" />
              <ValidatedField
                label={translate('jhApp.video.description')}
                id="video-description"
                name="description"
                data-cy="description"
                type="text"
              />
              <ValidatedField
                label={translate('jhApp.video.releaseYear')}
                id="video-releaseYear"
                name="releaseYear"
                data-cy="releaseYear"
                type="text"
              />
              <ValidatedField
                label={translate('jhApp.video.classification')}
                id="video-classification"
                name="classification"
                data-cy="classification"
                type="text"
              />
              <ValidatedField
                label={translate('jhApp.video.duration')}
                id="video-duration"
                name="duration"
                data-cy="duration"
                type="text"
              />
              <ValidatedField label={translate('jhApp.video.episode')} id="video-episode" name="episode" data-cy="episode" type="text" />
              <ValidatedField label={translate('jhApp.video.season')} id="video-season" name="season" data-cy="season" type="text" />
              <ValidatedField label={translate('jhApp.video.rating')} id="video-rating" name="rating" data-cy="rating" type="select">
                {ratingValues.map(rating => (
                  <option value={rating} key={rating}>
                    {translate('jhApp.Rating.' + rating)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                label={translate('jhApp.video.videoURL')}
                id="video-videoURL"
                name="videoURL"
                data-cy="videoURL"
                type="text"
              />
              <ValidatedField
                label={translate('jhApp.video.imageURL')}
                id="video-imageURL"
                name="imageURL"
                data-cy="imageURL"
                type="text"
              />
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/video" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default VideoUpdate;
