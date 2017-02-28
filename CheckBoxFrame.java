
// Fig. 11.17: CheckBoxFrame.java
// Criando botões JCheckBox.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame implements ItemListener{
	private int valBold = Font.PLAIN; // controla o estilo de fonte negrito
	private int valItalic = Font.PLAIN; // controla o estilo de fonte
										// itálico
	private JTextField textField; // exibe o texto na alteração de fontes
	private JCheckBox boldJCheckBox; // para aplicar/remover seleção de negrito
	private JCheckBox italicJCheckBox; // para aplicar/remover seleção de
										// itálico

	// construtor CheckBoxFrame adiciona JCheckBoxes a JFrame
	public CheckBoxFrame() {
		super("JCheckBox Test");
		setLayout(new FlowLayout()); // configura o layout do frame

		// configura JTextField e sua fonte
		textField = new JTextField("Watch the font style change", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField); // adiciona textField a JFrame

		boldJCheckBox = new JCheckBox("Bold"); // cria caixa de seleção de
												// negrito
		italicJCheckBox = new JCheckBox("Italic"); // cria itálico
		add(boldJCheckBox); // adiciona caixa de seleção para negrito a JFrame
		add(italicJCheckBox); // adiciona caixa de seleção para negrito a JFrame

		// registra listeners para JCheckBoxes
		//CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(this);
		italicJCheckBox.addItemListener(this);
	} // fim do construtor CheckBoxFrame

	// classe interna private para tratamento de evento ItemListener
	/*private class CheckBoxHandler implements ItemListener {
		private int valBold = Font.PLAIN; // controla o estilo de fonte negrito
		private int valItalic = Font.PLAIN; // controla o estilo de fonte
											// itálico

		// responde aos eventos de caixa de seleção
		public void itemStateChanged(ItemEvent event) {
			// processa aos eventos de caixa de seleção de negrito
			if (event.getSource() == boldJCheckBox)
				valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

			// processa eventos de caixa de seleção de itálico
			if (event.getSource() == italicJCheckBox)
				valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;

			// configura fonte do campo de texto
			textField.setFont(new Font("Serif", valBold + valItalic, 14));
		} // fim do método itemStateChanged
	} // fim da classe CheckBoxHandler interna private
	*/

	@Override
	public void itemStateChanged(ItemEvent event) {
		// processa aos eventos de caixa de seleção de negrito
					if (event.getSource() == boldJCheckBox)
						valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

					// processa eventos de caixa de seleção de itálico
					if (event.getSource() == italicJCheckBox)
						valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;

					// configura fonte do campo de texto
					textField.setFont(new Font("Serif", valBold + valItalic, 14));
		
	}

} // fim da classe CheckBoxFrame
