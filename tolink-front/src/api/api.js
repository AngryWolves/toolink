const API_URL = 'http://192.168.1.124:1460';
const gatewayToken = '';
// const Promise = require('./bluebird');


function fetchApi(URL, params, method, GWToken) {
  // 用户登录时需要将access_token存在storage里面
  // var token = wx.getStorageSync('access_token');
  if (GWToken) {
    var header = {
      "Content-Type": "application/json", //post
      "Authorization": '6ea026a7b1b8936c19b9e79d2ed3ef20c06805aa900ebc6346133e3fd5595f6a'
    }
  } else {
    var header = {
      "Content-Type": "application/json", //post
    }
  }
  return new Promise((resolve, reject) => {
    wx.request({
      url: URL,
      data: params,
      method: method,
      header: header,
      success: resolve,
      fail: reject,
    })
  })
}

export function toParams(obj) {
  var param = ""
  for (const name in obj) {
    if (typeof obj[name] != 'function') {
      param += "&" + name + "=" + encodeURI(obj[name])
    }
  }
  return param.substring(1)
}


export default {
  API_URL,
  fetchApi
}