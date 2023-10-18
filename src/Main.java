import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static String startinggamevalue = "s";
    public static void main(String[] args) {

    }
    private static ArrayList inputAndShufflePlayers(){
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
                {       "Stepladder", "Jug", "Spain", "Sausage", "Carrot",
                        "Sergeant", "Mayonnaise", "Parrot", "Glasses", "Crocodile"
                };
        return words[randomdigit()];
    }
    private static String describeWords(){
        String description = "";
        switch (wheelword()) {
            case "Stepladder": description = "One of the first images of this useful device was found in a cave more than 10,000 years ago";
            break;
            case "Jug": description = "What did the skudelnik make in the old days";
            break;
            case "Spain": description = "According to one version, the name of this country from one of the ancient languages can be translated as the coast of rabbits";
            break;
            case "Sausage": description = "This delicious product appeared in medieval Germany, and acquired a modern look at the beginning of the 19th century";
            break;
            case "Carrot": description = "A minute of laughter is as useful as one kilogram of... what?";
            break;
            case "Sergeant": description = "In the 11th century in England, this was the name of landowners who held their plots under the condition of performing a certain service to the king";
            break;
            case "Mayonnaise": description = "What was invented by the French commander Louis of Crillon?";
            break;
            case "Parrot": description = "Prone to using the same phrases more often than I would like";
            break;
            case "Glasses": description = "What was forbidden to wear in the Tsarskoye Selo Lyceum?";
            break;
            case "Crocodile": description = "The cubs of this animal acquire sex depending on the ambient temperature";
            break;
        }
        return description;
    }
    private static void displaytoscreen(){

    }
    private static void guessingwords(){

    }
    private static int[] assignpoints(){
        return new int[inputAndShufflePlayers().toArray().length];
    }
    private static void startingGame(){

    }
    private static int randomdigit(){
        return (int) (Math.random() * 10);
    }
}
