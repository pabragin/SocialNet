/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

/**
 *
 * @author Brasha
 */

import business.User;
import db.FriendshipDBWorker;
import db.UserDBWorker;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HttpServer {

    public static void start() throws Throwable {
        try{
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
        }
        catch(BindException e){
            System.out.println("Одна версия приложения уже запущена!");
        }
    }
    public static class Item {
        Integer key;
        User value;
        Item(int k, User v) {
            key = k; value = v;
        }
    }
    
    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream os;

        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        public void run() {
            try {
                readInputHeaders();
                String resp = new String();
                FriendshipDBWorker fdb = new FriendshipDBWorker("jdbc:derby://localhost:1527/SocialNetwork", "pabragin", "147896321");
                UserDBWorker udb = new UserDBWorker();
                ArrayList<User> LU = new ArrayList<>();
                LU = udb.getAllUsers();
                List<Item> list = new ArrayList<Item>();
                for(int i=0; i<LU.size(); i++)
                {
                    list.add(new Item(fdb.GetFriends(LU.get(i).getID()).size(), LU.get(i)));
                    System.out.println(fdb.GetFriends(LU.get(i).getID()).size());
                }
                Collections.sort(list, new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return o1.key. compareTo(o2.key);
                }
                });
                for(int i=list.size()-1; i!=-1; i--)
                {
                    resp+=(" <user id="+"\""+String.valueOf(list.get(i).value.getID())+"\" "+"First_Name="+"\""+list.get(i).value.getFirstName()+"\" "+"Last_Name="+"\""+list.get(i).value.getLastName()+"\" "+ "NumFriends=\""+String.valueOf(list.get(i).key) + "\"" + "/>\r\n");
                }
                writeResponse("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"+
                        "<UserTop color=\"black\" size=\"13.3\">\r\n"+
                        resp +"</UserTop>");
                System.out.println(resp);
            } catch (Throwable t) {
                /*do nothing*/
            } finally {
                try {
                    s.close();
                } catch (Throwable t) {
                    /*do nothing*/
                }
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String s) throws Throwable {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: YarServer/2009-09-09\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + s.length()*2 + "\r\n" +
                    "Connection: close\r\n\r\n";
            System.out.println(s.length());
            String result = response + s;
            os.write(result.getBytes());
            os.flush();
        }

        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while(true) {
                String s = br.readLine();
                if(s == null || s.trim().length() == 0) {
                    break;
                }
            }
        }
    }
}
