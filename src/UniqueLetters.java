import java.util.Scanner;

public class UniqueLetters
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int count = 0;

        for (int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) != ' '){
                ++count;
                word = word.replace(word.charAt(i),' ');
            }
        }

        System.out.println("word: " + word);
        System.out.println("count: " + count);
    }
}

