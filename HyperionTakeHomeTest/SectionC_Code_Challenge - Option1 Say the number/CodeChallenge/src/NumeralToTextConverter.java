public class NumeralToTextConverter {
    private static final String[] DIGITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TEENS = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String numeralToText(String numeral) {
        // Convert the numeral to an integer
        int num = Integer.parseInt(numeral);

        // Handle special cases
        if (num == 0) {
            return "zero";
        } else if (num < 0) {
            return "minus " + numeralToText(numeral.substring(1));
        } else if (num < 10) {
            return DIGITS[num];
        } else if (num < 20) {
            return TEENS[num - 10];
        } else if (num < 100) {
            return TENS[num / 10] + ((num % 10 != 0) ? " " : "") + DIGITS[num % 10];
        } else if (num < 1000) {
            return DIGITS[num / 100] + " hundred" + ((num % 100 != 0) ? " and " : "") + numeralToText(numeral.substring(1));
        } else if (num < 1000000) {
            return numeralToText(numeral.substring(0, numeral.length() - 3)) + " thousand" + ((num % 1000 != 0) ? " " : "") + numeralToText(numeral.substring(numeral.length() - 3));
        } else if (num < 1000000000) {
            return numeralToText(numeral.substring(0, numeral.length() - 6)) + " million" + ((num % 1000000 != 0) ? " " : "") + numeralToText(numeral.substring(numeral.length() - 6));
        } else {
            return "Sorry, this program only supports numbers up to 999,999,999.";
        }
    }

    public static void main(String[] args) {
        // Test the function with various inputs
        String[] inputs = {"0", "123", "19093", "123456", "999999999", "-42"};
        String[] expectedOutputs = {"zero", "one hundred and twenty three", "nineteen thousand and ninety three", "one hundred and twenty three thousand four hundred and fifty six", "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", "minus forty two"};
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expectedOutput = expectedOutputs[i];
            String actualOutput = numeralToText(input);
            if (!actualOutput.equals(expectedOutput)) {
                System.out.println("Error: Expected \"" + expectedOutput + "\" but got \"" + actualOutput + "\" for input \"" + input + "\"");
            }
        }
        System.out.println("Tests complete.");
    }
}
