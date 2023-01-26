package com.example.projectkursuspti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText namalengkap, username, email, password;
    String str_namalengkap, str_username, str_email, str_password;
    String url = "https://projectkursuspti.000webhostapp.com/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide(); // hide the title bar

        namalengkap = findViewById(R.id.namalengkap);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

//        Button btn_signup = findViewById(R.id.btn_signup);
//
//        btn_signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Register.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
    public void moveToLogin(View view) {

        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    public void Register(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");


        if(namalengkap.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Nama Lengkap", Toast.LENGTH_SHORT).show();
        }
        else if(email.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Email", Toast.LENGTH_SHORT).show();
        }
        else if(username.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Username", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Password", Toast.LENGTH_SHORT).show();
        }
        else{

            progressDialog.show();
            str_namalengkap = namalengkap.getText().toString().trim();
            str_email = email.getText().toString().trim();
            str_username = username.getText().toString().trim();
            str_password = password.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    namalengkap.setText("");
                    email.setText("");
                    username.setText("");
                    password.setText("");
                    Toast.makeText(Register.this, response, Toast.LENGTH_SHORT).show();
                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Register.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();

                    params.put("namalengkap",str_namalengkap);
                    params.put("email",str_email);
                    params.put("username",str_username);
                    params.put("password",str_password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
            requestQueue.add(request);


        }

    }
}