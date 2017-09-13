package com.example.aids.a09application;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
    private boolean isCanceled;

    String VideoUrl = "https://vimeo.com/193755452";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.live_video_viewer );

        videoView = (VideoView) findViewById( R.id.VideoView );
        pDialog = new ProgressDialog( LiveVideoViewer.this );

        pDialog.setTitle( "Drifting Live Streaming" );
        pDialog.setMessage( "Buffering" );
        pDialog.setIndeterminate( false );
        pDialog.setCancelable( true );

        // Put a cancel button in progress dialog
        pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener(){
            // Set a click listener for progress dialog cancel button
            @Override
            public void onClick(DialogInterface dialog, int which){
                // dismiss the progress dialog
                pDialog.dismiss();
            }
        });


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
