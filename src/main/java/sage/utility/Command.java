package sage.utility;

public class Command {
    private String[] rawOutput;
    private String taskType;
    private String taskDescription;
    private String by = null;
    private String from = null;
    private String to = null;

    public Command(String input) {
        this.rawOutput = input.split("/");
        String[] body = rawOutput[0].split(" ", 2);
        this.taskType = body[0].toLowerCase();
        if (body.length > 1) {
            this.taskDescription = body[1];
        }

        for (String i : rawOutput) {
            String[] line = i.split(" ", 2);
            String field = line.length > 1 ? line[1].trim() : null;
            switch (line[0]) {
            case "by":
                this.by = field;
                break;
            case "from":
                this.from = field;
                break;
            case "to":
                this.to = field;
                break;
            }
        }

    }

    public String getTaskType() {
        return taskType;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getBy() {
        return by;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
