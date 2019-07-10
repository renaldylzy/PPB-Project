package renaldy.com.buildyourownvape;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.VideoView;
import android.net.Uri;

import java.util.Vector;


public class CoilingActivity extends Activity {

    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.mainvid_coiling);

        recyclerView = (RecyclerView) findViewById(R.id.rviewCoiling);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LEuRDlvsLwI\" frameborder=\"0\" allowfullscreen></iframe>"));

        VidAdapter videoAdapter = new VidAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);

    }

}
