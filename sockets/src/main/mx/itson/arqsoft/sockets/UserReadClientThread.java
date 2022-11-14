package mx.itson.arqsoft.sockets;

import java.io.*;
import java.net.*;

public class UserReadClientThread extends Thread {
  private BufferedReader reader;
  private Socket socket;
  private ChatClient client;

  public UserReadClientThread(Socket socket, ChatClient client) {
    this.socket = socket;
    this.client = client;

    try {
      InputStream input = this.socket.getInputStream();
      reader = new BufferedReader(new InputStreamReader(input));
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
 
  public void run() {
    while (true) {
      try {
        String response = reader.readLine();
        System.out.println("\n" + response);
        // prints the username after displaying the server's message
        if (client.getUserName() != null) {
          System.out.print("[" + client.getUserName() + "]: ");
        }
      } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
        break;
      }
    }
  }
}
