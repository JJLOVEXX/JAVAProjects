package com.jackfrued.dao;

import java.io.Serializable;
import java.util.List;

import com.jackfrued.comm.QueryBean;
import com.jackfrued.comm.QueryResult;

/**
 * 数据访问对象接口(以对象为单位封装CRUD操作) * @author 骆昊 * * @param <E> 实体类型 * @param <K> 实体标识字段的类型
 */
public interface BaseDao<E, K extends Serializable> {
    /*新增 *
    @param
    entity 业务实体对象 *@return 增加成功返回实体对象的标识 */

    public K save(E entity);

    /**
     * 删除 * @param entity 业务实体对象
     */
    public void delete(E entity);

    /**
     * 根据ID删除 * @param id 业务实体对象的标识 * @return 删除成功返回true否则返回false
     */
    public boolean deleteById(K id);

    /**
     * 修改 * @param entity 业务实体对象 * @return 修改成功返回true否则返回false
     */
    public void update(E entity);

    /**
     * 根据ID查找业务实体对象 * @param id 业务实体对象的标识 * @return 业务实体对象对象或null
     */
    public E findById(K id);

    /**
     * 根据ID查找业务实体对象 * @param id 业务实体对象的标识 * @param lazy 是否使用延迟加载 * @return 业务实体对象对象
     */
    public E findById(K id, boolean lazy);

    /**
     * 查找所有业务实体对象 * @return 装所有业务实体对象的列表容器
     */
    public List<E> findAll();

    /**
     * 分页查找业务实体对象 * @param page 页码 * @param size 页面大小 * @return 查询结果对象
     */
    public DeptService.QueryResult<E> findByPage(int page, int size);

    /**
     * 分页查找业务实体对象 * @param queryBean 查询条件对象 * @param page 页码 * @param size 页面大小 * @return 查询结果对象
     */
    public QueryResult<E> findByPage(QueryBean queryBean, int page, int size);
} package com.jackfrued.dao;import java.io.Serializable;import java.util.List;
        import com.jackfrued.comm.QueryBean;import com.jackfrued.comm.QueryResult;

/**
 * 查询条件的接口 * @author 骆昊 *
 */
public interface QueryBean {
    /**
     * 添加排序字段 * @param fieldName 用于排序的字段 * @param asc 升序还是降序 * @return 查询条件对象自身(方便级联编程)
     */
    public QueryBean addOrder(String fieldName, boolean asc);

    /**
     * 添加排序字段 * @param available 是否添加此排序字段 * @param fieldName 用于排序的字段 * @param asc 升序还是降序 * @return 查询条件对象自身(方便级联编程)
     */
    public QueryBean addOrder(boolean available, StringfieldName, boolean asc);

    /**
     * 添加查询条件 * @param condition 条件 * @param params 替换掉条件中参数占位符的参数 * @return 查询条件对象自身(方便级联编程)
     */
    public QueryBean addCondition(String condition, Object... params);

    /**
     * 添加查询条件 * @param available 是否需要添加此条件 * @param condition 条件 * @param params 替换掉条件中参数占位符的参数 * @return 查询条件对象自身(方便级联编程)
     */
    public QueryBean addCondition(boolean available, String condition, Object... params);

    /**
     * 获得查询语句 * @return 查询语句
     */
    public String getQueryString();

    /**
     * 获取查询记录数的查询语句 * @return 查询记录数的查询语句
     */
    public String getCountString();

    /**
     * 获得查询参数 * @return 查询参数的列表容器
     */
    public List<Object> getParameters();
} package com.jackfrued.dao;import java.io.Serializable;import java.lang.reflect.ParameterizedType;import java.util.ArrayList;import java.util.Collections;import java.util.List;
        import org.hibernate.Query;import org.hibernate.Session;import org.hibernate.SessionFactory;import org.springframework.beans.factory.annotation.Autowired;import com.jackfrued.comm.HQLQueryBean;import com.jackfrued.comm.QueryBean;import com.jackfrued.comm.QueryResult;

/**
 * 部门数据访问对象接口 * @author 骆昊
 */
public interface DeptDao extends BaseDao<Dept, Integer> {
    /**
     * 分页查询顶级部门 * @param page 页码 * @param size 页码大小 * @return 查询结果对象
     */
    public QueryResult<Dept> findTopDeptByPage(int page, int size);
} package com.jackfrued.comm;import java.util.List;

/**
 * 部门业务逻辑接口 * @author 骆昊 *
 */
public interface DeptService {
    /**
     * 创建新的部门 * @param department 部门对象 * @return 创建成功返回true否则返回false
     */
    public boolean createNewDepartment(Dept department);
    package com.jackfrued.comm;import java.util.List;

    /**
     * 删除指定部
     * 门
     *
     * @param id 要删除的部门的编号 * @return 删除成功返回true否则返回false
     */
    public boolean deleteDepartment(Integer id); package com.jackfrued.dao;import com.jackfrued.comm.QueryResult;import com.jackfrued.entity.Dept;

    /**
     * 分页获取顶级部门 * @param page 页码 * @param size 页码大小 * @return 部门对象的分页器对象
     */
    public PageBean<Dept> getTopDeptByPage(int page, int size);
package com.jackfrued.dao.impl;import java.util.List;import org.springframework.stereotype.Repository;import com.jackfrued.comm.QueryResult;import com.jackfrued.dao.BaseDaoHibernateImpl;import com.jackfrued.dao.DeptDao;import com.jackfrued.entity.Dept;

    /**
     * BaseDao的缺省适配器 * @author 骆昊 * * @param <E> 实体类型 * @param <K> 实体标识字段的类型
     */
    public abstract class BaseDaoAdapter<E, K extends Serializable> implements BaseDao<E, K> {
        @Override
        public K save(E entity) {
            return null;
        }

        @Override
        public void delete(E entity) {
        }

        @Override
        public boolean deleteById(K id) {
            E entity = findById(id);
            if (entity != null) {
                delete(entity);
                return true;
            }
            return false;
        }

        @Override
        public void update(E entity) {
        }

        @Override
        public E findById(K id) {
            return null;
        }

        @Override
        public E findById(K id, boolean lazy) {
            return null;
        }

        @Override
        public List<E> findAll() {
            return null;
        }

        @Override
        public QueryResult<E> findByPage(int page, int size) {
            return null;
        }

        @Override
        public QueryResult<E> findByPage(QueryBean queryBean, int page, int size) {
            return null;
        }
    } package com.jackfrued.comm;import java.util.List;

    /**
     * 基于Hibernate的BaseDao实现类 * @author 骆昊 * * @param <E> 实体类型 * @param <K> 主键类型
     */
    @SuppressWarnings(value = {"unchecked"})
    public abstract class BaseDaoHibernateImpl<E, K extends Serializable> extends BaseDaoAdapter<E, K> {
        @Autowired
        protected SessionFactory sessionFactory;
        private Class<?> entityClass; // 业务实体的类对象
        private String entityName; // 业务实体的名字

        public BaseDaoHibernateImpl() {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            entityClass = (Class<?>) pt.getActualTypeArguments()[0];
            entityName = entityClass.getSimpleName();
        }

        @Override
        public K save(E entity) {
            return (K) sessionFactory.getCurrentSession().save(entity);
        }

        @Override
        public void delete(E entity) {
            sessionFactory.getCurrentSession().delete(entity);
        }

        @Override
        public void update(E entity) {
            sessionFactory.getCurrentSession().update(entity);
        }

        @Override
        public E findById(K id) {
            return findById(id, false);
        }

        @Override
        public E findById(K id, boolean lazy) {
            Session session = sessionFactory.getCurrentSession();
            return (E) (lazy ? session.load(entityClass, id) : session.get(entityClass, id));
        }

        @Override
        public List<E> findAll() {
            return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
        }

        @Override
        public QueryResult<E> findByPage(int page, int size) {
            return new QueryResult<E>(findByHQLAndPage("from " + entityName, page, size), getCountByHQL("select count(*) from " + entityName));
        }

        @Override
        public QueryResult<E> findByPage(QueryBean queryBean, int page, int size) {
            if (queryBean instanceof HQLQueryBean) {
                HQLQueryBean hqlQueryBean = (HQLQueryBean) queryBean;
                return new QueryResult<E>(findByHQLAndPage(hqlQueryBean.getQueryString(), page, size, hqlQueryBean.getParameters()), getCountByHQL(hqlQueryBean.getCountString(), hqlQueryBean.getParameters()));
            }
            return null;
        }

        /**
         * 根据HQL和可变参数列表进行查询 * @param hql 基于HQL的查询语句 * @param params 可变参数列表 * @return 持有查询结果的列表容器或空列表容器
         */
        protected List<E> findByHQL(String hql, Object... params) {
            return this.findByHQL(hql, getParamList(params));
        }

        /**
         * 根据HQL和参数列表进行查询 * @param hql 基于HQL的查询语句 * @param params 查询参数列表 * @return 持有查询结果的列表容器或空列表容器
         */
        protected List<E> findByHQL(String hql, List<Object> params) {
            List<E> list = createQuery(hql, params).list();
            return list != null && list.size() > 0 ? list : Collections.EMPTY_LIST;
        }

        /**
         * 根据HQL和参数列表进行分页查询 * @param hql 基于HQL的查询语句 * @page 页码 * @size 页面大小 * @param params 可变参数列表 * @return 持有查询结果的列表容器或空列表容器
         */
        protected List<E> findByHQLAndPage(String hql, int page, int size, Object... params) {
            return this.findByHQLAndPage(hql, page, size, getParamList(params));
        }

        /**
         * 根据HQL和参数列表进行分页查询 * @param hql 基于HQL的查询语句 * @page 页码 * @size 页面大小 * @param params 查询参数列表 * @return 持有查询结果的列表容器或空列表容器
         */
        protected List<E> findByHQLAndPage(String hql, int page, int size, List<Object> params) {
            List<E> list = createQuery(hql, params).setFirstResult((page - 1) * size).setMaxResults(size).list();
            return list != null && list.size() > 0 ? list : Collections.EMPTY_LIST;
        }

        /**
         * 查询满足条件的记录数 * @param hql 基于HQL的查询语句 * @param params 可变参数列表 * @return 满足查询条件的总记录数
         */
        protected long getCountByHQL(String hql, Object... params) {
            return this.getCountByHQL(hql, getParamList(params));
        }

        /**
         * 查询满足条件的记录数 * @param hql 基于HQL的查询语句 * @param params 参数列表容器 * @return 满足查询条件的总记录数
         */
        protected long getCountByHQL(String hql, List<Object> params) {
            return (Long) createQuery(hql, params).uniqueResult();
        } // 创建Hibernate查询对象(Query)

        private Query createQuery(String hql, List<Object> params) {
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
            return query;
        } // 将可变参数列表组装成列表容器

        private List<Object> getParamList(Object... params) {
            List<Object> paramList = new ArrayList<>();
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    paramList.add(params[i]);
                }
            }
            return paramList.size() == 0 ? Collections.EMPTY_LIST : paramList;
        }
    }
package com.jackfrued.comm;

    /**
     * 查询结果 * @author 骆昊 ** @param <T> 泛型参数
     */
    public class QueryResult<T> {
        private List<T> result; // 持有查询结果的列表容器
        private long totalRecords; // 查询到的总记录数

        /**
         * 构造器
         */
        public QueryResult() {
        }

        /**
         * 构造器 * @param result 持有查询结果的列表容器 * @param totalRecords 查询到的总记录数
         */
        public QueryResult(List<T> result, long totalRecords) {
            this.result = result;
            this.totalRecords = totalRecords;
        }

        public List<T> getResult() {
            return result;
        }

        public void setResult(List<T> result) {
            this.result = result;
        }

        public long getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(long totalRecords) {
            this.totalRecords = totalRecords;
        }
    } package com.jackfrued.biz;import com.jackfrued.comm.PageBean;import com.jackfrued.entity.Dept;

    @Repository
    public class DeptDaoImpl extends BaseDaoHibernateImpl<Dept, Integer> implements DeptDao {
        private static final String HQL_FIND_TOP_DEPT = " from Dept as d where d.superiorDept is null ";

        @Override
        public QueryResult<Dept> findTopDeptByPage(int page, int size) {
            List<Dept> list = findByHQLAndPage(HQL_FIND_TOP_DEPT, page, size);
            long totalRecords = getCountByHQL(" select count(*) " + HQL_FIND_TOP_DEPT);
            return new QueryResult<>(list, totalRecords);
        }
    }

    /*** 分页器 * @author 骆昊 * * @param <T> 分页数据对象的类型 */
    public class PageBean<T> {
        private static final int DEFAUL_INIT_PAGE = 1;
        private static final int DEFAULT_PAGE_SIZE = 10;
        private static final int DEFAULT_PAGE_COUNT = 5;
        private List<T> data; // 分页数据
        private PageRange pageRange; // 页码范围
        private int totalPage; // 总页数
        private int size; // 页面大小
        private int currentPage; //当前页码
        private int pageCount; // 页码数量

        /**
         * 构造器 * @param currentPage 当前页码 * @param size 页码大小 * @param pageCount 页码数量
         */
        public PageBean(int currentPage, int size, int pageCount) {
            this.currentPage = currentPage > 0 ? currentPage : 1;
            this.size = size > 0 ? size : DEFAULT_PAGE_SIZE;
            this.pageCount = pageCount > 0 ? size : DEFAULT_PAGE_COUNT;
        }

        /**
         * 构造器 * @param currentPage 当前页码 * @param size 页码大小
         */
        public PageBean(int currentPage, int size) {
            this(currentPage, size, DEFAULT_PAGE_COUNT);
        }

        /**
         * 构造器 * @param currentPage 当前页码
         */
        public PageBean(int currentPage) {
            this(currentPage, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_COUNT);
        }

        /**
         * 构造器
         */
        public PageBean() {
            this(DEFAUL_INIT_PAGE, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_COUNT);
        }

        public List<T> getData() {
            return data;
        }

        public int getStartPage() {
            return pageRange != null ? pageRange.getStartPage() : 1;
        }

        public int getEndPage() {
            return pageRange != null ? pageRange.getEndPage() : 1;
        }

        public long getTotalPage() {
            return totalPage;
        }

        public int getSize() {
            return size;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        /**
         * 将查询结果转换为分页数据 * @param queryResult 查询结果对象
         */
        public void transferQueryResult(QueryResult<T> queryResult) {
            long totalRecords = queryResult.getTotalRecords();
            data = queryResult.getResult();
            totalPage = (int) ((totalRecords + size - 1) / size);
            totalPage = totalPage >= 0 ? totalPage : Integer.MAX_VALUE;
            this.pageRange = new PageRange(pageCount, currentPage, totalPage);
        }
    }

    /**
     * 页码范围 * @author 骆昊 *
     */
    public class PageRange {
        private int startPage; // 起始页码
        private int endPage; // 终止页码

        /**
         * 构造器 * @param pageCount 总共显示几个页码 * @param currentPage 当前页码 * @param totalPage 总页数
         */
        public PageRange(int pageCount, int currentPage, int totalPage) {
            startPage = currentPage - (pageCount - 1) / 2;
            endPage = currentPage + pageCount / 2;
            if (startPage < 1) {
                startPage = 1;
                endPage = totalPage > pageCount ? pageCount : totalPage;
            }
            if (endPage > totalPage) {
                endPage = totalPage;
                startPage = (endPage - pageCount > 0) ? endPage - pageCount + 1 : 1;
            }
        }

        /**
         * 获得起始页页码 * @return 起始页页码
         */
        public int getStartPage() {
            return startPage;
        }

        /**
         * 获得终止页页码 * @return 终止页页码
         */
        public int getEndPage() {
            return endPage;
        }
    }
} package com.jackfrued.biz.impl;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import com.jackfrued.biz.DeptService;import com.jackfrued.comm.PageBean;import com.jackfrued.comm.QueryResult;
        import com.jackfrued.dao.DeptDao;import com.jackfrued.entity.Dept;

@Service
@Transactional // 声明式事务的注解
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean createNewDepartment(Dept department) {
        return deptDao.save(department) != null;
    }

    @Override
    public boolean deleteDepartment(Integer id) {
        return deptDao.deleteById(id);
    }

    @Override
    public PageBean<Dept> getTopDeptByPage(int page, int size) {
        QueryResult<Dept> queryResult = deptDao.findTopDeptByPage(page, size);
        PageBean<Dept> pageBean = new PageBean<>(page, size);
        pageBean.transferQueryResult(queryResult);
        return pageBean;
    }
}