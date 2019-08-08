package com.example.myapplication2907;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class QuestionViewModel extends AndroidViewModel {

    private int numberQuestion=0;
    private Repository repository;
    private MutableLiveData<Question> question;
    public QuestionViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository();
        repository.initQuestions(application);
        question=new MutableLiveData<>();
        question.setValue(repository.getDb().questions.get(numberQuestion));
    }
    public MutableLiveData<Question> getQuestion() {
        return question;
    }
    public void nextQuestion(){
        numberQuestion++;
        question.setValue(repository.getDb().questions.get(numberQuestion));
    }

    public int getNumberOfQuestion(){
        return numberQuestion;
    }
}
