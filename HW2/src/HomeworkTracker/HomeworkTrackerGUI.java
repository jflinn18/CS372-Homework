package HomeworkTracker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomeworkTrackerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private HomeworkTracker hwt = new HomeworkTracker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeworkTrackerGUI frame = new HomeworkTrackerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeworkTrackerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel score = new JLabel("Score: ");
		score.setBounds(21, 11, 46, 14);
		contentPane.add(score);
		
		textField = new JTextField();
		
		textField.setBounds(60, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMin = new JLabel("Min: ");
		lblMin.setBounds(21, 87, 140, 14);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(21, 117, 140, 14);
		contentPane.add(lblMax);
		
		JLabel lblAverage = new JLabel("Average: ");
		lblAverage.setBounds(21, 151, 140, 14);
		contentPane.add(lblAverage);
		
		/**
		 * Handles the button action
		 */
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double doub = Double.parseDouble(textField.getText());
				
				hwt.addScore(doub);
				
				String f = String.format("Min: %.2f", hwt.calcMin());
				lblMin.setText(f);
				f = String.format("Max: %.2f", hwt.calcMax());
				lblMax.setText(f);
				f = String.format("Average: %.2f", hwt.calcAve());
				lblAverage.setText(f);
				
				textField.setText("");
			}
		});
		btnSubmit.setBounds(167, 7, 89, 23);
		contentPane.add(btnSubmit);
		
		/**
		 * Lets the user press 'Enter' to submit the score
		 * Resets the cursor in the text box
		 */
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() != KeyEvent.VK_ENTER) {return;}
				
				double doub = Double.parseDouble(textField.getText());
				
				hwt.addScore(doub);
				
				String f = String.format("Min: %.2f", hwt.calcMin());
				lblMin.setText(f);
				f = String.format("Max: %.2f", hwt.calcMax());
				lblMax.setText(f);
				f = String.format("Average: %.2f", hwt.calcAve());
				lblAverage.setText(f);
				
				textField.setText("");
			}
		});
	}
}