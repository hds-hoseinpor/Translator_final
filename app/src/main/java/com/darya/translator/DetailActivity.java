package com.darya.translator;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.darya.translator.Adapter.AdapterRecyclerViewItem;
import com.darya.translator.DataModel.DMTranslateData;
import com.darya.translator.Tools.ActivityWithAnimation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DetailActivity extends AppCompatActivity {

    private TextView txt_text;
    private ImageView img_speach;
    private RecyclerView recycler_view;
    private DMTranslateData item;
    private Context context;
    private RelativeLayout root, rl_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context = this;
        initView();
        initListener();
        getDataIntent();
        ActivityWithAnimation.init(root, txt_text,img_speach);
//        ActivityWithAnimation.init( rl_top);
    }


    private void initView() {
        txt_text = findViewById(R.id.txt_text);
        recycler_view = findViewById(R.id.recycler_view);
        root = findViewById(R.id.root);
        rl_top = findViewById(R.id.rl_top);
        img_speach = findViewById(R.id.img_speach);
    }

    private void initListener() {

    }

    private void getDataIntent() {
        item = new Gson().fromJson(getIntent().getStringExtra("data"),
                new TypeToken<DMTranslateData>() {
                }.getType());
        String text = getIntent().getStringExtra("text");
        txt_text.setText(text);
        if (item != null) {
            setupRecyclerView();
        }
    }

    private void setupRecyclerView() {
        AdapterRecyclerViewItem adapter = new AdapterRecyclerViewItem(context, item.getMatches());
        recycler_view.setLayoutManager(new LinearLayoutManager(context));
        recycler_view.setAdapter(adapter);
    }

}