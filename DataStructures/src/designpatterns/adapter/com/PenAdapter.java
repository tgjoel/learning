package designpatterns.adapter.com;

import designpatterns.adapter.org.Pencil;

public class PenAdapter implements Pen {

    Pencil pencil = new Pencil();

    @Override
    public void writeWithPen(String str) {
        pencil.write(str);
    }
}
