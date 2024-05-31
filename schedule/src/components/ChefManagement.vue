<template>
    <div class="main-container">
      <div class="content-container">
        <AppHeader />
        <main class="main-content">
          <MainDashboard />
        </main>
      </div>
    </div>
</template>
<script>
import AppHeader from './AppHeader.vue';
import MainDashboard from './MainDashboard.vue';
export default {
  name: 'ChefManagement',
  components: {
    AppHeader,
    MainDashboard
  }
};
</script>

<style>

.main-container {
  display: flex;
  width: 100%;
  height: 100%;
  background-color: #fff; /* 主容器背景色 */
  border-radius: 20px; /* 圆角 */
  overflow: hidden; /* 溢出隐藏 */
  box-shadow: 0 4px 8px rgba(250, 249, 249, 0.1); 
}

.content-container {
  display: flex;
  flex-direction: column;
  flex: 1;
}

.main-content {
  flex: 1;
  padding: 20px;
  background-color: #f8f9fc;
}
</style>
