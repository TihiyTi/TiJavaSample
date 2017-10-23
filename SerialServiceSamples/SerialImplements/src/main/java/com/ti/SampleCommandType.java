package com.ti;

import com.ti.command.AbstractCommand;
import com.ti.command.DataCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum SampleCommandType implements CommandTypable {
    OK((byte)0x00, 8),
    NO((byte)0x01, 8),
    DATA((byte)0x02, 8){
        @Override
        public AbstractCommand getCommand(){return  new DataCommand<>(this);}
    };
    public byte syncByte;
    public int commandSize;

    SampleCommandType(byte b, int size) {
        syncByte = b;
        commandSize = size;
    }

    //todo выпилить методы после удаления методов из библиотеки
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
        return command.is() == this;
    }
}
