
public class Linha 
{
	private String tag;
	private String texto;
	private Integer nLinha;

	public Linha(Integer nLinha,String tag, String texto)
	{
		this.nLinha = nLinha;
		this.tag = tag.toUpperCase();
		this.texto = texto;
	}
	public String getTexto()
	{
		return texto;
	}
	
	public String getTag()
	{
		return tag;
	}
	public  String toString(){
		return tag + " "+ " "+ texto;
	}
	
}