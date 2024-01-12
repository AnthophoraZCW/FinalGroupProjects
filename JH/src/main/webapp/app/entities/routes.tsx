import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import UserProfile from './user-profile';
import Video from './video';
import Playlist from './playlist';
import Comment from './comment';
import Category from './category';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        {/* write new component for user homepage */}
        <Route path="user-profile/*" element={<UserProfile />} />
        <Route path="video/*" element={<Video />} />
        <Route path="playlist/*" element={<Playlist />} />
        <Route path="comment/*" element={<Comment />} />
        <Route path="category/*" element={<Category />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
