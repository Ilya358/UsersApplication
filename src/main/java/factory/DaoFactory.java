package factory;

import dao.UserDao;

public interface DaoFactory {
    UserDao createDao();
}
