package searchChar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyClass {
    public static String log = "";

    public static boolean FormeazaTriunghi(String[] args) {
        log = "";

        if (args.length != 3) {
            String text = "Numar incorect de argumente\n";
            log += text;
            System.out.print(text);
            return false;
        }

        int i = 0;
        while (i < args.length) {
            if (!args[i].matches("^[+]?\\d*$")) {
                String text = "Argument incorect: " + args[i] + "\n";
                log += text;
                System.out.print(text);
                return false;
            }
            i = i + 1;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a + b <= c) {
            return false;
        }

        if (a + c <= b) {
            return false;
        }

        if (c + b <= a) {
            return false;
        }

        return true;
    }
}
