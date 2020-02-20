package com.example.onlinetestexam;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class QuestionRecycleViewAdapter extends RecyclerView.Adapter<QuestionRecycleViewAdapter.ViewHolder>{



    private Context context;
    List<QuestionDataModel> questiondataModels;



    public QuestionRecycleViewAdapter(Context context, List<QuestionDataModel> questiondataModels) {
        this.context = context;
        this.questiondataModels = questiondataModels;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.question_pattern_row, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuestionDataModel data = questiondataModels.get(position);
        holder.textView.setText(data.getQuestion());
        holder.op1.setText(data.getA());
        holder.op2.setText(data.getB());
        holder.op3.setText(data.getC());
        holder.op4.setText(data.getD());


    }

    @Override
    public int getItemCount() {
        return questiondataModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {



        public TextView textView,textView2;
        public Button op1,op2,op3,op4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.SoftEasyQuizQuestion);
            op1=itemView.findViewById(R.id.softEasyOp1);
            op2=itemView.findViewById(R.id.softEasyOp2);
            op3=itemView.findViewById(R.id.softEasyOp3);
            op4=itemView.findViewById(R.id.softEasyOp4);


        }



    }




}
