package factory;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class UserDaoFactory {
    @SneakyThrows
    private static String getProperties() {
        FileInputStream file = new FileInputStream("C:/Users/manager/IdeaProjects/untitled2/src/main/resources/DB");
        Properties properties = new Properties();
        properties.load(file);
        String daoType = properties.getProperty("daotype");
        return daoType;
    }

    private static DaoFactory createUserDaoByProperties(String properties) {
        if(properties.equalsIgnoreCase("jdbc")) {
            return new UserCreateJdbcDao();
        } else if (properties.equalsIgnoreCase("hibernate")) {
            return new UserCreateHibernateDao();
        } else {
            throw new RuntimeException(properties + " is unknown DAO.");
        }
    }
    public static DaoFactory getDaoFactory() {
        return createUserDaoByProperties(getProperties());
    }
}
