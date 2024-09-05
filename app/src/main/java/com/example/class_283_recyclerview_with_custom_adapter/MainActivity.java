package com.example.class_283_recyclerview_with_custom_adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HashMap <String, String> hashMap;
    ArrayList <HashMap <String, String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclearView);

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("video_id","Aj1wu1L5glA");
        hashMap.put("title","আমাদের শিবির 1");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","Aj1wu1L5glA");
        hashMap.put("title","আমাদের শিবির 2");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","Aj1wu1L5glA");
        hashMap.put("title","আমাদের শিবির 3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id","Aj1wu1L5glA");
        hashMap.put("title","আমাদের শিবির 4");
        arrayList.add(hashMap);



        MyAdaptar adaptar = new MyAdaptar();
        recyclerView.setAdapter(adaptar);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

//    -----------------------------------

    private class MyAdaptar extends RecyclerView.Adapter <MyAdaptar.myViewHolder> {

        private class myViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.recycle_item, parent, false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            //holder.textView.setText("Item Position "+position);

            hashMap = arrayList.get(position);

            String Video_id = hashMap.get("video_id");
            String title = hashMap.get("title");
            String imgUrl = "https://img.youtube.com/vi/"+Video_id+"/0.jpg";
            holder.textView.setText(title);

            Picasso.get().load(imgUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }
}