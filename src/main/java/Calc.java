import java.util.ArrayList;
import java.util.List;

public class Calc {

    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String[] nums;
        String delimiter;
        String newIP = numbers;

        if (numbers.startsWith("//")) {
            if (isMultiDelimiter(numbers)) {
                delimiter = Character.toString(numbers.charAt(2));
                newIP = numbers.substring(4);
            } else {
                List<Integer> lst = new ArrayList<>();
                int len;
                int begin = numbers.indexOf('[');
                while (begin >= 0) {
                    lst.add(begin);
                    begin = numbers.indexOf('[',begin + 1);
                }
                List<Integer> lst2 = new ArrayList<>();
                int end = numbers.indexOf(']');
                while(end >= 0){
                    lst2.add(end);
                    end = numbers.indexOf(']', end + 1);
                }
                //int len;
                int last = lst2.get(lst.size() - 1);

                StringBuilder s = new StringBuilder();
                int n = lst.size();
                for(int i = 0; i < n; i++) {
                    int right = lst.get(i);
                    int left = lst2.get(i);
                    String temp = numbers.substring(right + 1, left);
                    if (temp.charAt(0) == '$' || temp.charAt(0) == '.' || temp.charAt(0) == '+' || temp.charAt(0) == '?' || temp.charAt(0) == '^' || temp.charAt(0) == '*') {
                        int tempSize = temp.length();
                        StringBuilder tempStr = new StringBuilder();
                        for (int j = 0; j < tempSize; j++) {
                            tempStr.append("\\").append(temp.charAt(j));
                        }
                        s.append(tempStr);
                    } else {
                        s.append(temp);
                    }

                    if (i < n - 1) {
                        s.append("|");
                    }
                }
                    delimiter = s.toString();
                    newIP = numbers.substring(last + 2);
            }
        }
        else{
                delimiter = ("[,\n]");
            }
            nums = newIP.split(delimiter);
            return sumNumbers(nums);
        }

        private Boolean isMultiDelimiter(String number) {
            return number.charAt(2) != '[';
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