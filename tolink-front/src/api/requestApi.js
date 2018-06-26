import config from '@/api/api.js'

export function LabelShow(params) {
  return config.fetchApi("http://192.168.1.124:1460/api/userFundChannel/v1/LabelShow", params, "GET", true).then(res => res.data);
};

export default {
  LabelShow
}