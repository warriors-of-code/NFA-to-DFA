package ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class DrawFrame extends JFrame implements ActionListener{

  int nodes;
  int variables;

  JPanel contentPane;
  JButton btn1, btn2, btn3, btn4, btn5;
  Button proceed;
  JLabel label;

  boolean isBtnClicked = false;
  boolean finalNodesSelected = false;
  JButton firstBtnClicked = null;
  JButton secondBtnClicked = null;

  public DrawFrame(int nodes, int variables){
    this.nodes = nodes;
    this.variables = variables;

    setTitle("Join the circles!");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
    setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    btn1 = new JButton("A") {
      @Override
      protected void paintComponent(Graphics g){
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);
      }

      protected void paintBorder(Graphics g) {
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
      }
    };

    btn1.setBackground(Color.green);

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

    label = new JLabel("Select the final nodes and then click done!");
    label.setBounds(150,50,300,40);
    contentPane.add(label);

    proceed = new Button("Done");
    proceed.setBackground(Color.red);
    proceed.setBounds(500, 50, 70, 40);
    proceed.addActionListener(
      new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          finalNodesSelected = true;
          proceed.setVisible(false);
          label.setText("Now select the starting and ending nodes...");
        }
      }
    );
    contentPane.add(proceed);

    switch(nodes){
      case 2: btn1.setBounds(200, 300, 100, 100);
              btn2.setBounds(400, 300, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              break;

      case 3: btn1.setBounds(200, 200, 100, 100);
              btn2.setBounds(400, 200, 100, 100);
              btn3.setBounds(300, 370, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              break;

      case 4: btn1.setBounds(200, 200, 100, 100);
              btn2.setBounds(400, 200, 100, 100);
              btn3.setBounds(200, 370, 100, 100);
              btn4.setBounds(400, 370, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              contentPane.add(btn4);
              break;

      case 5: btn1.setBounds(100, 200, 100, 100);
              btn2.setBounds(300, 200, 100, 100);
              btn3.setBounds(500, 200, 100, 100);
              btn4.setBounds(200, 370, 100, 100);
              btn5.setBounds(400, 370, 100, 100);
              contentPane.add(btn1);
              contentPane.add(btn2);
              contentPane.add(btn3);
              contentPane.add(btn4);
              contentPane.add(btn5);
              break;
    }

    //addActionListeners
    btn1.addActionListener(this); btn1.setName("A");
    btn2.addActionListener(this); btn2.setName("B");
    btn3.addActionListener(this); btn3.setName("C");
    btn4.addActionListener(this); btn4.setName("D");
    btn5.addActionListener(this); btn5.setName("E");

  }

  public void actionPerformed(ActionEvent e){
    JButton btn = (JButton)e.getSource();
    //System.out.println(btn.getName());
    if(!finalNodesSelected){
      btn.setBackground(Color.red);
      return;
    }
    if(isBtnClicked){
      secondBtnClicked = btn;
      isBtnClicked = false;
      System.out.println("There is a path between " + firstBtnClicked.getName() + " and " + secondBtnClicked.getName());
    } else {
      firstBtnClicked = btn;
      isBtnClicked = true;
      System.out.println("Select the ending point");
    }
  }

}
