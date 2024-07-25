import java.io.*;
import java.util.*;

public class Main
{
    // Define transitions for each state and input symbol
    public static void main(String[] args)
    {
        try {
            File inputFile = new File("input.txt");
            File outputFile = new File("output.txt");
            PrintWriter writer = new PrintWriter(outputFile);

            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String problemNumberLine = scanner.nextLine().trim();
                if (problemNumberLine.isEmpty()) continue;
                int problemNumber = Integer.parseInt(problemNumberLine);
                List<String> inputs = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String input = scanner.nextLine().trim();
                    if (input.equals("end")) break;
                    inputs.add(input);
                }
                switch (problemNumber) {
                    case 1:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA1(s) ? "True" : "False");
                        }
                        break;
                    case 2:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA2(s) ? "True" : "False");
                        }
                        break;
                    case 3:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA3(s) ? "True" : "False");
                        }
                        break;
                    case 4:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA4(s) ? "True" : "False");
                        }
                        break;
                    case 5:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA5(s) ? "True" : "False");
                        }
                        break;
                    case 6:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(DFA6(s) ? "True" : "False");
                        }
                        break;
                    case 7:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(NFA7(s) ? "True" : "False");
                        }
                        break;
                    case 8:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(NFA8(s) ? "True" : "False");
                        }
                        break;
                    case 9:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(NFA9(s) ? "True" : "False");
                        }
                        break;
                    case 10:
                        writer.println(problemNumber);
                        for (String s : inputs) {
                            writer.println(NFA10(s) ? "True" : "False");
                        }
                        break;
                    default:
                        break;
                }
                if (problemNumber != 10) {
                    writer.println("x");
                }
            }

            scanner.close();
            writer.close();
            System.out.println("Output written to output.txt successfully.");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static boolean DFA1(String s)
    {
        int state = 0;
        for (char c : s.toCharArray())
        {
            if (state == 0)
            {
                if (c == 'a') state = 0;
                else if (c == 'b') state = 1;
            }
            else if (state == 1)
            {
                if (c == 'a') state = 2;
                else if (c == 'b') state = 1;
            }
            else if (state == 2 )
            {
                state = state;
            }
        }
        return state != 2;
    }

    public static boolean DFA2(String s)
    {
        int state = 0;
        for (char c : s.toCharArray())
        {
            if (state == 0)
            {
                if (c == '0') state = 1;
                else if (c == '1') state = 3;
            }
            else if (state == 1)
            {
                if (c == '0') state = 0;
                else if (c == '1') state = 2;
            }
            else if (state == 2)
            {
                if (c == '0') state = 2;
                else if (c == '1') state = 2;
            }
            else if (state == 3)
            {
                if (c == '0') state = 4;
                else if (c == '1') state = 4;
            }
            else if (state == 4)
            {
                if (c == '0') state = 4;
                else if (c == '1') state = 4;
            }
        }
        return (state == 3||state==2);
    }
    public static boolean DFA3(String s)
    {
        int state = 0;
        for (char c : s.toCharArray())
        {
            if (state == 0)
            {
                if (c == 'x') state = 1;
                if (c == 'y') state = 2;
            }
            else if (state == 1){
                if (c == 'x') state = 0;
                if (c == 'y') state = 1;
            }
            else if (state == 2)
            {
                if (c == 'x') state = 3;
                if (c == 'y') state = 2;
            }
            else if (state == 3)
            {
                if (c == 'x') state = 2;
                if (c == 'y') state = 3;
            }
        }
        return (state == 1||state==3);
    }
    public static boolean DFA4(String s)
    {
        //if(input.length() < 2) return false;
        //return input.charAt(0) == input.charAt(input.length() - 1);
        int state = 0;
        for (char c : s.toCharArray())
        {
            if (state == 0)
            {
                if (c == 'a') state = 1;
                if (c == 'b') state = 4;
            }
            else if (state == 1){
                if (c == 'a') state = 3;
                if (c == 'b') state = 2;
            }
            else if (state == 2)
            {
                if (c == 'a') state = 3;
                if (c == 'b') state = 2;
            }
            else if (state == 3)
            {
                if (c == 'b') state = 2;
                if (c == 'a') state = 3;
            }
            else if (state == 4)
            {
                if (c == 'b') state = 6;
                if (c == 'a') state = 5;
            }
            else if (state == 5)
            {
                if (c == 'a') state = 5;
                if (c == 'b') state = 6;
            }
            else if (state == 6)
            {
                if (c == 'a') state = 5;
                if (c == 'b') state = 6;
            }
        }
        return (state == 3||state==6);

    }
    public static boolean DFA5(String s)
    {
        int state = 0;
        for (char c : s.toCharArray())
        {
            if (state == 0)
            {
                if (c == '0') state = 1;
                if (c == '1') state = 0;
            }
            else if (state == 1)
            {
                if (c == '0') state = 2;
                else if (c == '1') state = 0;
            }
            else if (state == 2)
            {
                if (c == '0') state = 2;
                else if (c == '1') state = 0;
            }
        }
        return (state == 2||state==1);
    }
    public static boolean DFA6(String input)
    {
        int currentState = 0;
        for(char c : input.toCharArray())
        {
            if(currentState == 0 && c == '0')
            {
                currentState = 0;
            }
            else if(currentState == 0 && c == '1')
            {
                currentState = 1;
            }
            else if(currentState == 1 && c == '0')
            {
                currentState = 0;
            }
            else if(currentState == 1 && c == '1')
            {
                currentState = 2;
            }
            else if(currentState == 2 && c == '0')
            {
                currentState = 3;
            }
            else if(currentState == 2 && c == '1')
            {
                currentState = 2;
            }
            else if(currentState == 3 && c == '0'){
                currentState = 3;
            }
            else if (currentState == 3 && c == '1'){
                currentState = 2;
            }
        }
        return currentState != 2;
    }
    public static boolean NFA7(String input)
    {
        int state = 0;
        int count01 = 0;
        int count10 = 0;
        for (char c : input.toCharArray())
        {
            if (state == 0 && c == '0')
            {
                state = 1;
            }
            else if (state == 0 && c == '1')
            {
                state = 2;
            }
            else if (state == 1 && c == '0')
            {
                state = 1;
            }
            else if (state == 1 && c == '1')
            {
                state = 2;
                count01++;
            }
            else if (state == 2 && c == '0')
            {
                state = 1;
                count10++;
            }
            else if (state == 2 && c == '1')
            {
                state = 2;
            }
        }
        return count01 == count10 && (state == 1 || state == 2);
    }


    public static boolean NFA8(String s) {
        char currentState1 = 'e';
        int finalstate=9;
        if(currentState1=='e'){
            int currentState2=1;
            for (char c : s.toCharArray()) {
                if (currentState2 == 1) {
                    if(c=='0'){
                        currentState2=1;
                    } else if (c=='1') {
                        currentState2=2;
                    }
                }
                else if (currentState2 == 2) {
                    if(c=='0'){
                        currentState2=3;
                    }
                }
                else if (currentState2 == 3) {
                    if(c=='1'){
                        currentState2=4;
                    }
                }
                else if (currentState2 == 4) {
                    currentState2=9;
                }
                else if (currentState2 == 9) {
                    currentState2=9;
                }
            }
            if(currentState2==9){
                return true;
            }
        }
        // Reset currentState2 for the second path
        currentState1 = 'e';
        int currentState2=5;
        for (char c : s.toCharArray()) {
            if (currentState2 == 5) {
                if(c=='0'){
                    currentState2=6;
                } else if (c=='1') {
                    currentState2=5;
                }
            }
            else if (currentState2 == 6) {
                if(c=='0'){
                    currentState2=5;
                }
                else if(c=='1'){
                    currentState2=7;
                }
            }
            else if (currentState2 == 7) {
                if(c=='0'){
                    currentState2=9;
                }
                else if(c=='1'){
                    currentState2=7; // Corrected from 7 to 8
                }
            }
            else if (currentState2 == 9) {
                currentState2=9;
            }
        }
        if(currentState2==9){
            return true;
        }

        return false;
    }


    public static boolean NFA9(String input) {
        char currentState1 = 'e';
        if (currentState1 == 'e') {
            //path1
            int currentState = 0;
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                if (currentState == 0) {
                    if (symbol == '0') {
                        currentState = 1;
                    }
                } else if (currentState == 1) {
                    if (symbol == '1') {
                        currentState = 3;
                    }
                } else if (currentState == 3) {
                    if (symbol == '0') {
                        currentState = 1;
                    }
                }
            }
            if (currentState == 3) {
                return true;
            }
            //path2
            currentState = 4;
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                if (currentState == 4) {
                    if (symbol == '1') {
                        currentState = 5;
                    }
                } else if (currentState == 5) {
                    if (symbol == '0') {
                        currentState = 3;
                    }
                } else if (currentState == 3) {
                    if (symbol == '1') {
                        currentState = 5;
                    }
                }
            }
            if (currentState == 3) {
                return true;
            }
        }
        return false;
    }
    public static boolean NFA10(String input) {
        int currentState = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (currentState == 0) {
                if (symbol == '1') {
                    currentState = 2;
                } else if (symbol == '0') {
                    currentState = 3;
                }
            } else if (currentState == 2) {
                if (symbol == '1') {
                    currentState = 2;
                }
            } else if (currentState == 3) {
                if (symbol == '1') {
                    currentState = 4;
                }
            } else if (currentState == 4) {
                if (symbol == '0') {
                    currentState = 3;
                } else if (symbol == '1') {
                    currentState = 2;
                }
            }
        }

        return currentState == 2;
    }

}