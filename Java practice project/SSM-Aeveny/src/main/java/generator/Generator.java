package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {
	// targetRuntime="MyBatis3Simple", 不生成Example
	public void generateMyBatis() {
		List<String> warnings = new ArrayList<String>();//该集合记录MBG执行过程中的警告信息
		boolean overwrite = true ;	//当生成的代码重复时，覆盖原代码
		String generatorFile = "/mybatis/generatorConfig.xml";	//指定配置文件路径
		InputStream is = Generator.class.getResourceAsStream(generatorFile);//读取MBG配置文件
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try {
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);//执行生成代码
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//打印出执行过程中的警告信息，以便于修改 
		for (String warning : warnings) {
			System.out.println(warning);
		}	
	}

	// main方法为java普通类运行入口
	public static void main(String[] args) {
		Generator generator = new Generator();
		generator.generateMyBatis();
	}
}
