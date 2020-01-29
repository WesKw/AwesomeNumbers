public class AwesomeNumbers {

    public static void main(String[] args) {
        boolean awesome;
        //This program spits out every 'awesome' number between 10 and 10000000.
        //awesome numbers are numbers whose digit factorials add up to said number
        //System.out.println(totalDigits(1));
        //System.out.println(factorial(5));
        //System.out.println(awesomeCheck(20, 2));
        System.out.print("{ ");

        for(long i = 10; i <= 10000000; i++) {
            int digits = totalDigits(i);

            awesome = awesomeCheck(i, digits);

            if(awesome)
                System.out.print(i + " ");
        }

        System.out.print("}");
    }

    public static int totalDigits(long num) {
        int count = 0;
        while(num != 0) {
            num = num / 10;
            count++;
        }

        return count;
    }

    public static long factorial(long num) {
        long total = num;

        for(long i = num - 1; i > 0; i--) {
            total *= i;
        }

        return total;
    }

    public static boolean awesomeCheck(long num, int totalDigits) {

        String temp = Long.toString(num); //Convert int to String
        //System.out.println(temp);
        long sum = 0;
        char[] charNumArray = temp.toCharArray(); //Convert string to char array
        int[] numbers = new int[totalDigits]; //Array to store separate digits

        for(int i = 0; i < totalDigits; i++) { //Loop through array to store digits and add.
            numbers[i] = Character.getNumericValue(charNumArray[i]);
            sum += factorial(numbers[i]); // add each digit factorial to the total sum
        }

        if(sum == num) { //if total sum equals original number
            return true;
        }

        return false;
    }

}
