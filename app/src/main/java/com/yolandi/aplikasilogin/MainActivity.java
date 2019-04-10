package com.yolandi.aplikasilogin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radiogroupJK;
    private RadioButton radioButtonJK;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (TextView) findViewById(R.id.inputTanggalLahir);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

    }

    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



    public void scndActvt(View v){
        EditText ketik = (EditText) findViewById(R.id.inputEmail);
        String pesan = ketik.getText().toString();
        Intent login = new Intent(this,LoginActivity.class);
        login.setData(Uri.parse(pesan));
        startActivity(login);
    }

    public void sendExtras(View v){
        //get data from input
        EditText nm = (EditText) findViewById(R.id.inputNama);
        String nama = nm.getText().toString();
        EditText ketik = (EditText) findViewById(R.id.inputEmail);
        String pesan = ketik.getText().toString();
        EditText pw = (EditText) findViewById(R.id.inputPassword);
        String password = pw.getText().toString();
        Intent login = new Intent(this,LoginActivity.class);
        //create object intent
        login.putExtra("message",pesan);
        login.putExtra("name",nama);
        login.putExtra("pass",password);
        startActivity(login);
    }

    public void sendExtrasBundle(View v){

        EditText nm = (EditText) findViewById(R.id.inputNama);
        String nama = nm.getText().toString();
        EditText ketik = (EditText) findViewById(R.id.inputEmail);
        String email = ketik.getText().toString();
        EditText pw = (EditText) findViewById(R.id.inputPassword);
        String password = pw.getText().toString();
        radiogroupJK = (RadioGroup) findViewById(R.id.radiogroupJenisKelamin);
        int selectId = radiogroupJK.getCheckedRadioButtonId();
        radioButtonJK = (RadioButton) findViewById(selectId);
        String JK = radioButtonJK.getText().toString();
        EditText TL = (EditText) findViewById(R.id.inputTempatLahir);
        String  Tempat = TL.getText().toString();
        EditText Tgl = (EditText) findViewById(R.id.inputTanggalLahir);
        String  Tanggal = Tgl.getText().toString();
        EditText almt = (EditText) findViewById(R.id.inputAlamat);
        String  alamat = almt.getText().toString();
        Intent login = new Intent(this,LoginActivity.class);
        Bundle data = new Bundle();
        data.putString("name",nama);
        data.putString("gmail",email);
        data.putString("pass",password);
        data.putString("jeniskelamin",JK);
        data.putString("tempatlahir",Tempat);
        data.putString("tanggallahir",Tanggal);
        data.putString("addres",alamat);
        login.putExtras(data);
        startActivity(login);
        //bikin 2 aktiviti dimana aktivity 1 itu ada 1 edit text sama 1 button, di aktivity ke dua ada 1 text view
        //untuk menampilkan isi edit text yang di aktivity 1, di aktivity ke 2 edit text lagi dengan 1 tomnol
    }
}
