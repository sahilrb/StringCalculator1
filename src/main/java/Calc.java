public class Calc {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else {
            String[] nums = numbers.split(",");
            int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            return sum;
            return sumNumbers(nums);
        }
    }
    public int sumNumbers(String[] nums){
        int SUM=0;
        for(String each : nums){
            SUM += Integer.parseInt(each);
        }
        return SUM;
    }
}