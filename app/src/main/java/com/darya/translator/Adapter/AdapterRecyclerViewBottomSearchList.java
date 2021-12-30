package com.darya.translator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.darya.translator.DataModel.DMBottomSearchData;
import com.darya.translator.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterRecyclerViewBottomSearchList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DMBottomSearchData> items = new ArrayList<>();
    private final Context context;
    private final ClickItem clickItem;


    public AdapterRecyclerViewBottomSearchList(Context context, ClickItem clickItem) {
        this.context = context;
        this.clickItem = clickItem;
    }

    public void addData(List<DMBottomSearchData> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class N1ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title;

        public N1ViewHolder(View v) {
            super(v);
            txt_title = v.findViewById(R.id.txt_title);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 0:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottom_search_list, parent, false);
                return new N1ViewHolder(v);
        }
        return null;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof N1ViewHolder) {
            N1ViewHolder holder = (N1ViewHolder) viewHolder;
            DMBottomSearchData item = items.get(position);
            holder.txt_title.setText(item.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItem.clickItem(item);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public interface ClickItem {
        void clickItem(DMBottomSearchData item);
    }
}