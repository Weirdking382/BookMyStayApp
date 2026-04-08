import java.util.regex.*;

public class Main {

    static boolean isValidTrainId(String trainId) {
        Pattern pattern = Pattern.compile("^TRN-\\d{4}$");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    static boolean isValidCargoCode(String cargo) {
        Pattern pattern = Pattern.compile("^[A-Z]{3,10}$");
        Matcher matcher = pattern.matcher(cargo);
        return matcher.matches();
    }

    public static void main(String[] args) {

        String trainId1 = "TRN-1234";
        String trainId2 = "TRAIN12";

        String cargo1 = "COAL";
        String cargo2 = "oil123";

        System.out.println("Train ID " + trainId1 + " valid: " + isValidTrainId(trainId1));
        System.out.println("Train ID " + trainId2 + " valid: " + isValidTrainId(trainId2));

        System.out.println("Cargo " + cargo1 + " valid: " + isValidCargoCode(cargo1));
        System.out.println("Cargo " + cargo2 + " valid: " + isValidCargoCode(cargo2));
    }
}