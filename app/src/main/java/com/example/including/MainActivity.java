package com.example.including;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class MainActivity extends AppCompatActivity {

    LinearLayout main;
    AppCompatButton addbtn,removebtn;

    LayoutInflater layoutInflater;
    ListView list;

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


        main = findViewById(R.id.main);
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);






        list = findViewById(R.id.list);
        MyAdapter myAdapter = new MyAdapter();
        list.setAdapter(myAdapter);




    }



    private  class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 100;
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
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater1;
            layoutInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View Lview = layoutInflater1.inflate(R.layout.new_,list,false);
            LinearLayout l;

            l = Lview.findViewById(R.id.l1);
            l.setOnClickListener(view1 -> {
                Toast.makeText(MainActivity.this, "Position Number is: "+position, Toast.LENGTH_SHORT).show();
            });









            TextView txt = Lview.findViewById(R.id.txt);
            txt.setText(""+position);



            return Lview;
        }
    }
}