package com.fortune.tools.utils.collection;

import java.util.Collection;
import java.util.Map;

/**
 * 参考 spring CollectionUtils里面对集合判断写法，
 * 使其 引用的统一规范
 * @author linkepeng
 * @date 2018年12月8日
 */
public class CollectionUtils {
	
	/**
	 * Return {@code true} if the supplied Collection is {@code null} or empty.
	 * Otherwise, return {@code false}.
	 * @param collection the Collection to check
	 * @return whether the given Collection is empty
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * Return {@code true} if the supplied Map is {@code null} or empty.
	 * Otherwise, return {@code false}.
	 * @param map the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

}
