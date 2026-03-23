package com.example.listychyba;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayListJezyki;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       arrayListJezyki = new ArrayList<>();
       arrayListJezyki.add("JavaScript");
       arrayListJezyki.add("Rust");
       arrayListJezyki.add("Ruby");
       arrayListJezyki.add("Kotlin");
       arrayListJezyki.add("GBScript");

       arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListJezyki);

       listView = findViewById(R.id.ListViewJezyki);
       listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener( // na 4
               new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       //view.setBackgroundColor(Color.GREEN);
                       arrayListJezyki.remove(i);
                       arrayAdapter.notifyDataSetChanged();
                   }
               }
       );
       editText = findViewById(R.id.editTextText);
       button = findViewById(R.id.button);

       button.setOnClickListener( // na 5
               new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String jezyk = editText.getText().toString();
                       arrayListJezyki.add(jezyk);
                       arrayAdapter.notifyDataSetChanged();
                   }
               }
       );
       //lista liczb albo stringow
        // jezeli lista intow (wylosowac liste)

    }
}