package com.mad.mymoon.ui.Phases;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PhasesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PhasesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Moon Phase fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}