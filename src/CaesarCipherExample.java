import java.util.LinkedList;
import java.util.Queue;

/**
 * This example shows how to use Queues to maintain the key for encoding and decoding message using Caesar Cipher
 */

public class CaesarCipherExample {

    public static void main(String[] args) {
        int[] secret_key = {2, 1, -5, 3, -1, 4};
        String message = "All programmers are playwrights and all " +
        "computers are lousy actors.";
        //message = "top secret message!";

        String encoded_message = "";
        String decoded_message = "";

        // Queue containing the key for encoding the message
        Queue<Integer> encoding_queue = new LinkedList<Integer>();
        // Queue containing the key for decoding the message
        Queue<Integer> decoding_queue = new LinkedList<Integer>();

        // Let's add the key to the queues
        for (int i=0; i<secret_key.length; i++) {
            encoding_queue.add(secret_key[i]);
            decoding_queue.add(secret_key[i]);
        }

        // Encode the message using encoding queue
        for (int i=0; i<message.length(); i++) {
            int key = encoding_queue.remove();
            encoded_message += (char)(message.charAt(i) + key);
            encoding_queue.add(key);
        }
        System.out.println("Encoded Message:" + encoded_message);
        // Just to make sure the original message is lost
        message = null;

        // Decode the message using decoding queue
        for (int i=0; i<encoded_message.length(); i++) {
            int key = decoding_queue.remove();
            decoded_message += (char)(encoded_message.charAt(i) - key);
            decoding_queue.add(key);
        }
        System.out.println("Decoded Message:" + decoded_message);

    }
}
