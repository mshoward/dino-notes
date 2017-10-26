package com.names.horrible.dinonotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by mason on 10/26/17.
 */

public class DynamicNoteDataStore {
    private DynamicNoteDataStore(){}
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


    public class DynamicNoteReaderHelper extends SQLiteOpenHelper{
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "DYNAMIC_NOTE_DB.db";
        public final String[][] EXAMPLE_NOTES = {
                //id, tree, title, body, parent list, child list
                {"0", "Example Tree", "Example Root", "Example Body", "", "1\n"},
                {"1", "Example Tree", "Example Node 1", "Example Body 1", "0", "2\n3\n"},
                {"2", "Example Tree", "Example Node 2", "Example Body 2", "1\n", "3\n4\n"},
                {"3", "Example Tree", "Example Node 3", "Example Body 3", "1\n", "4\n"},
                {"4", "Example Tree", "Example Node 4", "Example Body 4", "2\n3\n", ""}
        };

        public DynamicNoteReaderHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db){

            db.execSQL(DinoDBReaderContract.SQL_CREATE_NOTE);
            SQLitePutExample(db);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            //// TODO: 10/26/17 add a database method that doesn't wipe data
            db.execSQL(DinoDBReaderContract.SQL_DELETE_NOTE);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO: 10/26/17 technically this will do it.
            onUpgrade(db, oldVersion, newVersion);
        }

        public void SQLitePutExample(SQLiteDatabase db){
            ContentValues contentValues = new ContentValues();
            long rowIds = 0;
            for(int i = 0; i < 5; i++){
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_ROOT_NAME,
                        EXAMPLE_NOTES[i][0]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_TITLE,
                        EXAMPLE_NOTES[i][1]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_BODY,
                        EXAMPLE_NOTES[i][2]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_PARENT_LIST,
                        EXAMPLE_NOTES[i][3]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_CHILD_LIST,
                        EXAMPLE_NOTES[i][4]);

                rowIds = db.insert(DinoDBReaderContract.DynamicNoteNote.TABLE_NAME,
                        null,
                        contentValues);
            }
        }
        /**
         * TODO: 10/26/17 data-store functionality needed:
         *  - give list of trees in db in String[]
         *  - give list of questions in tree in db in ArrayList<DynamicNoteData>
         *  - give all questions in db in ArrayList<DynamicNoteData>
         *  - accept new DynamicNoteNode, transform into DynamicNoteData, put in db
         *  - edit DynamicNoteNote entries
        **/


    }
    public class DynamicNoteExample{
        public final String[][] EXAMPLE_NOTES = {
                //id, tree, title, body, parent list, child list
                {"0", "Example Tree", "Example Root", "Example Body", "", "1\n"},
                {"1", "Example Tree", "Example Node 1", "Example Body 1", "0", "2\n3\n"},
                {"2", "Example Tree", "Example Node 2", "Example Body 2", "1\n", "3\n4\n"},
                {"3", "Example Tree", "Example Node 3", "Example Body 3", "1\n", "4\n"},
                {"4", "Example Tree", "Example Node 4", "Example Body 4", "2\n3\n", ""}
        };
        public Context context;
        public DynamicNoteReaderHelper rh;
        public SQLiteDatabase db;
        public void SQLitePutExample(){
            ContentValues contentValues = new ContentValues();
            long rowIds = 0;
            for(int i = 0; i < 5; i++){
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_ROOT_NAME,
                        EXAMPLE_NOTES[i][0]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_TITLE,
                        EXAMPLE_NOTES[i][1]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_BODY,
                        EXAMPLE_NOTES[i][2]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_PARENT_LIST,
                        EXAMPLE_NOTES[i][3]);
                contentValues.put(DinoDBReaderContract.DynamicNoteNote.COLUMN_NAME_CHILD_LIST,
                        EXAMPLE_NOTES[i][4]);

                rowIds = db.insert(DinoDBReaderContract.DynamicNoteNote.TABLE_NAME,
                        null,
                        contentValues);
            }

        }
        public DynamicNoteExample(Context pContext){
            context = pContext;
            rh = new DynamicNoteReaderHelper(context);
            db = rh.getWritableDatabase();
        }
    }
}
