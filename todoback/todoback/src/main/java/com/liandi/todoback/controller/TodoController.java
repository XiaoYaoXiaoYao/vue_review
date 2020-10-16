package com.liandi.todoback.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.liandi.todoback.bean.TengytTodo;
import com.liandi.todoback.service.TodoService;
import com.liandi.todoback.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {


    @Resource
    private TodoService todoService;



    @PostMapping("/insert")
    public AjaxResult insertTodo(@RequestBody TengytTodo tengytTodo) {
        TengytTodo tengytTodo_insert = new TengytTodo();
        String week_ = "";
        if (tengytTodo.getCheckWeeks().size()!=0) {
            for (String checkWeek : tengytTodo.getCheckWeeks()) {
                week_ = week_ + "," + checkWeek;
            }
            String substring = week_.substring(1);
            tengytTodo_insert.setWeek(substring);
        }else{
            tengytTodo_insert.setWeek(null);

        }

        tengytTodo_insert.setDatetime(tengytTodo.getDatetime());
        tengytTodo_insert.setTtime(tengytTodo.getTtime());
        tengytTodo_insert.setLooptype(tengytTodo.getLooptype());
        tengytTodo_insert.setUseTime(tengytTodo.getUseTime());
        tengytTodo_insert.setGrade(tengytTodo.getGrade());
        tengytTodo_insert.setContent(tengytTodo.getContent());
        int insertTodo = todoService.insertTodo(tengytTodo_insert);
        if (insertTodo==1) {
            return AjaxResult.success("添加成功");

        }
        return AjaxResult.error("添加失败");
    }

    @GetMapping("/todoList")
    public  AjaxResult selectTodoList(TengytTodo tengytTodo,
                                      @RequestParam("pageNum")Integer pageNum,
                                      @RequestParam("pageSize")Integer pageSize,
                                      @RequestParam("query")String query) {
        PageHelper.startPage(pageNum,pageSize);
        tengytTodo.setContent(query);
        List<TengytTodo> tengytTodoList= todoService.selectTodoList(tengytTodo);
        int count=todoService.selectTodoListCount(tengytTodo);
        HashMap<String, Object> res = new HashMap<>();
        res.put("tengytTodoList", tengytTodoList);
        res.put("count", count);
        return AjaxResult.success(res);

    }


    @DeleteMapping("/deleteTodo/{id}")
    public  AjaxResult selectTodoList(@PathVariable int id) {
        int count=todoService.deleteTodo(id);
        return AjaxResult.success("删除成功",count);

    }

    @GetMapping("/getTodo/{id}")
    public  AjaxResult getTodo(@PathVariable int id) {
        TengytTodo todo = todoService.getTodo(id);
        return AjaxResult.success("查询成功",todo);

    }


    @PutMapping("/todoUpdate")
    public  AjaxResult todoUpdate(@RequestBody TengytTodo tengytTodo) {
        String week_ = "";
        if (tengytTodo.getCheckWeeks().size()!=0) {
            for (String checkWeek : tengytTodo.getCheckWeeks()) {
                week_ = week_ + "," + checkWeek;
            }
            String substring = week_.substring(1);
            tengytTodo.setWeek(substring);
        }else{
            tengytTodo.setWeek(null);

        }
        int  count = todoService.todoUpdate(tengytTodo);
        return AjaxResult.success("修改成功",count);

    }

}
