package view.commands;

import view.ConsoleUI;

public class SetDateOfDeath extends Command {
    public SetDateOfDeath(ConsoleUI consoleUI) {
        super("Указать дату смерти человека", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setDateOfDeath();
    }
}