<template>
    <div class="main-container">
      <div class="content-container">
        <AppHeader1 />
        <main class="main-content">
          <MainDashboard1 />
        </main>
      </div>
    </div>
</template>
<script>
import AppHeader1 from './AppHeader1.vue';
import MainDashboard1 from './MainDashboard1.vue';
export default {
  name: 'WaiterManagement',
  components: {
    AppHeader1,
    MainDashboard1
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
