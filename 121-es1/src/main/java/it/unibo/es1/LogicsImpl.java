package it.unibo.es1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {
	private final int size;
	private final List<Integer> val;
	public LogicsImpl(int size) {
		this.size=size;
		this.val=new ArrayList<>(values());
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		List<Integer> l=new ArrayList<>();
		for(int i=0;i<this.size;i++){
			l.add(i);
		}
		return l;
	}

	@Override
	public List<Boolean> enablings() {
		List<Boolean> l=new ArrayList<>();
		for(int v: val){
			if(v<this.size){
				l.add(true);
			}else{
				l.add(false);
			}
		}
		return l;
	}

	@Override
	public int hit(int elem) {
		if(elem<this.size()) {
			val.set(elem, val.get(elem) + 1);
		}
		return val.get(elem);
	}

	@Override
	public String result() {
		return val.stream().map(String::valueOf).collect(Collectors.joining("|","<<",">>"));
	}

	@Override
	public boolean toQuit() {
		return val.stream().allMatch(e->e.equals(val.getFirst()));
	}


}
