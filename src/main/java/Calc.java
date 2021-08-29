import java.util.ArrayList;
import java.util.List;

public class Calc {

    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String[] nums = null;
        String delimiter = null;
        String newIP = numbers;

        if (numbers.startsWith("//")) {
            if (isMultiDelimiter(numbers)) {
                delimiter = Character.toString(numbers.charAt(2));
                newIP = numbers.substring(4);
            } else {
                delimiter = delimiterSplitter(numbers);
                newIP = substringGenerator(numbers);
            }
        }
        else{
                delimiter = "[,\n]";
            }
            nums = newIP.split(delimiter);
            return sumNumbers(nums);
        }

        private Boolean isMultiDelimiter (String input){
            return (input.charAt(2) == '[' ? false : true);
        }

        private String delimiterSplitter (String input){
            int begin = input.indexOf('[');
            int last = input.indexOf(']');
            return input.substring(begin + 1, last);
        }

        private String substringGenerator (String input){
            int last = input.indexOf(']');
            return input.substring(last + 2);
        }

        private int sumNumbers (String[]nums){
            int SUM = 0;
            ingoreNegatives(nums);
            for (String each : nums) {
                if (Integer.parseInt(each) <= 1000) {
                    SUM += Integer.parseInt(each);
                }
            }
            return SUM;
        }

        private void ingoreNegatives (String[]nums){
            String checkNegative = negativeChecker(nums);
            if (!isEmpty(checkNegative)) {
                throw new IllegalArgumentException("Negative numbers not allowed: " + checkNegative);
            }
        }

        private String negativeChecker (String[]nums){
            List<String> number = new ArrayList<String>();
            for (String val : nums) {
                if (Integer.parseInt(val) < 0) {
                    number.add(val);
                }
            }
            return lstToStr(number);
        }

        private boolean isEmpty (String number){
            return number.isEmpty();
        }

        private String lstToStr (List < String > nums) {
            return String.join(",", nums);
        }
    }