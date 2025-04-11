public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            System.out.println("--- Task Manager ---");

            manager.addTask("Buy milk");
            manager.addTask("Study Java");
            manager.addTask("Exercise");

            System.out.println("\nAll Tasks: " + manager.getAllTasks());

            manager.sortTasks();
            System.out.println("Sorted Tasks: " + manager.getAllTasks());

            try {
                System.out.println("Found 'Study Java' at index: " + manager.searchTask("Study Java"));
                manager.searchTask("Read a book"); // Will throw TaskNotFoundException
            } catch (TaskNotFoundException e) {
                System.err.println("Search Error: " + e.getMessage());
            }

            try {
                manager.removeTask("Buy milk");
                System.out.println("Tasks after removal: " + manager.getAllTasks());
                manager.removeTask("Clean room"); // Will throw TaskNotFoundException
            } catch (TaskNotFoundException e) {
                System.err.println("Remove Error: " + e.getMessage());
            }

            System.out.println("\nLongest Task: " + manager.findLongestTask());

            try {
                System.out.println("Task at index 0: " + manager.getTaskByIndex(0));
                manager.getTaskByIndex(5); // Will throw IndexOutOfBoundsException
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index Error: " + e.getMessage());
            }

            // Testing invalid inputs
            System.out.println("\n--- Invalid Input Tests ---");
            try {
                manager.addTask(null);
            } catch (IllegalArgumentException e) {
                System.err.println("Add Error: " + e.getMessage());
            }
            try {
                manager.searchTask("");
            } catch (IllegalArgumentException e) {
                System.err.println("Search Error: " + e.getMessage());
            } catch (TaskNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                manager.removeTask("  ");
            } catch (IllegalArgumentException e) {
                System.err.println("Remove Error: " + e.getMessage());
            } catch (TaskNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                manager.getTaskByIndex(-1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Index Error: " + e.getMessage());
            }

        } finally {
            System.out.println("\n--- Finally Block ---");
            System.out.println("Task Manager operations complete.");
        }
    }
}