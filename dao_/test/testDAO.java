package com.mysql.dao_.test;

import com.mysql.dao_.dao.ActorDAO;
import com.mysql.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;


public class testDAO {

    @Test
    //测试ActorDAO 对actor表crud操作
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();

        String sql = "select * from actor where id >= ?";
        List<Actor> actors = actorDAO.queryMulti(sql,Actor.class,1);
        System.out.println("查询结果");
        for(Actor a : actors){
            System.out.println(a);
        }
        //查询单行
        Actor actor = (Actor) actorDAO.querySingle("select * from actor where id = ?",Actor.class,4);
        System.out.println("查询单行结果");
        System.out.println(actor);

        //查询单行单列
        Object o = actorDAO.queryScalar("select name from actor where id = ?",4);
        System.out.println("查询单行单列");
        System.out.println(o);

        // dml操作
        int update = actorDAO.update("insert into actor values(null,?,?,?,?)",Actor.class,2);
    }

}
