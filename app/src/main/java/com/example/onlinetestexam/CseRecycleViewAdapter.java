package com.example.onlinetestexam;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CseRecycleViewAdapter extends RecyclerView.Adapter<CseRecycleViewAdapter.ViewHolder>{



    private Context context;
    List<CseDataModel> csedataModels;



    public CseRecycleViewAdapter(Context context, List<CseDataModel> csedataModels) {
        this.context = context;
        this.csedataModels = csedataModels;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_row, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CseDataModel data = csedataModels.get(position);
        holder.textView.setText(data.getCourseName());

    }

    @Override
    public int getItemCount() {
        return csedataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textView=itemView.findViewById(R.id.CseDashSampleTextId);




        }


    }




}
