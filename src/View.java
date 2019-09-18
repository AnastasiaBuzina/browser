import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Отвечает за взаимодействие с пользователем.
 * Отрисоввывает интерфейс браузера с меню и кнопками, отображает web страницы.
 */

public class View extends JFrame implements ActionListener, HyperlinkListener {
    private Controller controller;
    private JTabbedPane jTabbedPane; //пусть браузер поддерживает работу с несколькимии вкладками
    private JEditorPane jEditorPane; //здесь будет отображаться web страница

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // TODO: Разобраться, что будет, если не установить LookAndFeel (сейчас не помню)
    // TODO: подумать, не лучше ли логировать исключения куда-нибудь в файл, а не консоль, если останется время
    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (HeadlessException |
                ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand();
        switch (actionName) {
            /* TODO: в зависимости от названия выбранного пользователем меню
            controller выполняет соответствующее действие, например
            case "Сохранить как..." : controller.saveDocumentAs(); break;
             */
        }
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        // TODO: если щёлкнули по гиперссылке, изменить содержимое jEditorPane
    }

    public void init(){
        initMenuBar();
        initTabsBar();
        // TODO: отрисоввываем основное окно, добавляем прокрутку

        // Загружаем домашнююю страницу
        try {
            jEditorPane.setPage(new URL("" /*адрес домашней страницы,
            можно сделать адрес текстовой переменной и изменять домашнюю страницу из меню браузера,
            а можно прописать здесь хардкодом, например, "http://google.com"*/));
        } catch (Exception e) {
            jEditorPane.setText("Не удалось загрузить домашнюю страницу");
            e.printStackTrace();
        }

        pack(); // уточнить, зачем это нужно и нужно ли, сейчас не помню
        setVisible(true);
    }

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        // TODO: добавляем в jMenuBar кнопки
    }

    public void initTabsBar(){
        //TODO: делаем панель с вкладками (одной) и кнопкой добавления новых вкладок
    }
}
