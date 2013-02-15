package tcpConnection;

import java.io.* ;
import java.net.* ;

class Server {
 
 
 public Server(int port) {
  
  try {
   
   ServerSocket skServidor = new ServerSocket( port );

   System.out.println("listening port " + port );
   
    Socket skCliente = skServidor.accept(); 
    OutputStream aux = skCliente.getOutputStream();
    DataOutputStream flow= new DataOutputStream( aux );
 
    flow.writeUTF( "Hello ");
    skCliente.close();

  } catch( Exception e ) {
   System.out.println( e.getMessage() );
  }
 }
 
 public static void main( String[] arg ) {
  
	 BufferedReader input; 
	 int port=80;
	 
	    System.out.print( "TCP port: " ); 
	    try { 
	    	input = 
	        new BufferedReader(new InputStreamReader(System.in));   
	    	port = Integer.parseInt(input.readLine()); 
	    } 
	    catch (IOException e) {
	    	  System.out.print( "Failed port: " ); 
	    } 
	 
	 
	 new Server(port);
 }
}