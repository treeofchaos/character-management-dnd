package com.zackary.character;
import java.util.Arrays;
import java.util.Scanner;
public class levelOneCharacterBuild 
{
	private static Scanner scan;
	public static void main(String[]args)
	{
		scan = new Scanner(System.in);
		String classes = new String("");
		int stats[];
		stats=new int[4];
		int ascore[];
		ascore=new int[6];
		int results[];
		results=new int[6];
		int result;
		int amod[];
		amod=new int[6];
		int mod;
		String race = new String("");
		boolean a=false;
		boolean b=false;
		int c=0;

		//Class Picking
		System.out.println("What class do you wish to play as?");
		classes=scan.nextLine();
		classes=classes.toLowerCase();
		a=classCheck(classes, a);
		if(a==true)
		{
			System.out.println("What race do you wish to play as?");
			race=scan.nextLine();
			race=race.toLowerCase();
			b=raceCheck(race, b);
			if(b==true)
			{
				if(race.equals("half elf"))
				{
					System.out.println("What stat would you like increased (not charisma)? (0-4, 0 being strength and going down the list)");
					c=scan.nextInt();
				}

				//Stat Rolling
				for(int j=0; j<results.length; j++)
				{
					for(int i=0; i<stats.length;i++)
					{
						stats[i] = (int) Math.floor(Math.random()*6);
					}
					result=stats(stats);
					results[j]=result;
				}

				Arrays.sort(results);
				classes(ascore, results, classes);
				raceMod(race, ascore, c);

				//Getting Ability Mods
				for(int i=0; i<amod.length; i++)
				{
					mod=ascore[i];
					mod=modifier(mod);
					amod[i]=mod;
				}
				//Stat Printing
				System.out.println(race+" "+classes);
				System.out.println("Strength:     "+ascore[0]+ " and your modifier is: " +amod[0]);
				System.out.println("Dexterity:    "+ascore[1]+ " and your modifier is: " +amod[1]);
				System.out.println("Constitution: "+ascore[2]+ " and your modifier is: " +amod[2]);
				System.out.println("Intelligence: "+ascore[3]+ " and your modifier is: " +amod[3]);
				System.out.println("Wisdom:       "+ascore[4]+ " and your modifier is: " +amod[4]);
				System.out.println("Charisma:     "+ascore[5]+ " and your modifier is: " +amod[5]);
			}
			else
			{
				//Ya fuckin racist
				System.out.println("That's not a race");
			}
		}
		else
		{
			//Ya dun fucked up
			System.out.println("That's not a class");
		}
	}

	//Stat Sorting
	private static int stats(int[] stats) 
	{
		for(int i=0; i<stats.length;i++)
		{
			stats[i]++;
		}
		Arrays.sort(stats);
		int a=stats[1]+stats[2]+stats[3];
		return a;
	}
	//Ability Score Modifiers
	private static int modifier(int mod)
	{
		int a=mod%18;
		int b=0;
		if(a==3)
		{
			b=-4;
		}
		if(a==4||a==5)
		{
			b=-3;
		}
		if(a==6||a==7)
		{
			b=-2;
		}
		if(a==8||a==9)
		{
			b=-1;
		}
		if(a==12||a==13)
		{
			b=1;
		}
		if(a==14||a==15)
		{
			b=2;
		}
		if(a==16||a==17)
		{
			b=3;
		}
		if(a==0||a==1)
		{
			b=4;
		}
		if(a==2)
		{
			b=5;
		}
		return b;
	}

	//Class Stat Sorting
	private static void classes(int[] ascore, int[] results, String classes)
	{
		if(classes.equals("barbarian"))
		{
			ascore[0]=results[5];
			ascore[1]=results[4];
			ascore[2]=results[3];
			ascore[3]=results[2];
			ascore[4]=results[1];
			ascore[5]=results[0];
		}
		if(classes.equals("bard"))
		{
			ascore[0]=results[0];
			ascore[1]=results[4];
			ascore[2]=results[3];
			ascore[3]=results[2];
			ascore[4]=results[1];
			ascore[5]=results[5];
		}
		if(classes.equals("cleric"))
		{
			ascore[0]=results[3];
			ascore[1]=results[0];
			ascore[2]=results[4];
			ascore[3]=results[1];
			ascore[4]=results[5];
			ascore[5]=results[2];
		}
		if(classes.equals("druid"))
		{
			ascore[0]=results[0];
			ascore[1]=results[2];
			ascore[2]=results[3];
			ascore[3]=results[5];
			ascore[4]=results[4];
			ascore[5]=results[1];
		}
		if(classes.equals("fighter"))
		{
			ascore[0]=results[5];
			ascore[1]=results[4];
			ascore[2]=results[3];
			ascore[3]=results[1];
			ascore[4]=results[0];
			ascore[5]=results[2];
		}
		if(classes.equals("monk"))
		{
			ascore[0]=results[2];
			ascore[1]=results[5];
			ascore[2]=results[3];
			ascore[3]=results[0];
			ascore[4]=results[4];
			ascore[5]=results[1];
		}
		if(classes.equals("mystic"))
		{
			ascore[0]=results[3];
			ascore[1]=results[1];
			ascore[2]=results[2];
			ascore[3]=results[5];
			ascore[4]=results[4];
			ascore[5]=results[0];
		}
		if(classes.equals("paladin"))
		{
			ascore[0]=results[4];
			ascore[1]=results[2];
			ascore[2]=results[3];
			ascore[3]=results[1];
			ascore[4]=results[0];
			ascore[5]=results[5];
		}
		if(classes.equals("ranger"))
		{
			ascore[0]=results[1];
			ascore[1]=results[5];
			ascore[2]=results[3];
			ascore[3]=results[2];
			ascore[4]=results[4];
			ascore[5]=results[0];
		}
		if(classes.equals("rogue"))
		{
			ascore[0]=results[1];
			ascore[1]=results[5];
			ascore[2]=results[2];
			ascore[3]=results[0];
			ascore[4]=results[4];
			ascore[5]=results[3];
		}
		if(classes.equals("sorcerer"))
		{
			ascore[0]=results[0];
			ascore[1]=results[2];
			ascore[2]=results[3];
			ascore[3]=results[1];
			ascore[4]=results[4];
			ascore[5]=results[5];
		}
		if(classes.equals("warlock"))
		{
			ascore[0]=results[1];
			ascore[1]=results[3];
			ascore[2]=results[2];
			ascore[3]=results[0];
			ascore[4]=results[4];
			ascore[5]=results[5];
		}
		if(classes.equals("wizard"))
		{
			ascore[0]=results[0];
			ascore[1]=results[4];
			ascore[2]=results[3];
			ascore[3]=results[5];
			ascore[4]=results[2];
			ascore[5]=results[1];
		}
	}
	//Classes
	private static boolean classCheck(String classes, boolean a)
	{
		if(classes.equals("barbarian"))
		{
			a=true;
		}
		if(classes.equals("bard"))
		{
			a=true;
		}
		if(classes.equals("cleric"))
		{
			a=true;
		}
		if(classes.equals("druid"))
		{
			a=true;
		}
		if(classes.equals("fighter"))
		{
			a=true;
		}
		if(classes.equals("monk"))
		{		
			a=true;
		}
		if(classes.equals("mystic"))
		{
			a=true;
		}
		if(classes.equals("paladin"))
		{
			a=true;
		}
		if(classes.equals("ranger"))
		{
			a=true;
		}
		if(classes.equals("rogue"))
		{
			a=true;
		}
		if(classes.equals("sorcerer"))
		{
			a=true;
		}
		if(classes.equals("warlock"))
		{
			a=true;
		}
		if(classes.equals("wizard"))
		{
			a=true;
		}
		return a;
	}
	//Race Stat Mods
	public static void raceMod(String race, int[] ascore, int c)
	{
		if(race.equals("protector aasimar"))
		{
			ascore[5]+=2;
			ascore[4]++;
		}
		if(race.equals("scourge aasimar"))
		{
			ascore[5]+=2;
			ascore[2]++;
		}
		if(race.equals("fallen aasimar"))
		{
			ascore[5]+=2;
			ascore[0]++;
		}
		if(race.equals("bugbear"))
		{
			ascore[0]+=2;
			ascore[1]++;
		}
		if(race.equals("dragonborn"))
		{
			ascore[0]+=2;
			ascore[1]++;
		}
		if(race.equals("duergar dwarf"))
		{
			ascore[2]+=2;
			ascore[0]++;
		}
		if(race.equals("hill dwarf"))
		{
			ascore[2]+=2;
			ascore[4]++;
		}
		if(race.equals("mountain dwarf"))
		{
			ascore[2]+=2;
			ascore[0]+=2;
		}
		if(race.equals("high elf"))
		{
			ascore[1]+=2;
			ascore[3]++;
		}
		if(race.equals("wood elf"))
		{
			ascore[1]+=2;
			ascore[4]++;
		}
		if(race.equals("drow")||race.equals("dark elf"))
		{
			ascore[1]+=2;
			ascore[5]++;
		}
		if(race.equals("firbolg"))
		{
			ascore[4]+=2;
			ascore[0]++;
		}
		if(race.equals("air genasi"))
		{
			ascore[2]+=2;
			ascore[1]++;
		}
		if(race.equals("earth genasi"))
		{
			ascore[2]+=2;
			ascore[0]++;
		}
		if(race.equals("fire genasi"))
		{
			ascore[2]+=2;
			ascore[3]++;
		}
		if(race.equals("water genasi"))
		{
			ascore[2]+=2;
			ascore[4]+=2;
		}
		if(race.equals("forest gnome"))
		{
			ascore[3]+=2;
			ascore[1]++;
		}
		if(race.equals("rock gnome"))
		{
			ascore[3]+=2;
			ascore[2]++;
		}
		if(race.equals("deep gnome"))
		{
			ascore[3]+=2;
			ascore[1]++;
		}
		if(race.equals("goblin"))
		{
			ascore[1]+=2;
			ascore[2]++;
		}
		if(race.equals("goliath"))
		{
			ascore[0]+=2;
			ascore[2]++;
		}
		if(race.equals("half elf"))
		{
			ascore[5]+=2;
			ascore[c]++;
		}
		if(race.equals("half orc"))
		{
			ascore[0]+=2;
			ascore[2]++;
		}
		if(race.equals("ghostwise halfling"))
		{
			ascore[1]+=2;
			ascore[4]++;
		}
		if(race.equals("lightfoot halfling"))
		{
			ascore[1]+=2;
			ascore[5]++;
		}
		if(race.equals("stout halfling"))
		{
			ascore[1]+=2;
			ascore[2]++;
		}
		if(race.equals("hobgoblin"))
		{
			ascore[2]+=2;
			ascore[3]++;
		}
		if(race.equals("human"))
		{
			for(int i=0; i<ascore.length; i++)
			{
				ascore[i]++;
			}
		}
		if(race.equals("kenku"))
		{
			ascore[1]+=2;
			ascore[4]++;
		}
		if(race.equals("kobold"))
		{
			ascore[1]+=2;
			ascore[0]-=2;
		}
		if(race.equals("lizardfolk"))
		{
			ascore[2]+=2;
			ascore[4]++;
		}
		if(race.equals("orc"))
		{
			ascore[0]+=2;
			ascore[2]++;
			ascore[3]-=2;
		}
		if(race.equals("tabaxi"))
		{
			ascore[5]++;
			ascore[2]+=2;
		}
		if(race.equals("tiefling"))
		{
			ascore[5]+=2;
			ascore[3]++;
		}
		if(race.equals("tortle"))
		{
			ascore[0]+=2;
			ascore[3]++;
		}
		if(race.equals("triton"))
		{
			ascore[0]++;
			ascore[2]++;
			ascore[5]++;
		}
		if(race.equals("yuan ti"))
		{
			ascore[5]+=2;
			ascore[3]++;
		}

	}
	//Setting Races
	public static boolean raceCheck(String race, boolean b)
	{
		if(race.equals("protector aasimar"))
		{
			b=true;
		}
		if(race.equals("scourge aasimar"))
		{
			b=true;
		}
		if(race.equals("fallen aasimar"))
		{
			b=true;
		}
		if(race.equals("bugbear"))
		{
			b=true;
		}
		if(race.equals("dragonborn"))
		{
			b=true;
		}
		if(race.equals("duergar dwarf"))
		{
			b=true;
		}
		if(race.equals("hill dwarf"))
		{
			b=true;
		}
		if(race.equals("mountain dwarf"))
		{
			b=true;
		}
		if(race.equals("high elf"))
		{
			b=true;
		}
		if(race.equals("wood elf"))
		{
			b=true;
		}
		if(race.equals("drow")||race.equals("dark elf"))
		{
			b=true;
		}
		if(race.equals("firbolg"))
		{
			b=true;
		}
		if(race.equals("air genasi"))
		{
			b=true;
		}
		if(race.equals("earth genasi"))
		{
			b=true;
		}
		if(race.equals("fire genasi"))
		{
			b=true;
		}
		if(race.equals("water genasi"))
		{
			b=true;
		}
		if(race.equals("forest gnome"))
		{
			b=true;
		}
		if(race.equals("rock gnome"))
		{
			b=true;
		}
		if(race.equals("deep gnome"))
		{
			b=true;
		}
		if(race.equals("goblin"))
		{
			b=true;
		}
		if(race.equals("goliath"))
		{
			b=true;
		}
		if(race.equals("half elf"))
		{
			b=true;
		}
		if(race.equals("half orc"))
		{
			b=true;
		}
		if(race.equals("ghostwise halfling"))
		{
			b=true;
		}
		if(race.equals("lightfoot halfling"))
		{
			b=true;
		}
		if(race.equals("stout halfling"))
		{
			b=true;
		}
		if(race.equals("hobgoblin"))
		{
			b=true;
		}
		if(race.equals("human"))
		{
			b=true;
		}
		if(race.equals("kenku"))
		{
			b=true;
		}
		if(race.equals("kobold"))
		{
			b=true;
		}
		if(race.equals("lizardfolk"))
		{
			b=true;
		}
		if(race.equals("orc"))
		{
			b=true;
		}
		if(race.equals("tabaxi"))
		{
			b=true;
		}
		if(race.equals("tiefling"))
		{
			b=true;
		}
		if(race.equals("tortle"))
		{
			b=true;
		}
		if(race.equals("triton"))
		{
			b=true;
		}
		if(race.equals("yuan ti"))
		{
			b=true;
		}
		return b;
	}
}