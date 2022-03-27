import NetWork.DataBaseChallenges;
import User.Customer;

import java.util.Arrays;

import static NetWork.DataBaseChallenges.showDailyTasks;


public class App {
    public static void main(String[] args) throws InterruptedException {
        DataBaseChallenges.getWeeklyTasks();
        DataBaseChallenges.saveUsersWeeklyTasks();
        DataBaseChallenges.sendWeeklyTasks();

    }
}
