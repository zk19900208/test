/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcoapp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author luolai
 */
public class LogInfo {

    public static void main(String[] args) {
        String newLog = " Date:" + new Date() + "  |";
        appendLog(newLog);
    }
    
    public static String getCurrentDate() {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sm.format(new Date());
    }

    public static String strRight(String value) {
        return value.substring(value.length() - 2, value.length());
    }

    public static void appendLog(String newLog) {
        Scanner sc = null;
        PrintWriter pw = null;
        Calendar c = new GregorianCalendar();
        File log = new File("log\\loginfo" + String.valueOf(c.get(c.YEAR))
                + strRight("00" + String.valueOf(c.get(c.MONTH)+1)) + strRight("00" + String.valueOf(c.get(c.DAY_OF_MONTH))) + ".log");
        try {
            if (!log.exists())//����ļ�������,���½�.
            {
                File parentDir = new File(log.getParent());
                if (!parentDir.exists())//�������Ŀ¼������,���½�.
                {
                    parentDir.mkdirs();
                }
                log.createNewFile();
            }
            sc = new Scanner(log);
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine())//�ȶ������ļ�����,���ݴ�sb��;
            {
                sb.append(sc.nextLine());
                sb.append("\r\n");//���з���Ϊ���,ɨ������������,���Ҫ�Լ����.
            }
            sc.close();

            pw = new PrintWriter(new FileWriter(log), true);
            /*
             * A.
             */
            pw.println(sb.toString());//,д����ļ�����.
   /*
             * B.
             */
            pw.println(newLog + "  [" + getCurrentDate() + "]");//д������־.
   /*
             * �����д��A,�����־���ļ����. ������д��B,�����־���ļ���ǰ.
             */
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void appendLog(String logFileName,String newLog) {
        Scanner sc = null;
        PrintWriter pw = null;
        Calendar c = new GregorianCalendar();
        File log = new File("log\\"+logFileName + String.valueOf(c.get(c.YEAR))
                + strRight("00" + String.valueOf(c.get(c.MONTH)+1)) + strRight("00" + String.valueOf(c.get(c.DAY_OF_MONTH))) + ".log");
        try {
            if (!log.exists())//����ļ�������,���½�.
            {
                File parentDir = new File(log.getParent());
                if (!parentDir.exists())//�������Ŀ¼������,���½�.
                {
                    parentDir.mkdirs();
                }
                log.createNewFile();
            }
            sc = new Scanner(log);
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine())//�ȶ������ļ�����,���ݴ�sb��;
            {
                sb.append(sc.nextLine());
                sb.append("\r\n");//���з���Ϊ���,ɨ������������,���Ҫ�Լ����.
            }
            sc.close();

            pw = new PrintWriter(new FileWriter(log), true);
            /*
             * A.
             */
            pw.println(sb.toString());//,д����ļ�����.
   /*
             * B.
             */
            pw.println(newLog + "  [" + getCurrentDate() + "]");//д������־.
   /*
             * �����д��A,�����־���ļ����. ������д��B,�����־���ļ���ǰ.
             */
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
