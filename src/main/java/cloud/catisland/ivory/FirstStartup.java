package cloud.catisland.ivory;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FirstStartup implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("检测是否是第一次启动");

        String filePath = System.getenv("SystemDrive")+"/root/.ivory/initialized";
		log.info("The lock file on {}.",filePath.toString());
		File lockFIle =	FileUtil.file(filePath);
		if (!(lockFIle.exists()&&lockFIle.isFile())){
			log.info("第一次启动");
			FileUtil.touch(lockFIle);
			FileUtil.writeString("1", lockFIle, "UTF8");
			//导入初始sql数据
		} else {
			FileUtil.writeString(RandomUtil.randomString(8), lockFIle, "UTF8");
		}
    }
}