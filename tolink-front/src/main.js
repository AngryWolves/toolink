import Vue from 'vue'
import App from './App'
import '../static/css/reset.css' //引入全局的reset样式

Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue(App)
app.$mount()

export default {
  // 这个字段走 app.json
  config: {
    // 页面前带有 ^ 符号的，会被编译成首页，其他页面可以选填，我们会自动把 webpack entry 里面的入口页面加进去
    pages: [
      '^pages/inCome/main',
      'pages/outPut/main'
    ],
    window: {
      backgroundTextStyle: 'light',
      navigationBarBackgroundColor: '#fff',
      navigationBarTitleText: 'WeChat',
      navigationBarTextStyle: 'black'
    },
    tabBar: {
      list: [{
        pagePath: "pages/inCome/main",
        iconPath: 'static/incomeIcon.png',
        selectedIconPath: 'static/incomeIconSelect.png',
        text: "收入"
      }, {
        pagePath: "pages/outPut/main",
        iconPath: 'static/outputIcon.png',
        selectedIconPath: 'static/outputIconSelect.png',
        text: "支出"
      }]
    },
  }
}