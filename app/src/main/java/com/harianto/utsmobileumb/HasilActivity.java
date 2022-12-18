package com.harianto.utsmobileumb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    ActionBar actionBar;
    TextView nama, nim, prodi, nilai_angka, nilai_huruf, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String str_nama = getIntent().getExtras().getString("nama");
        String str_nim = getIntent().getExtras().getString("nim");
        String str_prodi = getIntent().getExtras().getString("prodi");
        String str_nilai_angka = getIntent().getExtras().getString("nilai_angka");
        String str_nilai_huruf = getIntent().getExtras().getString("nilai_huruf");
        String str_status = getIntent().getExtras().getString("status");

        nama = findViewById(R.id.text_nama);
        nama.setText(str_nama);

        nim = findViewById(R.id.text_nim);
        nim.setText(str_nim);

        prodi = findViewById(R.id.text_prodi);
        prodi.setText(str_prodi);

        nilai_angka = findViewById(R.id.text_nilai_angka);
        nilai_angka.setText(str_nilai_angka);

        nilai_huruf = findViewById(R.id.text_nilai_huruf);
        nilai_huruf.setText(str_nilai_huruf);

        status = findViewById(R.id.text_status);
        status.setText(str_status);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}