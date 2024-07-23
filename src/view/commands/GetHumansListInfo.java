package view.commands;

import view.ConsoleUI;

public class GetHumansListInfo extends Command {
    public GetHumansListInfo(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getHumansListInfo();
    }
}