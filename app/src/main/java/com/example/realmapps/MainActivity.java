package com.example.realmapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
  private static final String TAG="MainActivity";
    EditText name;
    EditText password;
    Button login;
    Button register;
 Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText)findViewById(R.id.et_name);
        password = (EditText)findViewById(R.id.et_password);
        login = (Button)findViewById(R.id.et_button);
        register = (Button)findViewById(R.id.regbtn);
        Log.d(TAG ,"onCreate: View Initialisation done");
        realm=Realm.getDefaultInstance();
        realm.beginTransaction();


     realm.commitTransaction();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  savedata();
                  readData();
                Intent intent = new Intent(MainActivity.this,play.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Work_log.class);
                startActivity(intent);
            }
        });
    }

private void savedata(){
        realm.executeTransactionAsync(new Realm.Transaction() {
                                          @Override
                                          public void execute(Realm realm) {
                                              login1 login = realm.createObject(login1.class);
                                              login.setName(name.getText().toString().trim());
                                              login.setPassword(password.getText().toString().trim());

                                          }
                                      }, new Realm.Transaction.OnSuccess() {
                                          @Override
                                          public void onSuccess() {
                                              Log.d(TAG, "onSucess: written sucessfull");
                                          }
                                      }, new Realm.Transaction.OnError() {
                                          @Override
                                          public void onError(Throwable error) {
                                              Log.d(TAG, "onError: written error");
                                          }
                                      }
        );

}
private void readData(){
    RealmResults<login1> login1s=realm.where(login1.class).findAll();

    String data ="";
    for (login1 loogin:login1s);
    try {
        data=data + "\n "+login.toString();
    }catch (NullPointerException e){
        e.printStackTrace();
    }
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

