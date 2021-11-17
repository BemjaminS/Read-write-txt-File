import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

/**
 * main
 */
public class Grades {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

		nameId();
	}

	public static void nameId() throws IOException {

		FileWriter fw = new FileWriter("report.txt");// open a stream to enable writing characters to a file 
		PrintWriter pw = new PrintWriter(fw);//enable writing different types (numbers, object)
		FileReader studentFile = new FileReader ("Hedva.txt");// opens a file to read characters from nameOfFileStudent file
		FileReader gradeFile = new FileReader ("CS.txt");// opens a file to read characters from nameOfFileGrade file
		BufferedReader gradeB = new BufferedReader(gradeFile);// enables efficient reading, by lines using a buffer 
		BufferedReader studendB = new BufferedReader(studentFile);//" "
		
		String gradeLine = gradeB.readLine();//The readLine() method of Console class in Java is used to read a single line of text from the console.
		String studendLine = studendB.readLine();//" "
		
		while(gradeLine != null && studendLine!=null ){// loop while to know when the lines finish{
			String [] arrOfStudent= studendLine.split(" ");// array of Strings for the first file and split the words in the sentence, the split will be whit space 
			String [] arrOfGrade= gradeLine.split(" ");// array of Strings for the second file
			if (arrOfStudent[2].equals(arrOfGrade[0])){ // check if the Id is the same by using the equals func
			
				pw.print(arrOfStudent[2]+" ");// if its equals so we print the if first
				pw.print(arrOfStudent[0]+" ");// next we print name
				pw.print(arrOfStudent[1]+" ");// print the last name 
				pw.println(((Integer.parseInt(arrOfGrade[1])+Integer.parseInt(arrOfGrade[2])))/2);// checking the average of the scores and print
				gradeLine = gradeB.readLine();// read all the next line 
				studendLine = studendB.readLine();// read all the next line 
			}
			else {
				if((Integer.parseInt(arrOfStudent[2]))>(Integer.parseInt(arrOfGrade[0])))// because the details in the file are sort we can arrange it by check the value of of the Id
				{
					gradeLine = gradeB.readLine();//read all the next line 
				}
				else
				{
					studendLine = studendB.readLine();// " " 	
				}
			}
		}
		
		studendB.close(); //close the buffer of the student
		gradeB.close(); // close the buffer of the grade
		studentFile.close(); // close the FileReader
		gradeFile.close(); // close the gradeFile
		pw.close(); // close the FileWriter
		fw.close();// close the PrintWriter 
		
	}
        

}

