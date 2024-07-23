package view.commands;

import view.ConsoleUI;

public class SetFather extends Command{
    public SetFather(ConsoleUI consoleUI) {
        super("Добавить отца", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setFather();
    }
}