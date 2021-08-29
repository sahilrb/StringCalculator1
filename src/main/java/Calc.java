public class Calc {
    StringBuffer NegativeNumbers = new StringBuffer();

    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        else if (numbers.length() == 1) {
            int temp = Integer.parseInt(numbers);
            if(temp < 0) {
                throw new IllegalArgumentException("Negative not allowed: "+ String.valueOf(temp));
            }
            return temp;
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
            if(!NegativeNumbers.toString().isEmpty()){
                throw new IllegalArgumentException("Negative not allowed: "+ NegativeNumbers.toString());
            }
            return temp;
        }
    }
    public int sumNumbers(String[] nums){
        int SUM = 0;
        for(String each : nums){
            if(Integer.parseInt(each) < 0) {
                if(NegativeNumbers.toString().isEmpty()) {
                    NegativeNumbers.append(each.toString());
                } else {
                    NegativeNumbers.append(","+each.toString());
                }
            }
            if(Integer.parseInt(each) > 1000) {
                continue;
            }
            SUM += Integer.parseInt(each);
        }
        return SUM;
    }
}