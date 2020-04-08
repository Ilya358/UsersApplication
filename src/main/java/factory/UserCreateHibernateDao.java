package factory;

import dao.UserDao;
import dao.UserHibernateDao;
import util.DBHelper;

public class UserCreateHibernateDao implements DaoFactory {
    @Override
    public UserDao createDao() {
        return new UserHibernateDao(DBHelper.getConfiguration());
    }
}
