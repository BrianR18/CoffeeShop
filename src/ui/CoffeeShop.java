package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class CoffeeShop {
	
	private static double[] ages;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String readed = reader.readLine();
		String data = new String();
		int cont = Integer.parseInt(readed);
		int line = 0;
		while(line < cont){
			line++;
			readed = reader.readLine();
			data += readed + "\n";
		}//End while
		String[] lines = data.split("\\\n");
		String output = new String();
		line = 0;
		while( line < cont){
			ages = convertInput(lines[line]);
			output += bubbleSort() + "\n";
			line++;
		}//End while
		writer.write(output);
		reader.close();
		writer.close();
	}//End main
	
	public static String bubbleSort(){
		double aux = 0;
		int swaps = 0;
		for(int i = ages.length -1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(ages[j] > ages[j+1]){
					aux = ages[j];
					ages[j] = ages[j+1];
					ages[j+1] = aux;
					swaps++;
				}//End if
			}//End for
		}//End for
		return getFormat(swaps,ages.length -1);
	}//End burbbleSort
	
	public static double[] convertInput(String input){
		String[] sdata = input.split(" ");
		double[] idata = new double[sdata.length];
		for(int i = 0; i < sdata.length; i++ ){
			try{
				idata[i] = Double.parseDouble(sdata[i]);
			}catch(IllegalArgumentException e){System.out.println("Alto error");}
		}//End for
		return idata;
	}
	public static String getFormat(int swaps, int pass){
		double av = swaps/(double)pass;
		av = (double)(int)(av*100)/100.0;
		String format =  av + "-";
		for(int i = 0; i < ages.length; i++){
			format += (i+1 <  ages.length)?ages[i]+" ":ages[i];
		}//End for
		return format;
	}//End getFormat
}//End coffeeShop
