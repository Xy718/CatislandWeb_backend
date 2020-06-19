package cloud.catisland.ivory;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstStartup implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("检测是否是第一次启动");

        Path file = Paths.get(System.getProperty("user.dir")+"//.ivory/initialized");
		log
		if (Files.exists(file)) {
			System.out.println("非第一次启动");
		} else {
            System.out.println("是第一次启动");
            File f=new File(file.getFileName().toString());
            f.createNewFile();
			try {
				Files.write(file, "1".getBytes(), StandardOpenOption.CREATE_NEW);
			} catch (FileAlreadyExistsException e) {
				// 并发情况下，其他的线程已经创建了该文件
			}
		}
    }
}