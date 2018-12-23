package com.example.stkau.tsu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Intent instance;
    private TextView txt;
    private Boolean check = false;
    private RecyclerView cont;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] names = new String[]{"BOSS", "John"};
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener m_listener;

    private TextView emailT;
    private Button outBtn;
    private Button signBtn;
    private Button logBtn;
    private EditText pass;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailT = findViewById(R.id.email);
        outBtn = findViewById(R.id.btnOut);
        signBtn = findViewById(R.id.et_sign);
        logBtn = findViewById(R.id.et_logIn);
        pass = findViewById(R.id.et_pass);
        email = findViewById(R.id.et_email);
        mAuth = FirebaseAuth.getInstance();
        instance = getIntent();


        m_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser != null){
                    Toast.makeText(MainActivity.this ,"You are signed", Toast.LENGTH_SHORT).show();
                    emailT.setText(currentUser.getEmail());
                    Intent toMainScreen = new Intent(MainActivity.this, secAct.class);
                    toMainScreen.setFlags(toMainScreen.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(toMainScreen);
                }else{
                    Toast.makeText(MainActivity.this ,"You are not signed", Toast.LENGTH_SHORT).show();
                    emailT.setText("no user");
                }
                //updateUI(currentUser);
            }
        };
        mAuth.addAuthStateListener(m_listener);
        setListeners();




    }
    private void signIn(String email , String pass){
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this , new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this ,"Auth ok", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this ,"Auth no OK", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private void signOut(){
        mAuth.signOut();
    }
    private void updateUI( FirebaseUser user){
        if(user != null){
            String emailUI = user.getEmail();
            emailT.setText(emailUI);
        }else{
            emailT.setText("No user");
        }

    }

    private void registraition(String email , String pass){
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this ,"Reg ok", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this ,"Reg no OK", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean valid(@NonNull String str){
        if(str.length() != 0){
            return true;
        }else{
            Toast.makeText(MainActivity.this , "too small",Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    private void setListeners() {
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emCheck = email.getText().toString();
                String passCheck = pass.getText().toString();
                if(valid(emCheck) && valid(passCheck)){
                    registraition(emCheck,passCheck );
                }
            }
        });
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emCheck = email.getText().toString();
                String passCheck = pass.getText().toString();
                if(valid(emCheck) && valid(passCheck)){
                    signIn(emCheck,passCheck );
                }
            }
        });
        outBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
    }





}
