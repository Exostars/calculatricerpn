package edu.colleter.calculatriceconsole;
import java.util.Scanner;

public class Pile {
	private String chaineBrute;
    private String separator;
    boolean interactif = false;
    boolean trace = false;
    
    public Pile(){}

    public Pile(String chaineBrute, String separator)
    {
        this.chaineBrute = chaineBrute;
        this.separator = separator;
    }

    public String getChaineBrute()
    {
        return chaineBrute;
    }

    public String getSeparator()
    {
        return separator;
    }

    public void setChaineBrute(String chaine)
    {
        chaineBrute = chaine;
    }

    public void setSeparator(String sep)
    {
        separator = sep;
    }

    public String[] splitPile(Pile unePile)
    {
        String[] pile = unePile.getChaineBrute().split(unePile.getSeparator());
        return pile;
    }

    public void evaluer(Pile pile)
    {
        String[] splitedPile = pile.splitPile(pile);
        for (String s : splitedPile)
        {
            System.out.println(s + " ");
        }           
    }

	public boolean isAnumber(String nombreOuPas)
	{
		double i;
		boolean estUnNombre = false;
		try
		{
			i = Double.parseDouble(nombreOuPas);
			
			estUnNombre = true;
		}
		catch (Exception e)
		{
			
		}
		return estUnNombre;
	}
	
	public void setInteractif(String s)
	{
		if (s == "C"){
			this.interactif = false;
		}
		else{
			this.interactif = true;
		}		
	}
	
	public void setTrace(boolean b){
		if(b == true){
			this.trace = true;
		}
		else{
			this.trace = false;
		}
	}
	
	public double factorielle(double n)
	{
		if (n <= 1)
		    return  1;
		else
		    return  n * factorielle(n - 1);
	}
	
	void reverse(double[] tab)
	{
		int tailleTableau = tab.length;
        int i = 0;
        double temp = 0;
        for (i = 0 ; i < tailleTableau / 2 ; i++)
        {
                temp = tab[i];
                tab[i] = tab[tailleTableau - i - 1];
                tab[tailleTableau - i - 1] = temp;
        }
	}
	
	public void tracePile(double[] n)
	{
		reverse(n);
		System.out.println("\n");
		for (double nb : n){
			if (nb != 0){
				System.out.println(nb);
			}			
		}
		reverse(n);
	}

    public void traitement(Pile pile)
    {
    	setTrace(false);
    	double[] n = {0, 0, 0};
        int i = 0;
        int k = 0;
        double result = 0;         
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
    	if (this.interactif == true)
    	{
    		while(stop == false){
    			System.out.println("\nEntrer un nombre ou un opérateur \nstop : Arrêt || pile : État de la pile ||"
    					+ " trace : mode trace || result : Affiche le résultat");
    			String c = sc.nextLine();
                if (pile.isAnumber(c))
                {
                    n[k] = Double.parseDouble(c);
                    k = k+1;
                }
                else
                {
                    switch (c)
                    {
                        case "+":
                            n[k-2] = n[k - 2] + n[k-1];
                            n[k-1] = 0;
                            k = k - 1;
                            break;
    					case "-":
    						n[k-2] = n[k - 2] - n[k-1];
    						n[k-1] = 0;
                            k = k - 1;
    					    break;
    					case "*":
    						n[k-2] = n[k - 2] * n[k-1];
    						n[k-1] = 0;
                            k = k - 1;
    					    break;
    					case "/":
    						n[k-2] = n[k - 2] / n[k-1];
    						n[k-1] = 0;
                            k = k - 1;
    					    break;
    					case "puissance":											
    						n[k - 2] = Math.pow(n[k - 2], n[k - 1]);
    						n[k-1] = 0;
    						k = k - 1;
    					case "racine":
    						n[k-1]= Math.sqrt(n[k-1]);
    						break;		
    					case "carre":
    						n[k-1]= n[k-1] * n[k-1];
    						break;
    					case "cosinus":
    						n[k-1]= Math.cos(n[k-1]);
    						break;
    					case "sinus":
    						n[k-1]= Math.sin(n[k-1]);
    						break;
    					case "tangeante":
    						n[k-1]= Math.tan(n[k-1]);
    						break;
    					case "inverse":
    						n[k-1]= 1/n[k-1];
    						break; 
    					case "oppose":
    						n[k-1]= (-1)*n[k-1];
    						break;
    					case "!":
    						n[k-1] = factorielle(n[k-1]);
    						break;
    					case "stop":
    						stop = true;
    						System.exit(0);
    						break;
    					case "pile":
    						tracePile(n);
    						break;
    					case "result":
    						result = n[0];
    						System.out.println(result);
    						break;
    					case "trace":
    						if(this.trace == false){
    							setTrace(true);
    							System.out.println("\nTrace : ON");
    						}
    						else{
    							setTrace(false);
    							System.out.println("\nTrace : OFF");
    						}    							
    						break;
    					default:
    					    System.out.println(c + "Erreur");
    					    break;
                    }                    
                }    
                if (this.trace == true){
                	tracePile(n);
                }
    		}
    	}
    	else if (this.interactif == false)
    	{       		
    		System.out.println("Entrer une expression");    		
    		pile.setChaineBrute(sc.nextLine());
    		pile.setSeparator(" ");
    		String[] pilesplitedd = pile.splitPile(pile);
            while (i < pile.splitPile(pile).length)
            {
            	String element = pile.splitPile(pile)[i];
                if (pile.isAnumber(element))
                {
                    n[k] = Double.parseDouble(element);
                    k = k+1;
                }
                else
                {
                    switch (element)
                    {
                        case "+":
                            n[k-2] = n[k - 2] + n[k-1];
                            k = k - 1;
                            break;
    					case "-":
    						n[k-2] = n[k - 2] - n[k-1];
                            k = k - 1;
    					    break;
    					case "*":
    						n[k-2] = n[k - 2] * n[k-1];
                            k = k - 1;
    					    break;
    					case "/":
    						n[k-2] = n[k - 2] / n[k-1];
                            k = k - 1;
    					    break;
    					case "puissance":											
    						n[k - 2] = Math.pow(n[k - 2], n[k - 1]);	
    						k = k - 1;
    					case "racine":
    						n[k-1]= Math.sqrt(n[k-1]);
    						break;		
    					case "carre":
    						n[k-1]= n[k-1] * n[k-1];
    						break;
    					case "cosinus":
    						n[k-1]= Math.cos(n[k-1]);
    						break;
    					case "sinus":
    						n[k-1]= Math.sin(n[k-1]);
    						break;
    					case "tangeante":
    						n[k-1]= Math.tan(n[k-1]);
    						break;
    					case "inverse":
    						n[k-1]= 1/n[k-1];
    						break; 
    					case "oppose":
    						n[k-1]= (-1)*n[k-1];
    						break;
    					case "!":
    						n[k-1] = factorielle(n[k-1]);
    						break;
    					case "stop":
    						System.exit(0);
    						break;
    					case "pile":
    						for (double nb : n)
    						{
    							if (nb != 0)
    							{
    								System.out.println(nb);
    							}							
    						}
    						break;
    					default:
    					    System.out.println(element + "Erreur");
    					    break;
                    }
                }  
                i = i+1;
            }            
    	}
    	result = n[0];
        System.out.println(result);
    }
}