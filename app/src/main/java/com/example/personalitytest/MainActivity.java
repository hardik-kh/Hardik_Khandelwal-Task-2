package com.example.personalitytest;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score=0;
    int step=0;
    int [] sc ={0,0,0,0,0,0,0,0,0,0};
    int [][] scperques={{3,2,1},{1,2,3},{3,2,1},{3,2,1},{1,2,3},{3,2,1},{1,2,3},{3,2,1},{3,2,1},{1,2,3}};
    int i=0;
    int j=0;
    String [] data ={"1) I love to help others","Always","Sometimes","Never",
                     "2) I get angry easily","Very easily","Sometimes ","Rarely",
                    "3) I complete tasks successfully","Always","Sometimes","Never",
                    "4) I try to follow the rules","Always","Sometimes","Never",
                    "5) I talk to a lot of different people at parties","Rarely","Sometimes","Mostly",
                    "6) I feel sympathy for those who are worse off than myself.","Mostly","Sometimes","Rarely",
                    "7)I do things I later regret.","Mostly","Sometimes","Rarely",
                    "8) I keep my promises","Always","Sometimes","Never",
                    "9) I act comfortably with others.","Mostly","Sometimes","Rarely",
                    "10) I get stressed out easily","True","Depends on situation","False"};

    public void tap(View view){
        Button fin =findViewById(R.id.button);
        fin.setVisibility(View.VISIBLE);


        score= 0;
        i=0;
        step=0;
        Button nxt = findViewById(R.id.button);
        nxt.setText("Next");
        TextView ques=findViewById(R.id.question);
        ques.setText(data[step]);
        RadioButton r1= findViewById(R.id.r1);
        r1.setText(data[step+1]);
        RadioButton r2= findViewById(R.id.r2);
        r2.setText(data[step+2]);
        RadioButton r3= findViewById(R.id.r3);
        r3.setText(data[step+3]);
        RadioGroup rg = findViewById(R.id.radioGroup);
        rg.clearCheck();




    }
    public void calculation(View view){
        RadioButton val =(RadioButton) view;
        int tappedRadio = Integer.parseInt(val.getTag().toString());
        //val.setBackgroundColor();
        sc[i]= scperques[i][tappedRadio] ;



    }


    private Button test;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ques=findViewById(R.id.question);
        ques.setText(data[step]);
        RadioButton r1= findViewById(R.id.r1);
        r1.setText(data[step+1]);
        RadioButton r2= findViewById(R.id.r2);
        r2.setText(data[step+2]);
        RadioButton r3= findViewById(R.id.r3);
        r3.setText(data[step+3]);

        test = (Button) findViewById(R.id.button);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==8){
                    if(r1.isChecked()==false && r2.isChecked()==false && r3.isChecked()==false){
                        Toast.makeText(MainActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Button nxt= findViewById(R.id.button);
                        nxt.setText("Finish");
                        step=step+4;
                        TextView ques =findViewById(R.id.question);
                        ques.setText(data[step]);
                        RadioButton r1= findViewById(R.id.r1);
                        r1.setText(data[step+1]);
                        //r1.setChecked(false);
                        RadioButton r2= findViewById(R.id.r2);
                        r2.setText(data[step+2]);
                        //r2.setChecked(false);
                        RadioButton r3= findViewById(R.id.r3);
                        r3.setText(data[step+3]);
                        //r3.setChecked(false);
                        RadioGroup rg = findViewById(R.id.radioGroup);
                        rg.clearCheck();

                        score = score + sc[i];
                        String scorefortext = String.valueOf(score);

                        i=i+1;
                    }



                }
                else if(i==9){
                    String str;
                    score = score + sc[i];
                    String scoretext = String.valueOf(score);
                    String about;
                    if(score<=15){
                        about= "Personality is what really matters. Just a little bit of changes can make you a great person";
                    }
                    else if(score<25){
                        about="Personality is a mask you believe in.Be the way you are.Your attitude is a mirror of you personality ";
                    }
                    else{
                        about="Beauty of a person is temporary. But personality is permanent and you have that.";
                    }
                    if(r1.isChecked()==false && r2.isChecked()==false && r3.isChecked()==false){
                        Toast.makeText(MainActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        layoutInflater =(LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.test,null);
                        popupWindow =new PopupWindow(container,800,800,true);
                        TextView poptext = popupWindow.getContentView().findViewById(R.id.textView2);
                        poptext.setText("You have scored \n "+scoretext+" out of 30"+"\n \n"+about);
                        popupWindow.showAtLocation(constraintLayout, Gravity.NO_GRAVITY,150,600);
                        Button fin = findViewById(R.id.button);
                        fin.setVisibility(View.INVISIBLE);
                        
                    }




                }
                else{
                    RadioButton r1= findViewById(R.id.r1);
                    RadioButton r2= findViewById(R.id.r2);
                    RadioButton r3= findViewById(R.id.r3);
                    if(r1.isChecked()==false && r2.isChecked()==false && r3.isChecked()==false){
                        Toast.makeText(MainActivity.this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        step=step+4;
                        TextView ques =findViewById(R.id.question);
                        ques.setText(data[step]);

                        r1.setText(data[step+1]);

                        r2.setText(data[step+2]);

                        r3.setText(data[step+3]);

                        RadioGroup rg = findViewById(R.id.radioGroup);
                        rg.clearCheck();

                        score = score + sc[i];
                        String scorefortext = String.valueOf(score);

                        i=i+1;
                    }


                }



            }
        });
    }
}