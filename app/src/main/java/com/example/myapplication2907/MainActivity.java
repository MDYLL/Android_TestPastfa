package com.example.myapplication2907;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2907.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectedAnswer {

    private QuestionViewModel viewModel;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        viewModel.getQuestion().observe(this, new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                List<Answer> answerList = question.a;
                System.out.println(answerList.get(0).title);
                binding.setQuestion(question);
                adapter.setmAnswerList(answerList);
                adapter.notifyDataSetChanged();
                Log.d("MainActivity", question.q);

            }
        });

        //int numberOfQuestion=viewModel.getNumberOfQuestion();
        adapter = new MyRecyclerViewAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        binding.recyclerView.setItemAnimator(itemAnimator);

    }

    @Override
    public void answerSelected(Answer answer) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                viewModel.nextQuestion();
            }
        }, 1000L);

    }
}


