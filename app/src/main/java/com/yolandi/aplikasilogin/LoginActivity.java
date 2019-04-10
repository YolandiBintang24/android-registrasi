package com.yolandi.aplikasilogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent login = getIntent();

        //get data
        //String pesanData = login.getData().toString();

        //get extra
        //String pesanNama = login.getStringExtra("name");
        //String pesanExtras = login.getStringExtra("message");

        //get extra with bundle
        Bundle data = login.getExtras();
        String namaExtras = data.getString("name");
        String emailExtras = data.getString("gmail");
        String passwordExtras = data.getString("pass");
        String jeniskelaminExtras = data.getString("jeniskelamin");
        String tempatExtras = data.getString("tempatlahir");
        String tanggalExtras = data.getString("tanggallahir");
        String alamatExtras = data.getString("addres");


        //give data to text view
        TextView txtNama = (TextView) findViewById(R.id.textNama);
        txtNama.setText(namaExtras);
        TextView txtEmail = (TextView) findViewById(R.id.textEmail);
        txtEmail.setText(emailExtras);
        TextView txtPass = (TextView) findViewById(R.id.textPassword);
        txtPass.setText(passwordExtras);
        TextView txtjk = (TextView) findViewById(R.id.textJenisKelamin);
        txtjk.setText(jeniskelaminExtras);
        TextView txtTL = (TextView) findViewById(R.id.textTempatLahir);
        txtTL.setText(tempatExtras);
        TextView txtTgl = (TextView) findViewById(R.id.textTanggal);
        txtTgl.setText(tanggalExtras);
        TextView txtAlamat = (TextView) findViewById(R.id.textAlamat);
        txtAlamat.setText(alamatExtras);



    }
}
