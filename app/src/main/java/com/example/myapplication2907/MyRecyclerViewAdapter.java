package com.example.myapplication2907;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Answer> mAnswerList;
    private SelectedAnswer listener;

    MyRecyclerViewAdapter(SelectedAnswer listener) {
        this.listener = listener;
    }

    void setmAnswerList(List<Answer> answerList) {
        mAnswerList = answerList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRecyclerViewAdapter.MyViewHolder holder, final int position) {
        final Answer answer = mAnswerList.get(position);
        Log.d("holder", answer.title);
        holder.currentAnswer.setText(answer.title);
        holder.currentAnswer.setChecked(false);
        holder.currentAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("answer ", String.valueOf(position));
                listener.answerSelected(answer);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAnswerList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private RadioButton currentAnswer;

        MyViewHolder(View itemView) {
            super(itemView);
            currentAnswer = itemView.findViewById(R.id.answer);

        }


    }
}
