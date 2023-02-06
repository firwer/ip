import java.util.Scanner;

public class Sage {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Display ui = new Display();
        Scanner input = new Scanner(System.in);
        ui.welcomeUser();
        while (input.hasNextLine()) {
            Command command = new Command(input.nextLine());
            switch (command.getTaskType()) {
            case "bye":
                ui.goodByeUser();
                return;
            case "list":
                taskList.listTask();
                break;
            case "unmark":
                taskList.unmarkTask(command.getTaskDescription());
                break;
            case "mark":
                taskList.markTask(command.getTaskDescription());
                break;
            case "todo":
                taskList.addTask(command.getTaskDescription());
                break;
            case "deadline":
                taskList.addTask(command.getTaskDescription(), command.getBy());
                break;
            case "event":
                taskList.addTask(command.getTaskDescription(), command.getFrom(), command.getTo());
                break;
            default:
                ui.unknownInput();
                break;
            }
        }
    }
}
