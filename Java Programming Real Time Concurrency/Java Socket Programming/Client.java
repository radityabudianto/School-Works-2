import java.io.*;
import java.net.*;
//import java.lang.*;

public class Client {
    boolean replyStatus=false;
    DatagramSocket sendSocket,receiveSocket;
    DatagramPacket sendPacket,receivePacket;
    InetAddress localhost;
    

    public Client(){
    
        //localHost
        try{
            localhost=InetAddress.getLocalHost();
        }catch(UnknownHostException e){
            System.out.println("Can't get IP");
        }
        
        //SocketAddress send = new InetSocketAddress(localhost,68);    
    //    SocketAddress receive = new InetSocketAddress(localhost,71);
        
        try {
            sendSocket=new DatagramSocket();
            } catch (SocketException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
        
        try {
            receiveSocket = new DatagramSocket(71);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }// end Class Client
    
    public void sendClient(){
        
        if(receiveSocket.isConnected()==false){
        System.out.println("computer IP:"+localhost.getHostAddress());
        System.out.println("Bounded Socket port:"+sendSocket.getLocalPort());
    
    
        String s  = "TEST ABCDEFHG";        
        byte[] data=s.getBytes(); 
        
        sendPacket = new DatagramPacket(data, data.length,localhost,68);
      
    
         //send packet port 68 from sendSocket        
        
        try {
            sendSocket.send(sendPacket);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Packet sent");
        System.out.println("UDP sent port:"+sendPacket.getPort());
        System.out.println("packet contents:"+new String(sendPacket.getData()));
        
        }
    
    
    
        System.out.println(receiveSocket.isConnected());
        //Port71 for receive message
    if(receiveSocket.isConnected()){

        byte dataReceived[] = new byte[100];
         receivePacket = new DatagramPacket(dataReceived, dataReceived.length);

          
    
         // Block until a datagram is received via sendReceiveSocket.  
        
         try {
          receiveSocket.receive(receivePacket);
         } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        
        
        System.out.println("abc");
        //sockReceive.close();
        System.out.println(new String(receivePacket.getData()));
        System.out.println("abc");
        //sendReceiveSocket.close();

        }
    }
    




public static void main(String[] args){
//    sendReceiveSocket.close();
        Client test=new Client();
        test.sendClient();
    //    test.receiveClient();

        
    }
}