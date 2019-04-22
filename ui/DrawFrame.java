package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class DrawFrame extends JFrame{

  int nodes;
  int variables;

  JPanel contentPane;
  JButton btn1, btn2, btn3, btn4, btn5;

  public DrawFrame(int nodes, int variables){
    this.nodes = nodes;
    this.variables = variables;

    setTitle("Join the circles!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
    setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    btn1 = new JButton("A") {
      @Override
      protected void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    btn2 = new JButton("B") {
      @Override
      protected void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    btn3 = new JButton("C") {
      @Override
      protected void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    btn4 = new JButton("D") {
      @Override
      protected void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    btn5 = new JButton("E") {
      @Override
      protected void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    switch(nodes){
      case 2: btn1.setBounds(200, 200, 100, 100);
              btn2.setBounds(400, 200, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              break;

      case 3: btn1.setBounds(200, 100, 100, 100);
              btn2.setBounds(400, 100, 100, 100);
              btn3.setBounds(300, 270, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              break;

      case 4: btn1.setBounds(200, 100, 100, 100);
              btn2.setBounds(400, 100, 100, 100);
              btn3.setBounds(200, 270, 100, 100);
              btn4.setBounds(400, 270, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              contentPane.add(btn4);
              break;

      case 5: btn1.setBounds(100, 100, 100, 100);
              btn2.setBounds(300, 100, 100, 100);
              btn3.setBounds(500, 100, 100, 100);
              btn4.setBounds(200, 270, 100, 100);
              btn5.setBounds(400, 270, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              contentPane.add(btn4);
              contentPane.add(btn5);
              break;
    }

  }

}
