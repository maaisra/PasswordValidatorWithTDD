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

        //Test Case 3: มีการผสมระหว่างตัวเลข / ตัวอักษรพิมพ์เล็ก จะเป็น MEDIUM (ความยาวต้องมากกว่า 8)
        pw = "abcd1234" ;
        PasswordStrength result3 = PasswordValidator.validate(pw);
        if (result3 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 3 : "+pw+" : Passed:  mixed between number and lowercase is Medium.");
        } else {
            System.out.println("Test Case 3 : "+pw+" : FAILED: Expected WEAK but got " + result3);
        }

        //Test Case 4: มีการผสมระหว่างตัวอักษรพิมพ์ใหญ่ / ตัวอักษรพิมพ์เล็ก จะเป็น MEDIUM (ความยาวต้องมากกว่า 8)
        pw = "GgEZkegw" ;
        PasswordStrength result4 = PasswordValidator.validate(pw);
        if (result4 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 4 : "+pw+" : Passed:  mixed between uppercase and lowercase is Medium.");
        } else {
            System.out.println("Test Case 4 : "+pw+" : FAILED: Expected WEAK but got " + result4);
        }

        //Test Case 5: มีการผสมระหว่างตัวเลข / ตัวอักษรพิมพ์ใหญ่ จะเป็น MEDIUM (ความยาวต้องมากกว่า 8)
        pw = "ABCDLL1234" ;
        PasswordStrength result5 = PasswordValidator.validate(pw);
        if (result5 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 5 : "+pw+" : Passed:  mixed between number and uppercase is Medium.");
        } else {
            System.out.println("Test Case 5 : "+pw+" : FAILED: Expected WEAK but got " + result5);
        }

        //Test Case 6: มีการผสมทั้ง 3 แบบในรหัสผ่านเดียว จะเป็น STRONG (ความยาวต้องมากกว่า 8)
        pw = "Voyager268" ;
        PasswordStrength result6 = PasswordValidator.validate(pw);
        if (result6 == PasswordStrength.STRONG) {
            System.out.println("Test Case 6 : "+pw+" : Passed:  mixed all is Strong.");
        } else {
            System.out.println("Test Case 6 : "+pw+" : FAILED: Expected WEAK but got " + result6);
        }

        System.out.println("--------------------------------");
    }
}
