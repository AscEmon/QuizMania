package com.example.onlinetestexam;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{


    private Context context;
    List<DataModel> dataModels;


    public RecycleViewAdapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycle_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel data = dataModels.get(position);

        holder.textView.setText(data.getCourseName());
        Picasso.get().load(data.getImage()).into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView imgView;
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textView=itemView.findViewById(R.id.SampleTextId);
            imgView= itemView.findViewById(R.id.SampleImageId);



        }
    }
}
