package com.ti;

import com.ti.command.AbstractCommand;
import com.ti.command.MechaCommand;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MechaController extends AbstractSerialController implements Runnable{
    @Override
    public void serviceRequest(AbstractCommand command) {
        MechaCommand mechaCommand = (MechaCommand) command;
        System.out.println("READ");
//        System.out.println("reo1 = "+mechaCommand.getReo_1());
//        System.out.println("reo2 = "+mechaCommand.getReo_2());
//        System.out.println("ecg1 = "+mechaCommand.getEcg_1());
//        System.out.println("ecg2 = "+mechaCommand.getEcg_2());
//        System.out.println("control1 = "+mechaCommand.getCurrentControl_1());
//        System.out.println("control2 = "+mechaCommand.getCurrentControl_2());
    }

    public void send(){
        toServiceResponse(new MechaCommand(1, 2, 0, 1, 2, 0));
    }

    @Override
    public void run() {
        System.out.println("Send");
        send();
    }
    void runSendService(){
        Executors.newSingleThreadScheduledExecutor().
                scheduleWithFixedDelay(this, 0L, 2000L, TimeUnit.MILLISECONDS);
    }
}
