import ui.MainFrame;

import java.awt.*;
import javax.swing.*;

public class Main{
  public static void main(String[] ar){
    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false);
          frame.setTitle("Convert NFA to DFA");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
  }
}
