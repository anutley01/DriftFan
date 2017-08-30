package com.example.aids.a09application;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Aids on 29/08/2017.
 */

public class LiveVideoViewer extends Activity {

    ProgressDialog pDialog;
    VideoView videoView;

    String VideoUrl = "m.youtube.com/watch?v=umtn_s_rNEU";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.live_video_viewer );

        videoView = (VideoView) findViewById( R.id.VideoView );
        pDialog = new ProgressDialog( LiveVideoViewer.this );

        pDialog.setTitle( "Drifting Live Streaming" );
        pDialog.setMessage( "Buffering" );
        pDialog.setIndeterminate( false );
        pDialog.setCancelable( false );

        pDialog.show();
        try {
            MediaController mediaController = new MediaController( LiveVideoViewer.this );
            mediaController.setAnchorView( videoView );
            Uri video = Uri.parse( VideoUrl );
            videoView.setMediaController( mediaController );
            videoView.setVideoURI( video );
        } catch (Exception e) {
            Log.e( "Error", e.getMessage() );
            e.printStackTrace();


        }

        videoView.requestFocus();
        videoView.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoView.start();

            }
        } );

    }
}
