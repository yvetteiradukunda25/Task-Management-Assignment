public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
       //manager is an object of a class TaskManager
        try {
            System.out.println("Added tasks:");
            manager.addTask("Go to Market");
            manager.addTask("Learning Python and java");
            manager.addTask("Do some exxercises");
            manager.addTask("Pay electricity bill online");
            manager.addTask("Plan weekend trip");
            manager.addTask("Plan weekend trip");

            System.out.println(manager.getAllTasks());

            manager.sortTasks();
            System.out.println("Sorted Tasks: " + manager.getAllTasks());

            try { //try any task initialized before and see if you find the task
                System.out.println("Found 'Learning Python and java' at index: " + manager.searchTask("Learning Python and java"));
                manager.searchTask("Study python"); //try any
                // Will throw TaskNotFoundException because 'study python' is not one of the tasks listed,
            } catch (TaskNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }

            try {manager.removeTask("Go to Market"); // after removing the task, all tasks remains will be displayed
                System.out.println("Tasks after removal: " + manager.getAllTasks());
                manager.removeTask("Clean room"); // Will throw TaskNotFoundException
            } catch (TaskNotFoundException e) {System.err.println("Error: " + e.getMessage());
            }
            System.out.println("\nLongest Task: " + manager.findLongestTask());

            try {System.out.println("Task at index 0: " + manager.getTaskByIndex(0));
                manager.getTaskByIndex(3);
                // manager.getTaskByIndex(5); Will throw IndexOutOfBoundsException
                // because it is invalid index, try to be one of the tasks above and check
            } catch (IndexOutOfBoundsException e) {System.err.println("Error: " + e.getMessage());
            }

            // Testing invalid inputs
            try {
                manager.addTask(null);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
            try {
                manager.searchTask("Plan weekend trip");
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
                
            }
            try {
                manager.getTaskByIndex(-1);
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } finally {System.out.println("All operations complete.");
        }
    }
}