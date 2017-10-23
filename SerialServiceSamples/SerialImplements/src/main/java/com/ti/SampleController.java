package com.ti;

import com.ti.command.AbstractCommand;
import com.ti.command.DataCommand;

public class SampleController extends AbstractSerialController implements SampleDeviceInterface {
    private SampleViewInterface viewController;
    @Override
    public void setViewController(SampleViewInterface controller) {
        viewController = controller;
    }


    @Override
    public void serviceRequest(AbstractCommand command) {
        //todo equalCommand функционал вынести из XxxCommandType в AbstractCommand
        if(SampleCommandType.DATA.equalCommand(command)){
            int i = ((DataCommand)command).getReo();
            int j = ((DataCommand)command).getMio();
            viewController.process(i,j);
        }
    }

    @Override
    public void send(int i, int j) {
        toServiceResponse(new DataCommand<>(SampleCommandType.DATA, i, j));
    }
}
