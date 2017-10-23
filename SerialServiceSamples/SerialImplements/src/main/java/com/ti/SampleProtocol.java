package com.ti;

import com.ti.checkers.CommandSplittable;
import com.ti.checkers.ProtocolCheckable;
import com.ti.protocol.AbstractCommandProtocol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SampleProtocol extends AbstractCommandProtocol<SampleCommandType>{

    public SampleProtocol() {
        Map<Byte,Integer> map = new HashMap<>();
        Arrays.asList(SampleCommandType.values()).forEach(x->map.put(x.syncByte,x.commandSize));
        setCommandMap(map);
        fillSetOfCommandType(SampleCommandType.values());
    }

    public SampleProtocol(ProtocolCheckable protocolChecker, CommandSplittable commandSplitter){
        super(protocolChecker, commandSplitter);
    }
}
