package com.lk.play.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
/**
 * redis������
 * @author Administrator
 *
 */
@Component
public class JedisUtil {
	
	@Autowired
	private RedisTemplate redisTemplate;
	private static ValueOperations opsForValue;
	
	/**
	 * �洢String���͵�key-valueֵ
	 * @param key
	 * @param value
	 */
    public void jedisStringSet(String key, String value) {
    	 opsForValue = redisTemplate.opsForValue();
    	 opsForValue.set(key, value);
    }
    
    /**
     * �洢Object���͵�key-valueֵ
     * @param key
     * @param item
     * @param value
     */
    public void jedisObjectPut(String key, String item, Object value) {
    	redisTemplate.opsForHash().put(key, item, JSON.toJSONString(value));
    }
    
    /**
     * �洢list���͵�ֵ��redis
     * @param key
     * @param index
     * @param value
     */
    public void jedisListPush(String key,List objList) {
    	for(Object obj:objList) {
    		redisTemplate.opsForList().rightPush(key, JSON.toJSONString(obj));
    	}  
    	/*redisTemplate.opsForList().rightPushAll(key, JSON.toJSONString(objList));*/
    }
    
    /**
     * ��ȡString����valueֵ
     * @param key
     * @return
     */
    public String jedisStringGet(String key) {
    	return  (String) redisTemplate.opsForValue().get(key);
    }
    
    /**
     * ��ȡobject���͵�valueֵ
     * @param key
     * @param item
     * @param clazz
     * @return
     */
    public Object jedisObjectGet(String key, String item, Class clazz) {
    	Object object = redisTemplate.opsForHash().get(key, item);     	
    	return JSON.parseObject((String) object, clazz);
    }
    
    /**
     * ��ȡ����
     * @param key
     * @param clazz
     * @return
     */
    public List jedisObjectPop(String key, Class clazz) {
    	/*Object obj = redisTemplate.opsForList().rightPop(key);
    	return JSON.parseObject((String)obj, clazz);*/       
    	List newList = new ArrayList();
    	List objList = redisTemplate.opsForList().range(key, 0, -1);
    	for(Object obj:objList) {
    		Object parseObject = JSON.parseObject((String)obj, clazz);
    		newList.add(parseObject);    		
    	}
    	return newList;
    }
    
    public void jedisUpdate() {
    	
    }
    
    public void jedisRemove() {
    	
    }
    
    
}
