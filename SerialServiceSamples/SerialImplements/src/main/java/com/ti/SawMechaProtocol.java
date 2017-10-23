package com.ti;

import com.ti.checkers.CommandSplittable;
import com.ti.checkers.ProtocolCheckable;
import com.ti.command.AbstractCommand;
import com.ti.command.MechaCommand;
import com.ti.protocol.AbstractProtocol;

import java.nio.ByteBuffer;

public class SawMechaProtocol  extends AbstractProtocol<AbstractCommand, AbstractCommand> {

    public SawMechaProtocol(ProtocolCheckable protocolChecker, CommandSplittable commandSplitter){
        super(protocolChecker, commandSplitter);
    }

    @Override
    public ByteBuffer createResponseToByte(AbstractCommand command) {
        return command.createByteBuffer();
    }

    @Override
    public AbstractCommand createByteToRequest(ByteBuffer buffer) {
        return new MechaCommand().parseByteBuffer(buffer);
    }
}
