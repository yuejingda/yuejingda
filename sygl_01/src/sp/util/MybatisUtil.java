package sp.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	static{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("configuration.xml");
		factory = builder.build(is);
	}
	public static SqlSession getSession(){
		return getSession(false);
	}
	public static SqlSession getSession(boolean isAutoCommit){
		return factory.openSession(isAutoCommit);
	}
	public static <T> T getMapper(Class<T> clazz){
		return getSession(true).getMapper(clazz);
	}
	
}
