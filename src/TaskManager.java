import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//thi is a custom exception,
// it indicates when a search/removal operation fails because the task doesn't exist.
class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
// our class is called TaskManager
class TaskManager {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty.");
        }
        tasks.add(task.trim());
        System.out.println("Added: " + task.trim());
    }

    public List<String> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void sortTasks() {
        Collections.sort(tasks);
        System.out.println("Tasks are already sorted.");
    }

    public int searchTask(String task) throws TaskNotFoundException {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be empty.");
        }
        int index = tasks.indexOf(task.trim());
        if (index == -1) {
            throw new TaskNotFoundException("Task '" + task.trim() + "' not found.");
        }
        return index;
    }

    public void removeTask(String task) throws TaskNotFoundException {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task to remove cannot be empty.");
        }
        if (!tasks.remove(task.trim())) {
            throw new TaskNotFoundException("Task '" + task.trim() + "' not found for removal.");
        }
        System.out.println("Removed: " + task.trim());
    }

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

    public String getTaskByIndex(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return tasks.get(index);
    }
}