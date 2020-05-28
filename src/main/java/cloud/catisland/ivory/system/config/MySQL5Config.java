package cloud.catisland.ivory.system.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class MySQL5Config extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_bin";
    }
}