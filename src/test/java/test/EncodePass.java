package test;

import org.apache.shiro.util.ByteSource;

import com.lk.play.common.service.SystemService;

import redis.clients.jedis.Jedis;

public class EncodePass {
/*	
	public static void main(String[] args) {
		String str = "fs345";
		ByteSource bytes = ByteSource.Util.bytes(str);
		System.out.println(bytes);
		String str2 = bytes.toString();//ZnMzNDU=       
		System.out.println(ByteSource.Util.bytes(str2));
	}
	   //MTIzNA==
	   //MTIzNDU=
	   //ZnMzNDU=
*/
	static Jedis jedis = null;
	public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        setString();
        //delString();
    }
	
	/**
	 * �ַ�������
	 */
	public static void setString() {		
		jedis.set("save","redis");
		System.out.println("redis �洢���ַ���Ϊ: "+jedis.get("save"));
	}
    
	/**
	 * ɾ���ַ���
	 */
	public static void delString() {
		jedis.del("save");
		System.out.println("ɾ���ɹ�"+jedis.get("save"));
	}
	
	/**
	 * �޸��ַ���
	 */
	public static void updateString() {
	    
		System.out.println("ɾ���ɹ�"+jedis.get("save"));
	}
}
