public class StringCalculator {

    public int add(String String_value) {
        int sum = 0;
        String negative_String = "";
        String_value = String_value.replaceAll(" ", "");

        // Custom delimeter
        int delimiter_Index = String_value.indexOf("//");
        int String_Index = String_value.indexOf("\n");

        if (delimiter_Index != -1) {
            String delimiter = String_value.substring(delimiter_Index + 2, String_Index);
            String_value = String_value.substring(String_Index + 1);
            String[] arr1 = String_value.split(delimiter);
            for (String n : arr1) {
                Integer current = Integer.parseInt(n);
                sum += current;
            }
            return sum;
        }

        else if (String_value.equals("")) {
            return 0;
        }
        while (String_value.length() >= 1) {
            String arr[] = String_value.split("[,\n]");
            for (String n : arr) {
                if (n.matches("[a-z]")) {
                    sum += n.codePointAt(0) - 96;
                } else {
                    int current = Integer.parseInt(n);
                    if (current > 1000) {
                        continue;
                    } else if (current < 0) {
                        negative_String += (String.valueOf(current) + " ");
                    }
                    sum += current;
                }
            }
            if (negative_String != "") {
                throw new RuntimeException("Negatives not allowed -> " + negative_String);
            }
            return sum;
        }
        return 1;
    }
}
