package renaldy.com.buildyourownvape;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class BuildActivity extends Activity  {


    private SQLiteDatabase db = null;
    private Cursor vapeCursor = null;
    private DataVape dataVape = null;
    TextView selection_type;
    TextView selection_level;
    TextView tvResult1;
    TextView tvResult2;
    Spinner spin_type;
    Spinner spin_level;
    String[] level = { "Newbie", "Intermediate", "Expert" };
    String[] type = { "Starter Kit" , "Pods" , "Electrical" , "Mechanical" , "Semi-Mecha" };
    String tmpType, tmpLevel;
    Button btnGetSearched;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataVape = new DataVape(this);
        db = dataVape.getWritableDatabase();
        dataVape.createTable(db);
        dataVape.generateData(db);

        setContentView(R.layout.activity_build);
        tvResult1 = (TextView) findViewById(R.id.tvResult1);
        tvResult2 = (TextView) findViewById(R.id.tvResult2);

        selection_level = (TextView) findViewById(R.id.selection_level);
        Spinner spin = (Spinner) findViewById(R.id.spin_level);
        ArrayAdapter<String> aa = new ArrayAdapter<String>
                (this,android.R.layout.simple_spinner_item, level);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent , View view , int position, long id) {
                tmpLevel = level[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        selection_type = (TextView) findViewById(R.id.selection_type);
        spin_type = (Spinner) findViewById(R.id.spin_type);
        ArrayAdapter<String> aaType = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, type);
        aaType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_type.setAdapter(aaType);
        spin_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tmpType = type[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void test(View v) {
        String test = tmpLevel + " " + tmpType;
        Toast.makeText(this, test, Toast.LENGTH_LONG).show();
    }

    public void getSearchItem(View view) {
        String result = "", result02 = "";
        vapeCursor = db.rawQuery("SELECT ID, NAME, TYPE, LEVEL, PRICE"
                + " FROM vape where TYPE = '" + tmpType + "' AND LEVEL = '" + tmpLevel + "' ORDER BY NAME", null);
        if (vapeCursor.moveToFirst()) {
            result = vapeCursor.getString(1);
            result02 = vapeCursor.getString(4);
            for (; !vapeCursor.isAfterLast(); vapeCursor.moveToNext()) {
                result = vapeCursor.getString(1);
                result02 = vapeCursor.getString(4);
                if (result != "") {
                    tvResult1.append(result + " " + result02 + "\n");
            }   else {
                    tvResult1.setText("Data Not Found");
                }
            }

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vapeCursor.close();
        db.close();
    }
}
