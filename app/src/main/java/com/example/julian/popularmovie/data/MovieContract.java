package com.example.julian.popularmovie.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class MovieContract {

    public static final String CONTENT_AUTHORITY = "com.example.julian.popularmovie";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_MOVIE = "movie";
    public static final String PATH_VIDEOS = "videos";
    public static final String PATH_REVIEWS = "reviews";

    public static long parseId(Uri contentUri){
        String second = contentUri.getPathSegments().get(1);
        return second == null ? -1 : Long.parseLong(second);
    }

    public static final class MovieEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" +PATH_MOVIE;


        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_AVERAGE_VOTE = "average_vote";
        public static final String COLUMN_POSTER_PATH = "poster_path";

//        public static final String COLUMN_FAVOURITE = "favourite";
//        public static final String COLUMN_DATE = "date";

        public static Uri buildMovieUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildMovieVideosUri(long id){
            return CONTENT_URI.buildUpon()
                    .appendEncodedPath(String.valueOf(id))
                    .appendPath(PATH_VIDEOS)
                    .build();
        }

        public static Uri buildMovieReviewsUri(long id){
            return CONTENT_URI.buildUpon()
                    .appendEncodedPath(String.valueOf(id))
                    .appendPath(PATH_REVIEWS)
                    .build();
        }
    }

    public static final class VideoEntry implements BaseColumns{
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_VIDEOS)
                .build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_VIDEOS;

        public static final String TABLE_NAME = "videos";
        public static final String COLUMNT_MOVIE_ID = "movie_id"; //Foreign key
        public static final String COLUMN_KEY = "key";
    }

    public static final class ReviewEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_REVIEWS)
                .build();

        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_REVIEWS;

        public static final String TABLE_NAME = "reviews";
        public static final String COLUMN_MOVIE_ID = "movie_id"; //foreign key
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLMUN_CONTENT = "content";

    }
}
