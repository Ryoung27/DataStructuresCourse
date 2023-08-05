/**
 * CSCI463ProjectTwo: Use MyStack and MyQueue to write a project that check if a sentence is palindrom
 * 
 * @author Ronnie Young
 * @version 06-16-23
 */
import java.util.Scanner;

public class CSCI463ProjectTwo
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String sentence;
        String again;
        do{
            System.out.println("Enter a sentence, I will tell you if it is a palindrome: ");
            sentence = input.nextLine();
            if(isPalindrome(sentence))
                System.out.println("\"" + sentence + "\" is a palindrome!");
            else
                System.out.println("\"" + sentence + "\" is not a palindrome!");
            System.out.println("Do you want another test (\"YES\" or \"NO\"): ");
            again = input.nextLine();
        }while(again.equalsIgnoreCase("YES"));
        
    }
    
    /**
     * isPalindrom returns true if the given String is a palindrom
     * @
     */
    public static boolean isPalindrome(String sentence)
    {
        // declare a MyStack s
        MyStack<Character> s = new MyStack<>();
        // declare a MyQueue q
        MyQueue<Character> q = new MyQueue<>();
        for(int i = 0; i < sentence.length(); i++)
        {
            char charac = sentence.charAt(i);
            // if ith character in sentence is a letter
            if (Character.isLetter(charac)){
                // convert to upper case and push it into s and q
                charac = Character.toUpperCase(charac);
                s.push(charac);
                q.push(charac);
            }
        }
        while(!s.isEmpty()){
            // if the front of the queue not match the top of stack
            if(!q.peek().equals(s.peek())){
                // return false
                return false;
            }
            // pop out top of the stack and front of the queue
            s.pop();
            q.pop();
        }
        return true;
        }
}