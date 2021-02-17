package com.example.demo.Util;

/**
 * @author includeno
 * @since 2021/2/15 11:07
 */
public class TimeCounterHelper {
    private Integer count=-1;
    private boolean hasStarted=false;
    private Long starttime;
    private Long endtime;

    public void start(){
        if(hasStarted==false&&count<0)
        {
            starttime= System.currentTimeMillis();
            System.out.println( "....................start....................");
            hasStarted=true;
            count=1;
        }

    }

    public double stop(){
        endtime= System.currentTimeMillis();

        if(hasStarted==true&&count>0)
        {
            double result=((endtime - starttime) / 1000.0);
            System.out.println( "....................end....................");
            hasStarted=false;
            count=-1;
            starttime=Long.valueOf("0");
            endtime=Long.valueOf("0");

            return result;
        }
        else {
            return 0;
        }
    }

    public String getResult(){
        if(hasStarted==false&&count<0&&(starttime<=endtime))
        {
            return String.valueOf((endtime - starttime) / 1000.0);
        }
        else {
            return "0";
        }
    }
}
