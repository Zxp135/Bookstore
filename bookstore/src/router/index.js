import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/Login'
import list from '@/components/list'
import register from '@/components/register'
import shopcar from '@/components/shopCar'
import viewbook from '@/components/viewBook'
import order from '@/components/order'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },{
      path:'/login',
      name:'Login',
      component:login
    },{
        path:'/list',
        name:'list',
        component:list
    },{
      path:'/register',
      name:'register',
      component:register
  },{
    path:'/shopcar',
    name:'shopCar',
    component:shopcar
},{
  path:'/viewbook',
  name:'viewbook',
  component:viewbook
},{
  path:'/order',
  name:'order',
  component:order
}
  ]
})
