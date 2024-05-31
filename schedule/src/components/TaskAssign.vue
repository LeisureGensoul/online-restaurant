<template>
 <el-card class="earnings-overview">
    <div slot="header" class="clearfix">
      <span class="headword">待做任务栏</span>
    </div>
    <div class="overview-taskcards">
      <div class="earning-taskcards">
        <div
          v-for="(item, index) in earnings"
          :key="index"
          class="taskcard"
          :style="{ backgroundColor: generateColor(index) }"
          @click="handletaskcardClick(item)"
        >
          <div class="taskcard-content">
            <h3>{{ item.name }}</h3>
            <h2>{{ item.quantity }}</h2>
          </div>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script>

export default {
  name: 'TaskAssign',
  data() {
    return {
      earnings: [] // 菜品列表
    };
  },
  mounted() {
    this.fetchEarnings();
  },
  methods: {
    fetchEarnings() {
      // 模拟后端请求
      this.earnings = [
        { name: 'Dish 1', quantity: 10 },
        { name: 'Dish 2', quantity: 20 },
        { name: 'Dish 3', quantity: 30 },
        { name: 'Dish 4', quantity: 40 },
        { name: 'Dish 5', quantity: 50 },
        { name: 'Dish 6', quantity: 60 },
        { name: 'Dish 7', quantity: 70 },
        { name: 'Dish 8', quantity: 80 }
      ];
    },
    generateColor(index) {
      const colors = [
  '#FF0000', // Red
 '#FF7500', // red to Yellow
  '#FF9F00', // Yellow
  '#7FFF00', // Yellow-Green
  '#00FF00', // Green
  '#00FF7F', // Green-Cyan
  '#00FFFF', // Cyan
  '#007FFF', // Cyan-Blue
  '#0000FF', // Blue
  '#7F00FF', // Blue-Purple
  '#FF00FF', // Purple
  '#FF007F', // Purple-Red
  '#FF1493', // Deep Pink
  '#FF4500'  // Orange-Red 2
];

      return colors[index % colors.length];
    },
    handletaskcardClick() {
      
    }
  }
};
</script>

<style scoped>

.overview-taskcards {
  margin-bottom: 20px;
}

.earning-taskcards {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
}

.taskcard {
  position: relative;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  cursor: pointer;
  color: #fff;
}
.headword{
  text-align: left;
  padding: 20px;
  font-size: 1.5em;
}
.taskcard-content {
  text-align: center;
  padding: 20px;
}

.taskcard-content h3 {
  margin: 0;
  font-size: 1em;
}

.taskcard-content h2 {
  margin: 5px 0 0;
  font-size: 1.5em;
}

@media (max-width: 768px) {
  .earning-taskcards {
    grid-template-columns: repeat(2, 1fr);
  }

  .taskcard {
    margin-bottom: 20px;
    flex-basis: 100%;
  }

  .taskcard:last-child {
    margin-bottom: 0;
  }
}
</style>