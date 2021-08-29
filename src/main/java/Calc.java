public class Calc {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        }
        else {
            int temp = 0;
            if(numbers.matches("//(.)\n(.*)")) {
                char delimiter = numbers.charAt(2);
                String newStr = numbers.substring(4);
                String[] nums = newStr.split(Character.toString(delimiter));
                temp = sumNumbers(nums);
            }
            else {
                String[] nums = numbers.split(",|\n");
                temp = sumNumbers(nums);
            }
            return temp;
        }
    }
    public int sumNumbers(String[] nums){
        int SUM = 0;
        for(String each : nums){
            SUM += Integer.parseInt(each);
        }
        return SUM;
    }
}