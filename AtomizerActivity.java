package renaldy.com.buildyourownvape;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;

import java.util.Vector;

public class AtomizerActivity extends Activity {

    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<>();

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.mainvid_atomizer);

        recyclerView = (RecyclerView) findViewById(R.id.rviewAtomizer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/esNbyx6wqR8\" frameborder=\"0\" allowfullscreen></iframe>"));

        VidAdapter videoAdapter = new VidAdapter(youtubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }

}
