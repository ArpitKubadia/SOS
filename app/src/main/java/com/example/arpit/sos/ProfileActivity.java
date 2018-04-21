package com.example.arpit.sos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

        //firebase auth object
        private FirebaseAuth firebaseAuth;
        private DatabaseReference databaseReference;
        EditText name,surname,age,phone,email;
        RadioGroup cpr;
        RadioButton rb;
        Button save;
        //view objects
        private TextView textViewUserEmail;
        private Button buttonLogout;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            Bundle intent=getIntent().getExtras();
            name=findViewById(R.id.name);
            surname=findViewById(R.id.surname);
            email=findViewById(R.id.email);
            age=findViewById(R.id.age);
            phone=findViewById(R.id.phone);
            cpr=findViewById(R.id.cpr);
            save=findViewById(R.id.save);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveUserInformation();
                }
            });


            //Intent intent=getIntent();
            if(intent!=null){
                name.setText(intent.getString("name"));
                surname.setText(intent.getString("surname"));
                email.setText(intent.getString("email"));
            }


            //initializing firebase authentication object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the user is not logged in
            //that means current user will return null
            if(firebaseAuth.getCurrentUser() == null){
                //closing this activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
            }
            databaseReference= FirebaseDatabase.getInstance().getReference();

            //getting current user
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //initializing views
            //textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
            buttonLogout = (Button) findViewById(R.id.buttonLogout);

            //displaying logged in user name
            email.setText(user.getEmail());

            //adding listener to button
            buttonLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firebaseAuth.signOut();
                    //closing activity
                    finish();
                    //starting login activity
                    startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                }
            });
        }

        private void saveUserInformation() {
            String names=name.getText().toString().trim();
            String surnames=surname.getText().toString().trim();
            String emails=email.getText().toString().trim();
            int ages=Integer.parseInt(age.getText().toString());
            float phones=Float.parseFloat(phone.getText().toString());
            rb=findViewById(cpr.getCheckedRadioButtonId());
            String knows_cpr=rb.getText().toString();

            UserInformation userInformation=new UserInformation(names,surnames,emails,knows_cpr,ages,phones);
            FirebaseUser user=firebaseAuth.getCurrentUser();
            databaseReference.child(user.getUid()).setValue(userInformation);
            Toast.makeText(this,"Information is saved in the database",Toast.LENGTH_LONG).show();
            startActivity(new Intent(ProfileActivity.this,MapsActivity.class));

        }


}

