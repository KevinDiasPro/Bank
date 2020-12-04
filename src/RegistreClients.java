import java.util.Collection;
import java.util.Iterator;

public class RegistreClients implements Collection<Client> {

	private static final int TAILLE_INI = 100;
	private Client[] table;
	private int nbClients;

	public RegistreClients() {

		this.table = new Client[TAILLE_INI];
		this.nbClients = 0;
	}
	
	/// Collection Clients

	public boolean add(Client client) {
		
		
		if (this.contains(client))
			return false;
		
		if(nbClients == TAILLE_INI){
			Client[] tmp = new Client [TAILLE_INI*2];
			for (int i = 0; i < TAILLE_INI*2; i++) {
				tmp[i] = table[i];
			}
			table = tmp;
		}
		
		table[nbClients] = client;
		nbClients++;
		return true;
	}

	public boolean contains(Client client) {

		for (int i = 0; i < nbClients; i++) {
			if (table[i] == client)
				return true;
		}
		return false;
	}

	public boolean isEmpty() {

		return nbClients == 0;
	}

	public boolean remove(Client client) {

		if (!contains(client))
			return false;
		else{
			for (int i = 0; i < nbClients; i++) {
				if (table[i] == client) {
					table[i] = table[nbClients-1];
					nbClients--;
					return true;
				}

			}
			return false;
		}
		
	}
	
	public int size() {

		return nbClients;
	}

	public void clear() {
		
		for (int i = 0; i < nbClients; i++) {
			table[i] = null;
		}

	}

	@Override
	public boolean addAll(Collection<? extends Client> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Client> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

}
