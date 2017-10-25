package com.ti.comm.sawSerial;

import com.ti.checkers.CommandSplittable;
import com.ti.checkers.ProtocolCheckable;
import com.ti.command.AbstractCommand;
import com.ti.protocol.AbstractProtocol;

import java.nio.ByteBuffer;

public class SawProtocol extends AbstractProtocol<AbstractCommand, AbstractCommand> {

    public SawProtocol(ProtocolCheckable protocolChecker, CommandSplittable commandSplitter){
        super(protocolChecker, commandSplitter);
    }

    @Override
    public ByteBuffer createResponseToByte(AbstractCommand command) {
        return command.createByteBuffer();
    }

    @Override
    public AbstractCommand createByteToRequest(ByteBuffer buffer) {
        return new SawCommand().parseByteBuffer(buffer);
    }
}
