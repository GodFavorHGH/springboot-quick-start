package com.dip.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.dip.service.SystemCachedDataService;

/**
 * 应用启动时加载相关数据到redis缓存
 * @author hegh
 *
 */
@Component
@SuppressWarnings({"rawtypes", "unchecked"})
public class CachedDataStartUpRunner implements CommandLineRunner{

	@Autowired
	private SystemCachedDataService systemCachedDataService;
	
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Map> products = (List<Map>) systemCachedDataService.loadProducts();
		set("products", products);
	}
	
	public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
