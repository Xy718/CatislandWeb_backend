package cloud.catisland.ivory;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FirstStartup implements ApplicationRunner {

	@Autowired
	private EntityManager em;

	@Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("检测是否是第一次启动");

        String filePath = System.getenv("SystemDrive")+"/root/.ivory/initialized";
		log.info("The lock file on {}.",filePath.toString());
		File lockFIle =	FileUtil.file(filePath);
		if (!(lockFIle.exists()&&lockFIle.isFile())){
			log.info("第一次启动");
			//导入初始sql数据
			String sqlScript=FileUtil.readString(new ClassPathResource("initdata.sql").getFile(), "UTF8");
			Query query= em.createNativeQuery(sqlScript);
			int lins=query.executeUpdate();
			log.info("帖子导入成功：{}条.",lins);

			//写入lock文件
			FileUtil.touch(lockFIle);
			FileUtil.writeString("1", lockFIle, "UTF8");
		} else {
			FileUtil.writeString(RandomUtil.randomString(8), lockFIle, "UTF8");
		}
    }
}