import java.util.*;


public class rabinkarp
{

    static int d = 10;
    
    private static void rabin_karp_search(String pattern, String text, int a){
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++)
        h = (h * d) % a;

        
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % a;
            t = (d * t + text.charAt(i)) % a;
        }

        
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
                }

                if (j == m)
                System.out.println("Pattern is found at position: " + (i + 1));
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % a;
                if (t < 0)
                t = (t + a);
            }
        }
    }
    public static void main(String[] args)
    {
        String pattern = "ABBA";
        String text = "ABABABBABBBBABABABBABABA";
        int a = 3;
        System.out.print("Pattern: " + pattern + "\nText: " + text + "\n");
        rabin_karp_search(pattern, text, a);
    }
}