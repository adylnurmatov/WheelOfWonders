
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static String wordToGuess = wheelword();
    public static String startinggamevalue = "s";
    public static int wordlen = wordToGuess.length();
    public static int maxpoints = wordlen * 100;
    public static int midpoints = maxpoints / 2;
    public static int pointPerLetter = 100;
    public static String winner = null;
    public static String description = describeWords();


    public static String hiddenword = hideTheWord();

    public static void main(String[] args) {
        playersMoves();
    }
    private static ArrayList<String> inputAndShufflePlayers(){
        ArrayList<String> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of players");
        System.out.println("To start to play enter 's' ");
        String player = input.nextLine();
        while(!player.equals(startinggamevalue)){
            players.add(player);
            player = input.nextLine();
        }
        Collections.shuffle(players);
        return players;
    }
    private static String wheelword(){
        String[] words =
                {       "stepladder", "jug", "spain", "sausage", "carrot",
                        "sergeant", "mayonnaise", "parrot", "glasses", "crocodile"
                };
        return words[randomdigit()];
    }
    private static String describeWords(){
        return switch (wordToGuess) {
            case "stepladder" ->
                    "One of the first images of this useful device was found in a cave more than 10,000 years ago";
            case "jug" -> "What did the skudelnik make in the old days";
            case "spain" ->
                    "According to one version, the name of this country from one of the ancient languages can be translated as the coast of rabbits";
            case "sausage" ->
                    "This delicious product appeared in medieval Germany, and acquired a modern look at the beginning of the 19th century";
            case "sarrot" -> "A minute of laughter is as useful as one kilogram of... what?";
            case "sergeant" ->
                    "In the 11th century in England, this was the name of landowners who held their plots under the condition of performing a certain service to the king";
            case "mayonnaise" -> "What was invented by the French commander Louis of Crillon?";
            case "parrot" -> "Prone to using the same phrases more often than I would like";
            case "glasses" -> "What was forbidden to wear in the Tsarskoye Selo Lyceum?";
            case "crocodile" -> "The cubs of this animal acquire sex depending on the ambient temperature";
            default -> "";
        };
    }
    private static void playersMoves(){
        ArrayList<String> players0 = inputAndShufflePlayers();
        int[] pointsTable = createPointsTable(players0);
        String[] players = new String[players0.size()];
        players0.toArray(players);
        boolean isHaveMove = true;
        while(isHaveMove){
            for (int i = 0; i < players.length; i++) {
                System.out.println(description);
                System.out.println(hiddenword);
                System.out.println("Now the move is for - " + players[i]);
                System.out.println("You have " + pointsTable[i] + "/" + midpoints);
                String letterFromPlayer = inputLetter();
                if(letterFromPlayer.length() == 1 && isContainthisLetter(letterFromPlayer)){
                    pointsTable[i] += givePoint();
                    hiddenword = openLetter(letterFromPlayer);
                }
                else if(letterFromPlayer.length() == wordToGuess.length() && isEqualToWord(letterFromPlayer)){
                    System.out.println(wordToGuess);
                    System.out.println("you win");
                    winner = players[i];
                    isHaveMove = false;
                    break;
                }
                else{
                    System.out.println("Wrong");
                }
            }
            if(winner != null){
                isHaveMove = false;
            }
        }
        System.out.println(winner);
    }
    private static String hideTheWord() {
        String word = "";
        for (int i = 0; i < wordlen; i++) {
            word += "*";
        }
        return word;
    }
    private static int[] createPointsTable(ArrayList<String> players){
        return new int[players.toArray().length];
    }
    private static int randomdigit(){
        return (int) (Math.random() * 10);
    }
    private static int givePoint(){
        return pointPerLetter;
    }
    private static boolean isContainthisLetter(String letter){
        return wordToGuess.contains(letter);
    }
    private static boolean isEqualToWord(String letter){
        return wordToGuess.equals(letter);
    }
    private static String openLetter(String letter){
        for(int i = 0; i < wordToGuess.length(); i++){
            char openlet = wordToGuess.charAt(i);
            char let = letter.charAt(0);
            if(openlet == let){
                hiddenword = hiddenword.substring(0, i) + letter + hiddenword.substring(i + 1);
            }
        }
        return hiddenword;
    }
    private static String openWord(){
        return wordToGuess;
    }
    private static String inputLetter() {
        Scanner input = new Scanner(System.in);
        boolean isnotCorrectLen = true;
        String letter = null;
        while (isnotCorrectLen) {
            letter = input.nextLine();
            if(letter.length() == 1 || letter.length() == wordToGuess.length()){
                isnotCorrectLen = false;
            }
        }
        return letter;
    }
}
