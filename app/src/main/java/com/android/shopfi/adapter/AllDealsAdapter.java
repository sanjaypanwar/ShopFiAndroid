package com.android.shopfi.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.shopfi.R;
import com.android.shopfi.response.Outlet;

import java.util.List;

public class AllDealsAdapter extends RecyclerView.Adapter<AllDealsAdapter.DealsViewHolder> {

    private List<Outlet> allDeals;
    private int rowLayout;
    private Context context;


    public static class DealsViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView dealsTitle;
        TextView data;
        TextView dis_price;
        TextView actual_price;


        public DealsViewHolder(View v) {
            super(v);
            card_view = (CardView) v.findViewById(R.id.card_view);
            dealsTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            dis_price = (TextView) v.findViewById(R.id.dis_price);
            actual_price = (TextView) v.findViewById(R.id.actual_price);
        }
    }

    public AllDealsAdapter(List<Outlet> allDeals, int rowLayout, Context context) {
        this.allDeals = allDeals;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public AllDealsAdapter.DealsViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DealsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DealsViewHolder holder, final int position) {

        holder.dealsTitle.setText(allDeals.get(position).getOutletTitleName());
        holder.data.setText(allDeals.get(position).getOutletDescription());
        holder.actual_price.setPaintFlags(holder.actual_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        holder.dis_price.setText(allDeals.get(position).getOverview());
//        holder.actual_price.setText(allDeals.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return allDeals.size();
    }
}