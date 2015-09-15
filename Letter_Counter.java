/* -----------------------------------------------------------------------------
 *
 * File Name: Letter_Counter.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Lab 11
 * Description:  This program will take in a text file, read the text file, and give an analysis of the letters.
 * Date: December 1, 2014
 *
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Letter_Counter {
	public static void main(String[] args) {
		boolean a = true;
		Scanner input = new Scanner(System.in);
		FileReader myFileReader= null;
		BufferedReader myBufferedReader= null;
		FileWriter fstream = null;
		BufferedWriter out = null;
		String line = "";
		String filename ="";
		String file_out="";
		while (a) {
			try
			{
				System.out.println("Input a file name: ");
				filename = input.next();
				myFileReader= new FileReader(filename);
			    myBufferedReader= new BufferedReader(myFileReader);	
				a = false;
			}
			catch (Exception e)
			{
			   System.out.println("Invalid filename given. Input another."); //print what went wrong
			   a = true;
			}
		}
		try
		{
		    System.out.println("Input an out file name: ");
			file_out = input.next();
			fstream = new FileWriter(file_out);
			out = new BufferedWriter(fstream);
		}
		catch (Exception e) {
		}
	    int[] my_array= new int[58];
	    System.out.println("Do you want the scan of the file to be case sensitive? (1 for Yes. 2 for No): ");
	    int answer = input.nextInt();
	    while (answer!=1 && answer!=2) {
	    	 System.out.println("Enter Valid Input");
	    	 System.out.println("Do you want the scan of the file to be case sensitive? (1 for Yes. 2 for No): ");
	    	 answer = input.nextInt();
	    }
	    for (int i = 0; i < my_array.length; i++) {
	    	my_array[i] = 0;
	    }
	    System.out.println("Reading from " + filename);
	    if (answer == 1) {
		    while(line !=null) {
		    	try {
		    	    line= myBufferedReader.readLine();
		    	    if (line!= null) {
		    	    System.out.println(line);
		    	    }
		    	}
		    	catch (Exception e) {
		    		line = null;
		    	}
		    	if (line!=null) {
			    	for(int i = 0; i< line.length(); i++) {
			    		char letter = line.charAt(i);
			    		int value = (int) letter;
			    		for (int j = 65; j <= 122; j++) {
			    		  if ((value >= 65 && value <= 90) || (value>=97 && value <= 122)) {
			    			  if (value == j) {
			    				  my_array[j-65] = my_array[j-65] +1;
			    			  }
			    		  }
			    		}
			    	}
		    	}
		    }
	    }
	    if (answer == 2) {
	    	while(line !=null) {
		    	try {
		    	    line= myBufferedReader.readLine();
		    	    if (line!= null) {
		    	    System.out.println(line);
		    	    }
		    	}
		    	catch (Exception e) {
		    		line = null;
		    	}
		    	if (line!=null) {
			    	for(int i = 0; i< line.length(); i++) {
			    		char letter = line.charAt(i);
			    		int value = (int) letter;
			    		for (int j = 65; j <= 122; j++) {
			    		  if ((value >= 65 && value <= 90)) {
			    			  if (value == j) {
			    				  my_array[j-65] = my_array[j-65] +1;
			    			  }
			    		  }
			    		  if ((value>=97 && value <= 122)) {
			    			  if (value == j) {
			    				  my_array[j-97] = my_array[j-97] +1;
			    			  }
			    		  }
			    		}
			    	}
		    	}
		    }
	    }
	    try {
	    myBufferedReader.close();//close the file
	    }
	    catch (Exception e) { 	
	    }
	    if (answer==1) {
	    	int my_max = my_array[0];
	    	int max_index = 0;
	    	char max_char = (char) 97;
		    for (int i = 65; i <= 122; i++) {
		    	try {
			    	if ((i >= 65 && i <= 90) || (i>=97 && i <= 122)) {
			    		char my_char = (char) i;
			    		out.write(my_char + "=" + my_array[i-65]);
			    		out.newLine();
			    	}
		    	}
		    	catch (Exception e) {
		    	}
		    }
		    for (int i =65; i <= 122; i++) {
		    	if ((i >= 65 && i <= 90) || (i>=97 && i <= 122)) {
		    		if (my_array[i-65] > my_max) {
		    			my_max = my_array[i-65];
		    			max_index = i-65;
		    			max_char = (char) (i);
		    		}
	    		}
	    	}
		    try {
	    		out.newLine();
	    		out.write("The letter that appeared the most is " +(max_char) + " appearing " + my_array[max_index] + " times.");
	    		out.newLine();
	    	}
	    	catch (Exception e) {
	    	}
	    	  for (int i =65; i <= 122; i++) {
			    	if ((i >= 65 && i <= 90) || (i>=97 && i <= 122)) {
			    		if (my_array[i-65] == my_max && (i-65)!= max_index) {
			    			my_max = my_array[i-65];
			    			max_index = i-65;
			    			max_char = (char) (i);
			    			try {
			    			out.newLine();
			    			out.write("The letter that also appeared the most is " +(max_char) + " appearing " + my_array[max_index] + " times.");
			    			out.newLine();
			    			}
			    			catch (Exception e) {
			    			}
			    		}
		    		}
		    	}
	    }
	    if (answer==2) {
	    	int my_max = my_array[0];
	    	int max_index = 0;
	    	char max_char = (char) 97;
	    	for (int i = 97; i <= 122; i++) {
		    	try {
			    	char my_char = (char) i;
			    	out.write(my_char + "=" + my_array[i-97]);
			    	out.newLine();
		    	}
		    	catch (Exception e) {
		    	}
		    }
	    	for (int i =0; i < 26; i++) {
	    		if (my_array[i] > my_max) {
	    			my_max = my_array[i];
	    			max_index = i;
	    			max_char = (char) (i+97);
	    		}
	    	}
	    	try {
	    		out.newLine();
	    		out.write("The letter that appeared the most is " +(max_char) + " appearing " + my_array[max_index] + " times.");
	    		out.newLine();
	    	}
	    	catch (Exception e) {
	    	}
	    	for (int i = 0; i < 26; i++) {
	    		if (my_array[i] == my_max && i!= max_index) {
	    			my_max = my_array[i];
	    			max_index = i;
	    			max_char = (char) (i+97);
	    			try {
	    				out.newLine();
	    				out.write("The letter that also appeared the most is " +(max_char) + " appearing " + my_array[max_index] + " times.");
	    				out.newLine();
		    		}
		    		catch (Exception e) {
		    		}
	    		}
	    	}
	    }
	    try {
	    out.close();
	    }
	    catch (Exception e) {
	    }
	    System.out.println("Results stored in " + file_out);
	}
}