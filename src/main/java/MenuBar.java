import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    private MainMenu menu;

    public MenuBar(MainMenu mm) {

        menu = mm;

        JMenu menu = new JMenu("Options");
        JMenuItem item = new JMenuItem("ayaya");
        item.addActionListener(this);

        menu.add(item);
        this.add(menu);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        menu.retourMainMenu();

    }
}
