package com.soundstreetradio.ftp_downloader.lancher;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Execute the process
class GUIProcess {
 public static void main(String[] args) {
     new GUIProcess();
 }
 JTextArea textarea;
 private JTextField coHost;
 private JTextField coUser;
 private JTextField coPass;
 private JTextField dpKey;
 private JTextField dpSecret;
 private JTextField upHost;
 private JTextField upUser;
 private JTextField upPass;
 private JTextField upPath;
 private Process deployProcess;
 private String command;

 GUIProcess() {
     JFrame frmPodcastCreatorFor = new JFrame();
     frmPodcastCreatorFor.setTitle("Podcast Creator For Radio.co");
     frmPodcastCreatorFor.getContentPane().setLayout(null);
     textarea = new JTextArea(){
    	@Override
    	public void append(String str) {
    		super.append(str);
    		textarea.setCaretPosition(textarea.getDocument().getLength());
    	}
    };
     textarea.setCaretPosition(textarea.getText().length());
     JScrollPane scrollPane = new JScrollPane(textarea);
     scrollPane.setBounds(12, 43, 451, 470);
     frmPodcastCreatorFor.getContentPane().add(scrollPane);

     JButton btnRunAll = new JButton("RUN");
     btnRunAll.setBounds(12, 10, 93, 23);
     btnRunAll.addActionListener(
    		 new ActionListener(){
    			 public void actionPerformed(ActionEvent e){
    				 command = "java -jar PodcastCreater.jar all";
    			 }
    		 });
     frmPodcastCreatorFor.getContentPane().add(btnRunAll);

//     JButton btnMedia = new JButton("MEDIA");
//     btnMedia.setBounds(117, 10, 93, 23);
//     btnMedia.addActionListener(
//    		 new ActionListener(){
//    			 public void actionPerformed(ActionEvent e){
//    				 command = "java -jar PodcastCreater.jar media";
//    			 }
//    		 });
//     frmPodcastCreatorFor.getContentPane().add(btnMedia);
//
//     JButton btnBuild = new JButton("BUILD");
//     btnBuild.setBounds(222, 10, 93, 23);
//     btnBuild.addActionListener(
//    		 new ActionListener(){
//    			 public void actionPerformed(ActionEvent e){
//    				 command = "java -jar PodcastCreater.jar build";
//    			 }
//    		 });
//     frmPodcastCreatorFor.getContentPane().add(btnBuild);

     JLabel lblSettingsFotRadiocos = new JLabel("Radio.co's FTP Settings");
     lblSettingsFotRadiocos.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
     lblSettingsFotRadiocos.setHorizontalAlignment(SwingConstants.CENTER);
     lblSettingsFotRadiocos.setBounds(475, 4, 270, 34);
     frmPodcastCreatorFor.getContentPane().add(lblSettingsFotRadiocos);

     coHost = new JTextField();
     coHost.setBounds(549, 46, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(coHost);
     coHost.setColumns(10);

     coUser = new JTextField();
     coUser.setColumns(10);
     coUser.setBounds(549, 75, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(coUser);

     coPass = new JTextField();
     coPass.setColumns(10);
     coPass.setBounds(549, 104, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(coPass);

     JLabel lblDropboxApiKey = new JLabel("Dropbox API key Settings");
     lblDropboxApiKey.setHorizontalAlignment(SwingConstants.CENTER);
     lblDropboxApiKey.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
     lblDropboxApiKey.setBounds(475, 133, 270, 34);
     frmPodcastCreatorFor.getContentPane().add(lblDropboxApiKey);

     dpKey = new JTextField();
     dpKey.setColumns(10);
     dpKey.setBounds(549, 177, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(dpKey);

     dpSecret = new JTextField();
     dpSecret.setColumns(10);
     dpSecret.setBounds(549, 206, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(dpSecret);

     JLabel lblPlaylistOutputFtp = new JLabel("Playlist Output FTP Settings");
     lblPlaylistOutputFtp.setHorizontalAlignment(SwingConstants.CENTER);
     lblPlaylistOutputFtp.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
     lblPlaylistOutputFtp.setBounds(475, 235, 270, 34);
     frmPodcastCreatorFor.getContentPane().add(lblPlaylistOutputFtp);

     upHost = new JTextField();
     upHost.setColumns(10);
     upHost.setBounds(549, 279, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(upHost);

     upUser = new JTextField();
     upUser.setColumns(10);
     upUser.setBounds(549, 308, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(upUser);

     upPass = new JTextField();
     upPass.setColumns(10);
     upPass.setBounds(549, 337, 196, 19);
     frmPodcastCreatorFor.getContentPane().add(upPass);

     upPath = new JTextField();
     upPath.setColumns(10);
     upPath.setBounds(549, 366, 197, 19);
     frmPodcastCreatorFor.getContentPane().add(upPath);

     JButton btnNewButton = new JButton("Update Settings");
     btnNewButton.addActionListener(
    		 new ActionListener(){
    			 public void actionPerformed(ActionEvent e){
    				 command = "java -jar PodcastCreater.jar set "
    						 	+coHost.getText()+" "+coUser.getText()+" "+coPass.getText()+" "+dpKey.getText()+" "+dpSecret.getText()+" "+upHost.getText()+" "+upUser.getText()+" "+upPass.getText()+" "+upPath.getText();
    			 }
    		 });
     btnNewButton.setBounds(475, 406, 270, 23);
     frmPodcastCreatorFor.getContentPane().add(btnNewButton);

     JLabel lblNewLabel = new JLabel("Hostname");
     lblNewLabel.setBounds(475, 49, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblNewLabel);

     JLabel lblUsername = new JLabel("Username");
     lblUsername.setBounds(475, 78, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblUsername);

     JLabel lblPassword = new JLabel("Password");
     lblPassword.setBounds(475, 107, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblPassword);

     JLabel lblApiKey = new JLabel("API key");
     lblApiKey.setBounds(475, 177, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblApiKey);

     JLabel lblApiSecret = new JLabel("API secret");
     lblApiSecret.setBounds(475, 209, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblApiSecret);

     JLabel lblHostname = new JLabel("Hostname");
     lblHostname.setBounds(475, 282, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblHostname);

     JLabel label_2 = new JLabel("Username");
     label_2.setBounds(475, 311, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(label_2);

     JLabel label_3 = new JLabel("Password");
     label_3.setBounds(475, 340, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(label_3);

     JLabel lblUploadPath = new JLabel("Upload Path");
     lblUploadPath.setBounds(475, 369, 79, 13);
     frmPodcastCreatorFor.getContentPane().add(lblUploadPath);
     frmPodcastCreatorFor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frmPodcastCreatorFor.setSize(766, 550);
     frmPodcastCreatorFor.setVisible(true);

     Properties prop = new Properties();
         try {
           prop.load(new FileInputStream("config/settings.txt"));
         } catch (IOException e) {
           e.printStackTrace();
           System.out.println("Error: Make sure settings.txt Exit.");
           System.exit(-1);
         }
         coHost.setText(prop.getProperty("hostname"));
         coUser.setText(prop.getProperty("username"));
         coPass.setText(prop.getProperty("password"));

         upHost.setText(prop.getProperty("xdomainHostname"));
         upUser.setText(prop.getProperty("xdomainUsername"));
         upPass.setText(prop.getProperty("xdomainPassword"));
         upPath.setText(prop.getProperty("podcastXmlUploadPass"));

         try{
        	  File file = new File("config/dropbox_conf.app");
        	  BufferedReader br = new BufferedReader(new FileReader(file));
        	  br.readLine();
        	  String dpAPIKey = br.readLine();
        	  dpAPIKey = dpAPIKey.replace("  \"key\": \"", "");
        	  dpAPIKey = dpAPIKey.replace("\",", "");
        	  dpKey.setText(dpAPIKey);

        	  String dpSec = br.readLine();
        	  dpSec = dpSec.replace("  \"secret\": \"", "");
        	  dpSec = dpSec.replace("\"", "");
        	  dpSecret.setText(dpSec);
        	  br.close();

        }catch(FileNotFoundException e){
        	System.out.println(e);
        }catch(IOException e){
        	System.out.println(e);
        }


     while(true){
    	 if(command != null){
		     try {
		         deployProcess = Runtime.getRuntime().exec(command);
		     }
		     catch (java.io.IOException ex) {
		         ex.printStackTrace();
		     }
		     (new Thread(new TextVacuum(deployProcess.getInputStream()))).start();
		     (new Thread(new TextVacuum(deployProcess.getErrorStream()))).start();
		     try {
		         deployProcess.waitFor();
		     }
		     catch (InterruptedException ex){}
    	 }
    	 command = null;
    	 try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
     }
 }


 private class TextVacuum implements Runnable {
     public TextVacuum(java.io.InputStream inStream) {
         myStream = new java.io.BufferedReader(new
             java.io.InputStreamReader(inStream));
     }

     public void run() {
         try {
             char[] cbuf = new char[4096];
             int numRead = myStream.read(cbuf);
             while (numRead != -1) {
                 //addText(new String(cbuf, 0, numRead));
                 textarea.append(new String(cbuf, 0, numRead));
                 numRead = myStream.read(cbuf);
             }
         }
         catch (java.io.IOException e) {
             System.err.println("ERROR reading from process stream of:"+ e);
         }
         finally {
             try {
                 myStream.close();
             }
             catch (java.io.IOException e) {}
             myStream = null;
         }
     }

     private java.io.BufferedReader myStream;
 }
}