package level02;

import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int age1 = sc.nextInt();
        System.out.print("Enter height of Amar: ");
        int height1 = sc.nextInt();

        System.out.print("Enter age of Akbar: ");
        int age2 = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        int height2 = sc.nextInt();

        System.out.print("Enter age of Anthony: ");
        int age3 = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        int height3 = sc.nextInt();

        // Youngest
        if (age1 <= age2 && age1 <= age3)
            System.out.println("Youngest friend is Amar");
        else if (age2 <= age1 && age2 <= age3)
            System.out.println("Youngest friend is Akbar");
        else
            System.out.println("Youngest friend is Anthony");

        // Tallest
        if (height1 >= height2 && height1 >= height3)
            System.out.println("Tallest friend is Amar");
        else if (height2 >= height1 && height2 >= height3)
            System.out.println("Tallest friend is Akbar");
        else
            System.out.println("Tallest friend is Anthony");
    }
}
