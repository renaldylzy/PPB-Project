 package renaldy.com.buildyourownvape;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;


public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Search","Tutorial","Build","Follow"};

    String[] infoArray = {
            "Search your vape",
            "Learn more about vape",
            "Build your own vape",
            "About developer"
    };

    Integer[] imageArray = {R.drawable.icon_search,
            R.drawable.icon_yt,
            R.drawable.icon_toolbox,
            R.drawable.icon_follow
    };

    ListView listview;
    Intent intent;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDialog = new Dialog(this);

        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, infoArray, imageArray);
        listview = (ListView) findViewById(R.id.listviewID);
        listview.setAdapter(whatever);


        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                switch (value) {
                    case "Search" :
                        intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;
                    case "Tutorial" :
                        intent = new Intent(MainActivity.this, TutorialActivity.class);
                        startActivity(intent);
                        break;
                    case "Follow" :
                        intent = new Intent(MainActivity.this, PopupActivity.class);
                        startActivity(intent);
                        break;
                    case "Build" :
                        intent = new Intent(MainActivity.this, BuildActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, value + " Not Available !", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }
}
