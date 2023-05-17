package repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import model.Form;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "form_app";
    private static final int DATABASE_VERSION = 1;

    private static final String ID_COL = "id";

    private static final String TABLE_NAME = "forms";
    private static final String REGION_COL = "region";
    private static final String SHOULDER_COL = "shoulder";
    private static final String ROAD_COL = "road";
    private static final String LINK_COL = "link";
    private static final String SUBLINK_COL = "sub_link";
    private static final String START_COL = "start";
    private static final String END_COL = "end";
    private static final String CORRIDOR_COL = "corridor";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + REGION_COL + " TEXT,"
                + SHOULDER_COL + " TEXT,"
                + ROAD_COL + " TEXT,"
                + LINK_COL + " TEXT,"
                + SUBLINK_COL + " TEXT,"
                + START_COL + " TEXT,"
                + END_COL + " TEXT,"
                + CORRIDOR_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void createForm(Form form){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ROAD_COL,form.getRoad());
        values.put(LINK_COL,form.getLink());
        values.put(SUBLINK_COL,form.getSub_link());
        values.put(START_COL,form.getStart());
        values.put(END_COL,form.getEnd());
        values.put(CORRIDOR_COL,form.getCorridor());
        values.put(REGION_COL,form.getRegion());
        values.put(SHOULDER_COL,form.getShoulder_type());

        db.insert(TABLE_NAME,null,values);
        db.close();

    }
    public ArrayList<Form> getAllForms(){
        ArrayList<Form> forms = new ArrayList<>();

        String query = "select * from "+TABLE_NAME+" order by id desc";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Form form = new Form();
                form.setId(Integer.parseInt(cursor.getString(0)));
                form.setRoad(cursor.getString(1));
                form.setLink(cursor.getString(2));
                forms.add(form);
            }while (cursor.moveToNext());
        }

        return forms;
    }

}
