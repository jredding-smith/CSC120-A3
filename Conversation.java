import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Hashtable;


// You should **not** update any call signatures in this file
// only modify the body of each function
class Conversation implements ConversationRequirements {

  // Attributes 
  // the possible convesations the user may start with or will be shown if the mirroring does not work 
  String[] randomConvos = {
    "How was your day?",
    "Do you have any plans for today?", 
    "Did you do anything exciting yesterday?",
    "What are you looking forward to this week", 
    "Is there anything you cant shake off you want to tell me?",
    "Do you have any responsibilites you want to tell me about",
    "Whats on your mind",
    "Whats the newest thing youre talking about",
    "Do you find youself busy all the time"
  };  
  
  // Dictornary for mirrored words
  Hashtable <String, String> mirror = new Hashtable <String, String>();
  
  

  // Empty array for transcript to add to for later 
  List<String> Transcript = new ArrayList<>();


   /* Constructor 
   */

   // Actually places the key value pairs for the disconary of mirror 
  Conversation() {
    mirror.put("i", "you");
    mirror.put("me", "you");
    mirror.put("am", "are");
    mirror.put("you", "I");
    mirror.put("my", "your");
    mirror.put("your", "my");
    // * I -> you
  }

  /**
   * Starts and runs the conversation with the user
   */

  // Does the entire functioning of talking 
  public void chat() {
    // established ability to do random convosation starters 
    Random random = new Random();
    int randomIndex = random.nextInt(0, randomConvos.length);

    // ask the user for how many convos they want to have 
    System.out.println("How many times would you like to talk to me? The number must be below 10, no decimals.");
    
    // gets the users input and uses the input to start the for loop 
    Scanner convoOptions = new Scanner(System.in);
    int convoCount = convoOptions.nextInt();

    // Does a full for loop for however many time you want to talk to the computer 
    for (int i = 0; i <= convoCount; i++){
      if (i == 0){
        // does the first convesation starter and adds the random starter to transcript 
        String randomStingStarter = randomConvos[randomIndex];
        System.out.println(randomStingStarter);
        Transcript.add(randomStingStarter);
      } else {
        // Takes in the input and does possible mirroring or random convesation starter 
        Scanner talking = new Scanner(System.in);
        String whatIsSaid = talking.nextLine();
        String lowercaseInput = whatIsSaid.toLowerCase();
        Transcript.add(lowercaseInput);
        String[] words = lowercaseInput.split(" ");
        // Checks to see if the indivdual words are equal to the mirrored words in the dictionary 
        for ( int p = 0; p < words.length; p++){
          if (mirror.containsKey(words[p])) {
            words[p] = mirror.get(words[p]);
          } 

        }  
        // combines the indivdual splitted up words into a sentance but now containing the replaced mirror words 
        String mirroredResponse = String.join(" ", words);

        // checks if there are any words to actually mirror or not. If not, does a random conversation starter and adds to transcript. If it does, mirrors the text and adds a question mark to the end then adds it to transcript 
        if (mirroredResponse.equals(lowercaseInput)){
          String randomNewConvo = randomConvos[randomIndex];
          System.out.println(randomNewConvo);
          Transcript.add(randomNewConvo);
        } else {
          System.out.println(mirroredResponse + "?");
          Transcript.add(mirroredResponse);
        }
      }
    
    }
    // Prints our the transcript when everything is done in terms of initial for loop 
    System.out.println("TRANSCRIPT:");
    for (String item : Transcript ){
      System.out.println(item);
    }
  }


  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
