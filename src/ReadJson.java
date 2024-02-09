import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.GridLayout;


import java.awt.event.ActionEvent;

// Program for print data in JSON format.
public class ReadJson {
    /*private JLabel allies;
    private JFrame mainFrame;
    private JLabel characters;
    private JPanel controlPanel;
    private int WIDTH = 800;
    private int HEIGHT = 700;*/
    public static JLabel characters,allies;

    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

      //  ReadJson swingControlDemo = new ReadJson();
    //    swingControlDemo.showEventDemo();
        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", new Integer(1704310046));
        file.put("Tuition Fees", new Double(65400));


        // To print in JSON format.
        System.out.print(file.get("Tuition Fees"));
        pull();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });


    }
    public static void createAndShowGUI(){

        // Create the basic frame
        JFrame frame = new JFrame("Layout Demo");

        // Create a top panel
        JPanel top = new JPanel();
        frame.getContentPane().add(top, BorderLayout.PAGE_START);

        // Create a middle-left panel
        JPanel left = new JPanel();
        left.setBackground(Color.yellow);
        frame.getContentPane().add(left, BorderLayout.LINE_START);

        // Create a center panel
        JPanel center = new JPanel(new BorderLayout());
        frame.getContentPane().add(center, BorderLayout.CENTER);

        // Create a middle-right panel
        JPanel right = new JPanel();
        frame.getContentPane().add(right, BorderLayout.LINE_END);

        // Create a bottom panel
        JPanel bottom = new JPanel();
        frame.getContentPane().add(bottom, BorderLayout.PAGE_END);

        // Show the Frame
        frame.pack();
        frame.setSize(new Dimension(800, 700));
        frame.setVisible(true);
    }







    public void createComponents(){
        characters = new JLabel("name");
        allies = new JLabel ("allies");
        layout();

      //  createComponents();
    }
    public void layout(){
        JFrame frame = new JFrame("Vehicle Window");
        JPanel Panel2 = new JPanel(new GridLayout(3, 1));
        Panel2.add(characters);
        Panel2.add(allies);
        frame.getContentPane().add(Panel2);
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
    }

   /* private void prepareGUI(){
        mainFrame = new JFrame("Characters!");
        mainFrame.setSize(WIDTH,HEIGHT);
        mainFrame.setLayout(new GridLayout(3,1));

        characters = new JLabel("name", JLabel.NORTH);
        allies  = new JLabel("allies", JLabel.NORTH);

      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(3,1));

      mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        nextButton.setActionCommand("Next");
        previousButton.setActionCommand("Previous");

        mainFrame.add(nextButton);
        mainFrame.add(previousButton);
        mainFrame.add(characters);
        mainFrame.add(allies);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);

    }*/

    public static void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {

            URL url = new URL("https://last-airbender-api.fly.dev/api/v1/characters");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) parser.parse(totlaJson);
        System.out.println(jsonArray);

        try {

            JSONObject secretTunnelGuy = (JSONObject) jsonArray.get(0);
            System.out.println(secretTunnelGuy.get("name"));
            JSONArray secretTunnelGuyAllies = (JSONArray) secretTunnelGuy.get("allies");
            System.out.println(secretTunnelGuyAllies.get(0));



//            JSONObject secretTunnelGuy2 = (JSONObject) jsonArray.get(2);
//            System.out.println(secretTunnelGuy2.get("name"));
//
//            JSONObject secretTunnelGuy3 = (JSONObject) jsonArray.get(3);
//            System.out.println(secretTunnelGuy3.get("name"));
//
//            JSONObject secretTunnelGuy4 = (JSONObject) jsonArray.get(4);
//            System.out.println(secretTunnelGuy4.get("name"));
//
//            JSONObject secretTunnelGuy5 = (JSONObject) jsonArray.get(5);
//            System.out.println(secretTunnelGuy5.get("name"));
//
//            JSONObject secretTunnelGuy6 = (JSONObject) jsonArray.get(6);
//            System.out.println(secretTunnelGuy6.get("name"));
//
//            JSONObject secretTunnelGuy7 = (JSONObject) jsonArray.get(7);
//            System.out.println(secretTunnelGuy7.get("name"));

            for(int x=0;x<jsonArray.size();x++) {
                JSONObject secretTunnelGirl = (JSONObject) jsonArray.get(x);
                System.out.println(secretTunnelGirl.get("name"));

                for (int k = 0;k<jsonArray.size();k++ ){
                    JSONArray secretTunnelGirlAllies = (JSONArray) secretTunnelGirl.get("allies");
                    System.out.println(secretTunnelGirlAllies.get(k));
                }

            }

/*
            String name = (String)jsonArray.get("name");

            org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonArray.get("starships");
            int n =   msg.size(); //(msg).length();
            for (int i = 0; i < n; ++i) {
                String test =(String) msg.get(i);
                System.out.println(test);
                // System.out.println(person.getInt("key"));
            }
          //  String name= (String)jsonObject.get("height");
            System.out.println(name);*/
        }

        catch (Exception e) {
            e.printStackTrace();
        }




    }
}



