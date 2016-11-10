
public class Linha 
{
	private char tag;
	private String texto;

	public Linha(char tag, String texto)
	{
		this.tag = tag;
		this.texto = texto;
	}
	public String getTexto()
	{
		return texto;
	}
	
	public char getTag()
	{
		return tag;
	}
	
}