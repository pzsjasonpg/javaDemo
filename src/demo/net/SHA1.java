package demo.net;

import java.security.MessageDigest;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 说明：<br/>
 *  
 *  SHA1
 *
 * <p>
 *
 * 区分　责任人　日期　　　　<br/>
 * 创建　周柏成　  　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
public  class SHA1 {
    private static final char[] HEX = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式  
        for (int j = 0; j < len; j++) {
            buf.append(HEX[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
    	//0aeb4570-325a-4b62-9bd5-0c2a086d3bab-
		String password = "0aeb4570-325a-4b62-9bd5-0c2a086d3bab-201501607";
		String passwd = "0aeb4570-325a-4b62-9bd5-0c2a086d3bab-";
		String sha1 = DigestUtils.sha1Hex(passwd);
		System.out.println(sha1);
	}
}  