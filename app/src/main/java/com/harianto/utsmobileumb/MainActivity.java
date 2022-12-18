package com.harianto.utsmobileumb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText nama, nim, absen, tugas, uts, uas;
    RadioGroup rgProdi;
    RadioButton prodi;
    Button btnHitung, btnBersihkan;
    String nilai_huruf, status;
    Double int_nilai_angka, int_absen, int_uts, int_uas, int_tugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nama = findViewById(R.id.et_nama);
        nim = findViewById(R.id.et_nim);
        absen = findViewById(R.id.et_absen);
        rgProdi = findViewById(R.id.rd_prodi);
        tugas = findViewById(R.id.et_tugas);
        uts = findViewById(R.id.et_uts);
        uas = findViewById(R.id.et_uas);
        btnHitung = findViewById(R.id.btn_hitung);
        btnBersihkan = findViewById(R.id.btn_bersihkan);

        nama.requestFocus();

        btnBersihkan.setOnClickListener(view-> {
            nama.getText().clear();
            nim.getText().clear();
            absen.getText().clear();
            rgProdi.clearCheck();
            tugas.getText().clear();
            uts.getText().clear();
            uas.getText().clear();
            nama.requestFocus();
        });

        btnHitung.setOnClickListener(view -> {
            int radioId = rgProdi.getCheckedRadioButtonId();
            prodi = (RadioButton) findViewById(radioId);

            int_absen = Double.parseDouble(absen.getText().toString());
            int_tugas = Double.parseDouble(tugas.getText().toString());
            int_uts = Double.parseDouble(uts.getText().toString());
            int_uas = Double.parseDouble(uas.getText().toString());

            int_nilai_angka = (0.1 * int_absen) + (0.2 * int_tugas) + (0.3 * int_uts) + (0.4 * int_uas);
            String nilai_angka = Double.toString(int_nilai_angka);

            if (int_nilai_angka >= 80){
                nilai_huruf = "A";
            } else if (int_nilai_angka >= 70 ){
                nilai_huruf = "B";
            } else if (int_nilai_angka >= 60) {
                nilai_huruf = "C";
            } else if (int_nilai_angka >= 50){
                nilai_huruf = "D";
            } else if (int_nilai_angka < 50){
                nilai_huruf = "E";
            }

            if (int_nilai_angka >= 60){
                status = "LULUS";
            } else {
                status = "TIDAK LULUS";
            }

            Intent hasil = new Intent(MainActivity.this, HasilActivity.class);
            hasil.putExtra("nama", nama.getText().toString());
            hasil.putExtra("nim", nim.getText().toString());
            hasil.putExtra("prodi", prodi.getText().toString());
            hasil.putExtra("nilai_huruf", nilai_huruf);
            hasil.putExtra("status", status);
            hasil.putExtra("nilai_angka", nilai_angka);
            startActivity(hasil);
        });
    }
}