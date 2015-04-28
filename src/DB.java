import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class DB {
		public static void write(String id, String name, int openness, int agreeableness, int neuroticism, int concentiousness, int extraversion) throws FileNotFoundException, UnsupportedEncodingException
		{
			
			try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("database.txt", true)))) {
				writer.print(id + ",");
				writer.print(name + ",");
				writer.print(openness + ",");
				writer.print(agreeableness + ",");
				writer.print(neuroticism + ",");
				writer.print(concentiousness + ",");
				writer.println(extraversion);
			}catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
			
		}
}
