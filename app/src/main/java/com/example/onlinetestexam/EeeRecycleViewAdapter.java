package com.example.onlinetestexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EeeRecycleViewAdapter extends RecyclerView.Adapter<EeeRecycleViewAdapter.ViewHolder>{


    private static EeeRecycleViewAdapter.ClickSoftListener clickSoftListener;

    private Context context;
    List<EeeDataModel> eeedataModels;

    public EeeRecycleViewAdapter(Context context, List<EeeDataModel> eeedataModels) {
        this.context = context;
        this.eeedataModels = eeedataModels;
    }

    @NonNull
    @Override
    public EeeRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_row, parent, false);
      return   new EeeRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EeeRecycleViewAdapter.ViewHolder holder, int position) {
        EeeDataModel data = eeedataModels.get(position);
        holder.textView.setText(data.getCourseName());
    }

    @Override
    public int getItemCount() {
        return eeedataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.CseDashSampleTextId);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            clickSoftListener.onItemClick(getAdapterPosition(),v);

        }
    }

    public interface ClickSoftListener{
        void onItemClick(int position, View v);


    }
    public void setOnItemClickListener(EeeRecycleViewAdapter.ClickSoftListener clickSoftListener)
    {
        EeeRecycleViewAdapter.clickSoftListener=clickSoftListener;

    }



}
