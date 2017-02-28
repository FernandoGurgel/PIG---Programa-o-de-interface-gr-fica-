
// Fig. 22.3: SliderFrame.java
// Utilizando JSliders para dimensionar uma oval.
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SliderFrame extends JFrame {
	private JSlider diameterJSlider; // controle deslizante p/ selecionar o
										// diâmetro
	private OvalPanel myPanel; // painel para desenhar o círculo

	// construtor sem argumentos
	public SliderFrame() {
		super("Slider Demo");

		myPanel = new OvalPanel(); // cria painel para desenhar o círculo
		myPanel.setBackground(Color.YELLOW); // configura o fundo como amarelo

		// configura o JSlider para controlar o valor do diâmetro
		diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		diameterJSlider.setMajorTickSpacing(10); // cria uma marca de medida a
													// cada 10
		diameterJSlider.setPaintTicks(true); // pinta marcas no controle
												// deslizante

		// registra o ouvinte de evento do JSlider
		diameterJSlider.addChangeListener(

				new ChangeListener() // classe interna anônima
				{
					// trata da alteração de valor do controle deslizante
					public void stateChanged(ChangeEvent e) {
						myPanel.setDiameter(diameterJSlider.getValue());
					} // fim do método stateChanged
				} // fim da classe interna anônima
		); // fim da chamada para addChangeListener

		add(diameterJSlider, BorderLayout.SOUTH); // adiciona o controle
													// deslizante ao frame
		add(myPanel, BorderLayout.CENTER); // adiciona o painel ao frame
	} // fim do construtor SliderFrame
} // fim da classe SliderFrame
