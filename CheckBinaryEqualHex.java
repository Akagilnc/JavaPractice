/**
 * Created by deronlee on 7/13/16.
 */
public class CheckBinaryEqualHex {

    public static void main(String[] args) {
        CheckBinaryEqualHex checkBinaryEqualHex = new CheckBinaryEqualHex();
        boolean result = checkBinaryEqualHex.compareBinToHex("11", "03");
        System.out.println(result);
    }

    public boolean compareBinToHex(String binary, String hex) {
        int num1 = convertToBase(binary, 2);
        int num2 = convertToBase(hex, 16);

        System.out.println("num1 = " + num1 + " num2 = " + num2);

        if (num1 < 0 || num2 < 0)
            return false;
        else
            return num1 == num2;
    }

    public int digitToValue(char c) {
        if (c >= '0' && c <= '9' ){
            return c - '0';
        }
        else if (c >= 'A' && c <= 'F'){
            return 10 + c - 'A';
        }
        else if (c >= 'a' && c <= 'f'){
            return 10 + c - 'a';
        }
        return -1;
    }

    public int convertToBase(String number, int base) {
        if (base < 2 || (base > 10 && base != 16)) {
            return -1;
        }

        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue(number.charAt(i));
            if (digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += (digit * Math.pow(base, exp));
        }
        return value;
    }


}
