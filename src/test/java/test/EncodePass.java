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
        //连接本地的 Redis 服务
        jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        setString();
        //delString();
    }
	
	/**
	 * 字符串保存
	 */
	public static void setString() {		
		jedis.set("save","redis");
		System.out.println("redis 存储的字符串为: "+jedis.get("save"));
	}
    
	/**
	 * 删除字符串
	 */
	public static void delString() {
		jedis.del("save");
		System.out.println("删除成功"+jedis.get("save"));
	}
	
	/**
	 * 修改字符串
	 */
	public static void updateString() {
	    
		System.out.println("删除成功"+jedis.get("save"));
	}
}
