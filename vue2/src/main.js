import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './router/global.css'



Vue.config.productionTip = false
Vue.use(ElementUI);
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')


// import Vue from 'vue';
// import ElementUI from 'element-ui';

//
// new Vue({
//   el: '#app',
//   render: h => h(App)
// });
