package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	private List<Integer> values;

	public LogicsImpl(final int size) {
		this.values = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			this.values.add(0);
		}
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return new ArrayList<>(this.values);
	}

	@Override
	public List<Boolean> enablings() {
		List<Boolean> enablings = new ArrayList<>(size());
		for (int i = 0; i < size(); i++) {
			enablings.add(this.values.get(i) < size());
		}
		return enablings;
	}

	@Override
	public int hit(int elem) {
		this.values.set(elem, this.values.get(elem) + 1);
		return this.values.get(elem);
	}

	@Override
	public String result() {
		String out = "<<";
		var i = this.values.iterator();
		while (i.hasNext()) {
			out += i.next();
			if (i.hasNext()) {
				out += "|";
			}
		}
		out += ">>";
		return out;
	}

	@Override
	public boolean toQuit() {
		final Integer n = this.values.getFirst();
		for (int i = 1; i < size(); i++) {
			if (!this.values.get(i).equals(n)) {
				return false;
			}
		}
		return true;
	}
}
