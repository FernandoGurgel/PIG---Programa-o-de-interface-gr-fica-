import javax.swing.JFrame;

public class MouseDetaislsTest {
	public static void main(String args[]) {
		MouseDetailsFrame mouseDetailsFrame = new MouseDetailsFrame();
		mouseDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseDetailsFrame.setSize(400, 150); // configura o tamanho do frame
		mouseDetailsFrame.setVisible(true); // obtém o frame
	} // fim de main
}
