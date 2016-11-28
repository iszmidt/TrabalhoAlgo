
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) throws FileNotFoundException 
    {
    	ArvDeLinhas arv = new ArvDeLinhas();
    	GeneralTreeOfInteger arvore = arv.GetArvore();
    	arvore.positionsWidth();
    	
        
    }
    
     
}
