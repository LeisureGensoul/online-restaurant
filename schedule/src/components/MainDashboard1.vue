<template>
  <el-main class="dashboard">
    <div class="overview-cards">
      <el-card class="card card-total-tasks">
        <div class="card-content">
          <div class="card-info">
            <h3>    Total   Tasks</h3>
            <h2>       {{ totalTasks }}</h2>
          </div >
          <div class="card-icon-container">
          <img src="@/assets/tasks.svg" class="card-icon" alt="Total Tasks"/>
          </div>
        </div>
      </el-card>
      <el-card class="card card-ongoing-tasks">
        <div class="card-content">
          <div class="card-info">
            <h3> Ongoing Tasks</h3>
            <h2> {{ ongoingTasks }}</h2>
          </div>
          <div class="card-icon-container">
          <img src="@/assets/ongoing.svg" class="card-icon" alt="Ongoing Tasks"/>
          </div>
        </div>
      </el-card>
      <el-card class="card card-completed-tasks">
        <div class="card-content">
          <div class="card-info">
            <h3>Completed Tasks</h3>
            <h2>{{ completedTasks }}</h2>
          </div>
          <div class="card-icon-container">
          <img src="@/assets/completed.svg" class="card-icon" alt="Completed Tasks"/>
          </div>
        </div>
      </el-card>
    </div>
    <el-card class="cooked-overview">
    <div slot="header" class="clearfix">
      <span class="headword">待配送任务栏</span>
    </div>
    <div class="overview-taskcards">
      <div class="earning-taskcards">
        <div
          v-for="(item, index) in filteredcooked"
          :key="index"
          class="taskcard"
          :style="{ backgroundColor: generateColor(index) }"
          @click="handletaskcardClick(item)"
        >
          <div class="taskcard-content">
            <h3>{{ item.name }}</h3>
            <h2>配送桌号：{{ item.table_id }}</h2>
          </div>
        </div>
      </div>
    </div>
  </el-card>
  </el-main>
</template>


<script>
import axios from 'axios';
const instance = axios.create()
export default {
  name: 'MainDashboard1',
  created() {
    this.initializeCompletedTasks();
    this.scheduleDailyReset();
  },
   data() {
    return {
      totalTasks: 0,
      ongoingTasks: 0,
      completedTasks: 0,
      cooked:[],
      axios: null
    };
  },
   computed: {
    filteredcooked() {
      return this.cooked.filter(item => item.wait_num !== 0);
    }
  },
  mounted() {
    this.fetchcooked();
    this.interval = setInterval(this.fetchcooked, 5000); // 每5秒获取一次数据
  },
  beforeDestroy() {
    clearInterval(this.interval);
  },
   methods: {
    fetchcooked() {
      // 后端请求
      instance.get('/api/cooked')
        .then(response => {
          console.log("服务器返回的数据:", response.data.cooked);
          this.cooked = response.data.cooked;
          this.ongoingTasks = this.cooked.reduce((acc) => acc + 1, 0);
          this.totalTasks=this.ongoingTasks+this.completedTasks;
        })
        .catch(error => {
          console.error('Error fetching cooked:', error);
        });
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
    handletaskcardClick(item) {
      // instance.delete('/api/dish', {payload}).catch(console.log("temp"));
      // 发送DELETE请求到服务器
      const id=item.id;
      instance.post('/api/cooked/' + id)
        .then(response=> {
          this.completedTasks+=1;
          this.ongoingTasks-=1;
          this.cooked = this.cooked.filter(e => (e.name !== item.name) && (e.table_id !== item.table_id));
          this.totalTasks=this.ongoingTasks+this.completedTasks;
          console.log('Server response:', response.status);
        })
        .catch(error => {
          console.error('Error sending request:', error);
        });
    },
    initializeCompletedTasks() {
      const today = new Date().toISOString().split('T')[0];
      const storedDate = localStorage.getItem('lastResetDate');
      if (storedDate !== today) {
        this.completedTasks = 0;
        localStorage.setItem('lastResetDate', today);
      } else {
        this.completedTasks = parseInt(localStorage.getItem('completedTasks1') || '0');
      }
    },
    scheduleDailyReset() {
      const now = new Date();
      const millisTillMidnight = new Date(now.getFullYear(), now.getMonth(), now.getDate() + 1, 0, 0, 0, 0) - now;
      setTimeout(() => {
        this.completedTasks = 0;
        localStorage.setItem('lastResetDate', new Date().toISOString().split('T')[0]);
        this.scheduleDailyReset(); // 设置下次重置的定时器
      }, millisTillMidnight);
    }
  },
  watch: {
    completedTasks(newVal) {
      localStorage.setItem('completedTasks1', newVal);
    }
  }
};
</script>

<style scoped>
.dashboard {
  padding: 20px;
  background-color: #f8f9fc;
}

.overview-cards {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  flex-wrap: wrap;
}

.card {
  position: relative;
  flex: 1;
  margin-right: 20px;
  border-radius: 15px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  display: flex;
  align-items: center;
}

.card:last-child {
  margin-right: 0;
}

.card-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
}

.card-info {
  white-space: pre;
  text-align: left;
}

.card-info h3 {
  margin: 0;
  font-size: 1.5em;
  color: #6c757d;
}

.card-info h2 {
  margin: 5px 0 0;
  font-size: 1.5em;
  color: #333;
}
.card-icon-container {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  right: 85px;
  bottom: 35px;
}
.card-icon {
  width: 75px;
  height: 75px;
  opacity: 0.5;
}

.card:before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 100%;
  border-radius: 8px 0 0 8px;
}

.card-total-tasks:before {
  background-color: #3498db;
}

.card-total-tasks .card-info h3 {
  color: #3498db;
}

.card-ongoing-tasks:before {
  background-color: #2ecc71;
}

.card-ongoing-tasks .card-info h3 {
  color: #2ecc71;
}

.card-completed-tasks:before {
  background-color: #1abc9c;
}

.card-completed-tasks .card-info h3 {
  color: #1abc9c;
}

@media (max-width: 768px) {
  .card {
    margin-bottom: 20px;
    flex-basis: 100%;
  }

  .card:last-child {
    margin-bottom: 0;
  }
}
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
  font-size: 1.2em;
}

.taskcard-content h2 {
  margin: 5px 0 0;
  font-size: 1.2em;
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


