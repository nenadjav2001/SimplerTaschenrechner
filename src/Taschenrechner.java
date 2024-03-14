import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Taschenrechner ist eine einfache Swing-Anwendung zur Durchführung grundlegender mathematischer Operationen.
 */
public class Taschenrechner implements ActionListener {

    JFrame frame; // Das Hauptfenster der Anwendung.
    JButton[] numberButtons = new JButton[10]; // Die Ziffern-Tasten.
    JButton[] functionButtons = new JButton[6]; // Die Funktionstasten (+, -, *, /, ., =).
    JTextField textfield; // Das Textfeld zur Anzeige von Zahlen und Ergebnissen.
    JButton plusButton, minusButton, geteiltButton, malButton, gleichButton, kommaButton; // Die Funktionstasten separat.
    double num1 = 0, num2 = 0, result = 0; // Die Operanden und das Ergebnis der Berechnungen.
    char operator; // Der Operator für die Berechnungen.
    Font myFont = new Font("Arial", Font.ITALIC, 20); // Die Schriftart für die Tasten.
    JPanel panelGrid; // Das Panel für die Anordnung der Tasten im Raster.
    JButton clear, delete; // Die Tasten für das Löschen von Eingaben.

    /**
     * Konstruktor für die Taschenrechner-Klasse.
     * Erzeugt das GUI und initialisiert die Komponenten.
     */
    public Taschenrechner() {

        frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Taschenrechner");
        frame.setSize(400, 600);
        frame.getContentPane().setBackground(new Color(50));
        textfield = new JTextField();
        textfield.setEditable(false);
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(new Font("Arial", Font.ITALIC, 30));
        panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(4, 4, 10, 10));
        panelGrid.setBounds(45, 150, 300, 300);
        panelGrid.setBackground(new Color(20));
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.white);
            panelGrid.add(numberButtons[i]);
        }

        clear = new JButton();
        delete = new JButton();
        clear.addActionListener(this);
        delete.addActionListener(this);
        clear.setBounds(80, 500, 100, 30);
        clear.setFont(myFont);
        clear.setText("Clear");

        delete.setBounds(210, 500, 100, 30);
        delete.setText("Delete");
        delete.setFont(myFont);

        frame.add(delete);
        frame.add(clear);
        plusButton = new JButton();
        minusButton = new JButton();
        geteiltButton = new JButton();
        malButton = new JButton();
        kommaButton = new JButton();
        gleichButton = new JButton();

        functionButtons[0] = plusButton;
        functionButtons[1] = minusButton;
        functionButtons[2] = geteiltButton;
        functionButtons[3] = malButton;
        functionButtons[4] = kommaButton;
        functionButtons[5] = gleichButton;
        plusButton.setText("+");
        minusButton.setText("-");
        geteiltButton.setText("÷");
        malButton.setText("*");
        kommaButton.setText(".");
        gleichButton.setText("=");

        for (int i = 0; i < 6; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.white);
            panelGrid.add(functionButtons[i]);
        }

        frame.add(panelGrid);
        frame.add(textfield);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Die Hauptmethode zum Ausführen der Taschenrechner-Anwendung.
     *
     * @param args Die Befehlszeilenargumente (werden nicht verwendet).
     */
    public static void main(String[] args) {
        Taschenrechner taschenrechner = new Taschenrechner();
    }

    /**
     * Eine Methode, die aufgerufen wird, wenn ein ActionEvent auftritt, z. B. das Drücken einer Taste.
     *
     * @param e Das ActionEvent-Objekt, das den Ereignisursprung enthält.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            textfield.setText("");
        }
        if (e.getSource() == delete) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == kommaButton) {
            textfield.setText(textfield.getText().concat(","));
        }
        if (e.getSource() == plusButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == minusButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == geteiltButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == malButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == gleichButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
        }
    }
}
