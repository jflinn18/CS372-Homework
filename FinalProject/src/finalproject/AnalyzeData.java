/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;

/**
 *
 * @author Joseph
 */
public class AnalyzeData {
    
    private String[][] todaysData;
    private File[] history;
    private String date;
    
    private String[][][] weeksData;
    private int[] lows;
    private int[] highs;
    private int[] today;
    
    /**
     * Constructor
     * @param data
     * @param date 
     */
    public AnalyzeData(String[][] data, String date)
    {
        this.date = date;
        //PT -- why arrays here, and not ArrayLists?
        history = new File[7];
        //PT -- all of this seems pretty rigid. Your user has to report every hour, and limited to two weeks.
        //  If you wanted to allow reporting on the half-hour, or every three hours, you'd have to change the code
        //  There are ways to make this much more flexible.
        // Also, I wonder if String for data is the right type. A Data class could be more flexible, and you'd be
        //  able to add more information on each report
        weeksData = new String[7][24][2];
        lows = new int[24];
        highs = new int[24];
        today = new int[24];
        todaysData = data;
        
        for (int i = 0; i < 24; i++)
        {
            highs[i] = 0;
            lows[i] = 0;
        }
        
        String[] days = getPastWeek();
        getPastSevenFiles();
        popWeekData();
        getWeeksHighsAndLows();
        analyzeDataAgainstWeek();
    }
    
    /**
     * Analyzes the selected data with the data from the past week
     */
    public void analyzeDataAgainstWeek()
    {
        for(int i = 0; i < todaysData.length; i++)
        {
            if (todaysData[i][1] != null)
            {
                if(Integer.parseInt(todaysData[i][1]) > 160 && highs[i] > 3)
                    today[i] = 1;
                else if (Integer.parseInt(todaysData[i][1]) < 70 && lows[i] > 3)
                    today[i] = -1;
            }
        }
    }
    
    /**
     * Gets where the data was above or below the set range 
     * [0 , 70) U (160, INFINITY)
     */
    public void getWeeksHighsAndLows()
    {
        for (int i = 0; i < weeksData.length; i++)
        {
            for (int j = 0; j < todaysData.length; j++)
            {
                if (weeksData[i][j][1] != null)
                {
                    if (Integer.parseInt(weeksData[i][j][1]) > 160 )
                    {
                        if (j == 0)
                        {
                            highs[j]++;
                            highs[23]++;
                            highs[j+1]++;
                        }
                        else if(j == 23)
                        {
                            highs[j]++;
                            highs[0]++;
                            highs[j-1]++;
                        }
                        else
                        {
                            highs[j]++;
                            highs[j+1]++;
                            highs[j-1]++;
                        }
                    }
                    else if (Integer.parseInt(weeksData[i][j][1]) < 70)
                    {
                        if (j == 0)
                        {
                            lows[j]++;
                            lows[23]++;
                            lows[j+1]++;
                        }
                        else if(j == 23)
                        {
                            lows[j]++;
                            lows[0]++;
                            lows[j-1]++;
                        }
                        else
                        {
                            lows[j]++;
                            lows[j+1]++;
                            lows[j-1]++;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Gets the data from the last week
     */
    public void popWeekData()
    {
        FileIO fio = new FileIO();
        
        for (int i = 0; i < 7; i++)
        {
            weeksData[i] = fio.inputFromFile(history[i]);
        }
    }
    
    /**
     * Gets the files from the last week
     */
    public void getPastSevenFiles()
    {
        String[] days = getPastWeek();
        
        for (int i = 0; i < history.length; i++)
        {
            //history[i] = new File("Resources/Data/" + days[i] + ".txt");
            // For "commercial" use
            //history[i] = new File("C:\\Program Files\\BGDataAnalysis\\Data\\" + days[i] + ".txt");
            history[i] = new File("C:\\BGDataAnalysis\\Data\\" + days[i] + ".txt");
        }
    }
    
    /**
     * Returns the last seven days from a given day
     * @return 
     */
    public String[] getPastWeek()
    {
        String[] days = new String[7];
        String[] today = date.split("-");
        int[] date = new int[3];
        
        for(int i = 0; i < 3; i++)
            date[i] = Integer.parseInt(today[i]);
        
        for(int i = 0; i < days.length; i++)
        {
            if((date[1] - 1) > 0)
                days[i] = date[0] + "-" + (date[1] - 1) + "-" + date[2];
            else if ((date[0] - 1) > 0)
                days[i] = (date[0] - 1) + "-" + date[1] + "-" + date[2];
            else
                days[i] = date[0] + "-" + date[1] + "-" + (date[2] - 1);
  
           
           today = days[i].split("-");
           
           for(int j = 0; j < 3; j++)
               date[j] = Integer.parseInt(today[j]);
        }
        
        return days;
    }

    /**
     * Returns today, in an array of integers
     * [month, day, year]
     * @return 
     */
    public int[] getToday() { return today; }

}
