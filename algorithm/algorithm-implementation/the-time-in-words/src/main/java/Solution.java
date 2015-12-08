import java.util.Scanner;

public class Solution {
    public static final void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            System.out.println(Resolver.resolve(hour, minute));
        }
    }

    public static final class Resolver {
        private static String[] words = new String[]{
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine",
                "thirty",
                "thirty one",
                "thirty two",
                "thirty three",
                "thirty four",
                "thirty five",
                "thirty six",
                "thirty seven",
                "thirty eight",
                "thirty nine",
                "forty",
                "forty one",
                "forty two",
                "forty three",
                "forty four",
                "forty five",
                "forty six",
                "forty seven",
                "forty eight",
                "forty nine",
                "fifty",
                "fifty one",
                "fifty two",
                "fifty three",
                "fifty four",
                "fifty five",
                "fifty six",
                "fifty seven",
                "fifty eight",
                "fifty nine"};

        public static String resolve(int hour, int minute) {

            // specify terms
            if (minute == 0) {
                return words[hour] + " o' clock";
            }

            if (minute == 1) {
                return "one minute past " + words[hour];
            }

            if (minute == 15) {
                return "quarter past " + words[hour];
            }

            if (minute == 30) {
                return "half past " + words[hour];
            }

            if (minute == 45) {
                return "quarter to " + words[hour + 1];
            }

            if (minute == 59) {
                return "one minute to " + words[hour + 1];
            }

            if (minute > 1 && minute < 30) {
                return words[minute] + " minutes past " + words[hour];
            }

            if (minute > 30 && minute < 60) {
                return (words[60 - minute]) + " minutes to " + words[hour + 1];
            }

            throw new IllegalArgumentException();
        }
    }
}