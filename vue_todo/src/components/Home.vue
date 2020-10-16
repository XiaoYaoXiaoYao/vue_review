<template>
    <!-- 引入container布局 -->
    <el-container class="home-container">
        <!-- 头部 -->
        <el-header>
            <div>
                <img src="../assets/logo.png" alt=""/>
                <span>欢迎进入TODO主页</span>
            </div>
            <el-button type="info" @click="logout">安全退出</el-button>
        </el-header>
        <!-- 主体 -->
        <el-container>
            <!-- 侧边栏 -->
            <el-aside width="200px">
                <el-menu
                        background-color="#545c64"
                        text-color="#fff"
                        active-text-color="#ffd04b">
                    <!--          &lt;!&ndash; 一级菜单 &ndash;&gt;-->
                    <!--          <el-submenu index="1">-->
                    <!--            <template slot="title">-->
                    <!--              <i class="el-icon-location"></i>-->
                    <!--              <span>日程菜单</span>-->
                    <!--            </template>-->
                    <!--            &lt;!&ndash; 二级菜单 &ndash;&gt;-->
                    <!--            <el-menu-item index="1-1">-->
                    <!--              <template slot="title">-->
                    <!--                <i class="el-icon-location"></i>-->
                    <!--                <span>001</span>-->
                    <!--              </template>-->
                    <!--            </el-menu-item>-->
                    <!--          </el-submenu>-->

                    <el-menu-item index="1">
                        <i class="el-icon-menu"></i>
                        <span slot="title" @click="todo">日程菜单</span>
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <!-- 主体内容 -->
            <el-main>
                <!--路由占位符-->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: 'Home',
        data() {
            return {

            };
        },
        methods: {
            //安全退出
            logout() {
                window.sessionStorage.clear(); //清除session
                this.$router.push("/login"); //回到首页
            },

            todo() {
                this.$router.push("/todoList");

            }
        },
    };
</script>
<style lang="less" scoped>
    //布局器样式
    .home-container {
        height: 100%;
    }

    //头样式
    .el-header {
        background-color: #373d41;
        display: flex;
        justify-content: space-between; //左右贴边
        padding-left: 0%; //左边界
        color: #fff;

        > div {
            display: flex;
            font-size: 20px;
            align-items: center;

            span {
                margin-left: 15px;
            }
        }
    }

    //侧边栏样式
    .el-aside {
        background-color: #373d41;
    }

    //主体样式
    .el-main {
        background-color: #eaedf1;
    }

    img {
        width: 55px;
        height: 55px;
    }
</style>
