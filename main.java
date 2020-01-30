import java.util.Scanner;


public class num2 {
    static double getDouble(double num, Scanner in)
    {
        if (in.hasNextDouble()) {
            num = in.nextDouble();
            while (num <= 0) {
                System.out.println("wrong number. Input another");
                num = getDouble(num, in);
            }
        }
        else {
            System.out.println("it;s not a double number. Input double number.");
            String tmp = in.nextLine();
            num = getDouble(num, in);
        }

        return num;
    }

    static boolean ifTriangle(double a, double b, double c)
    {
        if (a + b <= c || a + c <= b || b + c <= a)
            return false;
        else
            return true;
    }

    static double getHieght(char side, double a, double b, double c, double p)
    {
        double ha = 0;
        switch (side){
            case 'a':
                ha = (2 / a) * Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;

            case 'b':
                ha = (2 / b) * Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;

            case 'c':
                ha = (2 / c) * Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;
        }
        return ha;
    }

    public static void main(String[] args) {
        System.out.println("Input triangles sides(a, b, c)");
        Scanner input = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
        a = getDouble(a, input);
        b = getDouble(b, input);
        c = getDouble(c, input);

        if(ifTriangle(a, b, c))
            System.out.println("It's not triangle. Shutting down the programm...");
        else {
            double p = (a + b + c) / 2;
            double ha = getHieght('a', a, b, c, p), hb = getHieght('b', a, b, c, p), hc = getHieght('c', a, b, c, p);
            System.out.println("Height a = " + ha + "\nHeight b = " + hb + "\nHeight c = " + hc);
        }
    }
}
