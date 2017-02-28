
// Fig. 22.14: JTabbedPaneDemo.java
// Demonstrando o JTabbedPane.
import javax.swing.JFrame;

public class JTabbedPaneDemo {
	public static void main(String args[]) {
		JTabbedPaneFrame tabbedPaneFrame = new JTabbedPaneFrame();
		tabbedPaneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabbedPaneFrame.setSize(250, 200); // configura o tamanho do frame
		tabbedPaneFrame.setVisible(true); // exibe o frame
	} // fim do main
} // fim da classe JTabbedPaneDemo
