package factory;

import dao.UserDao;
import dao.UserHibernateDao;
import dao.UserJdbcDao;
import util.DBHelper;

public class UserCreateJdbcDao implements DaoFactory {
    @Override
    public UserDao createDao() {
        return new UserJdbcDao(DBHelper.getConnection());
    }
}
