package com.ti;

import com.ti.command.AbstractCommand;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SerialMirror extends Application{
    private static final String SCENE_XML = "SamplePanel.fxml";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Настраиваем  порт в файле properties, указывает название файла
        PropertiesService.setGlobalPropertyFileName(SerialMirror.class.getSimpleName());

        FXMLLoader loader =  new FXMLLoader(this.getClass().getResource(SCENE_XML));
        BorderPane root = loader.load();
        Scene scene = new Scene(root,600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        SamplePanel viewController = loader.getController();
        // Настройка Serial сервиса
        SerialService<AbstractCommand,AbstractCommand> service = new SerialService<>();
        SampleProtocol protocol = new SampleProtocol();
        SampleController controller = new SampleController();
        service.setProtocol(protocol);
        service.addController(controller);
        //Линкуем Serial сервис с обработчиком SignalManager
        SignalManager manager =  new SignalManager();
        controller.setViewController(manager);
        manager.setDeviceController(controller);

        viewController.setProperties(manager.iProperty, manager.jProperty);

        manager.runSendService();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
        System.exit(0);
    }
}
