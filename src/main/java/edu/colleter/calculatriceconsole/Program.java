package edu.colleter.calculatriceconsole;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pile maPile = new Pile();  		
		System.out.println("Choisir un mode opératoire : C : Chaine  /  I : Interactif"); 
		Scanner sc = new Scanner(System.in);		
		maPile.setInteractif(sc.nextLine());
        maPile.traitement(maPile);
	}
}