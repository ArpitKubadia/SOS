package com.example.arpit.sos;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactPicker extends AppCompatActivity{
    EditText name1,name2,name3,contact1,contact2,contact3;
    Button save_contacts;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK)
            {
                Uri contact=data.getData();
                Cursor cursor=managedQuery(contact,null,null,null,null);
                //Cursor cursor=getContentResolver().query(contact,null,null,null);
                cursor.moveToFirst();
                String name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name1.setText(name);
                contact1.setText(number);
            }
        }

        else if(requestCode==2){
            if(resultCode==RESULT_OK)
            {
                Uri contact=data.getData();
                Cursor cursor=managedQuery(contact,null,null,null,null);
                //Cursor cursor=getContentResolver().query(contact,null,null,null);
                cursor.moveToFirst();
                String name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name2.setText(name);
                contact2.setText(number);
            }
        }

        else if(requestCode==3){
            if(resultCode==RESULT_OK)
            {
                Uri contact=data.getData();
                Cursor cursor=managedQuery(contact,null,null,null,null);
                //Cursor cursor=getContentResolver().query(contact,null,null,null);
                cursor.moveToFirst();
                String name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name3.setText(name);
                contact3.setText(number);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_picker);

        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        name3=findViewById(R.id.name3);
        contact1=findViewById(R.id.contact1);
        contact2=findViewById(R.id.contact2);
        contact3=findViewById(R.id.contact3);
        save_contacts=findViewById(R.id.save_contacts);
        save_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SP sp=new SP();
                //final SharedPreferences myPreferences=sp.getSharedPreferences();

                SharedPreferences myPreferences=PreferenceManager.getDefaultSharedPreferences(ContactPicker.this);
                SharedPreferences.Editor myEditor=myPreferences.edit();
                myEditor.putString("name1",name1.getText().toString());
                myEditor.putString("name2",name2.getText().toString());
                myEditor.putString("name3",name3.getText().toString());

                myEditor.putLong("contact1",Long.parseLong(contact1.getText().toString()));
                myEditor.putLong("contact2",Long.parseLong(contact2.getText().toString()));
                myEditor.putLong("contact3",Long.parseLong(contact3.getText().toString()));

                myEditor.commit();


                startActivity(new Intent(ContactPicker.this,MapsActivity.class).putExtra("SOS",false));

            }
        });

        name1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                //Intent intent=new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,1);

            }
        });
        name2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                //Intent intent=new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,2);

            }
        });

        name3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                //Intent intent=new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent,3);

            }
        });





    }
}
