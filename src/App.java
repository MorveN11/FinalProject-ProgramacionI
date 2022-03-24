import NetWork.DataBaseData;

public class App {
    public static void main(String[] args) {
        DataBaseData.verifyData();
        System.out.println(DataBaseData.isRepeated("Manu11", "UserName"));
    }
}
