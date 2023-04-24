package entity.grafo;

public class Vertice implements Comparable<Vertice>{
	
	String id;
	Coordenada coordenada;
	
	public Vertice(String id, Coordenada coordenada) {
		this.id = id;
		this.coordenada = coordenada;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		return "" + this.id + this.coordenada;
	}
	
	
	

}
