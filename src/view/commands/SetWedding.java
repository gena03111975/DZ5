package view.commands;

import view.ConsoleUI;

public class SetWedding extends Command{
    public SetWedding(ConsoleUI consoleUI) {
        super("Организовать свадьбу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setWedding();
    }
}