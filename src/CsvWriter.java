

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class CsvWriter{

    public void printMicroprocessors(List<Microprocessor> mMicroprocessors){
        
        try {
            File file = new File("table.csv");
            PrintWriter pw= new PrintWriter(file);
            StringBuilder sb=new StringBuilder();
            
            
            

            for(int i = 0; i<mMicroprocessors.size(); i++){
                sb.append("\r\n");
                sb.append("\r\n");

                sb.append("Micro Id");
                sb.append(",");
                sb.append("" + mMicroprocessors.get(i).getId());
                sb.append("\r\n");
                sb.append("\r\n");

                sb.append("Process Id");
                sb.append(",");
                sb.append("TCC");
                sb.append(",");
                sb.append("TE");
                sb.append(",");
                sb.append("TVC");
                sb.append(",");
                sb.append("TB");
                sb.append(",");
                sb.append("TT");
                sb.append(",");
                sb.append("TI");
                sb.append(",");
                sb.append("TF");
                sb.append(",");
                sb.append("\r\n");
                
                for(int j = 0; j< mMicroprocessors.get(i).getProcesses().size(); j++){
                    
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getProcessId());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getChangeOfContextTime());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getExecutionTime());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getTVC());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getLockTime());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getTotalTime());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getInitialTime());
                    sb.append(",");
                    sb.append("" + mMicroprocessors.get(i).getProcesses().get(j).getFinalTime());
                    sb.append(",");
                    sb.append("\r\n");
                }


            }

            pw.write(sb.toString());
            pw.close();
            System.out.println("finished");

            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
        } catch (Exception e) {
      // TODO: handle exception
        }
    }   

}
    

        

