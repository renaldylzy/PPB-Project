package renaldy.com.buildyourownvape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class TutorialActivity extends AppCompatActivity {

    String[] nameArray = {"Atomizer","Mods","Coiling","Wicking"};

    String[] infoArray = {
            "Which Atomizer suits you most",
            "How to choose your own Mod",
            "How to Coiling",
            "How to Wicking"
    };

    Integer[] imageArray = {R.drawable.icon_atomizer,
            R.drawable.icon_mod,
            R.drawable.icon_coil,
            R.drawable.icon_wick
    };

    ListView listview;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, infoArray, imageArray);
        listview = (ListView) findViewById(R.id.listviewTutorial);
        listview.setAdapter(whatever);


        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                switch (value) {
                    case "Atomizer" :
                        intent = new Intent(TutorialActivity.this, AtomizerActivity.class);
                        startActivity(intent);
                        break;
                    case "Mods" :
                        intent = new Intent(TutorialActivity.this, ModsActivity.class);
                        startActivity(intent);
                        break;
                    case "Coiling" :
                        intent = new Intent(TutorialActivity.this, CoilingActivity.class);
                        startActivity(intent);
                        break;
                    case "Wicking" :
                        intent = new Intent(TutorialActivity.this, WickingActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(TutorialActivity.this, value + " Not Available !", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

    }

}
