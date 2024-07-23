package view.commands;

import view.ConsoleUI;

public class SetMother extends Command{
    public SetMother(ConsoleUI consoleUI) {
        super("Добавить маму", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setMother();
    }
}