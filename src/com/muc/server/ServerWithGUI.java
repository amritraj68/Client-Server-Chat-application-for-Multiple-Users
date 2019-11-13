/* Name : Amrit Raj
 * Student ID : 1001723851
 *  */

/*
 * References :
 * https://stackoverflow.com/questions/22534356/java-awt-eventqueue-invokelater-explained
 * https://netbeans.org/kb/docs/java/quickstart-gui.html
 * https://stackoverflow.com/questions/20522685/whats-the-use-of-initcomponents-in-java-constructor
 * 
 */

package com.muc.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

////Start class of a Server GUI program

public class ServerWithGUI extends javax.swing.JFrame 
{

	private static final long serialVersionUID = 1L;
	ArrayList<PrintWriter> clientOutputStreams = new ArrayList<PrintWriter>();

	// arrayList to store the list of Clients accessing the server

	ArrayList<String> users = new ArrayList<String>();


	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton b_clear;// Button to clear the screen of the server
	private javax.swing.JButton b_end;   // button for stopping the server
	private javax.swing.JButton b_start;  // Start button for starting the server
	private javax.swing.JButton b_users;   // to show list of available online users
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea ta_chat;  // TextArea for for chatting or sending the messages

	// End of variables declaration//GEN-END:variables


	// The Main entry Point for the Server application

	public static void main(String args[]) 
	{
		// Makes the frame appear on-screen
		java.awt.EventQueue.invokeLater(new Runnable() //  to post messages to the EventQueue to start the GUI rather than updating the GUI like worker threads. Once main thread exits,but the GUI will keeps the process alive.
		{
			@Override
			public void run() {
				new ServerWithGUI().setVisible(true);
			}
		});
	}
	// code for designing the graphical user interface of the Server side of application

	public ServerWithGUI() 
	{
		setBackground(Color.yellow);
		initComponents();
		this.getContentPane().setBackground(Color.yellow);
	}

	//	Created the initComponents() method using the Netbeans Swing Designer to create Front-end design using the "DESIGN" button , generated the source code and  called like any other method in this program.
	// Created 4 buttons i.e Start server, Close server, Clear the server screen and for online users

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		ta_chat = new javax.swing.JTextArea();

		ta_chat.setForeground(Color.BLACK);
		ta_chat.setBackground(SystemColor.info);

		b_start = new javax.swing.JButton();
		b_start.setFont(new Font("Arial", Font.BOLD, 10));
		b_start.setBackground(Color.blue);

		b_end = new javax.swing.JButton();
		b_end.setFont(new Font("Arial", Font.BOLD, 10));
		b_end.setBackground(Color.blue);

		b_users = new javax.swing.JButton();
		b_users.setFont(new Font("Tahoma", Font.BOLD, 11));
		b_users.setBackground(Color.blue);

		b_clear = new javax.swing.JButton();
		b_clear.setFont(new Font("Tahoma", Font.BOLD, 11));
		b_clear.setBackground(Color.PINK);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Chat - Server's frame");
		setName("server"); // 
		setResizable(false);

		ta_chat.setColumns(20);
		ta_chat.setRows(5);
		jScrollPane1.setViewportView(ta_chat);

		b_start.setText("START");
		b_start.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_startActionPerformed(evt);
			}
		});

		b_end.setText("CLOSE");
		b_end.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_endActionPerformed(evt);
			}
		});

		b_users.setText("Online Users");
		b_users.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_usersActionPerformed(evt);
			}
		});

		b_clear.setText("Clear");
		b_clear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				b_clearActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(layout.createSequentialGroup()
										.addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(b_users, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(b_end, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(b_users, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(b_end, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents


//	Server Class to that handles multiple clients and allows to connect, disconnect the server


	public class ClientHandler implements Runnable	
	{
		BufferedReader reader;
		Socket sock;
		PrintWriter client;

		int id_privateChat ;

		// Constructor that accepts the newly client Socket for the new user

		public ClientHandler(Socket clientSocket, PrintWriter user)//, int useridnumber) 
		{
			client = user;

			try 
			{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			}
			catch (Exception ex) 
			{
				ta_chat.append("Unexpected error... \n");
			}

		}

		// Overriding the run method as clientHandler class implements the Runnable interface
		@Override
		public void run() 
		{
			String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" , privatemsg = "private" ;
			String[] data;

			try 
			{
				while ((message = reader.readLine()) != null) 
				{

					ta_chat.append("\nReceived: " + message + "\n");
					data = message.split(":");
					int counter2steps = 0;
					for (String token:data) 
					{
						if(counter2steps!=2)
							ta_chat.append(token + " ");
						counter2steps++;
					}
//					When the  Client clicks the Connect button, the below if statement will be executed as the form value is connect ="Connect"
					if (data[2].equals(connect)) 
					{
						// Calls the method tellEveryone() to send the message to all the users connected in the chat

						tellEveryone((data[0] + ":" + data[1] + ":" + chat));

						// Adds the user to the list of online users i.e A method userADD is called where the code for adding the connected client to the list is stored

						userAdd(data[0]);
					} 

					//when the client clicks theDisconnect button,  Calls the method tellEveryone() to send the message to all the users connected in the chat that the client has disconnected from the chat.

					else if (data[2].equals(disconnect)) 
					{
						tellEveryone((data[0] + "  has :Disconnected" + ":" + chat));

						// retrieves the thread id of the user that got disconnected

						clientOutputStreams.remove(getid(data[0]));

						// Removes the user to the list of online users i.e A method userRemove is called where the code for removing the connected client from the list is written.
						userRemove(data[0]);
					}

					// Chat button is clicked to send the message to all the users or individual user
					else if (data[2].equals(chat)) 
					{
						tellEveryone(message);
					} 

					// to send the private message, just click Private message button to know how to send the private message to any specific connected user.
					// format for sending is enter  "  @receiver_name your message  " , then the message will be delievered to that particular user

					else if (data[2].equals(privatemsg)) {

						int recievedID  = getid(data[3]);
						//JOptionPane.showMessageDialog(null, ""+recievedID);
						if (recievedID != -1) {
							// method to send individual message to a specific online user

							tellthispersononly(message, recievedID, data[3]);
						} else {
							tellthispersononly(message, recievedID, data[0]);						}

						// requesting the list of online users

					}else if (data[2].equals("request")) {

						int recievedID  ;
						//JOptionPane.showMessageDialog(null, "I am here ");
						StringBuilder stringBuilder = new StringBuilder();
						for (String current_user : users)
						{
							recievedID  = getid(current_user);
							stringBuilder.append(current_user).append(", With ID = ").append(recievedID);
							// stringBuilder.append("\n");
							stringBuilder.append(".   ");
						}           
						recievedID  = getid(data[0]);
						String finalString = stringBuilder.toString();
						finalString = data[0]+ ":" +finalString+ ":" ;
						tellthispersononly(finalString, recievedID, data[0]); // d[0] here is the receiver person which is the in this case the sender itself 

					}
					else 
					{
						ta_chat.append("No Conditions were met. \n");
					}
				} 
			} 
			catch (Exception ex) 
			{
				// clientOutputStreams.remove(getid(data[0]));
				ta_chat.append("Lost the connection. \n");
			} 
		} 
	}



	// This Stop button is clicked to stop the server connection
	private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
		try 
		{
			// Thread.sleep(500);                 //4000 milliseconds is five second.
			ta_chat.append("\n");
			ta_chat.append("\n");
			ta_chat.append("\n");
			ta_chat.append("\n");
			tellEveryone("Server: is stopping and all users will be disconnected:Chat");
			ta_chat.append("Server stopping ... \n");
			//  Thread.sleep(500);   
			ta_chat.setText("");
			ta_chat.setText("closing everything ...");
			Thread.sleep(500);
			System.exit(0);

		} 
		catch(InterruptedException ex) {Thread.currentThread().interrupt();}

		tellEveryone("Server:is stopping and all users will be disconnected.\n:Chat");
		ta_chat.append("Server stopping... \n");

		ta_chat.setText("");
	}//GEN-LAST:event_b_endActionPerformed

	//The Start button is clicked to invoke the below method to start the server..the control will goes to the ServerStart class where a main server thread is created to handle the requests from clients
	
	private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
		Thread starter = new Thread(new ServerStart()); // main server thread created
		starter.start(); // main server thread is started here
		ta_chat.setEditable(false);
		ta_chat.append(" Server has been started \n Waiting for connection ...");
		changetxtareafontsize(ta_chat) ;
	}//GEN-LAST:event_b_startActionPerformed

	// this method is invoked when clicked on the button " Online users"
	
	private void b_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_usersActionPerformed
		ta_chat.append("\n Online users : \n");

		// if there are no users online, it returns no one is online
		// if there are online users, it shows the thread id with username
		if(!users.isEmpty())
		{


			for (String current_user : users)
			{
				ta_chat.append(current_user + ", With ID = " + getid(current_user) );
				ta_chat.append("\n");
			}    
		}else {
			ta_chat.append(" No one is online ...");
		}
	}//GEN-LAST:event_b_usersActionPerformed

	// this method is invoked when clicked on the clear button to clear the screen of the server

	private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
		ta_chat.setText("");
	}//GEN-LAST:event_b_clearActionPerformed

	// Start of a Server worker class which receives the requests from clients
	public class ServerStart implements Runnable 
	{

		@Override
		public void run() 
		{
//			clientOutputStreams = new PrintWriter[15];
//			users = new ArrayList(); 
			//  int id = 0 ;

			try 
			{
				// Creating the server socket , serverSock accepts connections on the port 6000
				@SuppressWarnings("resource")
				ServerSocket serverSock = new ServerSocket(6000);

				while (true) 
				{
					Socket clientSock = serverSock.accept();// client socket is created
					PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
//					clientOutputStreams[id]= writer;
					clientOutputStreams.add(writer);

					// ClientHandler class is created that listens to multiple client requests and creates a separate thread for each individual client rquest that comes for server connection
					Thread listener = new Thread(new ClientHandler(clientSock, writer)); //, id));
					listener.start();
					ta_chat.append("Got a connection. \n");

					//	id  ++ ;
				}
			}
			catch (Exception ex)
			{
				ta_chat.append("Error making a connection. \n");
			}
		}
	}

	// to retrieve the user id of the client connected to the chat server
	public int getid(String data){

		int userid = users.indexOf(data);
		// JOptionPane.showMessageDialog(null, "the name is : "+data+ ", his ID is : "+userid);
		return userid ;
	}
//	this method is used to add the client to the list of online users i.e an arraylist of "users" is maintained to register the username of multiple clients
	public void userAdd (String data) 
	{
		String message, s = ": :Connect", done = "Server: :Done", name = data;
		users.add(name); // add everynew user in this array list
		for (String token:users) // advanced for loop to get each name from the the array
		{
			message = (token + s); // message will be his name plus the string connect
			tellEveryone(message);
		}
		tellEveryone(done);
	}

	// this method is invoked when the client clicks the disconnect button and user is removed from the arraylist of users
	public void userRemove (String data) 
	{
		@SuppressWarnings("unused")
		String message, s = ": :Disconnect", done = "Server: :Done", name = data;

		users.remove(name);

		for (String UserName:users) 
		{
			message = (UserName + s);
			tellEveryone(message);
		}
		//tellEveryone(done);
	}

	// to send a message to a specific client i.e one to one message
	public void tellthispersononly(String msg , int personid, String recievername){

		if (personid == -1) {

			msg =  "The Server ... : The User is Not Found in the online users your message has not been deliverd  :private";
//			tellthispersononly(Errormsg, getid(data[0]), data[0]);
//			//JOptionPane.showMessageDialog(null, "No Name of the online users matches this name : "+ data[3] +"\n Check the online users correctly ", "This user is not found or not online", JOptionPane.ERROR_MESSAGE);
			personid=getid(recievername);
			try 
			{
				PrintWriter writer =   clientOutputStreams.get(personid);   //(PrintWriter) it.next();
				writer.println(msg);
				writer.flush();
				ta_chat.append("Sending to {"+recievername+"} only this msg : Message not sent because the User not found in the online Users \n");
				ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
			}catch (Exception ex) 
			{
				ta_chat.append("Error in telling this to "+ recievername +"." +"\n");
			}

		} else {



			if (clientOutputStreams.get(personid)!= null) {

				try 
				{
					PrintWriter writer =    clientOutputStreams.get(personid); //clientOutputStreams[personid];   //(PrintWriter) it.next();
					writer.println(msg);
					writer.flush();
					ta_chat.append("Sending to {"+recievername+"} only: msg :  " + msg + "\n");
					ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
				}catch (Exception ex) 
				{
					ta_chat.append("Error in telling this "+ recievername +"." +"\n");
				}
			}
			else
			{
				ta_chat.append("Error in telling this ... his ID not found OR His outputstream is null "+ recievername +"." +"\n");
			}
		}
	}

	public void changetxtareafontsize(JTextArea txtarea){
		Font font1 = new Font("SansSerif", Font.BOLD, 12);
		txtarea.setFont(font1);
	}

	//Sending message to all the users connected to the Chat server

	public void tellEveryone(String message) 
	{

		Iterator<PrintWriter> it = clientOutputStreams.iterator(); // itrator for looping 

		while (it.hasNext()) 
			// for(int i=0 ; i<clientOutputStreams.length ;i++)
		{
			//        if (clientOutputStreams[i]!=null) {

			try 
			{
				PrintWriter writer = (PrintWriter) it.next();  //clientOutputStreams[i];   //(PrintWriter) it.next();
				writer.println(message);
				//ta_chat.append("Sending to all: " + message + "\n");
				writer.flush();
				ta_chat.setCaretPosition(ta_chat.getDocument().getLength());

			} 
			catch (Exception ex) 
			{
				ta_chat.append("Error telling everyone. \n");
			}
		} 
	}
}
