package com.names.horrible.dinonotes;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by mason on 10/26/17.
 */

public class DynamicNoteDataStore {
    public static final class DinoDBReaderContract{
        private DinoDBReaderContract(){}
        public static class DynamicNoteNote implements BaseColumns{
            public static final String TABLE_NAME = "note";
            public static final String COLUMN_NAME_ROOT_NAME = "root_name";
            public static final String COLUMN_NAME_TITLE = "title";
            public static final String COLUMN_NAME_BODY = "body";
            public static final String COLUMN_NAME_PARENT_LIST = "parent_list";
            public static final String COLUMN_NAME_CHILD_LIST = "child_list";
        }
        public static final String SQL_CREATE_NOTE =
                "CREATE TABLE " + DynamicNoteNote.TABLE_NAME + " (" +
                        DynamicNoteNote._ID + " INTEGER PRIMARY KEY, " +
                        DynamicNoteNote.COLUMN_NAME_ROOT_NAME + " TEXT, " +
                        DynamicNoteNote.COLUMN_NAME_TITLE + " TEXT, " +
                        DynamicNoteNote.COLUMN_NAME_BODY + " TEXT, " +
                        DynamicNoteNote.COLUMN_NAME_PARENT_LIST + " TEXT, " +
                        DynamicNoteNote.COLUMN_NAME_CHILD_LIST + " TEXT)";
        public static final String SQL_DELETE_NOTE =
                "DROP TABLE IF EXISTS " + DynamicNoteNote.TABLE_NAME;
    }
    public static final String DATABASE_NAME = "DYNAMIC_NOTE_DB";

    public SQLiteOpenHelper sqLiteOpenHelper;
}
