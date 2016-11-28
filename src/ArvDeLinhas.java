import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArvDeLinhas {
	private GeneralTreeOfInteger arvore = new GeneralTreeOfInteger();

	private  ArrayList<Linha> linhas = new ArrayList<Linha>();
	public ArvDeLinhas() throws FileNotFoundException
	{
		leTexto();
		montaArvore();
		System.out.println(arvore.positionsWidth());
	}
	
	public void leTexto() throws FileNotFoundException
    {
		Scanner scanner = new Scanner(new FileReader("texto.txt"));
		Linha linha = null;
		
		while (scanner.hasNext())
		{	
			int cont = 1;
			String tag = scanner.next();
			System.out.println(tag);
			String texto = scanner.nextLine();
			linha = new Linha(cont,tag, texto);
			linhas.add(linha);
			cont ++;
				
		}

    }
	public void montaArvore()
	{
		Linha titulo = null;
		Linha ultimoCapitulo = null;
		Linha ultimaSecao = null;
		Linha ultimaSubsecao = null;
		Linha ultimoParagrafo = null;
		int i = 0;
		
			while(i<linhas.size())
			{
				if(linhas.get(i).getTag().equals("L"))
				{
					System.out.println("--------------------------------");
					arvore.add(linhas.get(i), null);
					titulo = linhas.get(i);
				}
				
				else if(linhas.get(i).getTag().equals("C") )
				{
					arvore.add(linhas.get(i),titulo);
					ultimoCapitulo = linhas.get(i);
					
				}
				else if(linhas.get(i).getTag().equals("S"))
				{
					arvore.add(linhas.get(i), ultimoCapitulo);
					ultimaSecao = linhas.get(i);
				}
				else if(linhas.get(i).getTag().equals("SS"))
				{
					
					arvore.add(linhas.get(i), ultimaSecao);
					ultimaSubsecao = linhas.get(i);
				}
				else if(linhas.get(i).getTag().equals("P"))
				{
					if(ultimaSubsecao == null)
					{
						arvore.add(linhas.get(i), ultimaSecao);
						ultimoParagrafo = linhas.get(i);
					}
					else
					{
					arvore.add(linhas.get(i), ultimaSubsecao);
					ultimoParagrafo = linhas.get(i);
					}
				}
				i++;
				
				
			}
		
	}
	public GeneralTreeOfInteger GetArvore()
	{
	return	arvore;
	}
	
}
