// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'bootstrap/dist/css/bootstrap.css'
import 'jquery/src/jquery'
import $ from 'jquery'
import axios from 'axios'
// import 'bootstrap/dist/js/bootstrap.js'
// import 'popper.js/dist/esm/popper.js'
import mylogin from '@/components/HelloWorld'

Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.prototype.loginname = mylogin
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
