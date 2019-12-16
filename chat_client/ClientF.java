package chat_client;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author MAISON XP
 */   

public class ClientF extends javax.swing.JFrame 
{
    String userN, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket s;
    BufferedReader reader;
    PrintWriter writer;
    
    
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    
    
    public void userAdd(String data) 
    {
         users.add(data);
    }
    
  
    
    public void userRemove(String data) 
    {
         TxtAChat.append(data + " is now offline.\n");
    }
    
    
    
    public void writeUsers() 
    {
         String[] tempList = new String[(users.size())];
         users.toArray(tempList);
         for (String token:tempList) 
         {
             users.add(token + "\n");
         }
    }
    
   
    public void sendDisconnect() 
    {
        String bye = (userN + ": :Disconnect");
        try
        {
            writer.println(bye); 
            writer.flush(); 
        } catch (Exception e) 
        {
            TxtAChat.append("Disconnection message unsent!.\n");
        }
    }

    
    
    public void Disconnect() 
    {
        try 
        {
            TxtAChat.append("Disconnected.\n");
            s.close();
        } catch(Exception ex) {
            TxtAChat.append(" Disconnection failed. \n");
        }
        isConnected = false;
        TxtFUserN.setEditable(true);

    }
    
    public ClientF() 
    {
        initComponents();
    }
    
    
    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, connect = "Connect", disconnect = "Disconnect", done = "Done", chat = "Chat";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");

                     if (data[2].equals(chat)) 
                     {
                        TxtAChat.append(data[0] + ": " + data[1] + "\n");
                        TxtAChat.setCaretPosition(TxtAChat.getDocument().getLength());
                     } 
                     else if (data[2].equals(connect))
                     {
                        TxtAChat.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelAddress = new javax.swing.JLabel();
        TxtFAddress = new javax.swing.JTextField();
        LabelPort = new javax.swing.JLabel();
        TxtFPort = new javax.swing.JTextField();
        LabelUserN = new javax.swing.JLabel();
        TxtFUserN = new javax.swing.JTextField();
        LabelPsswrd = new javax.swing.JLabel();
        TxtFPsswrd = new javax.swing.JTextField();
        BtnConnect = new javax.swing.JButton();
        BtnDisconnect = new javax.swing.JButton();
        BtnAnony = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAChat = new javax.swing.JTextArea();
        TxtFChat = new javax.swing.JTextField();
        BtnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setBackground(new java.awt.Color(0, 204, 204));
        setName("client"); // NOI18N
        setResizable(false);

        LabelAddress.setText("Address : ");

        TxtFAddress.setText("localhost");
        TxtFAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addressActionPerformed(evt);
            }
        });

        LabelPort.setText("Port :");

        TxtFPort.setText("2222");
        TxtFPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_portActionPerformed(evt);
            }
        });

        LabelUserN.setText("Username :");

        TxtFUserN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        LabelPsswrd.setText("Password : ");

        BtnConnect.setText("Connecter");
        BtnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connectActionPerformed(evt);
            }
        });

        BtnDisconnect.setText("Deconnecter");
        BtnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_disconnectActionPerformed(evt);
            }
        });

        BtnAnony.setText("Utilisateur");
        BtnAnony.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_anonymousActionPerformed(evt);
            }
        });

        TxtAChat.setColumns(20);
        TxtAChat.setRows(5);
        jScrollPane1.setViewportView(TxtAChat);

        BtnSend.setBackground(new java.awt.Color(0, 102, 102));
        BtnSend.setForeground(new java.awt.Color(255, 255, 255));
        BtnSend.setText("SEND");
        BtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtFChat, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LabelUserN, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(LabelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtFAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(TxtFUserN))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelPsswrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtFPsswrd)
                            .addComponent(TxtFPort, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnConnect)
                                .addGap(2, 2, 2)
                                .addComponent(BtnDisconnect)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(BtnAnony, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAddress)
                    .addComponent(TxtFAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPort)
                    .addComponent(TxtFPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAnony))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFUserN)
                    .addComponent(TxtFPsswrd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelUserN)
                        .addComponent(LabelPsswrd)
                        .addComponent(BtnConnect)
                        .addComponent(BtnDisconnect)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFChat)
                    .addComponent(BtnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        BtnConnect.getAccessibleContext().setAccessibleName("Connecter");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addressActionPerformed
       
    }//GEN-LAST:event_tf_addressActionPerformed

    private void tf_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_portActionPerformed
   
    }//GEN-LAST:event_tf_portActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
    
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void b_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connectActionPerformed
        if (isConnected == false) 
        {
            userN = TxtFUserN.getText();
            TxtFUserN.setEditable(false);

            try 
            {
                s = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(s.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(s.getOutputStream());
                writer.println(userN + ":is Connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                TxtAChat.append(" Connectoion failed! re-try . \n");
                TxtFUserN.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            TxtAChat.append(" You're already Connected. \n");
        }
    }//GEN-LAST:event_b_connectActionPerformed

    private void b_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_disconnectActionPerformed
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_b_disconnectActionPerformed

    private void b_anonymousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_anonymousActionPerformed
        TxtFUserN.setText("");
        if (isConnected == false) 
        {
            String anon="anon";
            Random generator = new Random(); 
            int i = generator.nextInt(999) + 1;
            String is=String.valueOf(i);
            anon=anon.concat(is);
            userN=anon;
            
            TxtFUserN.setText(anon);
            TxtFUserN.setEditable(false);

            try 
            {
                s = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(s.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(s.getOutputStream());
                writer.println(anon + ":is Connected.:Connect");
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                TxtAChat.append("You're already Connecte!. \n");
                TxtFUserN.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            TxtAChat.append("You're already Connected! \n");
        }        
    }//GEN-LAST:event_b_anonymousActionPerformed

    private void b_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sendActionPerformed
        String nothing = "";
        if ((TxtFChat.getText()).equals(nothing)) {
            TxtFChat.setText("");
            TxtFChat.requestFocus();
        } else {
            try {
               writer.println(userN + ":" + TxtFChat.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                TxtAChat.append("Message unsent. \n");
            }
            TxtFChat.setText("");
            TxtFChat.requestFocus();
        }

        TxtFChat.setText("");
        TxtFChat.requestFocus();
    }//GEN-LAST:event_b_sendActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new ClientF().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnony;
    private javax.swing.JButton BtnConnect;
    private javax.swing.JButton BtnDisconnect;
    private javax.swing.JButton BtnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel LabelAddress;
    private javax.swing.JLabel LabelPsswrd;
    private javax.swing.JLabel LabelPort;
    private javax.swing.JLabel LabelUserN;
    private javax.swing.JTextArea TxtAChat;
    private javax.swing.JTextField TxtFAddress;
    private javax.swing.JTextField TxtFChat;
    private javax.swing.JTextField TxtFPsswrd;
    private javax.swing.JTextField TxtFPort;
    private javax.swing.JTextField TxtFUserN;
    // End of variables declaration//GEN-END:variables
    }

