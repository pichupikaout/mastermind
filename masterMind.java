
import java.util.*;
public class masterMind {
    public static void main () {
        String color = "kbywrg";
        char[] code = new char[4];
        char[] inputs = new char[4];
        int turns = 0;
        String xo = "";
        while (turns < 10) {
            System.out.println("Turn " + turns+1);  
            for (int b = 0; b < 4; b++) { //gives out a random code
                  Random a = new Random();
                  int randomLettervalue = Math.abs(a.nextInt(color.length()));
                  char randomLetter = color.charAt(randomLettervalue);
                  code[b] = randomLetter;
            }
            char[] codetemp = code;
            Scanner console = new Scanner(System.in);
            for (int z = 0; z < inputs.length; z++) {
                System.out.println("letter number " + (z + 1) + ": ");
                inputs[z] = console.next().charAt(0);
            }
            for (int n = 0; n < inputs.length; n++) { // checks if you got the color right and is in the right spot
                if (inputs[n] == codetemp[n]) {
                    xo = xo + 'x';
                    inputs[n] = 'N';
                    codetemp[n] = 'Q';
                }
            }
            for (int o = 0; o < inputs.length; o++) { // after checking if you got the color right and is in the right spot, this checks if you got the color right, but it's in the wrong spot
                for (int p = 0; p < code.length; p++) {
                    if (inputs[o] == codetemp[p]) {
                        xo = xo + 'o';
                        inputs[o] = 'N';
                        codetemp[p] = 'Q';
                    }
                }
            }
            System.out.println(xo);
            System.out.println("--------------------------------------------------------------");
            turns++;
            if (xo.equals("xxxx")) {
                System.out.println("Congrats! You did it in " + (turns + 1) + " turns!");
                
            }
        }
        if (!xo.equals("xxxx")) { //checks if you didn't guess the code after 10 turns
            System.out.println("You lose, the code was " + Arrays.toString(code) + ". Better luck next time!");;
        }
}
}
