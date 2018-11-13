package com.asiainno.uplive.push.base;

import com.asiainno.base.dao.BatisGenericDao;
import com.asiainno.base.utils.GenericsUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;

/**
 * @author zy
 */

/**
 * <p>
 * 负责为单个Entity 提供CRUD操作的IBatis DAO基类. 子类只要在类定义时指定所管理Entity的Class,
 * 即拥有对单个Entity对象的CRUD操作.
 * </p>
 * <p/>
 * <pre>
 * public class UserDao extends IBatisEntityDao&lt;User&gt; {
 * }
 * </pre>
 *
 * @see BatisGenericDao
 */
public class BatisEntityDao<T> extends BatisGenericDao {

    /**
     * DAO所管理的Entity类型.
     */
    protected Class<T> entityClass;


    @Autowired
    @Qualifier("sqlSessionFactoryW")
    private SqlSessionFactory sqlSessionFactoryW;

    private SqlSession sqlSessionW;

    /**
     * 在构造函数中将泛型T.class赋给entityClass.
     */
    @SuppressWarnings("unchecked")
    public BatisEntityDao() {
        entityClass = GenericsUtils.getSuperClassGenricType(getClass());
    }

    /**
     * 查找
     */
    public List<T> findBy(String statementName, Object parameterObject) {
        return findBy(getEntityClass(), statementName, parameterObject);
    }

    /**
     * 查找唯一
     */
    public T findUniqueBy(String statementName, Object parameterObject) {
        return findUniqueBy(getEntityClass(), statementName, parameterObject);
    }

    /**
     * 更新
     */
    public int updateBy(String statementName, Object parameterObject) {
        return updateBy(getEntityClass(), statementName, parameterObject);
    }

    /**
     * 根据ID获取对象.
     */
    public T get(Serializable id) {
        return get(getEntityClass(), id);
    }

    /**
     * 获取全部对象.
     */
    public List<T> getAll() {
        return getAll(getEntityClass());
    }

    /**
     * 删除所有对象
     */
    public int deleteAll() {
        return deleteAll(getEntityClass());
    }

    /**
     * 取得entityClass. <p/> JDK1.4不支持泛型的子类可以抛开Class<T> entityClass,重载此函数达到相同效果。
     */
    protected Class<T> getEntityClass() {
        return entityClass;
    }


    public SqlSession getSqlSessionW() {
        if (this.sqlSessionW == null) {
            synchronized (sqlSessionFactoryW) {
                if (this.sqlSessionW == null) {
                    sqlSessionW = new SqlSessionTemplate(this.sqlSessionFactoryW);
                }
            }
        }
        return this.sqlSessionW;
    }
}
