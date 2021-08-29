import java.util.ArrayList;
import java.util.List;

public class Calc {

    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String[] nums;
        StringBuilder delimiter;
        String newIP = numbers;

        if (numbers.startsWith("//")) {
            if (isMultiDelimiter(numbers)) {
                delimiter = new StringBuilder(Character.toString(numbers.charAt(2)));
                newIP = numbers.substring(4);
            } else {
                List<Integer> lst = new ArrayList<>();
                int len;
                int begin = numbers.indexOf('[');
                while (begin >= 0) {
                    lst.add(begin);
                    begin = numbers.indexOf('[',begin + 1);
                }
                if(lst.size() > 1) {
                    delimiter = new StringBuilder("[");
                    len = lst.size();

                    for(int i = 0; i < len; i++) {
                        int right = lst.get(i);
                        delimiter.append(numbers.charAt(right + 1));
                    }
                    delimiter.append("]");
                    int left = lst.get(len - 1);
                    newIP = numbers.substring(left + 4);
                } else {
                    delimiter = new StringBuilder(delimiterSplitter(numbers));
                    newIP = substringGenerator(numbers);
                }
            }
        }
        else{
            delimiter = new StringBuilder("[,\n]");
            }
            nums = newIP.split(delimiter.toString());
            return sumNumbers(nums);
        }

        private Boolean isMultiDelimiter(String number) {
            return number.charAt(2) != '[';
        }

        private String delimiterSplitter(String number) {
        int begin = number.indexOf('[');
        int last = number.indexOf(']');
        return number.substring(begin+1, last);
    }

        private String substringGenerator(String number) {
        int last = number.indexOf(']');
        return number.substring(last+2);
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
            if(!checkNegative.isEmpty()) {
                throw new IllegalArgumentException("Negative numbers not allowed: " + checkNegative);
            }
        }

        private String negativeChecker (String[]nums){
            List<String> number = new ArrayList<>();
            for (String val : nums) {
                if (Integer.parseInt(val) < 0) {
                    number.add(val);
                }
            }
            return String.join(",", number);
        }
    }