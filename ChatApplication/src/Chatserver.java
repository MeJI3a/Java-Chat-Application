import java.io.*;
import java.util.*;
import java.net.*;
import static java.lang.System.out;

public class Chatserver {

    public static void main(String... args) throws Exception {
        new Chatserver().startServer();
    } 
    
   
    Vector<Chatgroup> clientInfom = new Vector<Chatgroup>();
     Vector<String> onlineusers = new Vector<String>();

 

    

    public void sendingMessageToAll(String username, String messageinform) {

        for (Chatgroup group : clientInfom) {
            if (!group.getonlineClients().equals(username)) {
                group.Messagesend(username, messageinform);
            }
        }
    }
       public void startServer() throws Exception {
        ServerSocket serversocket = new ServerSocket(8000, 10);
        out.println(" The server has started and it is running................");
        while (true) {
            Socket newclient = serversocket.accept();
            Chatgroup group = new Chatgroup(newclient);
            clientInfom.add(group);
        }
    }

    class Chatgroup extends Thread {

        String useInformation = "";
        BufferedReader inputInfomation;
        PrintWriter outputData;

        public Chatgroup(Socket client) throws Exception {

            inputInfomation = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputData = new PrintWriter(client.getOutputStream(), true);

            useInformation = inputInfomation.readLine();
            onlineusers.add(useInformation); 
            start();
        }
         public String getonlineClients() {
            return useInformation;
        }

        public void Messagesend(String chatd, String chatm) {
            outputData.println(chatd + " Says:" + chatm);
        }

       

        @Override
        public void run() {
            String line;
            try {
                while (true) {
                    line = inputInfomation.readLine();
                    if (line.equals("end")) {
                        clientInfom.remove(this);
                        onlineusers.remove(useInformation);
                        break;
                    }
                    sendingMessageToAll(useInformation, line); 
                }
            } 
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } 
    } 
} 
