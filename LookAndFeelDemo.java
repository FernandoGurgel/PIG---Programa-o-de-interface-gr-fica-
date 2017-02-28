
// Fig. 22.10: LookAndFeelDemo.java
// Mudando a aparência e o comportamento.
import javax.swing.JFrame;

public class LookAndFeelDemo {
	public static void main(String args[]) {
		LookAndFeelFrame lookAndFeelFrame = new LookAndFeelFrame();
		lookAndFeelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lookAndFeelFrame.setSize(300, 200); // configura o tamanho do frame
		lookAndFeelFrame.setVisible(true); // exibe o frame
	} // fim do main
} // fim da classe LookAndFeelDemo
