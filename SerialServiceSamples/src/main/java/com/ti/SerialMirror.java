package com.ti;

import com.ti.command.AbstractCommand;

public class SerialMirror {
    public static void main(String[] args) {
        SerialService<AbstractCommand,AbstractCommand> service = new SerialService<>();
    }
}
