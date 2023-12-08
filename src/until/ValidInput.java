package until;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidInput {

	public static int getValidInteger(Scanner scanner, String prompt) {
        int number = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                isValid = true; // Nếu chuyển đổi thành công, thoát khỏi vòng lặp
            } catch (NumberFormatException e) {
                System.out.println("Đây không phải là một số  hợp lệ. Vui lòng nhập lại.");
            }
        }

        return number;
    }
	public static float getValidFloat(Scanner scanner, String prompt) {
        float number = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                number = Float.parseFloat(input);
                isValid = true; // Nếu chuyển đổi thành công, thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Đây không phải là một số  hợp lệ. Vui lòng nhập lại.");
            }
        }

        return number;
    }
	public static Double getValidDouble(Scanner scanner, String prompt) {
        Double number = 0.0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine();
                number = Double.parseDouble(input);
                isValid = true; // Nếu chuyển đổi thành công, thoát khỏi vòng lặp
            } catch (Exception e) {
                System.out.println("Đây không phải là một số  hợp lệ. Vui lòng nhập lại.");
            }
        }

        return number;
    }
	public static String getValidDate(Scanner scanner, String prompt) {
        String number = "";
        boolean isValid = false;
        String regex="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}";

        while (!isValid) {
           
                System.out.println(prompt);
                String input = scanner.nextLine();
                boolean isMatch = Pattern.matches(regex, input);
                if(isMatch==true) {
                	isValid=true;
                	number=input;
                }
                else {
                	isValid = false; 
                	 System.out.println("Đây không phải là một ngày hợp lệ. Vui lòng nhập lại. ví dụ hợp lệ dd/mm/year");
                }
           
        }

        return number;
    }
	
}
