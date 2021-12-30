package com.darya.translator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.darya.translator.DataModel.DMTranslateData;
import com.darya.translator.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterRecyclerViewItem extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DMTranslateData.MatchesBean> items = new ArrayList<>();
    private final Context context;


    public AdapterRecyclerViewItem(Context context, List<DMTranslateData.MatchesBean> items) {
        this.items = items;
        this.context = context;
    }


    public class N1ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_translate, txt_creator, txt_source_target;

        public N1ViewHolder(View v) {
            super(v);
            txt_translate = v.findViewById(R.id.txt_translate);
            txt_creator = v.findViewById(R.id.txt_creator);
            txt_source_target = v.findViewById(R.id.txt_source_target);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        switch (viewType) {
            case 0:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_means, parent, false);
                return new N1ViewHolder(v);
        }
        return null;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof N1ViewHolder) {
            DMTranslateData.MatchesBean item = items.get(position);
            N1ViewHolder holder = (N1ViewHolder) viewHolder;
            holder.txt_translate.setText(item.getTranslation());
            holder.txt_creator.setText(item.getCreatedby());
            holder.txt_source_target.setText(item.getSource() + " >> " + item.getTarget());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

}