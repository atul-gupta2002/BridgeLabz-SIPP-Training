package doublylinkedlist;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new state after current (typing or editing)
    public void addState(String newContent) {
        TextState newState = new TextState(newContent);

        if (head == null) {
            head = current = newState;
            size = 1;
            return;
        }
        current.next = null;

        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("No text available.");
        }
    }
    public void showAllStates() {
        System.out.println("\n--- Text History ---");
        TextState temp = head;
        while (temp != null) {
            System.out.println((temp == current ? "-> " : "   ") + temp.content);
            temp = temp.next;
        }

    }
}
public class UndoRedoTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! This");
        editor.addState("Hello World! This is");
        editor.addState("Hello World! This is a");
        editor.addState("Hello World! This is a test.");

        editor.showCurrentState();
        editor.showAllStates();

        editor.undo();
        editor.undo();
        editor.showCurrentState();

        editor.redo();
        editor.showCurrentState();

        editor.addState("Hello World! This is a new sentence.");
        editor.showAllStates(); // redo history cleared

        // Add more than 10 states to test trimming
        for (int i = 1; i <= 5; i++) {
            editor.addState("Text version " + i);
        }

        editor.showAllStates();
    }
}


