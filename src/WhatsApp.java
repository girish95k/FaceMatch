import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class WhatsApp {
	
	public static void main(String args[]) throws IOException
	{
		String everything;
		BufferedReader br2 = new BufferedReader(new FileReader("wa.txt"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br2.readLine();
	        
	        while (line != null) {
	        	//line.substring(10);
	        	//System.out.println(line);
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br2.readLine();
	            
	        }
	        everything = sb.toString();
	    } finally {
	        br2.close();
	    }
	    String lines[] = everything.split("\nM|\nA");
	    System.out.println(lines[0]);
	    int n=0;
	    for(int i=0; i<lines.length; i++)
	    {
	    	lines[i] = lines[i].substring(16);
	    	//System.out.println(lines[i]);
	    	if(lines[i].contains("Akshay Somayaji"))
	    	{
	    		n++;
	    	}
	    }
	    String somyalines[] = new String[n]; int j=0;
	    for(int i=0; i<lines.length; i++)
	    {
	    	if(lines[i].contains("Akshay Somayaji"))
	    	{
	    		somyalines[j]=lines[i];
	    		j++;
	    		//System.out.println(lines[i]);
	    	}
	    }
	    PrintWriter writer = new PrintWriter("somyaChat.txt", "UTF-8");
	    
	    for(int i=0; i<somyalines.length; i++)
	    {
	    	somyalines[i] = somyalines[i].replaceAll("Akshay Somayaji: ", "");
	    	System.out.println(somyalines[i]);
	    	writer.println(somyalines[i]);
	    }
	    writer.close();
	    /*
	    int n=0;
	    for(int i=0; i<lines.length; i++)
	    {
	    	if(!(lines[i].substring(0, 11) == "Aravind Cm: "))
	    	{
	    		n++;
	    	}
	    	
	    }
	    String somyalines[] = new String[n]; int j = 0;
	    for(int i=0; i<lines.length; i++)
	    {
	    	if(!(lines[i].substring(0, 11) == "Aravind Cm: "))
	    	{
	    		somyalines[j] = lines[i];
	    		j++;
	    		System.out.println(somyalines[j]);
	    	}
	    	
	    }
	    */
	    
	}

}
