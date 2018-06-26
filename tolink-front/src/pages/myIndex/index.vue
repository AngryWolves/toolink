<template>
<div>
  <p>我是首页内容</p>
  <p>我是首页内容</p>
</div>
</template>

<script>
import {
  LabelShow
} from '@/api/requestApi'
export default {
  data() {
    return {

    }
  },
  mounted() {
    let params = {
      labelType: 'skill'
    }

    LabelShow(params).then(res => {
      console.log(res, 'res');
    })
  }
}
</script>

<style lang="css">
</style>
