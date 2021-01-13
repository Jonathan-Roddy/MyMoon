package com.mad.mymoon.ui.AR;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ARViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ARViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the AR fragment \n This is a Test Page");
    }

    public LiveData<String> getText() {
        return mText;
    }
}