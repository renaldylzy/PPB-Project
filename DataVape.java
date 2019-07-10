package renaldy.com.buildyourownvape;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;

public class DataVape extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbvape";
    public static final String NAME= "name";
    public static final String TYPE = "type";
    public static final String LEVEL = "level";
    public static final String PRICE = "price";

    //Constructor DataVape untuk initiate database
    public DataVape(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //method createTable untuk membuat table kamus
    public void createTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS vape");
        db.execSQL("CREATE TABLE if not exists vape (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, " +
                "type TEXT, level TEXT, price TEXT);");
    }

    //method generateData untuk mengisikan data ke vape.
    public void generateData(SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put(NAME, "dotmod dualmech");
        cv.put(TYPE, "Semi-Mecha");
        cv.put(LEVEL, "Intermediate");
        cv.put(PRICE, "1.700.000");
        db.insert("vape", NAME, cv);
        cv.put(NAME, "druga foxy");
        cv.put(TYPE, "Electrical");
        cv.put(LEVEL, "Intermediate");
        cv.put(PRICE, "650.000");
        db.insert("vape", NAME, cv);
        cv.put(NAME, "smoant charon mini");
        cv.put(TYPE, "Electrical");
        cv.put(LEVEL, "Intermediate");
        cv.put(PRICE, "550.000");
        db.insert("vape", NAME, cv);
        cv.put(NAME, "banaspati");
        cv.put(TYPE, "Mechanical");
        cv.put(LEVEL, "Expert");
        cv.put(PRICE, "800.000");
        db.insert("vape", NAME, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }

}
