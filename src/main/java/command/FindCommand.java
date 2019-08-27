package command;

import exception.FindException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

import java.util.ArrayList;

/**
 * Command for finding query in TaskList.
 */
public class FindCommand extends Command {

    protected String[] input;

    public FindCommand(String[] input) {
        this.input = input;
    }

    /**
     * execute command for finding query in user's tasks list.
     * @param tasks a TaskList.
     * @param ui User Interface for output printing.
     * @param storage hard disk storage.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws FindException {
        if (input.length <= 1) {
            throw new FindException();
        } else {
            ArrayList<Task> resultList = new ArrayList<Task>();
            for (Task task : tasks.getTaskList()) {
                String[] result = task.toString().split(" ");
                for (String s : result) {
                    if (s.equals(input[1])) {
                        resultList.add(task);
                        break;
                    }
                }
            }

            if (resultList.isEmpty()) {
                ui.println("There are no matching tasks in your list");
            } else {
                ui.println("Here are the matching tasks in your list:");
                int i = 1;
                for (Task task : resultList) {
                    ui.println(i + "." + task.toString());
                    i++;
                }
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}