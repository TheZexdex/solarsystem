import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpeedController extends JFrame implements ActionListener {

    double speed = 0.25;
    JFrame controller = new JFrame();
    JPanel mainPanel = new JPanel();
	GridLayout gLayout = new GridLayout(1,2);
    JButton slowButton = new JButton();
	JButton speedButton = new JButton();

    public SpeedController() //This class once instatiated creates a small window with 2 buttons, one labelled "<<" (slow down) and the other labelled ">>" (speed up)
    {
        controller.setContentPane(mainPanel);
        controller.setTitle("Simulation Speed Controller");
        controller.setSize(200,100);
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(gLayout);

        slowButton.setText("<<");
        mainPanel.add(slowButton);
        slowButton.addActionListener(this);

        speedButton.setText(">>");
        mainPanel.add(speedButton);
        speedButton.addActionListener(this);

        controller.setVisible(true);
    }
        
    public void actionPerformed(ActionEvent e) //If the slow down button is pressed, it halves the speed variable, if the speed up button is pressed, it doubles
	{
		if (e.getSource() == slowButton)
		{
			speed = speed / 2;
		}	
		if (e.getSource() == speedButton)
		{
			speed = speed * 2;
		}
	}

	public double getSpeed() //This method simply returns the current value of the speed variable, so the simulation method in SolarSystemMain can properly simulate the desired movement speed
	{
		return(speed);
	}
}
