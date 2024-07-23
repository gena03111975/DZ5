package view.commands;

import view.ConsoleUI;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super("Добавить ребенка к матери/отцу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}