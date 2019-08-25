package pers.vay.designpattern.action.command.after.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand extends AbstractCommand {

    List<AbstractCommand> commands = new ArrayList<>();

    @Override
    public void execute() {
        for (AbstractCommand command : commands) {
            command.execute();
        }
    }

    public void addCommand(AbstractCommand command) {
        this.commands.add(command);
    }

}
