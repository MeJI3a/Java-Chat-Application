import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.System.out;

public final class  Chatclient extends JFrame implements ActionListener {
    
    BufferedReader bufferedReader;
    String chatname;
    PrintWriter printWriter;
    JButton sendButton,Close;
    JTextArea  chatSArea;
    JTextField chateField;
    Socket socket;
    
    public Chatclient(String uname,String servername) throws Exception {
        super(uname); 
        socket  = new Socket(servername,8000);
        this.chatname = uname;
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println(uname);
        bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream()) ) ;
        chatregion();
        new messageInformThreading().start(); 
    }
    
    public void chatregion() {
        sendButton = new JButton("Send");
        Close = new JButton("Close");
        chatSArea = new JTextArea();
        chatSArea.setRows(35);
        chatSArea.setColumns(55);
        chatSArea.setEditable(false);
        chateField  = new JTextField(60);
        JScrollPane option = new JScrollPane(chatSArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        option.setBackground(Color.yellow);
        add(option,"Center");
        JPanel allJPanel = new JPanel( new FlowLayout());
       allJPanel.add(chateField);
        
        allJPanel.add(sendButton);
        allJPanel.add(Close);
        allJPanel.setBackground(Color.LIGHT_GRAY);
        allJPanel.setName("Application Started");
        allJPanel.setBackground(Color.blue);
        add(allJPanel,"South");
        sendButton.addActionListener(this);
        Close.addActionListener(this);
        setSize(400,200);
        setVisible(true);
        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == Close ) {
            printWriter.println("Closing"); 
            System.exit(0);
        } else {
            
            printWriter.println(chateField.getText());
            chatSArea.append("Me:"+chateField.getText()+"\n");
            chateField.setText(null);
            
        }
    }
    
    public static void main(String ... args) {
    
        
        String username = JOptionPane.showInputDialog(null,"Provide your name :", "Chatting Application",
             JOptionPane.PLAIN_MESSAGE);
         String passString = JOptionPane.showInputDialog(null,"Provide your password :", "Chatting Application",
             JOptionPane.PLAIN_MESSAGE);
        String name_OfString = "localhost";  
        try {
            new Chatclient( username ,name_OfString);
        } catch(Exception error) {
            out.println( "Error:" + error.getMessage());
        }
        
    } 
    class  messageInformThreading extends Thread {
        @Override
        public void run() {
            String lineIString;
            try {
                while(true) {
                    lineIString = bufferedReader.readLine();
                    chatSArea.append("\t\t"+lineIString + "\n");
                }
            } catch(Exception ex) {}
        }
    }
} 
