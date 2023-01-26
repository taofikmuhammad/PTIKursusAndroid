package com.example.projectkursuspti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText username,password;
    String str_username, str_password;
    String url = "https://projectkursuspti.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }
    public void Login(View view) {

        if(username.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Username", Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().equals("")){
            Toast.makeText(this, "Masukan Password", Toast.LENGTH_SHORT).show();
        }
        else{


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait..");

            progressDialog.show();

            str_username = username.getText().toString().trim();
            str_password = password.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
//                        JSONArray jsonArray = new JSONArray(response);
//                        JSONObject jsonObject = jsonArray.getJSONObject(0);
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        String result = jsonObject.getString("status");

                        if(result.equalsIgnoreCase("success")){
                            for(int i = 0; i<jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                String username = object.getString("username");
                                String password = object.getString("password");
                                String email = object.getString("email");
                                String namalengkap = object.getString("namalengkap");

//                                username.setText("");
//                                password.setText("");
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent .putExtra("username",username);
                                intent .putExtra("password",password);
                                intent .putExtra("email",email);
                                intent .putExtra("namalengkap",namalengkap);
                                startActivity(intent);finish();

//                            Bundle bundle = new Bundle();
//                            bundle.putString("username",jsonObject.getString(str_username));
//                            bundle.putString("password",jsonObject.getString(str_password));
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                Toast.makeText(Login.this, response, Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(Login.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }


                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("username",str_username);
                    params.put("password",str_password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
            requestQueue.add(request);




        }
    }

    public void moveToRegistration(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
        finish();
    }
}