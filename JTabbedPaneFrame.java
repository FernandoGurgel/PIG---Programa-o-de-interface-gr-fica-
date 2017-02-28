
// Fig. 22.13: JTabbedPaneFrame.java
// Demonstrando JTabbedPane.
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JTabbedPaneFrame extends JFrame {
	// configurando GUI
	public JTabbedPaneFrame() {
		super("JTabbedPane Demo ");

		JTabbedPane tabbedPane = new JTabbedPane(); // cria JTabbedPane

		// configura o pane11 e o adiciona ao JTabbedPane
		JLabel label1 = new JLabel("panel one", SwingConstants.CENTER);
		JPanel panel1 = new JPanel(); // cria o primeiro painel
		panel1.add(label1); // adiciona o rótulo ao painel
		tabbedPane.addTab("Tab One", null, panel1, "First Panel");

		// configura panel2 e o adiciona ao JTabbedPane
		JLabel label2 = new JLabel("panel two", SwingConstants.CENTER);
		JPanel panel2 = new JPanel(); // cria o segundo panel
		panel2.setBackground(Color.YELLOW); // configura o fundo como amarelo
		panel2.add(label2); // adiciona o rótulo ao painel
		tabbedPane.addTab("Tab Two", null, panel2, "Second Panel");

		// configura o panel3 e o adiciona ao JTabbedPane
		JLabel label3 = new JLabel("panel three");
		JPanel panel3 = new JPanel(); // cria o terceiro painel
		panel3.setLayout(new BorderLayout()); // utiliza o borderlayout
		panel3.add(new JButton("North"), BorderLayout.NORTH);
		panel3.add(new JButton("West"), BorderLayout.WEST);
		panel3.add(new JButton("East"), BorderLayout.EAST);
		panel3.add(new JButton("South"), BorderLayout.SOUTH);
		panel3.add(label3, BorderLayout.CENTER);
		tabbedPane.addTab("Tab Three", null, panel3, "Third Panel");

		add(tabbedPane); // adicion a JTabbedPane ao frame
	} // fim do construtor JTabbedPaneFrame
} // fim da classe JTabbedPaneFrame