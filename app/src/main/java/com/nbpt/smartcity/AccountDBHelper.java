package com.nbpt.smartcity;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

/**
 * Created by Administrator on 2020/9/23.
 */

public class AccountDBHelper extends SQLiteOpenHelper {

    private Context mContext;
    static final String DB_Name = "user.db";
    static final String TABLE_Name = "tb_accounts";
    static final int VERSION_1 = 1;
    public AccountDBHelper(Context context, int version) {
        super(context, DB_Name, null, version);
        mContext=context;
    }

    public Cursor select(String where,String orderby){
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM "+TABLE_Name);
        if (where != null){
            stringBuilder.append(" WHERE ");stringBuilder.append(where);
        }
        if (orderby != null){
            stringBuilder.append(" ORDER BY ");stringBuilder.append(orderby);
        }
        return getWritableDatabase().rawQuery(stringBuilder.toString(),null);
    }

    /*public void register()
    {
        SQLiteDatabase db = new SQLiteDatabase()
        //StringBuilder stringBuilder = new StringBuilder("INSERT INTO "+TABLE_Name+" (username,password) VALUES ("+username+","+password+")");
        String stringBuilder = "INSERT INTO "+TABLE_Name+" (username,password) VALUES (lan,123)";
        //db.execSQL(stringBuilder);

       // execSQL(stringBuilder.toString());
       getWritableDatabase().rawQuery(stringBuilder.toString(),null);
    }*/

    public String getUsername(Cursor cursor){
        return cursor.getString(1);
    }

    public String getPassword(Cursor cursor){
        return cursor.getString(2);
    }

    public AccountDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
