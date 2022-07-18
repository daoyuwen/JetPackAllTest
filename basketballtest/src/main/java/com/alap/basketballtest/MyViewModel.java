package com.alap.basketballtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> number;
    private MutableLiveData<Integer> numberTwo;


    int a,b;

    public MutableLiveData<Integer> getNumber() {
        if (number==null){
            number=new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public MutableLiveData<Integer> getNumberTwo() {
        if (numberTwo==null){
            numberTwo=new MutableLiveData<>();
            numberTwo.setValue(0);
        }
        return numberTwo;
    }




    public void addOne(int p) {
        a = number.getValue();
        b = number.getValue();
        number.setValue(number.getValue() + p);
    }

    public void upOne(int p) {
        a = number.getValue();
        b = number.getValue();
        numberTwo.setValue(numberTwo.getValue() + p);
    }




    public void reset(){
        a = number.getValue();
        b = number.getValue();
        number.setValue(0);
        numberTwo.setValue(0);
    }



    public void undo(){
        number.setValue(a);
        numberTwo.setValue(b);

    }

}
