package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import connection.dto.Response;

public class ServerConnection {
	
	//TODO Сделать файл настроек - properties
	
	public static int port = 2233;
	public static String ip = "127.0.0.1";
	
	public Response sendObject(Response response){
		
		try {
			Socket socket = new Socket(ip, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			 oos.writeObject(response);
			 			 
			 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			 try {
					Response serverResponse = (Response) ois.readObject();
					return serverResponse;
				} catch (ClassNotFoundException e) {
					System.out.println("Не удалось получить данные от сервера");					
					e.printStackTrace();
				}	
			 
			
			 oos.flush();
			 oos.close();
			 socket.close();
		}
		catch (ConnectException e) {
			return null;
		}catch (UnknownHostException e) {
			System.out.println("Сервер не найден");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Не удалось установить связь с сервером");
			e.printStackTrace();
		}
		
		return null;
	}

}
