package com.ti;

import com.ti.command.AbstractCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum SampleCommandType implements CommandTypable {
    OK((byte)0x00, 8),
    NO((byte)0x01, 8);
    public byte syncByte;
    public int commandSize;

    SampleCommandType(byte b, int size) {
        syncByte = b;
        commandSize = size;
    }

    @Override @Deprecated
    public boolean check(byte head) {
        return false;
    }
    @Deprecated @Override
    public byte getHeadByte() {
        return 0;
    }

    @Deprecated @Override
    public int getCommandSize() {
        return 0;
    }

    @Deprecated @Override
    public Map<Byte,Integer> getCommandSizeMap(){
        return null;
    }

    @Override
    public AbstractCommand getCommand() {
        return null;
    }

    @Override
    public boolean equalCommand(AbstractCommand command) {
        return false;
    }
}
