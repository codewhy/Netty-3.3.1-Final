import java.io.OutputStream;
import java.net.Socket;


public class ClientTest {
    public static void main(String[] args ) throws Exception {
    	int count = 1;
    	while(true)
    	{
    		Socket client = new Socket("localhost", 8080);  
    		OutputStream out1 = client.getOutputStream();  
    		System.err.println("client "+(count++)+client);
    	}
    }  
}  
