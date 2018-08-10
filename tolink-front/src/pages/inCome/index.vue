<template>
<div>
  <p>收入</p>
</div>
</template>

<script>
import {} from '@/api/requestApi'
export default {
  data() {
    return {

    }
  },
  mounted() {
    wx.login({
      success: function(res) {
        console.log(res);
      }
    });
  }
}
</script>

<style scoped>

</style>
