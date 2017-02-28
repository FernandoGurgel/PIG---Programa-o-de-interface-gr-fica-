
// Fig. 11.21: ComboBoxFrame.java
// Usando a JComboBox para selecionar uma image para exibição.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame {
	private JComboBox imagesJComboBox; // caixa de combinação p/ armazenar nomes
										// de ícones
	private JLabel label; // rótulo para exibir ícone selecionado

	private String names[] = { "bug1.gif", "bug2.gif", "bug1.gif", "bug2.gif" };
	private Icon icons[] = { new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])), new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3])) };

	// construtor ComboBoxFrame adiciona JComboBox ao JFrame
	public ComboBoxFrame() {
		super("Testing JComboBox");
		setLayout(new FlowLayout()); // configura layout do frame

		imagesJComboBox = new JComboBox(names); // configura a JComboBox
		imagesJComboBox.setMaximumRowCount(3); // exibe trÊs linhas

		imagesJComboBox.addItemListener(new ItemListener() // classe interna
															// anÔnima
		{
			// trata evento JComboBox
			public void itemStateChanged(ItemEvent event) {
				// determina se caixa de seleção está marcada ou não
				if (event.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
			} // fim do método itemStateChanged
		} // fim da classe interna anônima
		); // fim da chamada para addItemListener

		add(imagesJComboBox); // adiciona a caixa de combinação ao JFrame
		label = new JLabel(icons[0]); // exibe o primeiro ícone
		add(label); // adiciona rótulo ao JFrame
	} // fim do construtor ComboBoxFrame
} // fim da classe ComboBoxFrame
