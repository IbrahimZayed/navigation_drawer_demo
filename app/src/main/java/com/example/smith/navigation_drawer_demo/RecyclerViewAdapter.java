package com.example.smith.navigation_drawer_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<ItemData> itemData;
    private Context mContext;
    private int recyclerType; // 1=v 2=h

    public RecyclerViewAdapter(ArrayList<ItemData> itemData, Context mContext, int recyclerType) {
        this.itemData = itemData;
        this.mContext = mContext;
        this.recyclerType = recyclerType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View itemView;

        if (recyclerType == 1) {
             itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_vertical_itemset_layout, parent, false);
            return new ViewHolderVertical(itemView);
        } else {

            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_horizontal_itemset_layout, parent, false);
            return new ViewHolderHorizontal(itemView);
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (recyclerType == 1) {

            final ViewHolderVertical holderVertical = (ViewHolderVertical) holder;
            holderVertical.drawerIcon.setImageResource(itemData.get(position).getIconRsId());
            holderVertical.drawerText.setText(itemData.get(position).getActionName());
            holderVertical.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, itemData.get(position).getActionName(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (recyclerType == 2) {

            ViewHolderHorizontal holderHorizontal = (ViewHolderHorizontal) holder;
            holderHorizontal.hImageview.setImageResource(itemData.get(position).getIconRsId());
            holderHorizontal.hDrawerText.setText(itemData.get(position).getActionName());
            holderHorizontal.hParentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, itemData.get(position).getActionName(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }


    public class ViewHolderVertical extends RecyclerView.ViewHolder {

        ImageView drawerIcon;
        TextView drawerText;
        RelativeLayout parentLayout;

        public ViewHolderVertical(View itemView) {
            super(itemView);
            drawerIcon = itemView.findViewById(R.id.drawer_icon);
            drawerText = itemView.findViewById(R.id.drawer_action_text);
            parentLayout = itemView.findViewById(R.id.drawer_parent_layout);


        }
    }

    public class ViewHolderHorizontal extends RecyclerView.ViewHolder {

        CircleImageView hImageview;
        TextView hDrawerText;
        LinearLayout hParentLayout;

        public ViewHolderHorizontal(View itemView) {
            super(itemView);
            hImageview = itemView.findViewById(R.id.drawer_V_icon);
            hDrawerText = itemView.findViewById(R.id.drawer_V_action_text);
            hParentLayout = itemView.findViewById(R.id.drawer_parent_layout_horizontal);


        }
    }
}
