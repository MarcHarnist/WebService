package fr.eni.javaee.module9;

// Tests
// http://localhost:8080/AppliDemo/modules/module9/rest/couleurs 
// http://localhost:8080/AppliDemo/modules/module9/rest/couleurs/rouge 
//  http://localhost:8080/AppliDemo/modules/module9/rest/couleurs/2 

@Path("/couleurs")
public class GestionCouleurs {
	private static List<String> listeCouleurs;
	
	static
	{
		listeCouleurs= new ArrayList<String>();
		listeCouleurs.add("bleu");
		listeCouleurs.add("vert");
		listeCouleurs.add("jaune");
		listeCouleurs.add("rouge");
	}
	
	@GET
	public String getCouleurs()
	{
		return listeCouleurs.toString();
	}
	
	@GET
	@Path("/rouge")
	public String getCouleurRouge()
	{
		return "rouge";
	}
	
	@GET
	@Path("/{id : \\d+}")
	public String getCouleur(@PathParam("id") int id)
	{
		return "La couleur de l'id " + id + " est " + listeCouleurs.get(id);
	}
}