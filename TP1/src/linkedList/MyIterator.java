package linkedList;

import java.util.Iterator;
import java.util.Objects;

public class MyIterator implements Iterator<Integer> {

	private Node cursor;
	
	public MyIterator(final Node first) {
		Node aux = first;
		while (Objects.nonNull(aux)) {
			aux = aux.getNext();
		}

		this.cursor = first;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public Integer next() {
		Integer info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return info;
	}
	
	/* Metodos adicionales que podemos agregar si queremos */
	
	public Integer get() {
		return this.cursor.getInfo();
	}

	public Integer getNext() {
		if (Objects.nonNull(cursor.getNext()))
		return this.cursor.getNext().getInfo();
		else return 0;
	}
	public void move() {
		this.cursor = this.cursor.getNext();
	}

}
