import java.util.Collection;
import java.util.Iterator;

public class RegistreCarteBancaire implements Collection<CarteBancaire> {

	private static final int TAILLE_INI = 50;
	private CarteBancaire[] table;
	private int nbCartesBancaire;

	public RegistreCarteBancaire() {

		this.table = new CarteBancaire[TAILLE_INI];
		this.nbCartesBancaire = 0;
	}

	@Override
	public boolean add(CarteBancaire e) {

		if (this.contains(e))
			return false;
		// taille max atteint
		if (nbCartesBancaire == TAILLE_INI) {
			CarteBancaire[] tmp = new CarteBancaire[TAILLE_INI * 2];
			for (int i = 0; i < TAILLE_INI * 2; i++) {
				tmp[i] = table[i];
			}
			table = tmp;
		}

		table[nbCartesBancaire] = e;
		nbCartesBancaire++;
		return true;
	}

	@Override
	public int size() {
		return nbCartesBancaire;
	}

	@Override
	public void clear() {

		for (int i = 0; i < nbCartesBancaire; i++) {
			table[i] = null;
		}

	}

	@Override
	public boolean contains(Object o) {

		for (int i = 0; i < nbCartesBancaire; i++) {
			if (table[i] == o)
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return nbCartesBancaire == 0;
	}

	@Override
	public boolean addAll(Collection<? extends CarteBancaire> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<CarteBancaire> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o))
			return false;
		else {
			for (int i = 0; i < nbCartesBancaire; i++) {
				if (table[i] == o) {
					table[i] = table[nbCartesBancaire - 1];
					nbCartesBancaire--;
					return true;
				}
			}
			return false;
		}

	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
