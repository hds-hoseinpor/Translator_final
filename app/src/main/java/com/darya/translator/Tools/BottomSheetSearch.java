package com.darya.translator.Tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.darya.translator.Adapter.AdapterRecyclerViewBottomSearchList;
import com.darya.translator.DataModel.DMBottomSearchData;
import com.darya.translator.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;


public class BottomSheetSearch extends RelativeLayout {

    LayoutInflater mInflater;
    private Context context;
    private List<DMBottomSearchData> items = new ArrayList<>();
    private BottomSheetBehavior bottomSheetBehavior;
    private OnStateChanged onStateChanged;
    private AdapterRecyclerViewBottomSearchList adapter;
    private OnClickItem onClickItem;
    private LinearLayout ll_no_item;
    public static final int STATE_COLLAPSED = BottomSheetBehavior.STATE_COLLAPSED;
    public static final int STATE_EXPANDED = BottomSheetBehavior.STATE_EXPANDED;
    private TextView txt_title, txt_description;

    public BottomSheetSearch(Context context) {
        super(context);
        this.context = context;
        mInflater = LayoutInflater.from(context);
        init();

    }

    public BottomSheetSearch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        mInflater = LayoutInflater.from(context);
        init();
    }

    public BottomSheetSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mInflater = LayoutInflater.from(context);
        init();
    }

    private void init() {
        View v = mInflater.inflate(R.layout.bottom_sheet_search, this, true);
        RecyclerView recycler_view = v.findViewById(R.id.recycler_view);
        View view_back_dark = v.findViewById(R.id.view_back_dark);
        view_back_dark.setAlpha(0f);
        View view_back_click = v.findViewById(R.id.view_back_click);
        view_back_click.setVisibility(View.GONE);
        EditText etxt_search = v.findViewById(R.id.etxt_search);
        txt_title = v.findViewById(R.id.txt_title);
        txt_description = v.findViewById(R.id.txt_description);
        txt_title.setVisibility(View.GONE);
        txt_description.setVisibility(View.GONE);
        ll_no_item = v.findViewById(R.id.ll_no_item);
        ll_no_item.setVisibility(View.GONE);
        ImageButton imgbtn_search = v.findViewById(R.id.imgbtn_search);
        ImageButton imgbtn_clear = v.findViewById(R.id.imgbtn_clear);
        imgbtn_clear.setVisibility(View.GONE);
        TextView txt_back = v.findViewById(R.id.txt_back);
        txt_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                etxt_search.getText().clear();
            }
        });
        imgbtn_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                etxt_search.getText().clear();
            }
        });
        view_back_click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        etxt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterAdapter(s.toString());
                if (etxt_search.getText().toString().isEmpty()) {
                    imgbtn_clear.setVisibility(View.GONE);
                    ll_no_item.setVisibility(View.GONE);
                } else {
                    imgbtn_clear.setVisibility(View.VISIBLE);
                }
            }
        });
        LinearLayout llBottomSheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        adapter = new AdapterRecyclerViewBottomSearchList(context, new AdapterRecyclerViewBottomSearchList.ClickItem() {
            @Override
            public void clickItem(DMBottomSearchData item) {
                Tools.hideKyboardWhenClicked(v, context);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                try {
                    onClickItem.onClickItem(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        recycler_view.setLayoutManager(new LinearLayoutManager(context));
        recycler_view.setAdapter(adapter);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setPeekHeight(0);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                try {
                    onStateChanged.onStateChanged(newState);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    ViewAnimation.alphaAnimation(false, view_back_dark, .25f, 0, 200, 0);
                    view_back_click.setVisibility(View.GONE);
                } else {
                    ViewAnimation.alphaAnimation(true, view_back_dark, .25f, 0, 500, 0);
                    view_back_click.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    public void addDataModel(List<DMBottomSearchData> items) {
        adapter.addData(items);
        this.items = items;
    }

    private void filterAdapter(String s) {
        if (s.length() > 0) {
            List<DMBottomSearchData> new_item = new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().contains(s)) {
                    new_item.add(items.get(i));
                }
            }
            adapter.addData(new_item);
        } else {
            adapter.addData(items);
        }
        if (adapter.getItemCount() > 0) {
            ll_no_item.setVisibility(View.GONE);
        } else {
            ll_no_item.setVisibility(View.VISIBLE);
        }

    }

    public void setTitleVisibility(int visibility) {
        txt_title.setVisibility(visibility);
    }

    public void setTitle(String s) {
        if (s.length() > 0) {
            txt_title.setText(s);
            txt_title.setVisibility(View.VISIBLE);
        } else {
            txt_title.setVisibility(View.GONE);
        }
    }

    public void setDescriptionVisibility(int visibility) {
        txt_description.setVisibility(visibility);
    }

    public void setDescription(String s) {
        if (s.length() > 0) {
            txt_description.setText(s);
            txt_description.setVisibility(View.VISIBLE);
        } else {
            txt_description.setVisibility(View.GONE);
        }
    }


    public void addStringData(List<String> items) {
        this.items = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            this.items.add(new DMBottomSearchData(items.get(i)));
        }
        adapter.addData(this.items);
    }

    public void setState(int state) {
        bottomSheetBehavior.setState(state);
    }

    public boolean canBackPress() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            return true;
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            return false;
        }
    }

    public void setBottomSheetCallback(OnStateChanged onStateChanged) {
        this.onStateChanged = onStateChanged;
    }

    public void onClickListener(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }


    public interface OnStateChanged {
        void onStateChanged(int newState);
    }

    public interface OnClickItem {
        void onClickItem(DMBottomSearchData item);
    }

}