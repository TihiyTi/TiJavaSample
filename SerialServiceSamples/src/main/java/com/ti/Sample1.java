package com.ti;

import com.ti.checkers.SawSynchroByteProtocolChecker;
import com.ti.command.AbstractCommand;

public class Sample1 {
    public static void main(String[] args) {
        PropertiesService.setGlobalPropertyFileName(SerialMirror.class.getSimpleName());
        // Настройка Serial сервиса
        SerialService<AbstractCommand,AbstractCommand> service = new SerialService<>();
        SawSynchroByteProtocolChecker checker = new SawSynchroByteProtocolChecker(24);
        SawMechaProtocol protocol =  new SawMechaProtocol(checker, checker);
        MechaController controller = new MechaController();
        service.setProtocol(protocol);
        service.addController(controller);

        //Линкуем Serial сервис с обработчиком SignalManager

//        viewController.setProperties(manager.iProperty, manager.jProperty);

        controller.runSendService();
    }
}
