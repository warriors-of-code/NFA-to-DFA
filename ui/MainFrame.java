package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame{

  JPanel contentPane;
  JLabel labelNodes;
  JLabel labelVariables;
  JLabel label;
  JTextField textNodes;
  JTextField textVariables;
  Button button;

  public MainFrame(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

    label = new JLabel("Please enter the following values to proceed!");
    label.setBounds(250,70,200,30);

    labelNodes = new JLabel("Enter number of nodes (max 4)");
    labelNodes.setBounds(170,150,250,30);

    textNodes = new JTextField();
    textNodes.setBounds(450,150,30,30);

    labelVariables = new JLabel("Enter number of variables");
    labelVariables.setBounds(170,200,200,30);

    textVariables = new JTextField();
    textVariables.setBounds(450,200,30,30);

    button = new Button("Proceed");
    button.setBounds(200,300,300,40);
    button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                int nodes;
                int variables;
                try{
                  if(textNodes.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the number of nodes!");
                    return;
                  }
                  if(Integer.parseInt(textNodes.getText()) > 4){
                    JOptionPane.showMessageDialog(null, "Maximum number of nodes can be 4!");
                    return;
                  }
                } catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Expected a number for nodes!");
                  return;
                }
                try{
                  if(textVariables.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the number of variables!");
                    return;
                  }
                  variables = Integer.parseInt(textVariables.getText());
                  nodes = Integer.parseInt(textNodes.getText());
                } catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Expected a number for variables!");
                  return;
                }
                dispose();
                DrawFrame drawFrame = new DrawFrame(nodes, variables);
            }
        });

    contentPane.add(label);
    contentPane.add(labelNodes);
    contentPane.add(labelVariables);
    contentPane.add(textNodes);
    contentPane.add(textVariables);
    contentPane.add(button);
  }


}
