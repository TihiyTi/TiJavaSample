package com.ti;

import com.ti.checkers.SawSynchroByteProtocolChecker;
import com.ti.comm.sawSerial.SawController;
import com.ti.comm.sawSerial.SawProtocol;
import com.ti.command.AbstractCommand;

public class Sample1 {
    public static void main(String[] args) {
        PropertiesService.setGlobalPropertyFileName(SerialMirror.class.getSimpleName());
        // Настройка Serial сервиса
        SerialService<AbstractCommand,AbstractCommand> service = new SerialService<>();
        SawSynchroByteProtocolChecker checker = new SawSynchroByteProtocolChecker(24);
        SawProtocol protocol =  new SawProtocol(checker, checker);
        SawController controller = new SawController();
        service.setProtocol(protocol);
        service.addController(controller);

        //Линкуем Serial сервис с обработчиком SignalManager

//        viewController.setProperties(manager.iProperty, manager.jProperty);

        controller.runSendService();
    }
}
