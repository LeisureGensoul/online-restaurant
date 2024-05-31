<template>
  <el-header class="header">
    <div class="logo">配送任务分配</div>
    <el-input placeholder="Search for..." prefix-icon="el-icon-search" class="search-input"></el-input>
    <div class="user-info">
      <el-badge is-dot><el-icon-message /></el-badge>
      <span class="username">服务员端</span>
      <el-avatar class="iconposition" icon="el-icon-user-solid" />
    </div>
  </el-header>
</template>

<script>
export default {
  name: 'AppHeader1'
};
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 30px;
  background-color: #fff;
  height: 60px; /* 固定高度 */
}

.logo {
  margin-left: 20px;
  font-size: 1.5em;
  font-weight: bold;
}

.search-input {
  flex: 1;
  margin: 0 20px;
}

.user-info {
  display: flex;
  align-items: center;
}

.item {
  margin-left: 20px;
}
.iconposition{
  margin-right: 20px;
}
.username {
  margin: 0 10px;
}
</style>
