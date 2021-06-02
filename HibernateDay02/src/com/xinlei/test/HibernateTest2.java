package com.xinlei.test;

import com.xinlei.entity.UserDay02;
import com.xinlei.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class HibernateTest2 {
    @Test
    //一级缓存验证  默认开启, 若第二次查询,则在缓存中取数据
    public void testGet() {
        //创建sessionFactory
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        //获得session
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();
        //根据id 查询
        //调用session里面的get方法
        UserDay02 userDay02 = session.get(UserDay02.class, 1);
        System.out.println(userDay02);

        UserDay02 user = session.get(UserDay02.class, 1);
        System.out.println(user);
        //提交事务
        transaction.commit();
        //关闭链接
        session.close();
        sessionFactory.close();
    }

    @Test
    //一级缓存特性
    public void testDemo() {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //1. 根据id查询
        UserDay02 userDay02 = session.get(UserDay02.class, 5);
        //2. 设置返回对象值
        userDay02.setUserName("小肥羊");

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testTran() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            UserDay02 userDay02 = new UserDay02();
            userDay02.setUserName("老肥羊");
            userDay02.setUserPassword("123");
            userDay02.setGender("男");
            session.save(userDay02);
            int i = 1 / 0;
            transaction.commit();
        } catch (Exception e) {
            System.out.println("出错了!");
            //回滚事务
            assert transaction != null;
            transaction.rollback();
        } finally {
            //关闭流
            System.out.println("关闭流了");
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void useQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //1. 创建query 对象
            //方法里面写hql语句
            Query query = session.createQuery("from UserDay02");
            //调用query对象里面的方法的到结果
            List<UserDay02> list = query.list();
            for (UserDay02 userDay02 : list) {
                System.out.println(userDay02);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("出错了!");
            //回滚事务
            assert transaction != null;
            transaction.rollback();
        } finally {
            //关闭流
            System.out.println("关闭流了");
            session.close();
            sessionFactory.close();
        }
    }
    @Test
    public void useCriteria() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //1. 创建Criteria 对象
            //方法里面参数是实体类class
            Criteria criteria = session.createCriteria(UserDay02.class);
            //调用query对象里面的方法的到结果
            List<UserDay02> list = criteria.list();
            for (UserDay02 userDay02 : list) {
                System.out.println(userDay02);
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("出错了!");
            //回滚事务
            assert transaction != null;
            transaction.rollback();
        } finally {
            //关闭流
            System.out.println("关闭流了");
            session.close();
            sessionFactory.close();
        }
    }
    @Test
    public void useSQLQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //1. 创建SQlquery 对象
            //方法里面参数是实体类class
            SQLQuery sqlQuery = session.createSQLQuery("select * from userDay02");
            //调用query对象里面的方法的到结果
            //修改返回的是一个实体
            sqlQuery.addEntity(UserDay02.class);
            List<UserDay02> list = sqlQuery.list();
            for (UserDay02 userDay02 : list) {
                System.out.println(userDay02); 
            }

/*            //默认返回的是数组
            List<Object[]> list = sqlQuery.list();
            for (Object[] object : list) {
                System.out.println(Arrays.toString(object));
            }*/
            transaction.commit();
        } catch (Exception e) {
            System.out.println("出错了!");
            //回滚事务
            assert transaction != null;
            transaction.rollback();
        } finally {
            //关闭流
            System.out.println("关闭流了");
            session.close();
            sessionFactory.close();
        }
    }
}
