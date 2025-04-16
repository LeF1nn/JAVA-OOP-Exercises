import java.util.Random;
import java.util.Scanner;

public class Game {

    private String[] word = {"kian", "dorcci", "tijay", "hidden", "shayea"};
    private String chosenWord;
    public char[] wordSplit;
    private char[] guessWord;
    private int canTry;


    public Game() {
        Random random = new Random();
        this.chosenWord = word[random.nextInt(word.length)];
        this.canTry = chosenWord.length() + 2;
        this.wordSplit = chosenWord.toCharArray();
        this.guessWord = new char[chosenWord.length()];
        for (int i = 0; i < chosenWord.length(); i++) {
            this.guessWord[i] = '-';
        }
    }


    public boolean isValid(String input) {
        return (input.length() == 1) || (input.charAt(0) >= 'a') && (input.charAt(0) <= 'z');
    }

    public boolean done() {
        boolean c = true;
        for (int i = 0; i < chosenWord.length(); i++) {
            if (guessWord[i] == '-') {
                c = false;
                break;
            }
        }
        return c ;
    }

    public void checkWord(String charecter) {
        if (isValid(charecter)) {
            char ch = charecter.charAt(0);
            for (int i = 0; i < chosenWord.length(); i++) {
                if (ch == chosenWord.charAt(i)) {
                    guessWord[i] = ch;
                }
            }
        } else System.out.println("invalid char try again:");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name);
        System.out.println("Welcome" + " " + player.getName());

        while (!done() && canTry > 0) {
            System.out.println("\n\n** " + String.valueOf(guessWord) + " **");
            System.out.println("Enter char(a-z): ");
            System.out.println("Try left : " + canTry);
            String input = scanner.next();
            checkWord(input);
            canTry--;
        }
        if (done()) {
            System.out.println("win!");
        } else {
            System.out.println("Lose!");
            System.out.println("word is : " + chosenWord);
        }
    }
}
