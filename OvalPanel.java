
// Fig. 22.2: OvalPanel.java
// Uma classe personalizada de JPanel.
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class OvalPanel extends JPanel {
	
	private int diameter = 10; // diâmetro padrão de 10

	// desenha uma oval do diâmetro especificado
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillOval(10, 10, diameter, diameter); // desenha um círculo
		
	} // fim do método paintComponent

	// valida e configura o diâmetro, então pinta novamente
	public void setDiameter(int newDiameter) {
		// se o diâmetro for inválido, assume o padrão de 10
		diameter = (newDiameter >= 0 ? newDiameter : 10);
		repaint(); // pinta o painel novamente
	} // fim do método setDiameter

	// utilizado pelo gerenciador de layout para determinar o tamanho preferido
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	} // fim do método getPreferredSize

	// utilizado pelo gerenciador de layout para determinar o tamanho mínimo
	public Dimension getMinimumSize() {
		return getPreferredSize();
	} // fim do método getMinimumSize
} // fim da classe OvalPanel
