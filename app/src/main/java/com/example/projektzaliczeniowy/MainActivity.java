package com.example.projektzaliczeniowy;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.time.temporal.ValueRange;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int [] pcty ={
            R.drawable.gotowiec1,
            R.drawable.gotowiec2,
            R.drawable.gotowiec3
    };
    int [] klawiatury ={
            R.drawable.apex5,
            R.drawable.ornata,
            R.drawable.logitech
    };
    int [] myszki ={
            R.drawable.rival5,
            R.drawable.razermysz,
            R.drawable.viper
    };
    int [] kamerki ={
            R.drawable.kamera1,
            R.drawable.logitechkamerka,
            R.drawable.savio
    };
    String [] opisy = {
            "G4M3R HERO i7-12700F/16GB/1TB/RTX3060, 5000zł",
            "G4M3R ELITE i7-13700KF/32GB/2TB/RTX3080, 7000zł",
            "Lenovo Legion T5 i5-11400F/16GB/512 RTX 3060Ti, 6000zł"
    };
    String [] opisy2 = {
            "Klawiatura STEELSERIES Apex 5, 300zł",
            "Klawiatura Razer Ornata V2 Hybrid Mecha-Membrane, 350zł",
            "Klawiatura LOGITECH G213 Prodigy, 200zł"
    };
    String [] opisy3 = {
            "Myszka SteelSeries Rival 5, 280zł",
            "Myszka RAZER DEATHADDER V2 MINI, 250zł",
            "Myszka Gamingowa Razer Viper, 230zł"
    };
    String [] opisy4 = {
            "Kamera internetowa Tracer WEB007, 100zł",
            "Kamera internetowa Logitech C920 HD Pro, 300zł",
            "Kamera internetowa SAVIO FullHD Webcam CAK-02, 200zł"
    };


    Slider slider;
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    int cena_komp;
    int cena_myszka;
    int cena_klaw;
    int cena_kamerka;
    int ilosc;
    TextView cenaWyswietl;
    CheckBox checkklaw;
    CheckBox checkmyszka;
    CheckBox checkkamerka;
    Button button_cena;
    int klawiatura = 0;
    int komputer = 0;
    int myszka = 0;
    int kamerka = 0;
    int slider1 = 1;

    SQLiteOpenHelper sqliteOpenHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sqliteOpenHelper = new FeedReaderHelperDB(this);
        db = sqliteOpenHelper.getWritableDatabase();


//        String query = "SELECT * FROM " + FeedReaderContract.komputer.TABLE_KOMPUTER;
//        Cursor cursor = db.rawQuery(query,null);
//        if(!cursor.moveToFirst()) {
//            Log.v(TAG, "Dodaje");
//            db.execSQL(methodsInsert.insertKomputer(1, "G4M3R HERO", 5000));
//        }

        slider = (Slider) findViewById(R.id.slider);

        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                switch ((int) value){
                    case 1:
                        slider1 = 1;
                        break;
                    case 2:
                        slider1 = 2;
                        break;
                    case 3:
                        slider1 = 3;
                        break;
                    case 4:
                        slider1 = 4;
                        break;
                    case 5:
                        slider1 = 5;
                        break;
                }
            }
        });


        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        komputer = 1;
                        break;
                    case 1:
                        komputer = 2;
                        break;
                    case 2:
                        komputer = 3;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opisy);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),pcty,opisy);
        spinner.setAdapter(myAdapter);


        spinner2 = findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        klawiatura = 1;
                        break;
                    case 1:
                        klawiatura = 2;
                        break;
                    case 2:
                        klawiatura = 3;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        MyAdapter myAdapter2 = new MyAdapter(getApplicationContext(),klawiatury,opisy2);
        spinner2.setAdapter(myAdapter2);


        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        myszka = 1;
                        break;
                    case 1:
                        myszka = 2;
                        break;
                    case 2:
                        myszka = 3;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        MyAdapter myAdapter3 = new MyAdapter(getApplicationContext(),myszki,opisy3);
        spinner3.setAdapter(myAdapter3);



        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        kamerka = 1;
                        break;
                    case 1:
                        kamerka = 2;
                        break;
                    case 2:
                        kamerka = 3;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        MyAdapter myAdapter4 = new MyAdapter(getApplicationContext(),kamerki,opisy4);
        spinner4.setAdapter(myAdapter4);

        checkmyszka = findViewById(R.id.checkbox2);
        checkklaw = findViewById(R.id.checkbox1);
        checkkamerka = findViewById(R.id.checkbox3);

        cenaWyswietl = findViewById(R.id.textView3);

        button_cena = findViewById(R.id.button_cena);
        button_cena.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(slider1 == 1){
                    ilosc= 1;
                }
                else if(slider1 == 2){
                    ilosc = 2;
                }
                else if(slider1 == 3){
                    ilosc = 3;
                }
                else if(slider1 == 4){
                    ilosc = 4;
                }
                else if(slider1 == 5){
                    ilosc = 5;
                }


                if(komputer == 1){
                    cena_komp = 5000;
                }
                else if(komputer == 2){
                    cena_komp = 7000;
                }
                else if(komputer == 3){
                    cena_komp = 6000;
                }



                if(checkmyszka.isChecked()){
                    if(myszka == 1){
                        cena_myszka = 280;
                    }
                    else if(myszka == 2){
                        cena_myszka = 250;
                    }
                    else if(myszka == 3){
                        cena_myszka = 230;
                    }

                }else{
                    cena_myszka = 0;
                }


                if(checkklaw.isChecked()){
                    if(klawiatura == 1){
                        cena_klaw = 300;
                    }
                    else if(klawiatura == 2){
                        cena_klaw = 350;
                    }
                    else if(klawiatura == 3){
                        cena_klaw = 200;
                    }

                }else{
                    cena_klaw = 0;
                }


                if(checkkamerka.isChecked()){
                    if(kamerka == 1){
                        cena_kamerka = 100;
                    }
                    else if(kamerka == 2){
                        cena_kamerka = 300;
                    }
                    else if(kamerka == 3){
                        cena_kamerka = 200;
                    }

                }else{
                    cena_kamerka = 0;
                }
                cenaWyswietl.setText(Integer.toString(cena_komp*ilosc+cena_myszka*ilosc+cena_klaw*ilosc+cena_kamerka*ilosc));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(getApplicationContext(), ListaZamowien.class);
                MainActivity.this.startActivity(intent);
                return true;

            case R.id.item2:
                intent = new Intent(getApplicationContext(), Sms.class);
                MainActivity.this.startActivity(intent);
                return true;

            case R.id.item3:
                intent = new Intent(getApplicationContext(), Oautorze.class);
                MainActivity.this.startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private static class methodsInsert {
        private static String insertKomputer(int Id, String komputer, int price) {
            return "INSERT INTO " + FeedReaderContract.komputer.TABLE_KOMPUTER + " (" +
                    FeedReaderContract.komputer.COLUMN_KOMPUTER_ID + ", " + FeedReaderContract.komputer.COLUMN_KOMPUTER_NAME + ", " + FeedReaderContract.komputer.COLUMN_KOMPUTER_PRICE +  ") " +
                    "VALUES (" + Id + ", '" + komputer + "', "  + price + "');";
        }
    }
}