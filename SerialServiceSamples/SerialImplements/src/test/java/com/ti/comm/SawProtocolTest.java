package com.ti.comm;

import com.ti.PropertiesService;
import com.ti.SerialService;
import com.ti.checkers.SawSynchroByteProtocolChecker;
import com.ti.comm.sawSerial.SawController;
import com.ti.comm.sawSerial.SawProtocol;
import com.ti.command.AbstractCommand;
import org.junit.Assert;
import org.junit.Test;

public class SawProtocolTest {
    @Test(timeout = 30000)
    public void sawProtocolTest(){
        PropertiesService.setGlobalPropertyFileName(SawProtocolTest.class.getSimpleName());
        SerialService<AbstractCommand,AbstractCommand> service = new SerialService<>();
        SawSynchroByteProtocolChecker checker =  new SawSynchroByteProtocolChecker(24);
        SawProtocol protocol = new SawProtocol(checker, checker);
        SawController controller =  new SawController();

        service.setProtocol(protocol);
        service.addController(controller);

        controller.send();
        controller.send();
        controller.send();
        controller.send();
        while(controller.data.size() < 24);
        Assert.assertArrayEquals(controller.data.stream().mapToInt(i -> i).toArray(), new int[]{1,2,0,1,2,0, 1,2,0,1,2,0, 1,2,0,1,2,0, 1,2,0,1,2,0});
        for (int i = 0; i < 10000; i++) {
            controller.send();
        }
        while(controller.data.size() < 60024);
        Assert.assertEquals(controller.data.size(), 60024);
    }
}
