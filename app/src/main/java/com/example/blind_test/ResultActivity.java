package com.example.blind_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {


    TextView txtCorrectText;
    TextView txtPercentText;
    private int totalQuestions;
    private int finalScore;

    sqLite db = new sqLite(this);
    TextView number_calc;
    TextView  name_calc;
    TextView  id_calc;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtCorrectText = findViewById(R.id.correct_textview);
        txtPercentText = findViewById(R.id.percent_textview);

        number_calc=findViewById(R.id.editTextNumberSigned_view);
        name_calc=findViewById(R.id.editTextTextPersonName_view);
        id_calc=findViewById(R.id.editTextNumberSigned2Hint_view);
        lst=findViewById(R.id.listView_view);
        showData();

        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestion",0);
        finalScore = intent.getIntExtra("finalScore",0);

        int mPercentScore=finalScore*100/totalQuestions;
        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(mPercentScore))));

        String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);

    }

    public void restartGame(View view) {
        super.onBackPressed();
    }

    public void showData(){
        ArrayList<String> listData = db.getAllRecord();
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
        lst.setAdapter(arrayAdapter);

    }
    public void btn_add_data(View view) {
        String Name=name_calc.getText().toString();
        Integer Number=Integer.parseInt(number_calc.getText().toString());

        boolean request= db.insertData(Name,Number);
        if (request == true){
            Toast.makeText(getBaseContext(), "Ok", Toast.LENGTH_SHORT).show();
            name_calc.setText("");
            number_calc.setText("");
            showData();
        }else{
            Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();

        }
    }

    public void btn_edit_data(View view) {
        String Name=name_calc.getText().toString();
        Integer Number=Integer.parseInt(number_calc.getText().toString());
        String Id=id_calc.getText().toString();

        boolean request= db.updateData(Id,Name,Number);
        if (request == true){
            Toast.makeText(getBaseContext(), "Ok", Toast.LENGTH_SHORT).show();
            name_calc.setText("");
            number_calc.setText("");
            id_calc.setText("");
            showData();
        }else{
            Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();

        }
    }

    public void btn_delete_data(View view) {
        String Id=id_calc.getText().toString();
        Integer result = db.Delete(Id);
        if (result>0){
            Toast.makeText(getBaseContext(), "Ok", Toast.LENGTH_SHORT).show();
            showData();
        }else{
            Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();
        }

    }
}