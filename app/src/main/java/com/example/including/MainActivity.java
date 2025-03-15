package com.example.including;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {



    LayoutInflater layoutInflater;
    ListView list;


    ArrayList<HashMap <String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        hashMap = new HashMap<>();
        hashMap.put("image",String.valueOf(R.drawable.img_1));
        hashMap.put("name","Bishal");
        hashMap.put("mobile","999");
        arrayList.add(hashMap);










     list = findViewById(R.id.list);

     MyAdater myAdapter = new MyAdater();
     list.setAdapter(myAdapter);











    }
    private  class MyAdater extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater1;
            layoutInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View myView = layoutInflater1.inflate(R.layout.new_,list,false);
            HashMap<String,String> hashMap1 = arrayList.get(i);

            TextToSpeech textToSpeech;

            textToSpeech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {

                }
            });


            TextView txt = myView.findViewById(R.id.txt);
            txt.setText(hashMap1.get("name"));
            txt.setOnClickListener(view1 -> {
                textToSpeech.speak(txt.getText().toString().trim(),TextToSpeech.QUEUE_FLUSH ,null,null);
            });


            ImageView img = myView.findViewById(R.id.img);

            img.setImageResource(Integer.parseInt(Objects.requireNonNull(hashMap1.get("image"))));

            String name = hashMap1.get("name");
            String image = hashMap1.get("image");






            LinearLayout l1;

            l1 = myView.findViewById(R.id.l1);

            l1.setOnClickListener(view1 -> {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            });


            return myView;
        }
    }




}