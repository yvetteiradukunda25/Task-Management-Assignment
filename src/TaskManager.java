import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//TaskNotFoundException is a custom exception,
// it indicates when a search/removal operation fails because the task doesn't exist.
class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
// our class is called TaskManager
class TaskManager {
    private List<String> tasks = new ArrayList<>();
    //this is a method add tasks
    public void addTask(String task) {
        //.trim().isEmpty() is a method handles cases where the user enters only whitespace or a null string as a task.

        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty."); // put a task to check
        }
        tasks.add(task.trim()); //.trim() is a method used to remove whitespace
        System.out.println(task.trim());
    }

    public List<String> getAllTasks() {

        return new ArrayList<>(tasks);
    }
       //this is a method to sort to tasks
    public void sortTasks() {
        Collections.sort(tasks);
    }
          //this is a method to search for a specific tasks
    public int searchTask(String task) throws TaskNotFoundException {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("This cannot be empty.");
        }
        int index = tasks.indexOf(task.trim()); // if the task is found, it will also display its index
        if (index == -1) {
            throw new TaskNotFoundException("Task '" + task.trim() + "' not found.");
        }
        return index;
    }
          //this is the method to remove task from others
    public void removeTask(String task) throws TaskNotFoundException {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("removal cannot be empty.");
        }
        if (!tasks.remove(task.trim())) {
            throw new TaskNotFoundException("Task '" + task.trim() + "' not found for removal.");
        }
         System.out.println("Removed: " + task.trim());
    }
       //this is method finds the longest task but if the task is empty, an error will be displayed
    public String findLongestTask() {
        if (tasks.isEmpty()) return null;
        String longest = "";
        for (String task : tasks) {
            if (task.length() > longest.length()) {
                longest = task;
            }
        }
        return longest;
    }
    // this is a method to get element by index but if index is less to zero or
    // index is greater or equal to the size of tasks, error will be displayed.
    public String getTaskByIndex(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return tasks.get(index);
    }
}