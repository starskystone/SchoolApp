package xaut.schoolapp.com.controller;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Map;

/**
 * Created by xiaoleilei on 2017/4/27.
 */

public class  RequestWebServece {

    public static String submitdata(String u,Map<String,String> params) throws JSONException {
        HttpURLConnection conn;
        String param = getRequestData(params).toString();
        JSONObject jsonObject = new JSONObject(param);
        byte [] datas =jsonObject.toString().getBytes();
        try{
            URL url = new URL(u);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(datas.length));
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");

            OutputStream out = conn.getOutputStream();
            out.write(datas);
           /* DataOutputStream out  = new DataOutputStream(conn.getOutputStream());
            out.write(param,0,param.length);*/

            int response = conn.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream in = conn.getInputStream();

                byte[] data = readInputStream(in);
                String res = new String(data);
                return res;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String submitInfo(String u,String params) throws JSONException {
        HttpURLConnection conn;
        String param = getRequestInfo(params).toString();
        JSONObject jsonObject = new JSONObject(param);
        byte [] datas = jsonObject.toString().getBytes();
        try{
            URL url = new URL(u);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(datas.length));
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");

            OutputStream out = conn.getOutputStream();
            out.write(datas);
           /* DataOutputStream out  = new DataOutputStream(conn.getOutputStream());
            out.write(param,0,param.length);*/

            int response = conn.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream in = conn.getInputStream();

                byte[] data = readInputStream(in);
                String res = new String(data);
                return res;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String submitSchoolName(String u,String params) throws JSONException {
        HttpURLConnection conn;
        String param = getRequestSchoolName(params).toString();
        JSONObject jsonObject = new JSONObject(param);
        byte [] datas = jsonObject.toString().getBytes();
        try{
            URL url = new URL(u);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(datas.length));
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");

            OutputStream out = conn.getOutputStream();
            out.write(datas);
           /* DataOutputStream out  = new DataOutputStream(conn.getOutputStream());
            out.write(param,0,param.length);*/

            int response = conn.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream in = conn.getInputStream();

                byte[] data = readInputStream(in);
                String res = new String(data);
                return res;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String submitSchoolDetailByNo(String u,String params) throws JSONException {
        HttpURLConnection conn;
        String param = GetSchoolDetailByNo(params).toString();
        JSONObject jsonObject = new JSONObject(param);
        byte [] datas = jsonObject.toString().getBytes();
        try{
            URL url = new URL(u);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(datas.length));
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Charset", "UTF-8");

            OutputStream out = conn.getOutputStream();
            out.write(datas);
           /* DataOutputStream out  = new DataOutputStream(conn.getOutputStream());
            out.write(param,0,param.length);*/

            int response = conn.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream in = conn.getInputStream();

                byte[] data = readInputStream(in);
                String res = new String(data);
                return res;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

   public static StringBuffer getRequestData(Map<String,String> params){
       StringBuffer stringBuffer = new StringBuffer();

       try{stringBuffer.append("{");
           for (Map.Entry<String,String> entry:params.entrySet()){
           stringBuffer.append(entry.getKey())
                   .append(":")
                   .append(entry.getValue())
                   .append(",");
           }
           stringBuffer.deleteCharAt(stringBuffer.length() - 1);
           stringBuffer.append("}");
       }catch (Exception e){
           Log.e("TAG",e.getMessage());
           e.printStackTrace();
       }
       return stringBuffer;
   }

    public static StringBuffer getRequestInfo(String params){
        StringBuffer stringBuffer = new StringBuffer();

        try{stringBuffer.append("{");
            stringBuffer.append("organizationName");
            stringBuffer.append(":");
            stringBuffer.append(params);
            stringBuffer.append("}");
        }catch (Exception e){
            Log.e("TAG",e.getMessage());
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static StringBuffer getRequestSchoolName(String params){
        StringBuffer stringBuffer = new StringBuffer();

        try{stringBuffer.append("{");
            stringBuffer.append("schoolName");
            stringBuffer.append(":");
            stringBuffer.append(params);
            stringBuffer.append("}");
        }catch (Exception e){
            Log.e("TAG",e.getMessage());
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static StringBuffer GetSchoolDetailByNo(String params){
        StringBuffer stringBuffer = new StringBuffer();

        try{stringBuffer.append("{");
            stringBuffer.append("sOrganizationNo");
            stringBuffer.append(":");
            stringBuffer.append(params);
            stringBuffer.append("}");
        }catch (Exception e){
            Log.e("TAG",e.getMessage());
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static byte[] readInputStream(InputStream in) throws Exception{
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
        byte[] data = new byte[40960];
        int ch = -1;
        while ((ch = in.read(data)) != -1){
            outputstream.write(data,0,ch);
        }
        outputstream.close();
        in.close();
        return outputstream.toByteArray();
    }
}
