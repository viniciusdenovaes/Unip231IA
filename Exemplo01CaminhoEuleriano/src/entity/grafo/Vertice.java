package entity.grafo;

public class Vertice implements Comparable<Vertice>{
	
	String id;
	
	public Vertice(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Vertice o) {
		return this.id.compareTo(o.id);
	}
	
	
	@Override
	public String toString() {
		return this.id;
	}
	
	
	

}
