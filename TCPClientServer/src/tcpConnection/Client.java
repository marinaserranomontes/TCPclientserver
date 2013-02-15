package tcpConnection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
 
	 public Client(String host, int port) {
	  try{
	   
	   Socket skCliente = new Socket( host , port );
	   
	   InputStream aux = skCliente.getInputStream();
	   
	   DataInputStream flujo = new DataInputStream( aux );
	   
	   System.out.println( flujo.readUTF() );
	   
	   skCliente.close();
	   
	  } catch( Exception e ) {
	   
	   System.out.println( e.getMessage() );
	  }
	 }
	 
	 public static void main( String[] arg ) {
		 BufferedReader input; 
		 String host = "";
		 int port=80;
		 
		    System.out.print( "Destination host: " ); 
		    try { 
		    	input = 
		        new BufferedReader(new InputStreamReader(System.in));   
		      host = input.readLine(); 
		    } 
		    catch (IOException e) {
		    	  System.out.print( "Failed host: " ); 
		    } 
		    
		    System.out.print( "TCP port: " ); 
		    try { 
		    	input = 
		        new BufferedReader(new InputStreamReader(System.in));   
		    	port = Integer.parseInt(input.readLine()); 
		    } 
		    catch (IOException e) {
		    	  System.out.print( "Failed port: "+ e.getMessage()); 
		    } 
		 
		 new Client(host, port);
	
		 
	 }
}

