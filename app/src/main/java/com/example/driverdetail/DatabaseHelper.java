package com.example.driverdetail;

 import android.content.ContentValues;
 import android.content.Context;
 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.database.sqlite.SQLiteOpenHelper;

 import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Driber.db";
    public static final String TABLE_NAME="driver_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="CONTACT";
    public static final String COL_4="ADDRESS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME +" (ID TEXT PRIMARY KEY,NAME TEXT, CONTACT INTEGER,ADDRESS TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String id, String name, String contact, String address){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,contact);
        contentValues.put(COL_4,address);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
        {
            return false;
        }else {
            return true;
        }
    }

    public Cursor viewData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="Select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }

    public boolean updateData(String id, String name, String contact, String address){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,contact);
        contentValues.put(COL_4,address);
        long res=db.update(TABLE_NAME,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[]{id});
    }
}
