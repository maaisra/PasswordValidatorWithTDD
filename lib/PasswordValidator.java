package lib;

public class PasswordValidator {

    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * @param password string ที่ต้องการตรวจสอบ
     * @param minLength ค่าความยาวรหัสผ่านขั้นต่ำ
     * @param num เช็กว่ามีตัวเลขในรหัสผ่านหรือไม่
     * @param lowercase เช็กว่ามีตัวอักษรพิมพ์เล็กในรหัสผ่านหรือไม่
     * @param uppercase เช็กว่ามีตัวอักษรพิมพ์ใหญ่ในรหัสผ่านหรือไม่
     * @param longlength ค่าความยาวของรหัสเพียงพอ (เกิน 8 ตัว)
     * @return PasswordStrength INVALID อื่น ๆ
     */
    public static PasswordStrength validate(String password) { 

        int minLength = 8 ;
        boolean num = false ;
        boolean lowercase = false ;
        boolean uppercase = false ;
        boolean longlength = false ;
        
        // กรณีรหัสผ่านนั้นว่างเปล่าหรือน้อยกว่า 8 ตัว
        if (password == null || password.length()<8)
            return PasswordStrength.INVALID;

        // นับตัวอักษร หากเป็นตัวอักษรเล็กทั้งหมดนับว่าเป็น weak
        int countLowercase = 0 ;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c))
                countLowercase++;
        }
        if (countLowercase==password.length()) {
            return PasswordStrength.WEAK;
        }

        // นับตัวอักษร หากเป็นตัวใหญ่ทั้งหมดนับว่าเป็น weak
        int countUppercase = 0 ;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                countUppercase++;
        }
        if (countUppercase==password.length()) {
            return PasswordStrength.WEAK;
        }

        // นับตัวเลข หากเป็นเลขล้วนทั้งหมดนับว่าเป็น weak
        if (countLowercase + countUppercase != password.length()) {
            num = true ;
        }

        // เช็กในกรณีความยาวถึงขีดที่กำหนด ก็คือต้องมากกว่า 8 ตัว จึงจะให้ผ่านเท่านั้น
        if (password.length() > minLength) {
            longlength = true;
        }
        
        // แบ่ง String ออกมาเป็นค่าใด ๆ เพื่อดูว่ามีตัวอักษรพิมพ์ใหญ่ / เล็ก / ตัวเลขหรือไม่
        if (countLowercase >= 1) {
            lowercase = true;
        }
        if (countUppercase >= 1) {
            uppercase = true;
        }

        //
        if ((num && lowercase && uppercase) && longlength) {
            return PasswordStrength.STRONG;
        } else {
            return PasswordStrength.MEDIUM;
        }
        
    }
}