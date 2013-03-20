package Lookup;

public class DocuData {

	String genre;
	String url;
	String naam;
	String subGenre;
	String Type;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getSubGenre() {
		return subGenre;
	}

	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
	public String toString(){
		
		return "Naam :   " + getNaam(); 
	
	}

}
