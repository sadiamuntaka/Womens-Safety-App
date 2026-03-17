package com.darkness.sparkwomen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LawDisplayerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView big,oneLine;
    String[] laws, lawsContent;
    int counter;
    Button back, next;
    View closeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law_displayer);

        big = findViewById(R.id.bigLaws);
        oneLine = findViewById(R.id.lawString);
        counter = getIntent().getIntExtra("position",0);
        laws = new String[]{"The Prohibition of Child Marriage Act, 1929","Special Marriage Act, 1872","Dowry Prohibition Act, 1980","Bangladesh Divorce Act, 1869","Maternity Benefit Act,1939","Medical Termination of Pregnancy Act,1979","Sexual Harassment of Women at Workplace (Prevention, Prohibition and Redress) Act, 2009","Indecent Representation of Women(Prevention) Act,1963","National Commission for Women Act, 1991","Equal Remuneration Act, 1976"};
        lawsContent = this.getResources().getStringArray(R.array.lawsBig);

        closeBtn = findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(view -> {
            onBackPressed();
            LawDisplayerActivity.this.finish();
        });

        back = findViewById(R.id.backBtn);
        next = findViewById(R.id.nextBtn);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        setData();
    }

    public void setData(){
        oneLine.setText(laws[counter]);
        big.setText(lawsContent[counter]);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.nextBtn){
            if(counter<9){
                counter++;
            }else {
                counter = 0;
            }
        } else if (view.getId() == R.id.backBtn) {
            if(counter == 0){
                counter = (laws.length-1);
            }else {
                counter--;
            }
        }

        setData();
    }
}