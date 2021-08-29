public class Calc {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else {
            int temp = 0;
            if(numbers.matches("//(.)\n(.*)")) {
                char delimiter = numbers.charAt(2);
                String newStr = numbers.substring(4);
                String[] nums = newStr.split(Character.toString(delimiter));
                temp = sumNumbers(nums);
            }
            return temp;
//            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
//            return sum;

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