package demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.jna.ptr.IntByReference;

public class InetAddressDemo {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		
		System.out.println(localHost.getHostName());
		System.out.println(localHost.getHostAddress());
		
		String hostAddress = localHost.getHostAddress();
		int[] ipAddr = getFieldByIP(hostAddress);
		
		//设置子网掩码
		String netmask = "255.255.0.0";
		int[] maskArr = getFieldByIP(netmask);
	
		long andResultIP = andResult(ipAddr);
		long andResultMask = andResult(maskArr);
		
		long result = maskAndIP(andResultIP, andResultMask);
		System.out.println(result);
		
		
		boolean connect = isConnect(hostAddress);
		if (connect) {
			System.out.println(hostAddress+":"+"连通");
		}else {
			System.out.println(hostAddress+":"+"不通");
		}
		
		
		/*StringBuilder sBuilder = new StringBuilder("169.254.55.");
		for(int i = 0; i < 256; i++) {
			sBuilder.append(i+"");
			
			String string = sBuilder.toString();
			boolean connect = isConnect(string);
			if (connect) {
				System.out.println(string+":"+"连通");
			}else {
				System.out.println(string+":"+"不通");
			}
			sBuilder.delete(11, sBuilder.length());
		}*/
		
	}
	
	public static int[] getFieldByIP(String hostAddress) {
		int[] arr = new int[4];
		String[] split = hostAddress.split("\\.");
		for(int i = 0; i < 4; i ++) {
			int parseInt = Integer.parseInt(split[i]);
			arr[i] = parseInt;
		}
		return arr;
		
	}
	
	public static long andResult(int[] arr) {
		long first = (long)arr[0] << 24;
		long second = (long)arr[1] << 16;
		long third = (long)arr[2] << 8;
		long num = first | second | third | arr[3];
		return num;
		
	}
	
	public static long maskAndIP(long ip, long mask) {
		return ip & mask;
	}
	
	//测试网络通
	public static boolean isConnect(String site){    
        boolean connect = false;    
        Runtime runtime = Runtime.getRuntime();    
        Process process;    
        try {    
            process = runtime.exec("ping" + " " + site);    
            InputStream is = process.getInputStream();     
            InputStreamReader isr = new InputStreamReader(is);     
            BufferedReader br = new BufferedReader(isr);     
            String line = null;     
            StringBuffer sb = new StringBuffer();     
            while ((line = br.readLine()) != null) {     
                sb.append(line);     
            }     
            System.out.println("返回值为:"+sb);      
           is.close();     
            isr.close();     
           br.close();     
     
           if (null != sb && !sb.toString().equals("")) {     
                String logString = ""; 
                if (sb.toString().indexOf("TTL") > 0) {     
                    // 网络畅通      
                    connect = true;    
                } else {     
                    // 网络不畅通      
                    connect = false;    
                }     
            }     
        } catch (IOException e) {    
           e.printStackTrace();    
        }     
        return connect;    
    }    
		      
		    

}
