public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            manager.addTask("Go to Market");
            manager.addTask("Learning Python and java");
            manager.addTask("Do some exxercises");
            manager.addTask("Pay electricity bill online");
            manager.addTask("Plan weekend trip");
            manager.addTask("Plan weekend trip");

            System.out.println(manager.getAllTasks());

            manager.sortTasks();
            System.out.println("Sorted Tasks: " + manager.getAllTasks());

            try {
                System.out.println("Found 'Learning Python and java' at index: " + manager.searchTask("Study Java"));
                manager.searchTask("Read a book");
                // Will throw TaskNotFoundException
            } catch (TaskNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }

            try {
                manager.removeTask("Go to Market");
                System.out.println("Tasks after removal: " + manager.getAllTasks());
                manager.removeTask("Clean room"); // Will throw TaskNotFoundException
            } catch (TaskNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("\nLongest Task: " + manager.findLongestTask());

            try {
                System.out.println("Task at index 0: " + manager.getTaskByIndex(0));
                manager.getTaskByIndex(5);
                // manager.getTaskByIndex(5); Will throw IndexOutOfBoundsException
                // because it is invalid index
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }

            // Testing invalid inputs
            try {
                manager.addTask(null);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
            try {
                manager.searchTask("");
            } catch (IllegalArgumentException e) {
                System.err.println("Error:" + e.getMessage());
            } catch (TaskNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                manager.removeTask("Go to Market ");
            } catch (IllegalArgumentException e) {
                System.err.println("Error:" + e.getMessage());
            } catch (TaskNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                manager.getTaskByIndex(-1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } finally {
            System.out.println("All operations complete.");
        }
    }
}