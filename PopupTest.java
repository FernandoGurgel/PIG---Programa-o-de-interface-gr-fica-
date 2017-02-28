
// Fig. 22.8: PopupTest.java
// Testando PopupFrame.
import javax.swing.JFrame;

public class PopupTest {
	public static void main(String args[]) {
		PopupFrame popupFrame = new PopupFrame(); // cria PopupFrame
		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popupFrame.setSize(300, 200); // configura o tamanho do frame
		popupFrame.setVisible(true); // exibe o frame
	} // fim do main
} // fim da classe PopupTest
