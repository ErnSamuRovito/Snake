package Model;

import javax.swing.text.Position;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Model.Position> body;
    private Model.Position head;

    private boolean alive;

    public Snake(Model.Position p)
    {
        body = new LinkedList<>();
        head = p;
        alive = true;
    }

    public Model.Position getHead()
    {
        return head;
    }

    public void updateHead(Model.Position newHead)
    {
        head = newHead;
    }

    public boolean hasBody()
    {
        return !body.isEmpty();
    }

    public Model.Position getBodyStart()
    {
        return body.getFirst();
    }

    public Model.Position getTail()
    {
        return body.getLast();
    }

    public void addBodyBlock(Model.Position p)
    {
        body.add(p);
    }

    public boolean isAlive() {
        return alive;
    }

    public void moveBody(Model.Position p)
    {
        body.removeLast();
        body.addFirst(p);
    }

    public void setDead() {
        alive = false;
    }
}
