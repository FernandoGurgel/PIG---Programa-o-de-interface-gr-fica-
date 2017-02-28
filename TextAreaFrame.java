
// Fig. 11.47: TextAreaFrame.java
// Copiando texto selecionado de uma textarea para a outra. 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame {
	private JTextArea textArea1; // exibe string demo
	private JTextArea textArea2; // texto destacado é copiado aqui
	private JButton copyJButton; // começa a copiar o texto

	// construtor sem argumentos
	public TextAreaFrame() {
		super("TextArea Demo");
		Box box = Box.createHorizontalBox(); // cria box
		String demo = "This is a demo string to\n" + "illustrate copying text\nfrom one textarea to \n"
				+ "another textarea using an\nexternal event\n";

		textArea1 = new JTextArea(demo, 10, 15); // cria textarea1
		box.add(new JScrollPane(textArea1)); // adiciona scrollpane

		copyJButton = new JButton("Copy >>>"); // cria botão de cópia
		box.add(copyJButton); // adiciona o botão de cópia à box
		copyJButton.addActionListener(

				new ActionListener() // classe interna anônima
				{
					// configura texto em textArea2 como texto selecionado de
					// textArea1
					public void actionPerformed(ActionEvent event) {
						textArea2.setText(textArea1.getSelectedText());
					} // fim do método actionPerformed
				} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		textArea2 = new JTextArea(10, 15); // cria segunda textarea
		textArea2.setEditable(false); // desativa a edição
		box.add(new JScrollPane(textArea2)); // adiciona scrollpane

		add(box); // adiciona box ao frame
	} // fim do construtor TextAreaFrame
} // fim da classe TextAreaFrame
