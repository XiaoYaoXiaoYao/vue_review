import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import Home from "../components/Home";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    redirect: "/login"
  },
  {
    path: "/login",
    component: Login
  },
  {
    path: "/home",
    component: () => import(/* webpackChunkName: 'ImportFuncDemo' */ '../components/Home.vue'),
    redirect: "/welcome",
    children:[
      {
        path: "/welcome",
        component: () => import(/* webpackChunkName: 'ImportFuncDemo' */ '../components/welcome.vue')
      },
      {
        path: "/todoList",
        component: () => import(/* webpackChunkName: 'ImportFuncDemo' */ '../components/todo/index')
      }


    ]
  },

  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  routes
})

export default router
