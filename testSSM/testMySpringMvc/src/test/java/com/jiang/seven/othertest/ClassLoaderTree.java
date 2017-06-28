package com.jiang.seven.othertest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.sun.tools.classfile.Opcode.Set;

public class ClassLoaderTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
		//System.out.println(System.getProperty("java.class.path"));
		/**
		 * E:\Program Files\Sts310WorkSpace\testMySpringMvc\target\test-classes;
		 * E:\Program Files\Sts310WorkSpace\testMySpringMvc\target\classes;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-core\4.3.4.RELEASE\spring-core-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-context\4.3.4.RELEASE\spring-context-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-aop\4.3.4.RELEASE\spring-aop-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-beans\4.3.4.RELEASE\spring-beans-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-expression\4.3.4.RELEASE\spring-expression-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-webmvc\4.3.4.RELEASE\spring-webmvc-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-web\4.3.4.RELEASE\spring-web-4.3.4.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-test\3.2.10.RELEASE\spring-test-3.2.10.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\mybatis\mybatis\3.1.1\mybatis-3.1.1.jar;
		 * F:\maven3\repository\maven_jar\org\mybatis\mybatis-spring\1.1.1\mybatis-spring-1.1.1.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-tx\3.1.1.RELEASE\spring-tx-3.1.1.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\spring-jdbc\3.1.1.RELEASE\spring-jdbc-3.1.1.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\mysql\mysql-connector-java\5.1.22\mysql-connector-java-5.1.22.jar;
		 * F:\maven3\repository\maven_jar\junit\junit\4.11\junit-4.11.jar;
		 * F:\maven3\repository\maven_jar\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;
		 * F:\maven3\repository\maven_jar\com\alibaba\druid\1.0.26\druid-1.0.26.jar;
		 * E:\Program Files\Java8\jdk1.8.0_101\lib\jconsole.jar;
		 * E:\Program Files\Java8\jdk1.8.0_101\lib\tools.jar;
		 * F:\maven3\repository\maven_jar\org\aspectj\aspectjweaver\1.7.4\aspectjweaver-1.7.4.jar;
		 * F:\maven3\repository\maven_jar\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;
		 * F:\maven3\repository\maven_jar\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;
		 * F:\maven3\repository\maven_jar\commons-fileupload\commons-fileupload\1.3.2\commons-fileupload-1.3.2.jar;
		 * F:\maven3\repository\maven_jar\commons-io\commons-io\2.2\commons-io-2.2.jar;
		 * F:\maven3\repository\maven_jar\javax\servlet\servlet-api\3.0-alpha-1\servlet-api-3.0-alpha-1.jar;
		 * F:\maven3\repository\maven_jar\jstl\jstl\1.2\jstl-1.2.jar;
		 * F:\maven3\repository\maven_jar\log4j\log4j\1.2.17\log4j-1.2.17.jar;
		 * F:\maven3\repository\maven_jar\com\alibaba\fastjson\1.2.22\fastjson-1.2.22.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\security\spring-security-web\4.2.0.RELEASE\spring-security-web-4.2.0.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\security\spring-security-core\4.2.0.RELEASE\spring-security-core-4.2.0.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\org\springframework\security\spring-security-config\4.2.0.RELEASE\spring-security-config-4.2.0.RELEASE.jar;
		 * F:\maven3\repository\maven_jar\com\fasterxml\jackson\core\jackson-core\2.8.5\jackson-core-2.8.5.jar;
		 * F:\maven3\repository\maven_jar\com\fasterxml\jackson\core\jackson-databind\2.8.5\jackson-databind-2.8.5.jar;F:\maven3\repository\maven_jar\com\fasterxml\jackson\core\jackson-annotations\2.8.0\jackson-annotations-2.8.0.jar;F:\maven3\repository\maven_jar\org\apache\directory\studio\org.apache.commons.lang\2.6\org.apache.commons.lang-2.6.jar;F:\maven3\repository\maven_jar\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;F:\maven3\repository\maven_jar\org\slf4j\slf4j-api\1.7.22\slf4j-api-1.7.22.jar;F:\maven3\repository\maven_jar\org\mongodb\mongodb-driver\3.4.1\mongodb-driver-3.4.1.jar;F:\maven3\repository\maven_jar\org\mongodb\mongodb-driver-core\3.4.1\mongodb-driver-core-3.4.1.jar;F:\maven3\repository\maven_jar\org\mongodb\bson\3.4.1\bson-3.4.1.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-mongodb\1.9.6.RELEASE\spring-data-mongodb-1.9.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-commons\1.12.6.RELEASE\spring-data-commons-1.12.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\mongodb\mongo-java-driver\2.14.3\mongo-java-driver-2.14.3.jar;F:\maven3\repository\maven_jar\org\slf4j\jcl-over-slf4j\1.7.22\jcl-over-slf4j-1.7.22.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-mongodb-log4j\1.9.6.RELEASE\spring-data-mongodb-log4j-1.9.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-mongodb-cross-store\1.9.6.RELEASE\spring-data-mongodb-cross-store-1.9.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\spring-aspects\4.2.9.RELEASE\spring-aspects-4.2.9.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\spring-orm\4.2.9.RELEASE\spring-orm-4.2.9.RELEASE.jar;F:\maven3\repository\maven_jar\org\aspectj\aspectjrt\1.8.9\aspectjrt-1.8.9.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-commons-core\1.4.1.RELEASE\spring-data-commons-core-1.4.1.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-redis\1.7.6.RELEASE\spring-data-redis-1.7.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\data\spring-data-keyvalue\1.1.6.RELEASE\spring-data-keyvalue-1.1.6.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\spring-oxm\4.2.9.RELEASE\spring-oxm-4.2.9.RELEASE.jar;F:\maven3\repository\maven_jar\org\springframework\spring-context-support\4.2.9.RELEASE\spring-context-support-4.2.9.RELEASE.jar;F:\maven3\repository\maven_jar\redis\clients\jedis\2.9.0\jedis-2.9.0.jar;F:\maven3\repository\maven_jar\org\apache\commons\commons-pool2\2.4.2\commons-pool2-2.4.2.jar;F:\maven3\repository\maven_jar\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar
		 */
	       while (loader != null) { 
	           System.out.println(loader.toString());
	           //sun.misc.Launcher$AppClassLoader@533e846f
		      //sun.misc.Launcher$ExtClassLoader@2d68be1b
	           
	       
	           System.out.println(loader.toString()+"===loader.getResource(\"ClassLoaderTree\") = " + loader.getResource("ClassLoaderTree"));   
	       //sun.misc.Launcher$AppClassLoader@3798f5e7===loader.getResource("ClassLoaderTree") = null
	       //sun.misc.Launcher$ExtClassLoader@1b382d35===loader.getResource("ClassLoaderTree") = null
	           System.out.println(loader.getSystemClassLoader().toString());
	           //sun.misc.Launcher$AppClassLoader@3798f5e7
	           System.out.println(loader.getSystemResource("config.properties"));
	           Properties p = new Properties();
	           try {
				p.load(loader.getSystemResourceAsStream("config.properties"));
//				for(Map.Entry<Object, Object> entry : System.getProperties().entrySet()){
//					System.out.println(entry.getKey()+"\t"+entry.getValue()); 
//				}
//				  Enumeration en = p.propertyNames(); //得到配置文件的名字
//				           while(en.hasMoreElements()) {
//				               String strKey = (String) en.nextElement();
//				               String strValue = p.getProperty(strKey);
//				               System.out.println(strKey + "==========" + strValue);
//				           }
				/*for(Iterator iterator = p.entrySet().iterator();iterator.hasNext();){
					System.out.println(iterator.next().toString());
				}*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	           //file:/E:/Program%20Files/Sts310WorkSpace/testMySpringMvc/target/classes/config.properties
	           System.out.println(loader.getResource("config.properties"));
//			   ExtClassLoader null AppClassLoader file:/E:/Program%20Files/Sts310WorkSpace/testMySpringMvc/target/classes/config.properties
	           loader = loader.getParent();  
	       }
	}

}
