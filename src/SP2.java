/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Girish
 */
public class SP2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        String everything, everything2;
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    System.out.println(everything2);

    int lo = lowopenness();
    int ho = highopenness();    
    int ha = highagreeableness();
    int la = lowagreeableness();
    int e = extraversion();
    int i = introversion();
    int n = neuroticism();
    int es = emotionalstability();
    int hc = highconscientiousness();
    int lc = lowconscientiousness();
    
    System.out.println((lo) + " " + (ho) + " " + (la) + " " + (ha) + " " + (i) + " " + (e) + " " + (es) + " " + (n) + " " + (lc) + " " + (hc));
    //System.out.println(ha);
    //System.out.println(neuroticism());
    //System.out.println("Extraversion " + e);
    
    //System.out.println("Neuroticism " + n);
    
    int openness, extraversion, concentiousness, agreeableness, neuroticism;
    
    if(ho>lo)
    {
        System.out.println("Openness: " + (ho*100/(ho+lo)) + "% "); openness = (ho*100/(ho+lo));
    }
    else
    {
        System.out.println("Openness: " + (ho*100/(ho+lo)) + "% "); openness = (ho*100/(ho+lo));
    }
    if(i>e)
    {
        System.out.println("Extraversion: " + (e*100/(i+e)) + "% "); extraversion = (e*100/(i+e));
    }
    else
    {
        System.out.println("Extraversion " + (e*100/(i+e)) + "% "); extraversion = (e*100/(i+e));
    }
    if(hc>lc)
    {
        System.out.println("Conscientiousness: " + (hc*100/(hc+lc)) + "% "); concentiousness = (hc*100/(hc+lc));
    }
    else
    {
        System.out.println("Conscientiousness: " + (hc*100/(hc+lc)) + "% "); concentiousness = (hc*100/(hc+lc));
    }
    if(ha>la)
    {
        System.out.println("Agreeableness: " + (ha*100/(ha+la)) + "% "); agreeableness = (ha*100/(ha+la));
    }
    else
    {
        System.out.println("Agreeableness: " + (ha*100/(ha+la)) + "% "); agreeableness = (ha*100/(ha+la));
    }
    if(n>es)
    {
        System.out.println("Neuroticism: " + (n*100/(n+es)) + "% "); neuroticism = (n*100/(n+es));
    }
    else
    {
        System.out.println("Neuroticism: " + (n*100/(n+es)) + "% "); neuroticism = (n*100/(n+es));
    }
    
    RadarChart.call(openness, agreeableness, neuroticism, concentiousness, extraversion);
    
    DB.write("1", "Girish", openness, agreeableness, neuroticism, concentiousness, extraversion);
   
    /*
    int highopen = (ho*100/(ho+lo));
    int lowopen = (lo*100/(ho+lo));
    int intro = (i*100/(i+e));
    int extra = (e*100/(i+e));
    int highcon = (hc*100/(hc+lc));
    int lowcon = (lc*100/(hc+lc));
    int highagree = (ha*100/(ha+la));
    int lowagree = (la*100/(ha+la));
    int neuro = (n*100/(n+es));
    int emostable = (es*100/(n+es));
    
    int openness, extraversion, concentiousness, agreeableness, neuroticism;
    if(ho>lo)
        openness = highopen;
    else
        openness = lowopen;
    if(i>e)
        extraversion = intro;
    else
        extraversion = extra;
    if(hc>lc)
        concentiousness = highcon;
    else
        concentiousness = lowcon;
    if(ha>la)
        agreeableness = highagree;
    else
        agreeableness = lowagree;
    if(n>es)
        neuroticism = neuro;
    else
        neuroticism = emostable;
    */
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    System.out.println(count2);
    
   
    }
    
   public static int neuroticism () throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("Neuroticism.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i] + "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println("found");
        	count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count;
   }
   
   public static int emotionalstability () throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("EmotionalStability.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i] + "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println("found");
        	count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count;
   }
   
   public static int lowagreeableness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("lowAgreeableness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i] + "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
            count1++; //System.out.println("found");
        	count = count + weights[i];
        }
    }  
   
   
    System.out.println(count1);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
   
   public static int highagreeableness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("highAgreeableness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i]+ "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
            count1++; //System.out.println("found");
            count = count + weights[i];
        }
    }  
   
   
    System.out.println(count1);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
   
   public static int lowopenness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("lowOpenness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i]+ "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
     int count = 0;
     int count1=0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println("found");
            count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count;
   }
   
   public static int highopenness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("highOpenness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + "\"" + words[i]+ "\"");
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println("found");
            count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count;
   }
   
   public static int extraversion() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("extra.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + words[i]);
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1 = 0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
            count1++; //System.out.println(words[i]);
        	count = count + weights[i];
        }
    }  
   
   
    System.out.println(count1);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
   
   public static int introversion() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("intro.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + words[i]);
    }
    
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        //words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
            count1++; //System.out.println(words[i]);
        	count = count + weights[i];
        }
    }  
   
   
    System.out.println(count1);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
   
   public static int highconscientiousness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("highConscientiousness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + words[i]);
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        //words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println(words[i]);
        	count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
   
   public static int lowconscientiousness() throws IOException
   {
       String everything, everything2;
        ArrayList<String> list = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader("lowConscientiousness.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        //list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        everything = sb.toString();
    } finally {
        br.close();
    }
    
    String[] words = everything.split("\n");
    int[] weights = new int[words.length];
    
    for(int i=0; i<words.length; i++)
    {
    	String sweight = words[i].substring(0, 2);
    	weights[i] = Integer.parseInt(sweight);
    	words[i]=words[i].substring(3);
    	words[i]=words[i].substring(0, words[i].length()-1);
    	//System.out.println(weights[i] + words[i]);
    }
    
    
    BufferedReader br2 = new BufferedReader(new FileReader("statusUpdatesSudhanva.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br2.readLine();
        list.add(line);
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br2.readLine();
        }
        everything2 = sb.toString();
    } finally {
        br2.close();
    }
    
    //System.out.println(everything2);
    int count1=0;
     int count = 0;
    for (int i=0; i<words.length; i++)
    {
        words[i] = words[i].substring(0, words[i].length()-1);
        //System.out.println(words[i]);
        if(everything2.toLowerCase().contains(words[i].toLowerCase()))
        {
        	count1++; //System.out.println(words[i]);
        	count = count + weights[i];
        }
    }  
   
   
    //System.out.println(count);
    
    everything2 = everything2.replace("\n", "");
    String[] no = everything2.split(" ");
    int count2 = no.length;
    
    //System.out.println(count2);
    
    return count1;
   }
}
