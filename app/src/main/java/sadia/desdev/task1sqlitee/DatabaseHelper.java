package sadia.desdev.task1sqlitee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_name="register.db";
    public static final String Table_name="registeruser";
    public static final String col_1 ="ID";
    public static final String col_2 ="username";
    public static final String col_3 ="password";

    public DatabaseHelper(Context context) {
        super(context, Database_name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL(" DROP TABLE IF EXISTS " + Table_name);
     onCreate(db);
    }
    public long AddUser(String user, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password", password);
        long res=db.insert("registeruser",null,contentValues);
        db.close();
        return res;

    }

    public boolean checkUser(String username,String password){
        String[] columns={col_1};
        SQLiteDatabase db=getReadableDatabase();
        String selection= col_2 + "=?" + " and " + col_3 + "=?";
        String[] selectionArgs ={ username , password };
        Cursor cursor=db.query(Table_name,columns,selection,selectionArgs,null,null,null);
       int count=cursor.getCount();
       cursor.close();
        db.close();
        if(count>0)
        {
            return true;
        }
        else
            return false;

    }
}
