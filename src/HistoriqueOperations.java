import java.util.Collection;
import java.util.Iterator;

public class HistoriqueOperations implements Collection<Operation> {
	private static final int TAILLE_INI = 1000;
	private Operation[] table;
	private int nbOperation;

	public HistoriqueOperations() {

		this.nbOperation = 0;
		this.table = new Operation[TAILLE_INI];

	}

	public boolean add(Operation operation) {
		
		if(this.contains(operation)) return false;
		//Augmenter taille tableau
		if(nbOperation == TAILLE_INI){
			Operation[] tmp = new Operation [TAILLE_INI*2];
			for (int i = 0; i < TAILLE_INI*2; i++) {
				tmp[i] = table[i];
			}
			table = tmp;
		}
		
		table[nbOperation]= operation;
		nbOperation++;
		return true;	
		
	}
	
	public boolean contains(Operation operation) {
		
		for (int i = 0; i < nbOperation; i++) {
			if(table[i] == operation){
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return nbOperation == 0;
	}
	
	public boolean remove(Operation operation) {
		
		if(!this.contains(operation))
			return false;
		else{
			for (int i = 0; i < nbOperation; i++) {
				if(table[i]==operation){
					table[i] = null;
					nbOperation--;
					return true;
				}
					
			}
			return false;
		}
		
	}

	public int size() {
		return nbOperation;
	}
	
	public void clear() {
		
		for (int i = 0; i < nbOperation; i++) {
			table[i] = null;
		}
		
	}

	@Override
	public boolean addAll(Collection<? extends Operation> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Operation> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}


	
	
}