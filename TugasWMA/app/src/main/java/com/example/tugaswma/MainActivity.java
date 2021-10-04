package com.example.tugaswma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    membuat array untuk data spinner
    String[] wisata={"Semua", "Pantai", "Taman", "Museum", "Restoran", "Mall"};
    int images[] = {R.drawable.ic_baseline_clear_all_24,R.drawable.ic_baseline_beach_access_24,R.drawable.ic_baseline_local_florist_24, R.drawable.ic_baseline_museum_24, R.drawable.ic_baseline_restaurant_24, R.drawable.ic_sharp_store_mall_directory_24};

    //List digunakan Untuk menampung Data negara
    private List<Country_Item> countryList;


    ListView lv;
    //Data-Data yang Akan dimasukan Pada ListView
    int[] iconList = new int[]{
            R.drawable.g1, R.drawable.g2, R.drawable.g5, R.drawable.g3,R.drawable.g4
    };
    // Data data yang Akan dimasukan Pada ListView pada bagian headline
    String[] Headline = {"Pantai Pandawa", "Kebun Raya Bogor", "Museum Nasional", "The Dubai Mall","True Food Kitchen"
    };
    // Data data yang Akan dimasukan Pada ListView pada bagian subhead
    String[] Subhead = {"Bali,Indonesia", "Bogor,Indonesia", "New Delhi,India", "Dubai, Arab","California"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ambil contoh Spinner dan
        // terapkan OnItemSelectedListener di atasnya yang
        // memberi tahu item spinner mana yang diklik
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Melakukan tindakan saat ItemSelected
            // dari spinner
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Select Position: "+position+" "+wisata[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            // Auto-generated method stub
            }
        });

        CustomSpinnerAdapter customAdapter=new CustomSpinnerAdapter(getApplicationContext(),images,wisata);

        // Set ArrayAdapter data pada
        // Spinner yang mengikat data ke spinner
        spin.setAdapter(customAdapter);

        //memanggil method fillcountrylist
        fillCountryList();
        AutoCompleteTextView autocompleteCountry=findViewById(R.id.autocompleteCountry);
        //memanggil setAdapter() pada objek Autocomplete
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this,countryList);
        autocompleteCountry.setAdapter(adapter);

        lv = findViewById(R.id.list);
        //memanggil setAdapter() pada objek ListView
        ListAdapter listAdapter = new ListAdapter(this, iconList, Headline, Subhead);
        lv.setAdapter(listAdapter);

        //untuk Menambahkan Aksi Klik pada ListView Item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast memberikan masukan singkat tentang operasi dalam pop-up kecil.
        //Metode makeText() menampilkan objek Toast yang diinisialisasi dengan benar.
        //metode show() untuk menampilkan Toast
                Toast.makeText(getApplicationContext(),
                        "Ini adalah wisata : " + Headline[position],
                        Toast.LENGTH_SHORT).show();

            }
        });


    }

//method untuk mengisikan data coutrylist
    private void fillCountryList(){
        countryList=new ArrayList<>();
        //menambahkan data negara ke dalamnya
        countryList.add(new Country_Item("Afghanistan",R.drawable.b6));
        countryList.add(new Country_Item("Amerika",R.drawable.b8));
        countryList.add(new Country_Item("Arab",R.drawable.b7));
        countryList.add(new Country_Item("Argentina",R.drawable.b12));

        countryList.add(new Country_Item("India",R.drawable.b2));
        countryList.add(new Country_Item("Indonesia",R.drawable.b1));
        countryList.add(new Country_Item("Irak",R.drawable.b4));
        countryList.add(new Country_Item("Iran",R.drawable.b5));
        countryList.add(new Country_Item("Irlandia",R.drawable.b3));

    }


}
