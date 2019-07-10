package renaldy.com.buildyourownvape;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private Cursor vapeCursor = null;
    private EditText txtSearch;
    private EditText txtResult;
    private EditText txtResult02;
    private EditText txtResult03;
    private DataVape dataVape = null;
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String LEVEL = "level";
    public static final String PRICE = "price";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataVape = new DataVape(this);
        db = dataVape.getWritableDatabase();
        dataVape.createTable(db);
        dataVape.generateData(db);

        setContentView(R.layout.search_activity);
        txtSearch = (EditText) findViewById(R.id.etSearch);
        txtResult = (EditText) findViewById(R.id.etResult01);
        txtResult02 = (EditText) findViewById(R.id.etResult02);
        txtResult03 = (EditText) findViewById(R.id.etResult03);

    }

    public void getVape(View view) {
        String result = "", result02 = "" , result03 = "";
        String vapeName = txtSearch.getText().toString();
        vapeCursor = db.rawQuery("SELECT ID, NAME, TYPE, LEVEL, PRICE "
                + "FROM vape where NAME LIKE '%" + vapeName
                + "%' ORDER BY NAME", null);

        if (vapeCursor.moveToFirst()) {
            result = vapeCursor.getString(2);
            result02 = vapeCursor.getString(3);
            result03 = vapeCursor.getString(4);
            for (; !vapeCursor.isAfterLast(); vapeCursor.moveToNext()) {
                result = vapeCursor.getString(2);
                result02 = vapeCursor.getString(3);
                result03 = vapeCursor.getString(4);
            }

        }
        if (result.equals("")) {
            String notFound = "Vape Not Found !";
            result = notFound;
            result02 = notFound;
            result03 = notFound;
        }
        txtResult.setText(result);
        txtResult02.setText(result02);
        txtResult03.setText(result03);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vapeCursor.close();
        db.close();
    }
}
