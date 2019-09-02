package vn.itplus.cmnthi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CMNThi extends SQLiteOpenHelper {

private static final String DATABASE_NAME = "List_CongViec";
private static final int DB_VERSION = 1;

public  static final String TABLE_WORK ="CongViec";

public static final String COT_TieuDe = "TieuDe";
public static final String COT_NoiDung = "NoiDung";


    public CMNThi(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public CMNThi (Context context){
        super(context, DATABASE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_WORK +
                " ( ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COT_TieuDe + " TEXT NOT NULL ," +
                COT_NoiDung + " TEXT NOT NULL ); " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        if(oldversion != newversion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORK);
            onCreate(db);
        }

    }
}
