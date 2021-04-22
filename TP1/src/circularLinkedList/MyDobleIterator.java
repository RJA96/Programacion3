package circularLinkedList;

import java.util.Iterator;
import java.util.Objects;

public class MyDobleIterator implements Iterator<Integer> {

    private NodoDoble cursorHead;
    private NodoDoble cursorTail;

    public MyDobleIterator(final NodoDoble first) {
        this.cursorHead = first;
        if (Objects.nonNull(first)) this.cursorTail = first.getPrevious();
    }

    @Override
    public boolean hasNext() {
        if (Objects.nonNull(cursorTail)) {
            return this.cursorHead != this.cursorTail;
        } else {
            return Objects.nonNull(cursorHead);
        }
    }

    @Override
    public Integer next() {
        Integer info = this.cursorHead.getInfo();
        this.cursorHead = this.cursorHead.getNext();
        return info;
    }

    /* Metodos adicionales que podemos agregar si queremos */

    public Integer get() {
        return this.cursorHead.getInfo();
    }

    //O(1) Se realizo asi, ya que, este metodo es utilizado simplemente para calcular la suma del actual + el sigueinte.
    //Por eso si no la encuentra retorna 0 para no modificar el valor de la suma.
    //Esto es utilizado para validar si el actual+elSiguiente supera el umbral.
    //No me parecio correcto sumar aqui dentro para revisar si supera el umbral. Ya que tendria logica de "negocio" dentro de un iterador.
    //Cambie el nombre por algo mas representativo.
    public Integer getNextForCalculeteSumOrsubtraction() {
        if (Boolean.TRUE.equals(cursorTail.hasNext()))
            return this.cursorHead.getNext().getInfo();
        else return 0;
    }

    //O(1)
    public void move() {
        this.cursorHead = this.cursorHead.getNext();
    }

    //O(1)
    public boolean isLast() {
        return this.cursorHead == this.cursorTail;
    }

}
