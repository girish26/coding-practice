package com.gk.designpatterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler2 implements Observer {
    private String resp;
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String){
            resp = arg.toString();
            System.out.println("Received response in handler2: "+resp);
        }
    }
}
