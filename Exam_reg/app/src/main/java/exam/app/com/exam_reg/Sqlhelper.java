package exam.app.com.exam_reg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 6/22/2016.
 */
public class Sqlhelper extends SQLiteOpenHelper {

    public Sqlhelper(Context context)
    {
       super(context,"my_database",null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("create table exm(id INTEGER PRIMARY KEY AUTOINCREMENT,fname text,lname text,address text,email text,mobile text,password text)");

        }
        catch(SQLiteException e)
        {

            Log.d("error in creating table", e.getLocalizedMessage().toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

         db.execSQL("drop table if exits exm");
        onCreate(db);

    }

    public int insertValues(String fname,String lname,String address,String mobile,String email,String password)
    {
        System.out.println(fname);
        System.out.println(lname);
        System.out.println(mobile);


        SQLiteDatabase db = this.getWritableDatabase();
        long result = -1;
        ContentValues register_cont = new ContentValues();
        ContentValues login = new ContentValues();
        register_cont.put("fname", fname);
        register_cont.put("lname", lname);
        register_cont.put("address", address);
        register_cont.put("email", email);
        register_cont.put("mobile", mobile);
        register_cont.put("password", password);
        try {

            result = db.insert("exm", null, register_cont);


        } catch (SQLiteException e) {
            Log.d("message", e.getLocalizedMessage().toString());

        }
        if (result == -1) {
            return 1;
        } else {
            return 0;
        }

    }

    public String getSingleData(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("exm", null, " email=?",
                new String[]{email}, null, null, null);


        if (cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;






    }


}
