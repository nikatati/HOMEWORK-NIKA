package UI;


import Country.Map;
import IO.SimulationFile;
import Simulation.Main;

import javax.swing.*;
import java.awt.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import java.io.File;
import java.io.IOException;

import static IO.StatisticsFile.csv;


public class Window extends JFrame implements ActionListener {
    // private final JFileChooser openFileChooser;
    static final JFrame frame = new JFrame();
    static Map m = new Map();

    public static <flag1> void main(String args[]) throws IOException {

        //Creating the Frame
        JFrame frame = new JFrame("Main Window");

        JLabel mapArea = new JLabel();
        mapArea.setOpaque(true);
        mapArea.setBackground(new Color(248, 213, 131));
        mapArea.setPreferredSize(new Dimension(400, 380));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        Window s = new Window();
        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Simulation");
        JMenu m3 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);

        // final Label fileChosen = new Label("No file chosen yet...");
        Button m11 = new Button("Load");
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //OpenFile of = new OpenFile();
                try{
                    //File file = of.PickMe();
                    m = SimulationFile.SimulationFile();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JButton m12 = new JButton("Statistics");
        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    csv(m);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton m13 = new JButton("Edit Mutations");

        JButton m14 = new JButton("Exit");
        m14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);
        JButton m21 = new JButton("Play");
        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dataInitialization(m);

            }
        });

        JButton m22 = new JButton("Pause");
        m22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Thread t : Thread.getAllStackTraces().keySet())
                {      if (t.getState()==Thread.State.RUNNABLE) {
                    try {
                        t.sleep(200);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                }

            }

        });

        JButton m23 = new JButton("Stop");
        m23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Thread t : Thread.getAllStackTraces().keySet())
                {      if (t.getState()==Thread.State.RUNNABLE)
                    t.stop();
                }

            }

        });

        JButton m24 = new JButton("Set Ticks Per Day");
        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m2.add(m24);
        JButton m31 = new JButton("Help");
        m31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This application is created for getting data about viruses on the map");
            }
        });
        JButton m32 = new JButton("About");
        m32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Writers: Nika and Liubov");
            }
        });

        m3.add(m31);
        m3.add(m32);
        JPanel panel = new JPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(mapArea);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}