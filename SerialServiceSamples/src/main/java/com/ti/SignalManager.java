package com.ti;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SignalManager implements SampleViewInterface,Runnable {
    SampleDeviceInterface device;
    int forSend = 0;

    IntegerProperty iProperty =  new SimpleIntegerProperty(0);
    IntegerProperty jProperty =  new SimpleIntegerProperty(0);

    void runSendService(){
        Executors.newSingleThreadScheduledExecutor().
                scheduleWithFixedDelay(this, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

    @Override
    public void setDeviceController(SampleDeviceInterface device) {
        this.device = device;
    }

    @Override
    public void process(int i, int j) {
        iProperty.setValue(i);
        jProperty.setValue(j);
    }

    @Override
    public void run() {
        device.send(forSend, forSend);
        forSend++;
    }
}
