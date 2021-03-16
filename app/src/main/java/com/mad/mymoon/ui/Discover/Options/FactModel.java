package com.mad.mymoon.ui.Discover.Options;

public class FactModel {
    private String fact;
//    private Button voice;

    @Override
    public String toString() {
        return "FactModel{" +
                "fact='" + fact + '\'' +
//                ", voice=" + voice +
                '}';
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

//    public Button getVoice() {
//        return voice;
//    }

//    public void setVoice(Button voice) {
//        this.voice = voice;
//    }

    public FactModel(String fact) {
        this.fact = fact;
//        this.voice = voice;
    }
}
