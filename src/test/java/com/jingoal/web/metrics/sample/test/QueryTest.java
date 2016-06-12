package com.jingoal.web.metrics.sample.test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;

public class QueryTest {

	private static String[] shareUids;
	private static String[] wordArr;
	private static int wordsLength;

	public static void main(String[] args) {

		wordArr = words.split("\n");
		wordsLength = wordArr.length;
		shareUids = new String[10000];
		for (int i = 0; i < 10000; i++) {
			int shareIDNum;
			if (i % 10 == 0) {
				shareIDNum = 1 + r.nextInt(99);
			} else {
				shareIDNum = 1 + r.nextInt(10);
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < shareIDNum; j++) {
				if (j > 0) {
					sb.append(" OR ");
				}
				sb.append("shareUids:");
				sb.append(r.nextInt(500));
			}
			shareUids[i] = sb.toString();
		}
		startReporter(1, TimeUnit.MINUTES);
		int threadNumber = Integer.valueOf(args[0]);
		System.out.println(threadNumber);
		for (int i = 0; i < threadNumber; i++) {
			new Thread(new QueryTask()).start();
		}
	}

	public static final void startReporter(long timerPeriod, TimeUnit unit) {
		slf4jReporter = Slf4jReporter.forRegistry(metrics).outputTo(logger).convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS).build();
		slf4jReporter.start(timerPeriod, unit);
	}

	private static Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger("/chenbin/metrics");
	private static Slf4jReporter slf4jReporter = null;
	private static final MetricRegistry metrics = new MetricRegistry();
	private static final Timer timer = metrics.timer("jin-join");

	static class QueryTask implements Runnable {

		public void run() {

			long count = 0;

			for (int i = 1; i <= 2000; i++) {
				Timer.Context c = timer.time();
				String cid = String.valueOf(1 + new Random().nextInt(1000));

				c.stop();
			}
			System.out.println("10000 times query hit count:" + count);

		}

	}

	private static String words = "的\n" + "是\n" + "在\n" + "一\n" + "不\n" + "有\n" + "这\n" + "个\n" + "上\n" + "也\n" + "他\n"
			+ "人\n" + "就\n" + "对\n" + "说\n" + "我\n" + "要\n" + "到\n" + "大\n" + "我们\n" + "多\n" + "把\n" + "来\n" + "等\n"
			+ "年\n" + "两\n" + "从\n" + "而\n" + "能\n" + "又\n" + "他们\n" + "以\n" + "时\n" + "没有\n" + "会\n" + "之\n" + "但\n"
			+ "三\n" + "被\n" + "很\n" + "下\n" + "自己\n" + "后\n" + "中国\n" + "并\n" + "使\n" + "向\n" + "已\n" + "出\n" + "用\n"
			+ "新\n" + "所\n" + "里\n" + "给\n" + "她\n" + "更\n" + "次\n" + "最\n" + "于\n" + "可以\n" + "可\n" + "去\n" + "由\n"
			+ "问题\n" + "小\n" + "工作\n" + "让\n" + "其\n" + "你\n" + "这个\n" + "生活\n" + "起\n" + "这样\n" + "天\n" + "它\n" + "高\n"
			+ "做\n" + "家\n" + "已经\n" + "再\n" + "或\n" + "才\n" + "前\n" + "走\n" + "这些\n" + "一些\n" + "却\n" + "二\n" + "条\n"
			+ "位\n" + "起来\n" + "各\n" + "成\n" + "什么\n" + "元\n" + "现在\n" + "社会\n" + "比\n" + "同\n" + "四\n" + "关系\n" + "名\n"
			+ "想\n" + "如\n" + "第一\n" + "因为\n" + "该\n" + "开始\n" + "许多\n" + "内\n" + "时间\n" + "人们\n" + "今天\n" + "国家\n"
			+ "本\n" + "点\n" + "思想\n" + "至\n" + "此\n" + "一定\n" + "如果\n" + "副\n" + "无\n" + "张\n" + "同时\n" + "需要\n" + "月\n"
			+ "则\n" + "重要\n" + "为了\n" + "日\n" + "老\n" + "就是\n" + "作\n" + "五\n" + "人民\n" + "事\n" + "认为\n" + "成为\n"
			+ "像\n" + "北京\n" + "历史\n" + "水\n" + "方面\n" + "情况\n" + "而且\n" + "党\n" + "学生\n" + "每\n" + "这里\n" + "但是\n"
			+ "孩子\n" + "可能\n" + "发生\n" + "必须\n" + "只有\n" + "外\n" + "要求\n" + "全\n" + "发现\n" + "进行\n" + "特别\n" + "因\n"
			+ "岁\n" + "得到\n" + "件\n" + "文化\n" + "分\n" + "便\n" + "同志\n" + "发展\n" + "即\n" + "日本\n" + "总\n" + "因此\n"
			+ "对于\n" + "领导\n" + "带\n" + "既\n" + "时候\n" + "钱\n" + "自\n" + "政府\n" + "吃\n" + "非\n" + "决定\n" + "进\n"
			+ "还是\n" + "受\n" + "国\n" + "应该\n" + "近\n" + "美\n" + "政治\n" + "话\n" + "公司\n" + "干部\n" + "出现\n" + "开\n"
			+ "一切\n" + "研究\n" + "认识\n" + "写\n" + "十分\n" + "十\n" + "站\n" + "之间\n" + "问\n" + "希望\n" + "快\n" + "虽然\n"
			+ "相\n" + "美国\n" + "知道\n" + "讲\n" + "大家\n" + "学校\n" + "组织\n" + "见\n" + "由于\n" + "正在\n" + "法\n" + "表示\n"
			+ "一样\n" + "活动\n" + "如何\n" + "教育\n" + "书\n" + "据\n" + "城市\n" + "道\n" + "艺术\n" + "经济\n" + "以及\n" + "部\n"
			+ "影响\n" + "太\n" + "其中\n" + "学\n" + "先生\n" + "完全\n" + "连\n" + "主要\n" + "继续\n" + "头\n" + "革命\n" + "之后\n"
			+ "参加\n" + "能够\n" + "住\n" + "上海\n" + "经过\n" + "非常\n" + "低\n" + "甚至\n" + "听\n" + "先\n" + "一直\n" + "学习\n"
			+ "仍\n" + "办\n" + "所以\n" + "代表\n" + "变\n" + "最后\n" + "一起\n" + "万\n" + "所有\n" + "那么\n" + "心\n" + "越\n"
			+ "较\n" + "办法\n" + "路\n" + "有些\n" + "未\n" + "通过\n" + "找\n" + "按\n" + "拿\n" + "解决\n" + "一般\n" + "另\n" + "经\n"
			+ "半\n" + "强\n" + "或者\n" + "时代\n" + "手\n" + "作品\n" + "不断\n" + "以后\n" + "关于\n" + "青年\n" + "各种\n" + "真\n"
			+ "其他\n" + "农民\n" + "那些\n" + "余\n" + "段\n" + "有的\n" + "买\n" + "根本\n" + "县\n" + "作者\n" + "者\n" + "请\n"
			+ "叫\n" + "感到\n" + "怎么\n" + "任何\n" + "六\n" + "表现\n" + "反\n" + "存在\n" + "然而\n" + "准备\n" + "送\n" + "约\n"
			+ "比较\n" + "书记\n" + "爱\n" + "单位\n" + "群众\n" + "应当\n" + "王\n" + "早\n" + "女\n" + "门\n" + "个人\n" + "座\n"
			+ "全国\n" + "意义\n" + "花\n" + "条件\n" + "环境\n" + "了解\n" + "搞\n" + "力量\n" + "不仅\n" + "目前\n" + "经验\n" + "产生\n"
			+ "真正\n" + "回\n" + "队\n" + "有关\n" + "字\n" + "会议\n" + "生命\n" + "今年\n" + "努力\n" + "靠\n" + "八\n" + "市\n"
			+ "类\n" + "共\n" + "意见\n" + "死\n" + "民族\n" + "块\n" + "只要\n" + "文学\n" + "成功\n" + "变化\n" + "句\n" + "管\n"
			+ "你们\n" + "指\n" + "地区\n" + "方\n" + "和\n" + "项\n" + "注意\n" + "当然\n" + "达\n" + "面\n" + "坐\n" + "家庭\n"
			+ "原因\n" + "进入\n" + "病\n" + "介绍\n" + "下来\n" + "事情\n" + "方式\n" + "首\n" + "计划\n" + "人类\n" + "报告\n" + "世纪\n"
			+ "方法\n" + "入\n" + "信\n" + "化\n" + "步\n" + "生\n" + "声\n" + "图\n" + "电话\n" + "能力\n" + "片\n" + "作用\n" + "台\n"
			+ "如此";

	// QueryBuilder qb = rangeQuery("createdAt").from(0)
	// // .to(1449718184000L);
	// .to(1449718204000L);
	//
	// SearchResponse scrollResp =
	// CLIENT.prepareSearch("im").setTypes("message").setSearchType(SearchType.SCAN)
	// .setScroll(new
	// TimeValue(60000)).setQuery(qb).setSize(2000).execute().actionGet();
	// // 500
	// // hits
	// // per
	// // shard
	// // will
	// // be
	// // returned
	// // for
	// // each
	// // scroll
	//
	// List<String> ids = new LinkedList<String>();
	// long start = System.currentTimeMillis();
	// // Scroll until no hits are returned
	// while (true) {
	//
	// for (SearchHit hit : scrollResp.getHits().getHits()) {
	// ids.add(hit.getId());
	// }
	// scrollResp =
	// CLIENT.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new
	// TimeValue(600000)).execute()
	// .actionGet();
	// // Break condition: No hits are returned
	// if (scrollResp.getHits().getHits().length == 0) {
	// break;
	// }
	// }
	// System.out.println(System.currentTimeMillis() - start);
}
