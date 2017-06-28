package com.jiang.seven.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class ExportByThread {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*Mongo mg = null;
		String address = "101.201.197.251";
		try {
			mg = new MongoClient(address, 27017);
			// mg = new Mongo("localhost", 27017);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DB db = mg.getDB("logsdb");*/
		/*MongoClient mongoClient = new MongoClient("101.201.197.251", 27017);
		DB db =   mongoClient.getDB("logsdb");*/
		/*System.out.println(db.getReadConcern()+"======"+
				db.getCollectionNames().size()+"====="+db.collectionExists("consultSessionStatusVo"));*/
//		db.addUser("accountAdmin01", "accountAdmin01".toCharArray());
		DB db = null ;
		try {
		        ServerAddress sa = new ServerAddress("101.200.194.68", 27017);
		        /*ServerAddress sa1 = new ServerAddress("101.200.194.68", 27017);
		        ServerAddress sa2 = new ServerAddress("101.200.180.132", 27017);*/
		        List<ServerAddress> sends = new ArrayList<ServerAddress>();
		        sends.add(sa);
		       /* sends.add(sa1);
		        sends.add(sa2);*/
		        List<MongoCredential> mongoCredentialList = new ArrayList<MongoCredential>();
		        mongoCredentialList.add(MongoCredential.createMongoCRCredential("accountAdmin01", "logsdb","accountAdmin01".toCharArray()));
		        db = new MongoClient(sends,mongoCredentialList).getDB("logsdb");
		} catch (Exception e) {
		        throw new RuntimeException("连接MongoDB数据库错误", e);
		}
		DBCollection cssv = db.getCollection("consultSessionStatusVo");
		//cssv.getCount();
		DBCursor cur = cssv.find();
		System.out.println(cur.count());
//		System.out.println(cssv.getCount());
		Scanner scanner = new Scanner(System.in);
		/**
		 * 所有医生名字
		 */
		String name = "师长丽,李军,马月英,测试,徐丽,何淑荣,李永康,姜艳芝,王君庆,董浩强,王波,皮科威胜,王渟,李瑞霞,孙卫民,王丽进,杨爱玲,李娟,万勇峰,戴聪玉,曹金侠,张晓荣,张同强,温都日勒,梁海英,马蕊,呼吸科果,班志梅,陈涛,儿内科闫,许蓓,张霞,王春岩,张雅清,管志伟,刘丽云,孙利方,宋玉山,王利,周耀,丰青龙,钟柳明,王亚昆,付锐,李瑞可,李军,石军祥,赵金豹,赵春霞,赵锋,营养YOYO,梁生,高莉军,付楠,朱芳,刘丽华,李悦芝,绳丽娟,张勤,王翠玲,苗秀芳,田慧娟,燕丽,回娟,值班医生,汤伟令,杨艳辉,郑丽娟,熊为先,王凤杰,石莉,白长月,王培,苗清湛,付俊生,高西波,王秋枫,张翠菊,郭飞,孙溪,林发振,李明彦,张晓娜,张安,郭海生,王荣,安晓丽,夏振,李小成,文娟,赵琴,田致洲,于莹,消化科孙露,李露,消化科张武杰,杨丽萍,张子燕,杨德光,薛祖洋,张燕敏,王伟,杨露露,呼吸科张亚,呼吸科谢,屈彦超,周鹏,钟柳明,王淑梅,关蕾,谢红霞,杨国强,刘云霄,江川,张利华,李慧玲,于维恒,陈佳科,刘华明,冯琴,孟凡萍,李艳梅,周磊,马福生,戴昭秋,窦桂丽,张晶晶,皮肤科乔,孙祥尧,周孟玲,张蕴萍,刘红霞,护士专用号,李娇,彭瑶,毕田田,李伟,曹国苹,田宏广,薄金侠,郭美英,贾子娟,李红娜,洪燕,梁平,滕广帅,王龙廷,马俊苓,刘星苗,曲圣爱,王莹,吕志香,马世国,冯丽华,张国鹏,戴晶晶,李伟英,罗金梅,张玉慈,张先华,徐然然,崔晓林测试,韩仲云,宋红燕,武志鹏,田俊华,只倩,张馨丹,呼吸科赵,马宁,李晓迎,刘建琴,孙雪娇,叶雷,汪莉,李经聪,消化科朱荣艳,血液科梁勇,李娜,刘玲玲,徐一方,叶盼敏,专科转诊专号,徐志强,刘欣欣,成丽琴,陈丽英,武明雷,郝青,陈维彬,徐鸿斌,康月刚,陈莉,杨菲菲,赵帅,大白,赵艳敏,李青芬,牛犇,孙卫华,牟嘉莉,楚艳,王利,沙洁,刘强,小白,冯岚,秘冬青,孙秀一,张慧敏,明立华,王齐兴,李薇,王志刚,胡瑗,张冬梅,李法涛,陈立新,霍大新,楚天臣,李凌云,吉朝利,孟建华,王艳丽,于庆波,裴玉梅,梁海燕,周雪,刘婕,张元林,李文娟,李奎九,王丽靖";
//		String name = "张翠菊";
		String[] nameZ = name.split(",");
		/**
		 * 所有医生ID
		 */
		String allDoctorString = "00021741a82a41ccb2c8034df11d3435,00032b390d744d0aa63a4d6e7a0e8dbf,00032b390d744d0sa63a4d6e7a0e8dbf,00032b390d744d0sa63a4d6esa0e1dbf,00032b390d744d0sa63a4d6esa0e8dbf,00032bd90d744d0sa63a4d6esa0e8dbf,00032bd90d744d0sa63a4d6esd0e8ddf,00032bd90d744ddaa63a4d6e7a0e8dbf,00032bd90d744sdsa63a4d6esd0e8ddf,00032bds0d744sdsa63a4d6esd0e8ddf,00034ads0d764sdsa66a2d6esd0e8ddf,00034bds0d744sdsa63a4d6esd0e8ddf,00034bds0d744sdsa66a4d6esd0e8ddf,00034bds0d764sdsa66a4d6esd0e8ddf,00034bds0d764sdsa66a8d6esd0e8ddf,00034bds0d76ssdsa66a8d6esd0e8ddf,00134bds0d76dmdsa66a8d6esd0e8ddf,00134bds0d76dsdsa66a8d6esd0e8ddf,00134bds0d79dmdsa66a8d6esd0e8ddf,00164bds0d49dmdsa65a0d6esd0e9ddf,00164bds0d79dmdsa65a0d6esd0e9ddf,00164bds0d79dmdsa66a0d6esd0e8ddf,00164bds0d79dmdsa66a0d6esd0e9ddf,0047bcaa59ac4f56bc6aa1cf18d52a47,01034ads0d764sdsa66a2d6esd0e8adf,01164bds0d42dmd9a6rt0d6esd0e9dsf,01164bds0d42dmdsa6rt0d6esd0e9ddf,01164bds0d42dmdsa6rt0d6esd0e9dsf,01164bds0d48dmdsa65a0d6esd0e9ddf,01164bds0d48dmdsa6fa0d6esd0e9ddf,01164bds0d48dmdsa6rt0d6esd0e9ddf,01164bds0d49dmdsa65a0d6esd0e9ddf,01573db870ed4f679d688f57d71d7652,02cc23869eca43b788d27459bbe3622e,02cdb240afeb4e5a997bfdd49c0ccb72,03d7dccf17174a72aff217479b671d9f,05e82f3144e54ed48e0d73b2e04c7ced,0776046493104bc4aa8a0ead0ce6ceda,0908b1f277fe4311b0ec5e46cff3fce9,0adbbe043e244ff8978ac9df6f2f7a8b,0d80897e09da4a64a3f27afefb92b2a6,0da11e3605aa4e1b972c7f1b6843eb90,0dcfca17d9904c1b985b4150c9778dbb,0e42c654bb5e43a69929e006b1439d36,0e46ae4eecca4b4d98a33e183fe835f5,0fa4b7c342e34866b2cc43fd97376f10,11034ads0d764sdsa66a2d6esd0e8bdf,11034ads0d764sdsa67b2d6esd0e8bdf,129c1e7fd87945dfb78b2c3930e8b05f,12c9f2e271da407db9a222a7ceac12c1,1363410f256f44a0b4b35ff8c5210e5c,13ea87266fec4826ae81a4b557528e6b,14f6b64a87df47c4b614157e99132ebc,16505fd27c044a67b0ab345950f8b7d1,17a7e0ad1e6e4d1491532256e7b87103,181b14cc4f34462788a64d6217267cbb,1882f6d864794a58994c5e2b7f5a8c56,19dc6688490340069e1ccf96df2ab758,1aa0e5d4682e4482b5620d940bb90038,1b1a5fa07a8041b3bf67f3edf7095c3d,1d037e14dd2440e390753ef92b424256,1d3665647a0740199af17efac4ea21eb,1e57a18b042241b8a00d13143904e248,1e92863c38924122809b400a2d31614b,1eccd3bf502c4c47a1fce7caa97b38c3,1fb49f4e108a4473aa5cf0fbd303cb01,21034ads0d764sdsa67a2d6esd0e8bdf,21753c7ee1f8414aa2db8dce119f5e0c,2283d7b8d05e494d81acd3471d06f814,2509cd882d294bc7ab4679e5e1f1401c,26707422ab334d6face3a8d0793b33f9,26c22857c42e40f9b422bb7e21d3b3e8,2c6e4c393e8d4b62ab0b449de4e9de88,2d0a7f78ad70462487f86582479317a1,2dacdcffc6f34292a48b53656116259a,2dbf1c00f67e46e689ab9c9f38bba5fc,2f9d6a3c48f54a91b20ce6c9b02bf138,32b7310f69164b5987e39e9809c71d48,32c34e632a914d049dde8585b58cc041,341e89621da74438b63b0e7998c15742,3565e2d5eacc434fb1438b1452a660b2,358412b4c1034bc099d7a397ecca11b9,3607421f134640a8bfc84a02bdee0aa0,39627b4b63ee4d2ca066b15c4f31f2de,3986b1cd74624d6187d27fdd51ef966e,3bb12e94f8664d54bf29d144db2e508c,3ccf021a8d9a45428133f2518475ca8f,40296e664eda40debb1a3ac682f21998,4048e69eb12c4b92b28aff465157c9e1,4072204336574c52aa2e71008ea4a9d2,40b4e14f831c457391aa540967e2e0f7,441ad1abada44f8ba0e20933be57b9d4,461388d89fff46a2b21dec10f38c856c,49de8df4283a4e77a53a51654ecdde92,4a0c941397b04b52b13740a66a156344,4ba0456dd7694d60b4bb1b96a5001e12,4c7bc4f283304bbe92a0113b141e9d3f,4e886cbac1504ce8840aba9d70e96b58,4ee47f66e60c4439abc5adb9d9a2d06e,504c116274d6471b868e4ed17a51d87f,5247c3add821433d84192e0b5863d7ae,5522293c6261443fb9f1bdb6f58dcb66,557c5bd1f02a4ebe8d2b450690e80472,56fcf51245ed46bc9eff811ab4368014,5787910f075e47bc826b602e8c5d64d7,59c8bf50b7e64b2a8e6fb499d0981acd,5b188ba2c48143d296fa981a8372ef09,5b4446cc908c4c659945ec18c72d3cac,5faf4595bc7542d892f6679adc078d1d,618c44f378f6425084bd0641f6fbf417,62467d5bcbac41ccac8f47d2edeea09f,63ccd64761344bf9abb8a747619c5252,67e0fa3c815d4e2e8edeec75d5e20b8e,6a01c103bff44b069374a7a904851ded,6a2b6ced4d5d4688a33376b7ef894eac,6c08550f5e67480e9337076107ae9a12,6ce9cea2ca834cbfb6099c92a206f9f4,6d3755a4c48540abbd8870849d880669,6f01f4dbc6a940a19da673425affde4b,6f6a21dfa77346bfa1549b070e5b2730,6f8e214982a74649a2c131b9c1bd4e08,6fd6c8d4ca794f20a317139d05d14707,7298847030ce48df93beacd7bfa6096f,73480f31ea934df38fe8daac3607dbd5,73a365472ed84b0bb4bb600f83a1ce04,7663df82cd2645e4bfb78f1553025bb4,767f1c07b22a40688959b9d39887e4bc,76854d3c6c5044479cda3462cefb0d59,775f72afbe764144937660868f61e39e,787350c4dcb84ed6a0120f19b154929e,7924a19bae994320a8038556fa2906e2,7c500a37e87f4527ab5a041dde7192a4,7cf5d2902f894be29031a9fc6610b1e1,7d74089fbde04f3c9015a22d8b3781b7,7e89a1d50ac54f6e91c879ad9f586271,7f07afb9315b40478eace9d84028688e,800db07c34444f07971bbe9db95e3f9f,833f55cba8b84091bf198d84b33812e2,8423e1c2c61a44f3b43b7803d567c324,84ab4a19931a432399ea25d86cf5971a,85ccb3237cbb4347899494f267e2c3be,85f78ef4111340f9a7ad213b5fb1fd22,862d72b191db4e919d743a6414be9ab0,8ab500a5ad184f5e9b5017d76659bd82,8ab94e95afe448dab66403fc5407d0ca,8b6b46e943ed4c09a72e32a18f2a4da5,8dad31d7b1d7431689dab3750637caff,911d6b8f7fcf49f9b172679635bebe9b,9231b72e4e894ba9baef05e17496dd9a,92385eb1afc04794bf0845f1cebcc97c,92d5ba3389e7487eb556b663103b2d77,93137523a5374ad2834a90d9a4246170,936368cad64846d08d1bf64c76ba05a1,943193d832424ed6b57e8b1a0e305085,94655768560541c4bbba61d5fab5dc6b,94f2360aaf3941a08f08224cc685dba3,9505b2e837624feb992cbdbdd70df343,959e0c44525646f091cf16a6a1d47efb,9657e5f35e7f4ba7aa1c3c91b6d27379,987559e2da3440f0b5fa65a6c5ea9abd,988267fc77cc4cab8998aa2d65f7b68a,98f781f14bd64977ada2e394b35dce4f,9908cdf3a87a4982aee465462775af05,999cfd40151c40f59ddd9d7c7e1d8bad,9a360b19709140ec83d1779cb627297d,9ae926230cfe43d3b8a73814ba577d21,9b4b763a496747c08c832e52d217b812,9b538fd8886243e79c66053f9126d436,9bc0948cd3c64b61ac30ff437ca4d20d,9d9a5f1014e54ff2ba8dfde344f09640,9e7c7545199f4bd386ab6cd8a98a4cb0,9f009062633748d59031a3515d86285d,9f0093c24f0840fbaf3d432aa8c8034f,9f216855038f49bbb08f49d45b8778f4,a0004b3d399a4406bb2919c929aeac6c,a225e2e0e46a4924a7d6e015d627efe5,a34ae7b821b642988d27e39d5dda714c,a437ea3838524b608155179c6fcc6600,a67d271ebcbe45e7b75e003edcc84196,a7ee56b0c6a44a52948f6e2931f92f17,a9930358243244b1b68398ed307a42b5,a9e6d6f9e02d4ddbbae77fac668cf31e,ac6287c2126c4db59c07f1e2fb20a8ab,ad85bbcc2df140b58f81189aac3bc97a,b12fc700278a482b9298913bc1e1bede,b1abee25afc24eddb3c5cc2381fd8144,b211e43a96bc4d6e90dbb69a8608c810,b23d37debd9b4f4b97c66afa51d7bd5e,b4f0d18cb6b84c5dba6a4d701953aac0,b5f8500c596f45fe94026f245eb320d0,b808a73fb8dd497287490fc2af23963c,b85c69258c2d484d8e8c8af2ea5cdd27,c0e98266ca784c14b4fa9f4b7d356234,c3555bdc7b04453d93f061bfb1d49d0c,c382729e0e4844b29405b9a0da891862,cd60d11b568e4f499ff4efb3f66ccb72,ce7a7f0a40384700952c37b01f88ee41,cf7bb54773564ff184559f71cb86a657,cf859d4472f749198cc4263b4aa26f47,d1d493dae9fd46e0b0a7112a58e863e1,d208a585a49d407495fb3ef3a6bc88da,d2cb75e0ca7a444580e19be856ccc386,d47423a2fa92401d8ff8b63cdd6c3480,d4e48b5300884b68b85f391325bd14c0,d8244e86cbed48189d107a5c2d32e256,dacda74debcb455982df356e77fa5c20,dc7f72341db748e589fd5bc6af63a76b,dfd618571ffe42af847553b1ffbe7547,e0d0e95e95ce4d81a907ba0d83a89ace,e14d8aa4b9aa46368af5196fe60b10dd,e1ccd4763aaa4891bec51d01ca5eef12,e1f87d3e09444394baf851921c1bf027,e3e576846cdf45d284657a04dd9e0481,e59e4e6f5ad64f2a9b6743773f3c36f9,e5f4e414a8c14fe19a12e8804bbeae22,e6918174d1624eb9b0df86a276fe8ca7,e723019f26d548c18014c2dbe8e64145,e84f5377f9484669a9b9d51ec20433bc,e86e523f29c04647a57041395c26cb9d,e8e47186c44c46698328b9e170de66cc,eb6963a6af324076a7f2cde58de6f517,eb88ebfef6f348379f75f3d9cd4f7e6e,ec7c5ae068b64b959e91ffb1f5126801,f0c4f8dc2b43436381731925ca26641d,f15e7cfe8a9449c1bfda0e515a0819cf,f170b7e6f202468d82085e08a257a860,f5ee0e1f8d4c4bf2a0e9ed9e65aa8d42,f60d1634c9594978816fbabd717fbd4a,f6b8bbf33d314ac3b980fcdc020cc192,f8eab7e0f3a44448aaec990808189caf,fb12dfe950344a27b2b0d6f3d43d1c31,fdeba1de194e43d1bf9a39bb9f1d1a30,fefb2645415f4b5aa7fb6c9bf5e2e79e";
	//	String allDoctorString = "32b7310f69164b5987e39e9809c71d48";
		String[] result = allDoctorString.split(",");
		System.out.println(result.length);
		/**
		 * 无效咨询sessionId集合
		 */
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("244261,244268,244293,244303,244557,244589,244600,244601,244633,244659,244665,244732,244850,244884,244902,244919,245330,245348,245530,245600,245748,245749,245789,245790,245817,246035,246054,246058,246059,246067,246463,246473,246500,246603,246846,247148,247420,247437,247858,248351,248358,248359,248374,248465,248784,249010,249046,249127,249180,249814,249915,249944,250096,250197,250248,250298,250339,250455,250495,250565,250581,250615,250621,250624,250626,250627,250628,250640,250646,250648,250649,250660,250670,250672,250675,250677,250679,250680,250686,250691,250702,250703,250704,250705,250708,250710,250711,250712,250720,250728,250730,250760,");
		sbBuffer.append("250783,250812,250815,250817,250819,250821,250826,250841,250986,251034,251090,251136,251141,251143,251163,251165,251209,251496,251595,251662,251735,251910,251954,251989,252020,252417,252434,252461,252497,252593,252744,253054,253088,253181,253184,253406,253584,253888,254029,254032,254095,254190,254326,254407,254503,254534,254564,254602,254626,254692,254728,254770,254798,254884,255036,255179,255293,255343,255466,255487,255513,255801,255821,255935,256498,256521,256547,257288,257304,257595,257661,257696,257749,257771,258071,258090,258227,258293,258406,258475,258536,258570,258580,258585,258614,258668,258791,258824,259170,259219,259280,259604,259783,259814,259879,259883,259891,259895,259907,259911,259933,259934,259963,259967,259972,259989,260006,260016,260041,260211,260265,260363,260367,260375,260439,261007,261110,261124,261125,261129,261182,261231,261739,261809,261879,261933,261934,261935,261936,261941,261989,262014,262019,262025,262033,262083,262136,262175,262222,262256,262273,262373,262403,262461,262903,262965,263086,263093,263101,263107,263118,263125,263151,263161,263173,263593,263609,263995,264163,264167,264306,264308,264359,264362,264579,264702,264803,264829,264845,265033,265137,265138,265290,265527,265601,265639,265669,265758,265768,265875,265896,265900,265934,265944,265988,266517,266816,266920,266925,266941,266942,266980,267034,267099,267148,267156,267695,267709,267772,267903,267924,267936,268022,");
		sbBuffer.append("268024,268205,268209,268232,268259,268363,268373,268384,268490,268503,268521,268658,268701,268841,268877,268999,269114,269135,269313,269442,269970,270081,270139,270161,270182,270193,270196,270209,270217,270266,270275,270285,270298,270360,270758,270800,271155,271350,271402,271408,271418,271428,271561,271569,271643,271714,271773,271774,271831,271894,271949,271992,272037,272070,272455,272631,272658,272667,272684,272701,272750,273407,273566,273574,273672,273832,273865,273887,274112,274165,274240,274274,274483,274569,274585,274592,274923,274990,275042,275043,275088,275143,275160,275310,275466,275525,275643,276081,276502,276587,276590,276594,276701,276742,276750,276791,277024,277242,277367,277368,277451,277467,277468,277469,277515,277530,277561,277564,277574,277610,277612,277643,277656,277658,277678,277683,277712,277740,277808,277830,277846,277900,278059,278073,278127,278130,278144,278153,278159,278675,278698,278819,278928,278963,279065,279159,279200,279293,279300,279361,279369,279375,279674,279735,280039,280058,280198,280232,280243,280268,280312,280323,280335,280385,280514,280655,280755,280891,280940,281004,281056,281117,281222,281362,281370,281810,281972,282028,282089,282101,282102,282106,282230,282257,282608,282873,283635,283650");
		String[] validStr = sbBuffer.toString().split(",");
		System.out.println("无效咨询个数：" + validStr.length);
		BasicDBObject aa = new BasicDBObject();
		aa.put("lastMessageTime", new BasicDBObject("$gte", new Date(
				2016 - 1900, 11 - 1, 28)).append("$lte", new Date(2016 - 1900,
				12 - 1, 25)));
		System.out.println(cssv.count(aa)); //;cssv.find(aa).count()
		System.out.println("继续执行请输入yes，立即停止请输入no，thank you ！");
        String string = scanner.nextLine();
        if ("yes".equalsIgnoreCase(string)) {
        	System.out.println("继续执行.......");
        } else {
            System.exit(0);
        }
		ExportByThread exportByThread = new ExportByThread();
		int num = 40 ;
		if(num > result.length){
			num = result.length ;
		}
		int taskSize = result.length % num == 0 ? result.length/num:result.length/num + 1 ;
		ExecutorService pool = Executors.newFixedThreadPool(taskSize); 
		System.out.println("线程执行开始："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
		for(int i = 0 ; i< taskSize ; i++){
			String threadName = "threadName-"+i;
			TestThread testThread = null ;
			int length = 0 ;
			if(i == 0){
				length = num ;
				String[] reStrings = new String[num];
				String[] nameZs = new String[num];
				for(int j =0 ; j< length;j++){
					reStrings[j] = result[j];
					nameZs[j] = nameZ[j];
				}
				testThread = exportByThread.new TestThread(cssv, reStrings, validStr, 10, 28, 11, 25, 2016, "2016-11-28", "2016-12-25",threadName,nameZs);
			}else if(i == taskSize-1){
				length = i*num ;
				String[] reStrings = new String[result.length - i*num];
				String[] nameZs = new String[result.length - i*num];
				for(int j =0 ; j< result.length - i*num;j++){
					reStrings[j] = result[length];
					nameZs[j] = nameZ[length];
					length++;
				}
				testThread = exportByThread.new TestThread(cssv, reStrings, validStr, 10, 28, 11, 25, 2016, "2016-11-28", "2016-12-25",threadName,nameZs);
			}else{
				length = i*num ;
				String[] reStrings = new String[num];
				String[] nameZs = new String[num];
				for(int j =0 ; j< num;j++){
					reStrings[j] = result[length];
					nameZs[j] = nameZ[length];
					length ++;
				}
				testThread = exportByThread.new TestThread(cssv, reStrings, validStr,  10, 28, 11, 25, 2016, "2016-11-28", "2016-12-25",threadName,nameZs);
			}
			pool.execute(testThread);
		}
		pool.shutdown(); 
		System.out.println(pool.isShutdown());
	}

	/**
	 * 
	 * @param cssv
	 * @param allDoctorListStrings
	 * @param validSessionIdStr
	 * @param fromMonth
	 *            9 (当前月-1)
	 * @param fromDay
	 * @param endMonth
	 *            10 (当前月-1)
	 * @param endDay
	 * @param currentYear
	 *            2016
	 * @param beginTime
	 *            "2016-10-31"
	 * @param endTime
	 *            "2016-11-27"
	 * @throws ParseException
	 * 
	 */
	public class TestThread implements Runnable {
		
		private DBCollection cssv ;
		private String[] allDoctorListStrings ;
		private String[] validSessionIdStr ;
		private int fromMonth ;
		private int fromDay ;
		private int endMonth ;
		private int endDay ;
		private int currentYear ;
		private String beginTime ;
		private String endTime ;
		private String threadName ;
		private String[] nameZ ;
		
		public TestThread( DBCollection cssv,
				 String[] allDoctorListStrings,
				 String[] validSessionIdStr,  int fromMonth,
				 int fromDay,  int endMonth,  int endDay,
				 int currentYear,  String beginTime, String endTime ,String threadName ,String[] nameZ){
			
			this.cssv = cssv ;
			this.allDoctorListStrings = allDoctorListStrings ;
			this.validSessionIdStr = validSessionIdStr ;
			this.fromMonth = fromMonth ; 
			this.fromDay = fromDay ;
			this.endMonth = endMonth ;
			this.endDay = endDay ;
			this.currentYear = currentYear ;
			this.beginTime = beginTime ;
			this.endTime = endTime ;
			this.threadName = threadName ;
			this.nameZ = nameZ ;
	
		}

		@Override
		public void run() {
			try {
				Map<String, Integer> hashMap = new HashMap<String, Integer>();
				BasicDBList basicDBList = new BasicDBList();
				for (int x = 0; x < validSessionIdStr.length; x++) {
					basicDBList.add(validSessionIdStr[x]);
				}
				int start = 0;
				for (int i = start; i < allDoctorListStrings.length ; i++) {
					BasicDBObject dbObject = new BasicDBObject();
					dbObject.put("lastMessageTime", new BasicDBObject("$gte", new Date(
							currentYear - 1900, fromMonth, fromDay)).append("$lte",
							new Date(currentYear - 1900, endMonth, endDay)));
					dbObject.put("csUserId", new BasicDBObject("$regex",
							allDoctorListStrings[i]));
					dbObject.put("sessionId", new BasicDBObject("$nin", basicDBList));
					int totalCount = cssv.find(dbObject).count();
					System.out.println(threadName+ "===" + allDoctorListStrings[i]
							+ "咨询总量：" + totalCount);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					long time = sdf.parse(endTime).getTime()
							- sdf.parse(beginTime).getTime();
					long len = time / (1000 * 60 * 60 * 24);
					Calendar calendarBegin = Calendar.getInstance();
					calendarBegin.set(currentYear, fromMonth, fromDay, 00, 00, 01);
					Calendar calendarEnd = Calendar.getInstance();
					calendarEnd.set(currentYear, fromMonth, fromDay, 06, 00, 00);
					long begin = calendarBegin.getTimeInMillis();
					long end = calendarEnd.getTimeInMillis();
					long diff = 24 * 60 * 60 * 1000;
					Calendar cb = Calendar.getInstance();
					cb.set(currentYear, fromMonth, fromDay, 23, 00, 00);
					Calendar ce = Calendar.getInstance();
					ce.set(currentYear, fromMonth, fromDay, 23, 59, 59);
					long bb = cb.getTimeInMillis();
					long ee = ce.getTimeInMillis();
					int removeCount = 0;
					for (int j = 0; j < len; j++) {
						BasicDBObject dbObj = new BasicDBObject();
						dbObj.put("lastMessageTime", new BasicDBObject("$gte",
								new Date(begin + j * diff)).append("$lte", new Date(end
								+ j * diff)));
						dbObj.put("csUserId", new BasicDBObject("$regex",
								allDoctorListStrings[i]));
						dbObj.put("sessionId", new BasicDBObject("$nin", basicDBList));
						int cou = cssv.find(dbObj).count();
						BasicDBObject Obj = new BasicDBObject();
						Obj.put("lastMessageTime", new BasicDBObject("$gte", new Date(
								bb + j * diff)).append("$lte", new Date(ee + j * diff)));
						Obj.put("csUserId", new BasicDBObject("$regex",
								allDoctorListStrings[i]));
						Obj.put("sessionId", new BasicDBObject("$nin", basicDBList));
						int cou_cc = cssv.find(Obj).count();
						int sum = cou + cou_cc;
						removeCount += sum;
					}
					
					if(removeCount != 0){
						System.out.println(threadName+"---"+allDoctorListStrings[i]+"无效总数："+removeCount);
					}
					hashMap.put(allDoctorListStrings[i], totalCount - removeCount);
				}
				System.out.println(threadName+ "线程执行完成，结果如下："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
				for (int j = 0; j < allDoctorListStrings.length; j++) {
					for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
						String key = entry.getKey().toString();
						if (allDoctorListStrings[j].equals(key)) {
							System.out.println(nameZ[j] + "	" + allDoctorListStrings[j]
									+ "	" + entry.getValue());
						}
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
