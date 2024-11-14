import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LReader {

    public static double score(double x, double y)
    {
        double score = 0;
        double pos = Math.sqrt((x*x) + (y*y));

        if(pos <= 3) {
            score = 100;
        }else if(pos <= 6) {
            score = 80;
        }else if(pos <= 9) {
            score = 60;
        }else if(pos <= 12) {
            score = 40;
        }else if(pos <= 15) {
            score = 20;
        }
        return score;
    }

    public static void main(String args []) throws FileNotFoundException
    {
        //reading the file
        File input_info = new File("information.txt");
        Scanner sc = new Scanner(input_info);

        //process of reading the file
        while(sc.hasNext())
        {
            double s_p1 = 0.0;
            double s_p2 = 0.0;

            String[] input = sc.nextLine().split(" ");

            //calculate score for player 1
            for(int i = 0; i < 5; i+=2)
            {
                double p1 = Double.parseDouble(input[i]);
                double p2 = Double.parseDouble(input[i+1]);

                s_p1 += score(p1, p2);
            }

            //calculate score for player 2
            for(int i = 6; i < 11; i+=2)
            {
                double p1 = Double.parseDouble(input[i]);
                double p2 = Double.parseDouble(input[i+1]);

                s_p2 += score(p1, p2);
            }

            String outcome = "";
            if(s_p1 > s_p2)
            {
                outcome = "PLAYER 1 WINS";
            }else if(s_p2 > s_p1)
            {
                outcome = "PLAYER 2 WINS";
            }else{
                outcome = "TIE";
            }

            System.out.println("SCORE: " + s_p1 + " to " + s_p2 + ", " + outcome);
        }

        sc.close();
    }
}
