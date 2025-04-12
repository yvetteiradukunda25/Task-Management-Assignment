public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
       //manager is an object of a class TaskManager
        //try and catch, Used to catch IllegalArgumentException, TaskNotFoundException
        try {
            System.out.println("Added tasks:");
            manager.addTask("Go to Market");
            manager.addTask("Learning Python and java");
            manager.addTask("Do some school assignment");
            manager.addTask("Pay electricity bill online");
            manager.addTask("Plan weekend trip");
            manager.addTask("Do body exercises at evening");

            System.out.println(manager.getAllTasks());

            manager.sortTasks();
            System.out.println("\nSorted Tasks: " + manager.getAllTasks());

            try { //try any task initialized before and see if you find the task
                System.out.println("\nFound 'Learning Python and java' at index: " + manager.searchTask("Learning Python and java"));
                manager.searchTask("Study python"); //try any
                // Will throw TaskNotFoundException because 'study python' is not one of the tasks listed,
            } catch (TaskNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }

            try {manager.removeTask("Go to Market"); // after removing the task, all tasks remains will be displayed
                System.out.println("Tasks after removal: " + manager.getAllTasks());
                manager.removeTask("Clean room");
                // This will throw TaskNotFoundException because no 'clean room' task we have
            } catch (TaskNotFoundException e) {System.err.println("Error: " + e.getMessage());
            }
            System.out.println("\nLongest Task: " + manager.findLongestTask());

            try {System.out.println("Task at index 0: " + manager.getTaskByIndex(1));
                manager.getTaskByIndex(3);
                // manager.getTaskByIndex(3); Will throw IndexOutOfBoundsException
                // because we want task on index 1
            } catch (IndexOutOfBoundsException e) {System.err.println("Error: " + e.getMessage());
            }

            // Testing invalid inputs
            try {
                manager.addTask(null);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
            try {
                manager.searchTask(" ");
            } catch (IllegalArgumentException e) {
                System.err.println("Error:" + e.getMessage());
            } catch (TaskNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                manager.removeTask("");
            } catch (IllegalArgumentException e) {
                System.err.println("Error:" + e.getMessage());
            } catch (TaskNotFoundException e) {
                
            }
            try {
                manager.getTaskByIndex(-1); //it will throw IndexOutOfBoundsException because index is < 0
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error: " + e.getMessage());
            }
           //Finally block used to print a final message
        } finally {System.out.println("All operations complete.");
        }
    }
}