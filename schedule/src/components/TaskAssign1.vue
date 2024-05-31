<template>
 <el-card class="earnings-overview">
    <div slot="header" class="clearfix">
      <span class="headword">待做任务栏</span>
    </div>
    <div class="overview-cards">
      <div class="earning-cards">
        <div
          v-for="(item, index) in earnings"
          :key="index"
          class="card"
          :style="{ backgroundColor: generateColor(index) }"
          @click="handleCardClick(item)"
        >
          <div class="card-content">
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
  name: 'TaskAssign1',
  data() {
    return {
      earnings: [] // 菜品列表
    };
  },
  created() {
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
  '#FF9F00', // Orange-Red
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
     handleCardClick(item) {
      this.$emit('complete-task', item.quantity);
    }
  }
};
</script>

<style scoped>

.overview-cards {
  margin-bottom: 20px;
}

.earning-cards {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
}

.card {
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
.card-content {
  text-align: center;
  padding: 20px;
}

.card-content h3 {
  margin: 0;
  font-size: 1em;
}

.card-content h2 {
  margin: 5px 0 0;
  font-size: 1.5em;
}

@media (max-width: 768px) {
  .earning-cards {
    grid-template-columns: repeat(2, 1fr);
  }

  .card {
    margin-bottom: 20px;
    flex-basis: 100%;
  }

  .card:last-child {
    margin-bottom: 0;
  }
}
</style>