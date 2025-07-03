package lib;

public class PasswordValidator {

    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * @param password string ที่ต้องการตรวจสอบ
     * @return PasswordStrength INVALID อื่น ๆ
     */
    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 

        int minLength = 8 ;
        if (password == null || password.length()<8)
            return PasswordStrength.INVALID;

        int count = 0 ;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                count++;
        }
        if (count==password.length()) {
            return PasswordStrength.WEAK;
        }
        if (password.length() == minLength) {
            return PasswordStrength.WEAK;
        }
        
        
        return PasswordStrength.STRONG; 
        
        return null ; // TODO: การคืนค่านี้ถูกต้องหรือไม่?
    }
}