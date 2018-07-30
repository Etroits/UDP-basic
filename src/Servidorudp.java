import java.net.*;
import java.io.*;
public class Servidorudp {
	public static void main(String[] args){
	DatagramSocket socket; 
	
	 boolean fin = false;
	 
	try {
	 //Se crea el socket 
	 socket = new DatagramSocket(6000);
	 
	byte[] mensaje_bytes = new byte[256];
	 String mensaje ="";
	 mensaje = new String(mensaje_bytes);
	 String mensajeComp ="";
	 
	DatagramPacket paquete = new DatagramPacket(mensaje_bytes,256);
	 DatagramPacket envpaquete = new DatagramPacket(mensaje_bytes,256);
	 
	int puerto;
	 InetAddress address;
	 byte[] mensaje2_bytes = new byte[256];
	 
	
	 do {
	 // Se recibe el paquete
	 socket.receive(paquete);


	 mensaje = new String(mensaje_bytes).trim();


	 System.out.println(mensaje);
	 //Obtenemos IP Y PUERTO
	 puerto = paquete.getPort();
	 address = paquete.getAddress();
	 
	 if (mensaje.startsWith("fin")) {
	 mensajeComp="Hasta luego, cliente";
	 }
	 
	 if (mensaje.startsWith("hola")) {
	 mensajeComp="Buenas, cliente";
	 }
	 
	 //formateamos el mensaje de salida
	 mensaje2_bytes = mensajeComp.getBytes();
	 
	//Se prepara el paquete que se quiere enviar
	 envpaquete = new DatagramPacket(mensaje2_bytes,mensajeComp.length(),address,puerto);


	 socket.send(envpaquete);
	 
	} while (1>0);
	 }
	 catch (Exception e) {
	 System.err.println(e.getMessage());
	 System.exit(1);
	 }
	 }
	}

