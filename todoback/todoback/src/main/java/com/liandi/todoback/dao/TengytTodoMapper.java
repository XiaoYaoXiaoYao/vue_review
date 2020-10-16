package com.liandi.todoback.dao;

import com.liandi.todoback.bean.TengytTodo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TengytTodoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TengytTodo record);

    int insertSelective(TengytTodo record);

    TengytTodo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TengytTodo record);

    int updateByPrimaryKey(TengytTodo record);

    List<TengytTodo> selectTodoList(@Param("tengytTodo")TengytTodo tengytTodo);

    int selectTodoListCount(@Param("tengytTodo")TengytTodo tengytTodo);
}