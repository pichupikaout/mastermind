import java.util.*;
public class masterMind {
    public static void main () {
        String color = "kbywrg";
        char[] code = new char[4];
        char[] inputs = new char[4];
        String input = "";
        int turns = 0;
        String xo = "";
        for (int b = 0; b < 4; b++) { //gives out a random code
            Random a = new Random();
            int randomLettervalue = Math.abs(a.nextInt(color.length()));
            char randomLetter = color.charAt(randomLettervalue);
            code[b] = randomLetter;
        }
        char[] codetemp = code;
        while (turns < 10) {
            System.out.println("Turn " + (turns + 1));  
            Scanner console = new Scanner(System.in);
            System.out.println("Type in your guess: ");
            input = console.next();
            for (int z = 0; z < input.length(); z++) {
                inputs[z] = input.charAt(z);
            }
            for (int n = 0; n < inputs.length; n++) { // checks if you got the color right and is in the right spot
                if (inputs[n] == codetemp[n]) {
                    xo = xo + 'X';
                    inputs[n] = 'N';
                    codetemp[n] = 'Q';
                }
            }
            for (int o = 0; o < inputs.length; o++) { // after checking if you got the color right and is in the right spot, this checks if you got the color right, but it's in the wrong spot
                for (int p = 0; p < code.length; p++) {
                    if (inputs[o] == codetemp[p]) {
                        xo = xo + 'O';
                        inputs[o] = 'N';
                        codetemp[p] = 'Q';
                    }
                }
            }
            System.out.println(xo);
            codetemp = code;
            System.out.println("--------------------------------------------------------------");
            turns++;
            if (xo.equals("XXXX")) {
                System.out.println("Congrats! You did it in " + turns + " turns!");
            }
        }
        if (!xo.equals("XXXX")) { //checks if you didn't guess the code after 10 turns
            System.out.println("You lose, the code was " + Arrays.toString(code) + ". Better luck next time!");;
        }
    }
}
