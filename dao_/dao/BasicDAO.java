package com.mysql.dao_.dao;

import com.mysql.连接池.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 青月
 * @version 1.0
 * 开发basicDAO 是其他DAO的父类
 */

public class BasicDAO<T>{ //泛型指定具体类型

   private QueryRunner qr = new QueryRunner();
   public int update(String sql,Object... parameters)  {
       Connection connection = null;
       try{
           connection = JDBCUtilsByDruid.getConnection();
           int affectRows = qr.update(connection,sql,parameters);
           return affectRows;
       }catch (SQLException e){
           throw new RuntimeException(e); //编译异常 -> 运行异常
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }
   }

   //返回多个对象

    /**
     *
     * @param sql 语句，可以有?
     * @param clazz 传入一个类的Class对象 比如Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object...parameters){

        Connection connection = null;
        try{
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行
    public T querySingle (String sql, Class<T> clazz, Object...parameters){

        Connection connection = null;
        try{
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行单列 -> 单值
    public Object queryScalar(String sql,Object...parameters){
        Connection connection = null;
        try{
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new ScalarHandler<>(),parameters);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

}
