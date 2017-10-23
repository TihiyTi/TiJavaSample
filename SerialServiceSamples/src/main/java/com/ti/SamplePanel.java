package com.ti;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.TextField;

public class SamplePanel {

    public TextField i;
    public TextField j;

    public void setProperties(IntegerProperty propertyI, IntegerProperty propertyJ){
        propertyI.addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> i.setText(String.valueOf(newValue.intValue())));
        });
        propertyJ.addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> j.setText(String.valueOf(newValue.intValue())));
        });
    }
}
