package com.lteam.job.common.routing;
/**
 * @Description:路右策略枚举
 * @author guicheng.huang
 * @date: 2017年4月19日 上午10:34:57
 * @version V0.0.1
 */
public enum RoutingStrategy {

	FIRST , LAST ,  //第一个,最后一个 仅适用于分片串行和未分片情形
	LONGESTUNUSED , //最久未使用,片串行or未分片选用最久未使用的一个执行,分片并行则按照倒序的方式依次选择
	LOWESTFREQUENCY ,//使用频率最低,分片串行or未分片选用频率最低的一个执行,分片并行则按照倒序的方式依次选择
	FAILOVER , //故障转移,分片串行or未分片随机选择一台来执行，如果发生故障则把当前分片转移到另一台，下一片等待，如果是分片并行，则看有无空闲机器，如果有直接转到该机器，如果没有则等待。
	POLLING , //随机选择一台
	HIGHESTCREDIT //服务器信誉度最高
}
