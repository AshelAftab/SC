import java.io.File;
import java.util.Scanner;


public class SettingsLoader {
    public Settings load(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) return null;
        UserType userType = UserType.REGULAR;
        PaymentType paymentType = PaymentType.CASH;
        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (line.startsWith("U")) {
                    String val = line.substring(2).trim();
                    if (val.equals("1")) userType = UserType.REGULAR;
                    else if (val.equals("2")) userType = UserType.PREMIUM;
                    else if (val.equals("3")) userType = UserType.VIP;
                } else if (line.startsWith("P")) {
                    String val = line.substring(2).trim().toUpperCase();
                    try { paymentType = PaymentType.valueOf(val); } catch (Exception e) { }
                }
            }
        } catch (Exception ex) {
            System.out.println("Settings not loaded: " + ex.getMessage());
        }
        return new Settings(userType, paymentType);
    }
}