import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.event.*;
import javax.swing.JButton;

public class Settings extends JFrame implements ActionListener{

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JButton saveButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Settings();
	}

	/**
	 * Create the frame.
	 */
	public Settings() {
		setOpacity(0.5f);
		setTitle("Game Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ball Speed");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 25, 124, 36);
		contentPane.add(lblNewLabel);
		
		JRadioButton slow = new JRadioButton("Slow");
		buttonGroup.add(slow);
		slow.setFont(new Font("Tahoma", Font.BOLD, 15));
		slow.setBounds(231, 33, 103, 21);
		contentPane.add(slow);
		
		JRadioButton normal = new JRadioButton("Normal");
		buttonGroup.add(normal);
		normal.setSelected(true);
		normal.setFont(new Font("Tahoma", Font.BOLD, 15));
		normal.setBounds(336, 33, 103, 21);
		contentPane.add(normal);
		
		JRadioButton fast = new JRadioButton("Fast");
		buttonGroup.add(fast);
		fast.setFont(new Font("Tahoma", Font.BOLD, 15));
		fast.setBounds(441, 33, 103, 21);
		contentPane.add(fast);
		
		JRadioButton veryfast = new JRadioButton("Very fast");
		buttonGroup.add(veryfast);
		veryfast.setFont(new Font("Tahoma", Font.BOLD, 15));
		veryfast.setBounds(546, 33, 103, 21);
		contentPane.add(veryfast);
		
		JLabel lblPallet = new JLabel("Pallet Width");
		lblPallet.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPallet.setBounds(28, 96, 124, 36);
		contentPane.add(lblPallet);
		
		JRadioButton rdbtnSmall = new JRadioButton("Short");
		buttonGroup_1.add(rdbtnSmall);
		rdbtnSmall.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnSmall.setBounds(231, 106, 103, 21);
		contentPane.add(rdbtnSmall);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup_1.add(rdbtnNormal);
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNormal.setBounds(336, 106, 103, 21);
		contentPane.add(rdbtnNormal);
		
		JRadioButton rdbtnLong = new JRadioButton("Long");
		buttonGroup_1.add(rdbtnLong);
		rdbtnLong.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnLong.setBounds(441, 106, 103, 21);
		contentPane.add(rdbtnLong);
		
		JLabel lblPalletSpeed = new JLabel("Pallet Speed");
		lblPalletSpeed.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPalletSpeed.setBounds(28, 168, 124, 36);
		contentPane.add(lblPalletSpeed);
		
		JRadioButton slow_1 = new JRadioButton("Slow");
		buttonGroup_2.add(slow_1);
		slow_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		slow_1.setBounds(231, 178, 103, 21);
		contentPane.add(slow_1);
		
		JRadioButton normal_1 = new JRadioButton("Normal");
		buttonGroup_2.add(normal_1);
		normal_1.setSelected(true);
		normal_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		normal_1.setBounds(336, 178, 103, 21);
		contentPane.add(normal_1);
		
		JRadioButton fast_1 = new JRadioButton("Fast");
		buttonGroup_2.add(fast_1);
		fast_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		fast_1.setBounds(441, 178, 103, 21);
		contentPane.add(fast_1);
		
		JRadioButton veryfast_1 = new JRadioButton("Very fast");
		buttonGroup_2.add(veryfast_1);
		veryfast_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		veryfast_1.setBounds(546, 178, 103, 21);
		contentPane.add(veryfast_1);
		
		JLabel lblBricks = new JLabel("Bricks");
		lblBricks.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBricks.setBounds(28, 242, 124, 36);
		contentPane.add(lblBricks);
		
		JLabel lblNewLabel_1 = new JLabel("Rows");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(245, 254, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Colomns");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(399, 254, 67, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		spinner_1.setModel(new SpinnerNumberModel(3, 3, 10, 1));
		spinner_1.setBounds(477, 242, 67, 36);
		contentPane.add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		spinner_1_1.setModel(new SpinnerNumberModel(3, 3, 10, 1));
		spinner_1_1.setBounds(302, 242, 67, 36);
		contentPane.add(spinner_1_1);
		
		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveButton.setBounds(591, 244, 103, 36);
		contentPane.add(saveButton);
		saveButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveButton)
		{
			dispose();
		}
		
	}
}
