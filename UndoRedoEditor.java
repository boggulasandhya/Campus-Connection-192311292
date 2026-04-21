import java.util.*;

public class UndoRedoEditor {
    static Stack<String> undo = new Stack<>();
    static Stack<String> redo = new Stack<>();
    static String text = "";

    public static void addText(String newText) {
        undo.push(text);
        text += newText;
        redo.clear();
        System.out.println("Current Text: " + text);
    }

    public static void undo() {
        if (!undo.isEmpty()) {
            redo.push(text);
            text = undo.pop();
            System.out.println("After Undo: " + text);
        }
    }

    public static void redo() {
        if (!redo.isEmpty()) {
            undo.push(text);
            text = redo.pop();
            System.out.println("After Redo: " + text);
        }
    }

    public static void main(String[] args) {
        addText("Hello ");
        addText("World");
        undo();
        redo();
    }
}
