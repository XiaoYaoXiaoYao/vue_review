<template>
<div>
    <!-- 卡片视图区 -->
    <el-card>
        <el-row :gutter="25">
            <el-col :span="10">
                <!-- 搜索添加 -->
                <el-input placeholder="请输入搜索内容" v-model="queryInfo.query" clearable @clear="getTodoList">
                    <el-button slot="append" icon="el-icon-search" @click="getTodoList"></el-button>
                </el-input>
            </el-col>

            <el-col :span="4">
                <el-button type="primary" @click="addDialogVisible = true">添加用户</el-button>
            </el-col>
        </el-row>
        <!-- 用户列表 -->
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="id" label="id" width="100"> </el-table-column>
            <el-table-column prop="content" label="内容" width="180"></el-table-column>
            <el-table-column prop="datetime" label="日期" width="100"></el-table-column>
            <el-table-column prop="ttime" label="时间" width="100"> </el-table-column>
            <el-table-column prop="looptype" label="循环类型" width="100"> </el-table-column>
            <el-table-column prop="week" label="周循环" width="100"></el-table-column>
            <el-table-column prop="useTime" label="按时间" width="100"> </el-table-column>
            <el-table-column prop="grade" label="级别" width="100"> </el-table-column>
            <el-table-column prop="status" label="状态" width="100"> </el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <!-- 修改 -->
                    <el-button type="primary" icon="el-icon-edit" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
                    <!-- 删除 -->
                    <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteTodo(scope.row.id)"></el-button>
                </template>
            </el-table-column>
        </el-table>


        <!-- 分页 -->
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="queryInfo.pageNum"
                :page-sizes="[1, 2, 5, 100]"
                :page-size="queryInfo.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
        ></el-pagination>
    </el-card>

    <!-- 创建新用户对话框 -->
    <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="50%"
               @close="addDialogClosed">
        <!-- 内容主体区域 -->

        <el-main class="abc">
            <el-form ref="form" :model="todoObject" label-width="80px">

                <el-form-item label="日期">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="todoObject.datetime"
                                        style="width: 100%;"  value-format="yyyy-MM-dd"></el-date-picker>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="todoObject.ttime" style="width: 100%;" value-format="HH:mm:ss">
                        </el-time-picker>
                    </el-col>
                </el-form-item>


                <el-form-item label="循环类型">
                    <el-radio-group v-model="todoObject.looptype"  >
                        <el-radio  :label="0">年循环</el-radio>
                        <el-radio :label="1">月循环</el-radio>
                        <el-radio  :label="2">日循环</el-radio>
                        <el-radio :label="3">工作日循环</el-radio>
                        <el-radio :label="4" >一次性</el-radio>
                        <el-radio :label="5" onclick="">周循环</el-radio>

                    </el-radio-group>

                </el-form-item>

                <el-form-item label="周循环"  v-if="todoObject.looptype ===5">
                    <el-checkbox-group v-model="todoObject.checkWeeks"  >
                        <el-checkbox label="周一"></el-checkbox>
                        <el-checkbox label="周二"></el-checkbox>
                        <el-checkbox label="周三"></el-checkbox>
                        <el-checkbox label="周四"></el-checkbox>
                        <el-checkbox label="周五"></el-checkbox>
                        <el-checkbox label="周六"></el-checkbox>
                        <el-checkbox label="周日"></el-checkbox>
                    </el-checkbox-group>
                </el-form-item>



                <el-form-item label="看时间">
                    <el-switch v-model="todoObject.useTime" active-value="1" inactive-value="0"></el-switch>
                </el-form-item>
                <el-form-item label="级别">
                    <el-select v-model="todoObject.grade" placeholder="请选择活动区域">
                        <el-option label="高" value="0"></el-option>
                        <el-option label="低" value="1"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="活动内容">
                    <el-input v-model="todoObject.content" placeholder="请输入内容"></el-input>
                </el-form-item>
            </el-form>
        </el-main>
        <!-- 内容底部区域 -->
        <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="onSubmit">确 定</el-button>
      </span>
    </el-dialog>
<!--     修改用户对话框 -->
        <el-dialog title="修改用户信息" :visible.sync="editDialogVisible" width="50%" @colse="editDialogClosed">


            <el-form ref="form" :model="editForm" label-width="80px">

                <el-form-item label="日期">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="editForm.datetime"
                                        style="width: 100%;"  value-format="yyyy-MM-dd"></el-date-picker>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                        <el-time-picker placeholder="选择时间" v-model="editForm.ttime" style="width: 100%;" value-format="HH:mm:ss">
                        </el-time-picker>
                    </el-col>
                </el-form-item>


                <el-form-item label="循环类型">
                    <el-radio-group v-model="editForm.looptype"  >
                        <el-radio  :label="0">年循环</el-radio>
                        <el-radio :label="1">月循环</el-radio>
                        <el-radio  :label="2">日循环</el-radio>
                        <el-radio :label="3">工作日循环</el-radio>
                        <el-radio :label="4" >一次性</el-radio>
                        <el-radio :label="5" onclick="">周循环</el-radio>

                    </el-radio-group>

                </el-form-item>

                <el-form-item label="周循环"  v-if="editForm.looptype ===5">
                    <el-checkbox-group v-model="editForm.checkWeeks" @change="ch">
                        <el-checkbox   v-for="(c,index) in checks" :key="index" :label="c.name">{{c.name}}</el-checkbox>
                    </el-checkbox-group>
                </el-form-item>



                <el-form-item label="看时间">
                    <el-switch v-model="editForm.useTime" :active-value="1" :inactive-value="0" ></el-switch>
                </el-form-item>
                <el-form-item label="级别">
                    <el-select v-model="editForm.grade" placeholder="请选择活动区域">
                        <el-option label="高" value="0"></el-option>
                        <el-option label="低" value="1"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="活动内容">
                    <el-input v-model="editForm.content" placeholder="请输入内容"></el-input>
                </el-form-item>
            </el-form>

          <span slot="footer" class="dialog-footer">
            <el-button @click="editDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="editTodoInfo">确 定</el-button>
          </span>
        </el-dialog>
</div>
</template>

<script>
    export default {
        data() {
            return {
                // 请求数据
                queryInfo: {
                    query: "",
                    pageNum: 1,
                    pageSize: 2
                },
                // 代办列表
                tableData: [

                ],


                todoObject:{
                    checkWeeks:[]
                },
                checks:[
                    {id:1,name:"周一"},
                    {id:2,name:"周二"},
                    {id:3,name:"周三"},
                    {id:4,name:"周四"},
                    {id:5,name:"周五"},
                    {id:6,name:"周六"},
                    {id:7,name:"周日"},
                ],
                total: 0, // 最大数据记录
                addDialogVisible: false ,// 对话框显示
                // 控制修改用户对话框显示/隐藏
                editDialogVisible:false,
                // 修改用户信息
                editForm:{
                    checkWeeks:[
                        {id:1,name:"周一"},
                        {id:2,name:"周二"},
                        {id:3,name:"周三"},
                        {id:4,name:"周四"},
                        {id:5,name:"周五"},
                        {id:6,name:"周六"},
                        {id:7,name:"周日"},
                    ]
                },

            };
        },
        created() {
            this.getTodoList();
        },
        methods: {
            async getTodoList() {
                // 调用post请求
                const { data: res } = await this.$http.get("todo/todoList", {
                    params: this.queryInfo
                });
                console.log(res.data.tengytTodoList);
                console.log(res.data.count);
                this.tableData = res.data.tengytTodoList; // 将返回数据赋值
                this.total = res.data.count; // 总个数
            },

            ch(){
                console.log(this.editForm.week)
            },

            // 监听pageSize改变的事件
            handleSizeChange(newSize) {
                this.queryInfo.pageSize = newSize;
                this.getTodoList(); // 数据发生改变重新申请数据
            },
            // 监听pageNum改变的事件
            handleCurrentChange(newPage) {
                this.queryInfo.pageNum = newPage;
                this.getTodoList(); // 数据发生改变重新申请数据
            },
            onSubmit() {
                console.log('submit!');
                //这边的前端的数据需要进行校验
                console.log(this.todoObject);
                //如果用户选择过周循环,并且给周循环的多选框选择过数据,之后又没有按周循环来循环,就要把checkWeeks数组置空
                if (this.todoObject.looptype!=5){
                    this.todoObject.checkWeeks=[];
                }

                this.$http.post(`/todo/insert`, this.todoObject).then((data) => {
                    console.log(data.data);
                    this.addDialogVisible=false;
                    this.getTodoList();
                    this.$message.success("添加成功");
                    this.todoObject={};


                }).catch((error) => {
                    console.log(error);


                })
            },
            // 展示修改框
            async showEditDialog(id){

                const {data:res} = await this.$http.get("todo/getTodo/"+id);
                this.editForm = res.data;
                this.editDialogVisible = true;
                //console.log(typeof this.editForm.checkWeeks =="object")
            },
            // 关闭窗口
            editDialogClosed(){
                this.$refs.editFormRef.resetFields();
            },
            // 确认修改
            async  editTodoInfo(){
                    const {data:res} = await this.$http.put("todo/todoUpdate",this.editForm);
                    console.log(res);
                    if (res.data != 1) return this.$message.error("更新失败！！！");
                    this.$message.success("更新成功！！！");
                    //隐藏
                    this.editDialogVisible = false;
                    this.getTodoList();


            },
            // 删除按钮
            async deleteTodo(id){
                // 弹框
                const confirmResult = await this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).catch(err => err)
                // 成功删除为confirm 取消为 cancel
                if(confirmResult!='confirm'){
                    return this.$message.info("已取消删除");
                }
                const {data:res} = await this.$http.delete("todo/deleteTodo/"+id);
                if (res.data != 1) {
                    return this.$message.error("删除失败！！！");
                }
                this.$message.success("删除成功！！！");
                this.getTodoList();
            },
        }
    };
</script>

<style scoped>

</style>
