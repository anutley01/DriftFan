package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.text.format.DateFormat;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aids on 29/08/2017.
 */

public class MainChatActivity extends AppCompatActivity {

    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMessage> adapter;
    RelativeLayout chat_activity_main;
    FloatingActionButton fab;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == (R.id.menu_signout))
        {
            AuthUI.getInstance().signOut( this ).addOnCompleteListener( new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make( chat_activity_main, "You have been signed out.", Snackbar.LENGTH_SHORT).show();
                    finish();

                }
            } );
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.chat_main_menu, menu );
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == SIGN_IN_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Snackbar.make( chat_activity_main, "Succesfully signed in. Welcome!", Snackbar.LENGTH_SHORT).show();
                displayChatMessage();
            }
            else {
                Snackbar.make( chat_activity_main, "We couldn't sign you in. Please try again!", Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.chat_activity_main );

        chat_activity_main = (RelativeLayout) findViewById( R.id.chat_activity_main );
        fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText) findViewById( R.id.input );
                FirebaseDatabase.getInstance().getReference().push().setValue( new ChatMessage( input.getText().toString(),
                        FirebaseAuth.getInstance().getCurrentUser().getEmail() ) );
                input.setText( "" );

            }
        } );

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult( AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_REQUEST_CODE );
        }
        else
        {
            Snackbar.make( chat_activity_main, "Welcome" + FirebaseAuth.getInstance().getCurrentUser().getEmail(), Snackbar.LENGTH_SHORT ).show();

            //Load Content
            displayChatMessage();
        }


    }



    private void displayChatMessage() {

        ListView listofMessage = (ListView) findViewById( R.id.list_of_messages );
        adapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,R.layout.chat_list_item,FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                //Get references to the views of chat_list_item.xml

                TextView messageText, messageUser, messageTime;
                messageText = (TextView) findViewById( R.id.message_text );
                messageUser = (TextView) findViewById( R.id.message_user );
                messageTime = (TextView) findViewById( R.id.message_time );

                messageText.setText( model.getMessageText() );
                messageUser.setText( model.getMessageUser() );
                messageTime.setText( DateFormat.format( "dd-mm-yyyy (HH:MM:SS)",model.getMessageTime() ) );
            }
        };

        listofMessage.setAdapter( adapter );

    }

}
