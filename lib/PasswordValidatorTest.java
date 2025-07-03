package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        String pw = "123";
        PasswordStrength result1 = PasswordValidator.validate(pw);
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 : "+pw+" :  Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 : "+pw+" : FAILED: Expected INVALID but got " + result1);
        }

        //Test Case 2: รหัสผ่านทั้งหมดเป็นตัวเล็กจะ Weak
        pw = "abcdefghij" ;
        PasswordStrength result2 = PasswordValidator.validate(pw);
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 : "+pw+" : Passed:  ALL lowercase is WEAK.");
        } else {
            System.out.println("Test Case 2 : "+pw+" : FAILED: Expected WEAK but got " + result2);
        }

        // --- เขียน Test Case อื่นๆ ต่อ ---

        System.out.println("--------------------------------");
    }
}
