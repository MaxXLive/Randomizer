package songRandomizer;

import java.util.Random;
import java.util.Scanner;

public class SongRandomizer
{
	public static void main(String[] args)
	{
		
		String[] files = new String[10];
		
		for(int i = 0; i < files.length; i++)
		{
			files[i] = String.valueOf(i+1);
		}
		
		System.out.println("Bitte wählen Sie:");
		System.out.println("1. Zufallsfunktion (Tauscht jedes mal gleich)");
		System.out.println("2. Zufallsfunktion (Tauscht jedes mal unterschiedlich, bei Wiederholung wird aber die gleiche Reihenfolge benutzt!");
		System.out.println("3. Zufallsfunktion (Tauscht jedes mal unterschiedlich, bei Wiederholung wird eine neue Reihenfolge generiert und verhindert, dass zwei Mal das selbe Lied abgespielt wird!");
		
		Scanner sc = new Scanner(System.in);
		String auswahl1 = sc.next();
		
		switch(auswahl1)
		{
			case "1": first(files); break;
			case "2": second(files); break;
			case "3": third(files); third(files); break;
			default: System.out.println("Ungültige Eingabe!"); break;
		}
		sc.close();
		
	}
	
	public static int random(int min, int max)
	{
		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
	}
	
	public static void tausche(String[] files, int x, int y)
	{
		String merke = files[x];
		files[x] = files[y];
		files[y] = merke;
	}
	
	private static void ausgabe(String[] files)
	{
		for(int i = 0; i < files.length; i++)
		{
			System.out.println(files[i]);
		}
	}
	
	private static void first(String[] files)
	{
		tausche(files, 0, 4);
		tausche(files, 1, 6);
		tausche(files, 2, 3);
		tausche(files, 5, 8);
		tausche(files, 7, 9);
		
		ausgabe(files);
		System.out.println("---");
		ausgabe(files);
	}
	
	private static void second(String[] files)
	{
		for(int i = 0; i < files.length - 1; i++)
		{
			tausche(files, i, random(i+1, files.length - 1));
		}
		
		ausgabe(files);
		System.out.println("---");
		ausgabe(files);
		
	}
	
	private static void third(String[] files)
	{
		System.out.println("---");
		
		String last = files[files.length-1];
		
		for(int i = 0; i < files.length - 1; i++)
		{
			if(i == 0)
			{
				while(true)
				{
					int rand = random(i+1, files.length - 1);
					if(!(files[rand].equals(last)))
					{
						tausche(files, i, rand);
						break;
					}
				}
			}
			else
			{
				tausche(files, i, random(i+1, files.length - 1));
			}
		}
		
		ausgabe(files);
		
	}
}
