package com.andawell.common.init;

import com.andawell.common.cache.EnumCacheMap;
import com.andawell.common.entity.EnumData;
import com.andawell.common.entity.EnumItem;
import com.andawell.common.entity.annotation.Enum;
import com.andawell.common.entity.template.EnumTemplate;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class EnumCacheInit {
    private final static Logger logger = LoggerFactory.getLogger(EnumCacheInit.class);

    @PostConstruct
    public void init() {
        logger.debug(EnumCacheInit.class.getName());
        Reflections reflections = new Reflections("com.andawell", new TypeAnnotationsScanner(), new SubTypesScanner());
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Enum.class);
        for (Class<?> enumClass : classSet) {
            if (!enumClass.isEnum()) {
                logger.error("枚举值初始化失败：类错误[" + enumClass.getName() + "]");
                System.exit(0);
            }
            if (!EnumTemplate.class.isAssignableFrom(enumClass)) {
                logger.error("枚举值初始化失败：类实现错误[" + enumClass.getName() + "]");
                System.exit(0);
            }
            Enum annotation = enumClass.getAnnotation(Enum.class);
            if (annotation == null) {
                logger.error("枚举值初始化失败：未找到[" + enumClass.getName() + "]");
                System.exit(0);
            }
            String key = annotation.value();
            if (StringUtils.isBlank(key)) {
                logger.error("枚举值初始化失败：key值错误[" + enumClass.getName() + "]");
                System.exit(0);
            }
            if (EnumCacheMap.containsKey(key)) {
                logger.error("枚举值初始化失败：key值重复[" + key + "]-[" + enumClass.getName() + "]");
                System.exit(0);
            }
            try {
                Map<String, String> map = new HashMap<>();
                List<EnumItem> list = new ArrayList<>();
                Object[] objects = enumClass.getEnumConstants();
                Method getName = enumClass.getMethod("name");
                Method getDisplayName = enumClass.getMethod("getName");
                for (Object obj : objects) {
                    String name = getName.invoke(obj).toString();
                    String displayName = getDisplayName.invoke(obj).toString();
                    map.put(name, displayName);
                    list.add(new EnumItem(name, displayName));
                }
                logger.debug("枚举值初始化，加载[" + key + ":" + new EnumData(map, list) + "]");
                EnumCacheMap.put(key, new EnumData(map, list));
            } catch (Exception e) {
                logger.error("枚举值初始化失败：异常[" + key + "]-[" + enumClass.getName() + "]", e.fillInStackTrace());
                System.exit(0);
            }

        }
    }
}