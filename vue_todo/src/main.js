import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import  './assets/css/global.css'
import axios from 'axios'

Vue.prototype.$http = axios
//设置axios访问根路径
axios.defaults.baseURL='http://localhost:9000'


Vue.config.productionTip = false

Vue.use(ElementUI);
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
