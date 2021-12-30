package com.darya.translator;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.darya.translator.DataModel.DMBottomSearchData;
import com.darya.translator.DataModel.DMTranslateData;
import com.darya.translator.Tools.ActivityWithAnimation;
import com.darya.translator.Tools.BottomSheetSearch;
import com.darya.translator.Tools.GsonModelToGsonAndGsonToModel;
import com.darya.translator.Tools.Tools;
import com.darya.translator.Volley.ApiService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView img_search;
    private EditText etxt_text;
    private TextView txt_from, txt_to, txt_result, txt_more;
    private TextView txt_translate;
    private Context context;
    private ApiService apiService;
    private BottomSheetSearch bss_language;
    private ImageView img_change;
    private LinearLayout ll_result;
    private RecyclerView recycler_view;
    private List<DMBottomSearchData> languages = new ArrayList<>();
    private String from_id = "fa", to_id = "en";
    private Target target;
    private MediaPlayer mediaPlayer;
    private View view;
    private DMTranslateData data;

    private enum Target {
        from,
        to
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        view = findViewById(android.R.id.content);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        languages = new ArrayList<>();
        languages.add(new DMBottomSearchData("fa", "فارسی"));
        languages.add(new DMBottomSearchData("en", "انگلیسی"));
        languages.add(new DMBottomSearchData("fr", "فرانسوی"));
        languages.add(new DMBottomSearchData("de", "آلمانی"));
        languages.add(new DMBottomSearchData("es", "اسپانیایی"));
        languages.add(new DMBottomSearchData("it", "ایتالیایی"));
        languages.add(new DMBottomSearchData("ps", "پشتو"));
        languages.add(new DMBottomSearchData("pt", "پرتغالی"));
        languages.add(new DMBottomSearchData("tg", "تاجیکستانی"));
        languages.add(new DMBottomSearchData("th", "تایلندی"));
        languages.add(new DMBottomSearchData("ru", "روسی"));
        languages.add(new DMBottomSearchData("ar", "عربی"));

        bss_language.addDataModel(languages);
    }


    private void initView() {
        img_search = findViewById(R.id.img_search);
        etxt_text = findViewById(R.id.etxt_text);
        txt_from = findViewById(R.id.txt_from);
        txt_to = findViewById(R.id.txt_to);
        txt_result = findViewById(R.id.txt_result);
        txt_more = findViewById(R.id.txt_more);
        txt_translate = findViewById(R.id.txt_translate);
        bss_language = findViewById(R.id.bss_language);
        img_change = findViewById(R.id.img_change);
        recycler_view = findViewById(R.id.recycler_view);
        ll_result = findViewById(R.id.ll_result);
        ll_result.setVisibility(View.GONE);
    }

    private void initListener() {
        txt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data != null) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("text", etxt_text.getText().toString());
                    intent.putExtra("data", GsonModelToGsonAndGsonToModel.ModelToJson(data));
                    ActivityWithAnimation.set(intent, context, ll_result, etxt_text,img_search);
//                    ActivityWithAnimation.set(intent, context, txt_translate);
                }
            }
        });
        img_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp_id = from_id;
                String temp_name = txt_from.getText().toString();
                from_id = to_id;
                txt_from.setText(txt_to.getText().toString());
                to_id = temp_id;
                txt_to.setText(temp_name);
                playSound();
            }
        });
        txt_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                target = Target.from;
                bss_language.setState(BottomSheetSearch.STATE_EXPANDED);
            }
        });
        txt_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                target = Target.to;
                bss_language.setState(BottomSheetSearch.STATE_EXPANDED);
            }
        });
        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSearch();
            }
        });
        etxt_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    clickSearch();
                    return true;
                }
                return false;
            }
        });
        bss_language.onClickListener(new BottomSheetSearch.OnClickItem() {
            @Override
            public void onClickItem(DMBottomSearchData item) {
                playSound();
                boolean set_change = false;
                if (target.equals(Target.from)) {
                    set_change = !from_id.equals(item.getId()) ? true : false;
                    from_id = item.getId();
                    txt_from.setText(item.getName());
                } else if (target.equals(Target.to)) {
                    set_change = !to_id.equals(item.getId()) ? true : false;
                    to_id = item.getId();
                    txt_to.setText(item.getName());
                }
                if (set_change) {
                    clickSearch();
                }
            }
        });
    }

    private void playSound() {
        checkMediaPlayer();
        mediaPlayer.start();
    }

    private void checkMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.pop);
        }

    }

    private void clickSearch() {
        if (etxt_text.getText().toString().isEmpty()) {
            return;
        }
        if (from_id.equals(to_id)) {
            txt_result.setText(etxt_text.getText().toString());
            ll_result.setVisibility(View.VISIBLE);
            txt_more.setVisibility(View.GONE);
            return;
        }
        Tools.hideKyboardWhenClicked(view, context);
        checkApiService();
        apiService.translate(etxt_text.getText().toString(), from_id, to_id, new ApiService.OnReceivedData() {
            @Override
            public void onReceived(DMTranslateData item) {
                data = item;
                ll_result.setVisibility(View.VISIBLE);
                txt_more.setVisibility(View.VISIBLE);
                txt_result.setText(item.getResponseData().getTranslatedText());
            }

            @Override
            public void onError(String message) {
//                Tools.showCustomToast(message, context);
            }
        });
    }

    private void checkApiService() {
        if (apiService == null) {
            apiService = new ApiService(context);
        }
    }
}