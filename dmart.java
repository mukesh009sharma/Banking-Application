package Application;


import java.util.Scanner;

  class Dmart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total purchase amount: ₹");
        
        if (scanner.hasNextDouble()) {
            double totalAmount = scanner.nextDouble();
            String message = calculateDiscountAndRewards(totalAmount);
            System.out.println(message);
        } else {
            System.out.println("Invalid input. Please enter a numeric value for the total purchase amount.");
        }

        scanner.close();
    }

    public static String calculateDiscountAndRewards(double totalAmount) {
        double finalAmount;
        String message;

        if (totalAmount >= 3000 && totalAmount < 5000) {
            finalAmount = totalAmount - 500;
            message = String.format("You get a Blanket ₹500 discount. Your final amount is ₹%.2f.", finalAmount);
        } else if (totalAmount >= 5000 && totalAmount < 10000) {
            finalAmount = totalAmount - (0.30 * totalAmount);
            message = String.format("You get a 30%% discount. Your final amount is ₹%.2f.", finalAmount);
        } else if (totalAmount >= 10000 && totalAmount < 15000) {
            finalAmount = totalAmount;
            message = "You get a free Iron.";
        } else if (totalAmount >= 15000) {
            finalAmount = totalAmount;
            message = "You get a free bag.";
        } else {
            finalAmount = totalAmount;
            message = "No discounts or free gifts applicable.";
        }
        System.out.println("Thank youu >..........visit again");
        System.out.println("");
        
    }
}
