package com.liandi.todoback.service;


import com.liandi.todoback.bean.TengytTodo;
import com.liandi.todoback.dao.TengytTodoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {



    @Resource
    private TengytTodoMapper tengytTodoMapper;


    public int insertTodo(TengytTodo tengytTodo) {
        int insert = tengytTodoMapper.insert(tengytTodo);

        return insert;

    }

    public List<TengytTodo> selectTodoList(TengytTodo tengytTodo) {
        return tengytTodoMapper.selectTodoList(tengytTodo);
    }

    public int selectTodoListCount(TengytTodo tengytTodo) {
        return tengytTodoMapper.selectTodoListCount(tengytTodo);
    }

    public int deleteTodo(int id) {
        int i = tengytTodoMapper.deleteByPrimaryKey(id);
        return i;
    }

    public TengytTodo getTodo(int id) {
        TengytTodo tengytTodo = tengytTodoMapper.selectByPrimaryKey(id);
        ArrayList<String> checkWeeks=new ArrayList<>();
        if (tengytTodo.getWeek()!=null) {
            String[] split = tengytTodo.getWeek().split(",");
            System.out.println(split);
            for (int i = 0; i < split.length; i++) {
                checkWeeks.add(split[i]);
            }
            tengytTodo.setCheckWeeks(checkWeeks);
        }else{//这边需要将checkWeeks设置成数组,传回前端;否则前端接受的数据类型是Object对象

            tengytTodo.setCheckWeeks(checkWeeks);
        }

        return tengytTodo;


    }

    public int todoUpdate(TengytTodo tengytTodo) {
        return tengytTodoMapper.updateByPrimaryKey(tengytTodo);
    }
}
