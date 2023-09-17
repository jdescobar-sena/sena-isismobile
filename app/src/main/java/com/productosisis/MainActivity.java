package com.productosisis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.productosisis.interfaces.AccountApi;
import com.productosisis.model.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtx_name, edtx_lastname, edtx_documentid, edtx_birthdate, edtx_email, edtx_password, edtx_address;
    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtx_name = findViewById(R.id.edtx_name);
        edtx_lastname = findViewById(R.id.edtx_lastname);
        edtx_documentid = findViewById(R.id.edtx_documentid);
        edtx_birthdate = findViewById(R.id.edtx_birthdate);
        edtx_email = findViewById(R.id.edtx_email);
        edtx_password = findViewById(R.id.edtx_password);
        edtx_address = findViewById(R.id.edtx_address);

        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAccount();
            }
        });

    }

    public  void registerAccount() {
        String first_name = edtx_name.getText().toString();
        String last_name = edtx_lastname.getText().toString();
        int document_id = Integer.parseInt(edtx_documentid.getText().toString());
        String birthdate = edtx_birthdate.getText().toString();
        String email = edtx_email.getText().toString();
        String password = edtx_password.getText().toString();
        String address = edtx_address.getText().toString();


        System.out.println("DEBUG: \n" + birthdate);

        Account a = new Account(first_name, last_name, document_id, birthdate, email, password, address);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(GsonConverterFactory.create()).build();

        AccountApi accountApi = retrofit.create(AccountApi.class);

        Call<Account> call = accountApi.registerData(a);

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Toast.makeText(MainActivity.this, "@string/register_sucess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "@string/register_failure", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
        
    }
}