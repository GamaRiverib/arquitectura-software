package mx.itson.arqsoft.sockets;

import java.io.*;
import java.net.*;

public class UserWriteClientThread extends Thread {
  private PrintWriter writer;
  private Socket socket;
  private ChatClient client;

  public UserWriteClientThread(Socket socket, ChatClient client) {
    this.socket = socket;
    this.client = client;

    try {
      OutputStream output = socket.getOutputStream();
      writer = new PrintWriter(output, true);
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  public void run() {

    Console console = System.console();

    String userName = console.readLine("\nEscribe tu nombre: ");
    client.setUserName(userName);
    writer.println(userName);

    String text;

    do {
      text = console.readLine("[" + userName + "]: ");
      writer.println(text);
    } while (!text.equals("bye"));

    try {
      socket.close();
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }
}
