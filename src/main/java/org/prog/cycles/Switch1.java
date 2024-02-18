package org.prog.cycles;

public class Switch1 {
    private static void test(String s) {
        switch (s) {
            case "1":
                System.out.println("Today is Monday!");
                break;
            case "2":
                System.out.println("Today is Tuesday!");
                break;
            case "3":
                System.out.println("Today is Wednsday!");
                break;
            case "4":
                System.out.println("Today is Thursday!");
                break;
            case "5":
                System.out.println("Taday is Friday!");
                break;
            case "6":
                System.out.println("Taday is Saturday!");
                break;
            case "7":
                System.out.println("Taday is Sunday!");
                break;
            default:
                throw new RuntimeException("Error!");
        }
    }

}
