package mx.itson.arqsoft.sockets;

import java.net.*;
import java.io.*;

public class ChatClient {
  private String hostname;
  private int port;
  private String userName;
 
  public ChatClient(String hostname, int port) {
    this.hostname = hostname;
    this.port = port;
  }

  public static void main(String[] args) {
    if (args.length < 2) return;

    String hostname = args[0];
    int port = Integer.parseInt(args[1]);

    ChatClient client = new ChatClient(hostname, port);
    client.execute();
  }
 
  public void execute() {
    try {
      Socket socket = new Socket(hostname, port);
      System.out.println("Conectado al Servidor de Chat.");
      new UserReadClientThread(socket, this).start();
      new UserWriteClientThread(socket, this).start();
    } catch (UnknownHostException ex) {
      System.out.println("No se encontró el servidor: " + ex.getMessage());
    } catch (IOException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }
 
  void setUserName(String userName) {
    this.userName = userName;
  }
 
  String getUserName() {
    return this.userName;
  }
}
