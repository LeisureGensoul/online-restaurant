// src/router/index.js
import Vue from 'vue';
import Router from 'vue-router';
import ChefManagement from '@/components/ChefManagement.vue';
import WaiterManagement from '@/components/WaiterManagement.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/chef',
      name: 'ChefManagement',
      component: ChefManagement
    },
    {
      path: '/waiter',
      name: 'WaiterManagement',
      component: WaiterManagement
    }
  ]
});
