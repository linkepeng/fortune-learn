package com.fortune.tools.utils.collection;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class CollectionUtilsTest {

	@Test
	void testIsEmptyCollectionOfQ() {
		List<String> list = new ArrayList<>();
		Assert.assertTrue(CollectionUtils.isEmpty(list));
		list.add("Hello");
		Assert.assertFalse(CollectionUtils.isEmpty(list));
		List<String> list2 = null;
		Assert.assertTrue(CollectionUtils.isEmpty(list2));
	}

	@Test
	void testIsEmptyMapOfQQ() {
		Map<String,String> map1 = new HashMap<>(16);
		Assert.assertTrue(CollectionUtils.isEmpty(map1));
		map1.put("Hello","ssss");
		Assert.assertFalse(CollectionUtils.isEmpty(map1));
		Map<String,String> map2 = null;
		Assert.assertTrue(CollectionUtils.isEmpty(map2));
	}

}
