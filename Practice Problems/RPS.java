import java.util.*;

class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] moves = {"Rock", "Paper", "Scissors"};
        int win = 0, loss = 0, draw = 0;

        for(int i = 1; i <= 5; i++) {
            System.out.print("Enter move: ");
            String p = sc.next();

            String c = moves[(int)(Math.random() * 3)];
            System.out.println("Computer: " + c);

            if(p.equals(c)) {
                System.out.println("Draw");
                draw++;
            }
            else if((p.equals("Rock") && c.equals("Scissors")) ||
                    (p.equals("Paper") && c.equals("Rock")) ||
                    (p.equals("Scissors") && c.equals("Paper"))) {
                System.out.println("Player Wins");
                win++;
            }
            else {
                System.out.println("Computer Wins");
                loss++;
            }
        }

        System.out.println("Wins: " + win);
        System.out.println("Losses: " + loss);
        System.out.println("Draws: " + draw);
        System.out.println("Win %: " + win / 5.0 * 100);
    }
}