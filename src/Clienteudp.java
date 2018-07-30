import java.net.*;
import java.io.*;
public class Clienteudp {
	public static void main(String[] args){
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 
	//Se define el socket, número de bytes del buffer, y mensaje.
	 DatagramSocket socket;
	 InetAddress address;
	 byte[] mensaje_bytes = new byte[256];
	 String mensaje="";
	 mensaje_bytes=mensaje.getBytes();
	 
	//Paquete
	 DatagramPacket paquete;
	 
	 String cadenaMensaje="";
	 
	DatagramPacket servPaquete;
	 
	byte[] RecogerServidor_bytes = new byte[256];
	 
	 try {
	 socket = new DatagramSocket();
	 
	address=InetAddress.getByName("localhost");
	 
	do {
	 mensaje = in.readLine();
	 mensaje_bytes = mensaje.getBytes();
	 paquete = new DatagramPacket(mensaje_bytes,mensaje.length(),address,6000);
	 socket.send(paquete);
	 
	RecogerServidor_bytes = new byte[256];
	 
	
	 servPaquete = new DatagramPacket(RecogerServidor_bytes,256);
	 socket.receive(servPaquete);
	 
	//Se convierte el mensaje en un string
	 cadenaMensaje = new String(RecogerServidor_bytes).trim();
	 
	
	 System.out.println(cadenaMensaje);
	 } while (!mensaje.startsWith("fin"));
	 }
	 catch (Exception g) {
	 System.err.println(g.getMessage());
	 System.exit(1);
	 }
	 }
	

}
