import { IComment } from 'app/shared/model/comment.model';
import { ICategory } from 'app/shared/model/category.model';
import { IPlaylist } from 'app/shared/model/playlist.model';
import { Rating } from 'app/shared/model/enumerations/rating.model';

export interface IVideo {
  id?: number;
  title?: string | null;
  description?: string | null;
  releaseYear?: number | null;
  classification?: string | null;
  duration?: number | null;
  episode?: number | null;
  season?: number | null;
  rating?: keyof typeof Rating | null;
  videoURL?: string | null;
  imageURL?: string | null;
  comments?: IComment[] | null;
  categories?: ICategory[] | null;
  playlists?: IPlaylist[] | null;
}

export const defaultValue: Readonly<IVideo> = {};
