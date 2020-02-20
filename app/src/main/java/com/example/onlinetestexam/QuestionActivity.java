package com.example.onlinetestexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    Button op1,op2,op3,op4;
    TextView questionText;


    FirebaseAuth mAuth;

    DatabaseReference reference,reference2;
    List<QuestionDataModel> questiondataModels;
    QuestionRecycleViewAdapter adapter,adapter2;
    RecyclerView questionrecyclerView,questionrecyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        questionText=findViewById(R.id.SoftEasyQuizQuestion);
        op1=findViewById(R.id.softEasyOp1);
        op2=findViewById(R.id.softEasyOp2);
        op3=findViewById(R.id.softEasyOp3);
        op4=findViewById(R.id.softEasyOp4);

        mAuth=FirebaseAuth.getInstance();


        //Toolbar setup
        toolbar=findViewById(R.id.questionDashToolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("QuestionDash");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);




        reference= FirebaseDatabase.getInstance().getReference("SoftwareQuiz").child("01").child("SoftwareEasyQuiz");
        questiondataModels = new ArrayList<>();
        questionrecyclerView=findViewById(R.id.QuestionDashRecycleViewId);
        adapter = new QuestionRecycleViewAdapter(this,questiondataModels);
        questionrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionrecyclerView.setHasFixedSize(true);
        questionrecyclerView.setAdapter(adapter);

              //EasyQuiz
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                try {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        QuestionDataModel model = ds.getValue(QuestionDataModel.class);
                        questiondataModels.add(model);
                        adapter.notifyDataSetChanged();
                    }
                }

                catch (Exception e){
                    Toast.makeText(QuestionActivity.this, "Could not parse the data properly", Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

/*


        reference2= FirebaseDatabase.getInstance().getReference("SoftwareQuiz").child("02").child("SoftwareHardQuiz");
        questiondataModels = new ArrayList<>();
        questionrecyclerView2=findViewById(R.id.QuestionDashRecycleViewId);
        adapter2 = new QuestionRecycleViewAdapter(this,questiondataModels);
        questionrecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        questionrecyclerView2.setHasFixedSize(true);
        questionrecyclerView2.setAdapter(adapter2);
        //HardQuiz
        reference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {


                try {
                    for (DataSnapshot ds2 : dataSnapshot1.getChildren()) {
                        QuestionDataModel modelll = ds2.getValue(QuestionDataModel.class);
                        questiondataModels.add(modelll);
                        adapter.notifyDataSetChanged();
                    }
                }

                catch (Exception e){
                    Toast.makeText(QuestionActivity.this, "Could not parse the data properly", Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
