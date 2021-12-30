package com.darya.translator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DetailActivity extends AppCompatActivity {

    private TextView txt_text;
    private RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getDataIntent();
        initView();
        initListener();
    }



    private void initView() {
        txt_text = findViewById(R.id.txt_text);
        recycler_view = findViewById(R.id.recycler_view);
    }
    private void initListener() {

    }
    private void getDataIntent() {

    }
}