<template>
  <el-aside width="250px" class="sidebar">
    <div class="logo-container">
      <img src="@/assets/logo.png" alt="Logo" class="logo" />
      <span class="title">调度系统</span>
    </div>
    <el-menu :default-active="activeIndex" class="el-menu-vertical-demo"  router>
      <el-menu-item index="/chef" class="menu-item">
        <img src="@/assets/chef.svg" class="icon" />
        <span class="menu-text">厨师管理</span>
      </el-menu-item>
      <el-menu-item index="/waiter" class="menu-item">
        <img src="@/assets/waiter.svg" class="icon" />
        <span class="menu-text">服务员管理</span>
      </el-menu-item>
    </el-menu>
    <div class="svg-container">
      <img src="@/assets/platfrom.svg" alt="Vector Image" class="svg-image" />
    </div>
  </el-aside>
</template>

<script>
export default {
  name: 'AppSidebar',
  data() {
    return {
      activeIndex: this.$route.path
    };
  },
  watch: {
    $route(to) {
      this.activeIndex = to.path;
    }
  },

};
</script>

<style scoped>
.sidebar {
  background-color: #4A90E2; /* 设置侧边栏背景色 */
  color: #fff;
  padding-top: 20px;
  overflow: hidden;
}

.logo-container {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 40px;
}

.logo {
  width: 40px;
  height: 40px;
  margin-right: 10px;
}

.title {
  font-size: 2em;
  font-weight: bold;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 100%;
}

.el-menu-vertical-demo {
  background-color: transparent;
}

.menu-item {
  height: 80px;
  display: flex;
  align-items: center;
  border-bottom: 1px solid rgba(255, 255, 255, 0.3); /* 设置分隔线 */
}

.menu-item .icon {
  margin-left: 20px;
  margin-right: 20px;
  width: 24px;
  height: 24px;
}
.svg-container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}
.svg-image {
  width: 200px;
  height: 200px;
  margin-top: 450px;
}
.menu-link {
  display: flex;
  align-items: center;
  color: inherit;
  text-decoration: none;
}
.menu-text {
  color: inherit; /* 确保文字颜色与父元素一致 */
  margin-left: 10px; /* 与图标保持间距 */
}
</style>
