package view.commands;

import view.ConsoleUI;

public class GetHumanAge extends Command {
    public GetHumanAge(ConsoleUI consoleUI) {
        super("Показать возраст человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAge();
    }
}