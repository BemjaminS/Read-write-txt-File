import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;

public class Rep {
    public static void main(String[] args) throws IOException {
        
        FileReader studentFile = new FileReader("CS.txt");
        FileReader gradeFile = new FileReader("Hedva.txt");


      
        nameIden(studentFile , gradeFile);

    }

    public static void nameIden(FileReader stud , FileReader grade ) throws IOException {

        FileWriter fw = new FileWriter("Report.txt");
        PrintWriter pw = new PrintWriter(fw);
        BufferedReader bf1 = new BufferedReader(stud);
        BufferedReader bf2 = new BufferedReader(grade);

        String studentLine = bf1.readLine();
        String gradeLine = bf2.readLine();

        while (studentLine !=null && gradeLine !=null) {
            String [] splitSdutent = studentLine.split(" ");
            String [] splitGrade = gradeLine.split(" ");

            if (splitSdutent[2].equals(splitGrade[0])) {
                
                pw.print(splitSdutent[2]+" ");
                pw.print(splitSdutent[0]+ " ");
                pw.print(splitSdutent[1]+ " ");
                pw.println(((Integer.parseInt(splitGrade[1]))+(Integer.parseInt(splitGrade[2])))/2);//convert fron string to int and avg them
                studentLine = bf1.readLine();//read next student line
                gradeLine = bf2.readLine();//read the next grade line
            }
            else{
                
                gradeLine = bf2.readLine();
                
            }

        }
        bf1.close();
        bf2.close();
        stud.close();
        grade.close();
        pw.close();
        fw.close();
    
    }
}
