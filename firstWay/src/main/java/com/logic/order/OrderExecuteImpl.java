package com.logic.order;

public class OrderExecuteImpl {
    public static void execute(Terminal terminal) {
        //System.out.print(OrderUtil.location);
        if (terminal.getArgument() != null) {
            ArgumentUtil.execute(terminal.getCommand(), terminal.getOption(), terminal.getArgument());
        } else if (terminal.getOption() != null) {
            OptionUtil.execute(terminal.getCommand(), terminal.getOption());
        } else {
            CommandUtil.execute(terminal.getCommand());
        }
    }
}