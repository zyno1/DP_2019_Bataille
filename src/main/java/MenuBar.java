import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    private MainMenu menu;

    public MenuBar(MainMenu mm) {

        menu = mm;

        JMenu menu = new JMenu("Options");

        JMenuItem item = new JMenuItem("Recommencer");
        item.addActionListener(this);

        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(this);

        menu.add(item);
        menu.add(quitter);
        this.add(menu);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getActionCommand().equals("Recommencer")) {
            menu.retourMainMenu();
        }

        if(actionEvent.getActionCommand().equals("Quitter")) {
            System.exit(0);
        }

    }
}
