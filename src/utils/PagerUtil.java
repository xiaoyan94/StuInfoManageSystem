package utils;

import java.util.Map;

public class PagerUtil {
	
	/**
	 * 将分页信息放入dataMap中
	 * @param dataMap
	 * @param pager
	 * @param dataKey dataMap中存放查询数据部分的key
	 * @param dataValue dataMap中存放的查询数据
	 */
	public static <T> void setPagerToDataMap(Map<String, Object> dataMap,Pager<T> pager,String dataKey,Object dataValue) {
		dataMap.put("currentPage", pager.getCurrentPage());
		dataMap.put("totalPage", pager.getTotalPage());
		dataMap.put("totalCount", pager.getTotalCount());
		dataMap.put("pageSize", pager.getPageSize());
		dataMap.put(dataKey, dataValue);
	}
}
