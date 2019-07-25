package fr.eni.javaee.module9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.eni.javaee.module9.bo.Crayon;

@Path("/crayons")
public class GestionCrayons {

	//Attention aux accès concurrents
	private static List<Crayon> listeCrayons = new ArrayList<>();
	
	static
	{
		listeCrayons.add(new Crayon(1, "bille", "bleu"));
		listeCrayons.add(new Crayon(2, "plume", "vert"));
	}
	
	@GET
	public List<Crayon> getCrayons()
	{
		return listeCrayons;
	}
	
	@GET
	@Path("/{id : \\d+}")
	public Crayon getCrayon(@PathParam("id") int id)
	{
		Crayon crayonARetourner=null;
		for(Crayon crayon:listeCrayons)
		{
			if(crayon.getId()==id)
			{
				crayonARetourner=crayon;
				break;
			}
		}
		return crayonARetourner;
	}
}