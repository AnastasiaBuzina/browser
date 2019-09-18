/**
 * Отвечает за внутреннюю работу программы.
 * Ведёт историю посещённых страниц, загружает файлы из интернета, сохраняет страницы на диск и т.п.
 */

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void init(){}

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
