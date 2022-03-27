import NetWork.DataBaseChallenges;

import static NetWork.DataBaseChallenges.showDailyTasks;


public class App {
    public static void main(String[] args) throws InterruptedException {
        DataBaseChallenges.showDailyTasks();
        DataBaseChallenges.deleteDailyTasks(3);
        System.out.println("\n");
        DataBaseChallenges.showDailyTasks();
    }
}
