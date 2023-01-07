package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
// importacion de un driver asincrono para usar mongodb
// import com.mongodb.async.client.MongoClient;


import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected ListView Lista;
    List<String> Items;
    ArrayAdapter ADP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText ETTask = findViewById(R.id.task);
        final Button BtnTask = findViewById(R.id.addTask);


        Lista = findViewById(R.id.lv);
        Items = new ArrayList<>();
        ADP = new ArrayAdapter(getApplicationContext(), R.layout.item_listview_quehaceres, Items);
        Lista.setAdapter(ADP);
        BtnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Items.add(ETTask.getText().toString());
                ADP.notifyDataSetChanged();
                ETTask.setText("");

            }
        });
        Lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Items.remove(position);
                ADP.notifyDataSetChanged();;
                return false;
            }
        });
    }
}