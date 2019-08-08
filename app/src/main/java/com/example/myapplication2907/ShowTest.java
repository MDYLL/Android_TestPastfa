package com.example.myapplication2907;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ShowTest extends Activity {

    public Context context;
    public ShowTest(Context context) {
        this.context=context;
    }

    /*public void showQuestion(String key){
        TextView textView=(TextView)((Activity) context).findViewById(R.id.tv_question);
        textView.setText(key);
        LinearLayout layout=(LinearLayout)((Activity) context).findViewById(R.id.questionsLayout);
        layout.removeAllViews();
        RadioGroup rg=questionList.get(key);
        rg.setOrientation(LinearLayout.VERTICAL);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb=(RadioButton) ((Activity) context).findViewById(radioGroup.getCheckedRadioButtonId());
                System.out.println(answerList.get(rb.getId()));
                for (int i = 0; i< countReligions.size(); i++){
                    countReligions.set(i,countReligions.get(i)+answerList.get(rb.getId()).get(i));
                }
                if(keyCounter<questionList.size()) {
                    keyCounter++;
                    if(keyCounter<questionList.size()) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showQuestion(keys.get(keyCounter));// showing the next question.
                            }
                        }, 1000L);
                    }
                    else{
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                LinearLayout layout=(LinearLayout)((Activity) context).findViewById(R.id.questionsLayout);
                                layout.removeAllViews();
                                TextView textView=(TextView)((Activity) context).findViewById(R.id.tv_question);
                                String answercountReligions=Calculate.firstReligion(countReligions);
                                Integer percentcountReligions=Calculate.percentReligion(countReligions);
                                textView.setText(answercountReligions+" "+Integer.toString(percentcountReligions)+" %");
                            }
                        }, 1000L);

                        return;
                    }
                }

            }
        });
        layout.addView(rg);
    }*/
}
