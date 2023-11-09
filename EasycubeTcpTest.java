import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EasycubeTcpTest {
    public static void main(String[] args) throws IOException {

        Socket socket = null;
        PrintWriter outputStream = null;
        InputStream inputStream = null;

        String IP_ADDRESS = "10.0.0.99" ;
        int PORT = 9990 ;


        try {
            socket = new Socket(IP_ADDRESS, PORT); // Open The Socket
            outputStream = new PrintWriter(socket.getOutputStream(), true); // Declare output Stream instance to send command to easycube
            inputStream = socket.getInputStream();  // Declare input Stream instance to get the returned responses from easycube 
        } catch (IOException e) {
            return;
        }

        String command = "MFR";  // Write Command as simple string .

        outputStream.println(command); // Send Command To Easycube tcp

        byte[] response = new byte[2048];
        int bytesRead = inputStream.read(response); // Get Response
        System.out.println(new String(response, 0, bytesRead)); // Print Response to console

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
