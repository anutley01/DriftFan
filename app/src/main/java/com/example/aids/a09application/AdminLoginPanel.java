package com.example.aids.a09application;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.aids.a09application.R.id.EnterPassword;

/**
 * Created by Aids on 15/08/2017.
 */

public class AdminLoginPanel extends Fragment {

    Button bt1;
    String password;
    FragmentTransaction ft;
    TextView attemptsleft;
    EditText editTextPassword;
    int numberOfLoginAttempts = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate( R.layout.admin_login_panel, container, false );
        editTextPassword = (EditText) view.findViewById( R.id.PasswordAdmin );
        bt1 = (Button) view.findViewById( EnterPassword );


        bt1.setOnClickListener( new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        String pass = editTextPassword.getText().toString();
                                        /** Creating the validation for the username and password */
                                        if (editTextPassword.getText().toString().equals( "admin" )) {
                                            /** Creating the Toast Message for succesful log in */
                                            Toast.makeText( getActivity().getApplicationContext(),
                                                    "Redirecting to Page", Toast.LENGTH_SHORT ).show();

                                            /** Creating the Intent for the button to link to the website */
                                            Fragment someFragment = new AdminFragment();
                                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                            transaction.replace(R.id.main_container, new AdminFragment()); // give your fragment container id in first parameter
                                            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                                            transaction.commit();
                                            /** Creating the else for unsucessful login */
                                        } else {
                                            Toast.makeText( getActivity().getApplicationContext(), "Wrong Login details entered.", Toast.LENGTH_SHORT ).show();
                                            /** Creating the clicker to decrement for unsuccesful logins. */
                                            numberOfLoginAttempts--;
                                            attemptsleft.setVisibility( View.VISIBLE );
                                            attemptsleft.setText( Integer.toString( numberOfLoginAttempts ) );
                                            /**Making login disabled by disabling button and displaying Toast Message */
                                            if (numberOfLoginAttempts == 0) {
                                                bt1.setEnabled( false );
                                                Toast.makeText( getActivity().getApplicationContext(), "Login Disabled.", Toast.LENGTH_SHORT ).show();


                                            }

                                        }

                                    }

                                }


        );

        return view;
    }

}

