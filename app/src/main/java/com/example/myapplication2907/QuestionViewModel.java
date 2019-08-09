package com.example.myapplication2907;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private int numberQuestion = 0;
    private Repository repository;
    private MutableLiveData<Question> question;
    private MutableLiveData<String> result;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
        repository.initQuestions(application);
        question = new MutableLiveData<>();
        question.setValue(repository.getDb().questions.get(numberQuestion));
        result = new MutableLiveData<>();
    }

    public MutableLiveData<Question> getQuestion() {
        return question;
    }

    MutableLiveData<String> getResult() {
        return result;
    }

    void nextQuestion() {
        numberQuestion++;
        if (numberQuestion < repository.getDb().questions.size()) {
            question.setValue(repository.getDb().questions.get(numberQuestion));
        } else {
            result.setValue(Calculate.firstReligion(Calculate.totalAnswer));
        }

    }

    void processAnswer(List<Integer> answerVector) {
        Calculate.totalAnswer = Calculate.sum(Calculate.totalAnswer, answerVector);
        System.out.println(Calculate.totalAnswer);
    }

}
