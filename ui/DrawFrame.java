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

  public DrawFrame(int nodes, int variables){
    this.nodes = nodes;
    this.variables = variables;

    setTitle("Convert NFA to DFA");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
    setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

  }

}
