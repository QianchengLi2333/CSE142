//<Qiancheng Li>
//<10/13/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #1>
//
//<This program will produce the lyrics of the song "There Was an
//Old Woman Who Swallowed a Fly."
//The sixth verse was written by myself.>

public class Song {
    public static void main (String[] args) {
        firstVerse();
        secondVerse();
        thirdVerse();
        fourthVerse();
        fifthVerse();
        sixthVerse();
        seventhVerse();
    }
     
    //Produce the common end part of each verse.
    public static void end() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();
    }
    
    //Produce the first verse of this song.
    public static void firstVerse() {
        System.out.println("There was an old woman who swallowed a fly.");
        end();
    }
    
    //Produce the end part of the second verse.
    public static void secondEnd() {
        System.out.println("She swallowed the spider to catch the fly,");
        end();
    }
    
    //Produce the second verse of this song.
    public static void secondVerse() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        secondEnd();
    }
    
    //Produce the end part of the third verse.
    public static void thirdEnd() {
        System.out.println("She swallowed the bird to catch the spider,");
        secondEnd();
    }
    
    //Produce the third verse of this song.
    public static void thirdVerse() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        thirdEnd();
    }
    
    //Produce the end part of the fourth verse.
    public static void fourthEnd() {
        System.out.println("She swallowed the cat to catch the bird,");
        thirdEnd();
    }
    
    //Produce the fourth verse of this song.
    public static void fourthVerse() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        fourthEnd();
    }
    
    //Produce the end part of the fifth verse.
    public static void fifthEnd() {
        System.out.println("She swallowed the dog to catch the cat,");
        fourthEnd();
    }
    
    //Produce the fifth verse of this song.
    public static void fifthVerse() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        fifthEnd();
    }
    
    //Produce the end part of the sixth verse.
    public static void sixthEnd() {
        System.out.println("She swallowed the pig to catch the dog,");
        fifthEnd();
    }
    
    //Produce the sixth verse of this song.
    public static void sixthVerse() {
        System.out.println("There was an old woman who swallowed a pig,");
        System.out.println("How hungry she was to swallow a pig.");
        sixthEnd();
    }
    
    //Produce the seventh verse of this song.
    public static void seventhVerse() {
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }
}
