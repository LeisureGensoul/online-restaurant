<template>
  <div id="app">
    <div class="main-container">
      <AppSidebar />
      <el-main>
        <router-view />
      </el-main>
    </div>
  </div>
</template>

<script>
import AppSidebar from './components/AppSidebar.vue';
import router from './router';
export default {
  name: 'App',
  components: {
    AppSidebar
  },
  router
};
</script>

<style>
#app {
  display: flex;
  justify-content: center; /* 居中 */
  align-items: center; /* 居中 */
  height: 100vh;
  background-color: #ffffff; /* 页面背景色 */
}



</style>
