// SimpleEchoServer.java
// This class is the server side of a simple echo server based on
// UDP/IP. The server receives from a client a packet containing a character
// string, then echoes the string back to the client.
// Last edited February 24, 2002 --db

import java.io.*;
import java.net.*;

/**
 * @author radityabudianto
 *
 */
/**
 * @author radityabudianto
 *
 */
public class Intermediary {

   DatagramPacket sendPacketIntermediary, receivePacketIntermediary;
   DatagramSocket sendSocketIntermediary, receiveSocketIntermediary;

   public Intermediary()
   {
      try {
         // Construct a datagram socket and bind it to any available 
         // port on the local host machine. This socket will be used to
         // send UDP Datagram packets.
         sendSocketIntermediary = new DatagramSocket();

         // Construct a datagram socket and bind it to port 5000 
         // on the local host machine. This socket will be used to
         // receive UDP Datagram packets.
        
         receiveSocketIntermediary = new DatagramSocket(68);
         System.out.println("receiverSocketFromClient bounded at Port:"+receiveSocketIntermediary.getLocalPort());
      } catch (SocketException se) {
         se.printStackTrace();
         System.exit(1);
      }
   }

   
   
   
   public void receiveAndEcho()
   {    
      //System.out.println("test");
      // Construct a DatagramPacket for receiving packets up 
      // to 100 bytes long (the length of the byte array).
       
      byte data[] = new byte[100];
      receivePacketIntermediary = new DatagramPacket(data, data.length);

      // Block until a datagram packet is received from receiveSocket.
    

         try {
            receiveSocketIntermediary.receive(receivePacketIntermediary);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }  
    
             
       
      
  
      

      // Process the received datagram.
     System.out.println("Server: Packet received:");
      System.out.println("From host: " + receivePacketIntermediary.getAddress());
      System.out.println("Host port: " + receivePacketIntermediary.getPort());
      System.out.println("Length: " + receivePacketIntermediary.getLength());
      System.out.print("Containing: " );

      // Get a reference to the data inside the received datagram.
      data = receivePacketIntermediary.getData();

      // Form a String from the byte array.
      String received = new String(data);   
      System.out.println(received);
      
      //close Bounded port 68 every time message is received
     
      
      
      
      // Create a new datagram packet containing the string received from the client.

      // Construct a datagram packet that is to be sent to a specified port 
      // on a specified host.
      // The arguments are:
      //  data - the packet data (a byte array). This is the packet data
      //         that was received from the client.
      //  receivePacketIntermediary.getLength() - the length of the packet data.
      //    Since we are echoing the received packet, this is the length 
      //    of the received packet's data. 
      //    This value is <= data.length (the length of the byte array).
      //  receivePacketIntermediary.getAddress() - the Internet address of the 
      //     destination host. Since we want to send a packet back to the 
      //     client, we extract the address of the machine where the
      //     client is running from the datagram that was sent to us by 
      //     the client.
      //  receivePacketIntermediary.getPort() - the destination port number on the 
      //     destination host where the client is running. The client
      //     sends and receives datagrams through the same socket/port,
      //     so we extract the port that the client used to send us the
      //     datagram, and use that as the destination port for the echoed
      //     packet.


      sendPacketIntermediary = new DatagramPacket(data, receivePacketIntermediary.getLength(),
                               receivePacketIntermediary.getAddress(), 71);
      
      try {
         sendSocketIntermediary.send(sendPacketIntermediary);
       } catch (IOException e) {
          e.printStackTrace();
          System.exit(1);
       }
      System.out.println( "Server: Sending packet:");
      System.out.println("To host: " + sendPacketIntermediary.getAddress());
      System.out.println("Destination host port: " + sendPacketIntermediary.getPort());
      System.out.println("Length: " + sendPacketIntermediary.getLength());
      System.out.print("Containing: ");
      System.out.println(new String(sendPacketIntermediary.getData()));

      // Send the datagram packet to the client via the send socket. 

      

      System.out.println("Server: packet sent");

      // We're finished, so close the sockets.
      //receiveSocketIntermediary.close();
      sendSocketIntermediary.close();
      
   }

   public static void main( String args[] )
   {
      Intermediary c = new Intermediary();
      c.receiveAndEcho();
   }
}