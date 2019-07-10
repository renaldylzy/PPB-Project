package renaldy.com.buildyourownvape;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.VideoView;

import java.util.Vector;

public class ModsActivity extends Activity {

    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.mainvid_mods);

        recyclerView = (RecyclerView) findViewById(R.id.rviewMods);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3p_6TNnn5bA\" frameborder=\"0\" allowfullscreen></iframe>"));

        VidAdapter videoAdapter = new VidAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);

    }

}
