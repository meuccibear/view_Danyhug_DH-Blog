<template>
  <div class="info">
    <img src="@/assets/images/logo.jpg" alt="">
    <div class="info-text">
      <p class="title">Danyhug</p>
      <p class="sub-title">我们原神玩家是这样的</p>
      <ul class="links">
        <li>
          <a href="">
            <p class="num">{{ data.articleCount }}</p>
            文章
          </a>
        </li>
        <span></span>
        <li>
          <a href="">
            <p class="num">{{ data.categoryCount }}</p>
            分类
          </a>
        </li>
        <span></span>
        <li>
          <a href="">
            <p class="num">{{ data.tagCount }}</p>
            标签
          </a>
        </li>
      </ul>

      <ul class="external-links">
        <li>
          <a href="https://github.com/Danyhug" target="_blank">
            <Icon iconName="icon-github1" iconSize="2.3"></Icon>
          </a>
        </li>
        <li>
          <a href="https://space.bilibili.com/38630127" target="_blank">
            <Icon iconName="icon-bilibili" iconSize="2.2" style="fill: rgb(250,116,153)"></Icon>
          </a>
        </li>
      </ul>
    </div>

    <Pet />
  </div>
</template>
<script setup lang="ts">
import Pet from '@/components/frontend/Pet.vue'
import { getOverview } from '@/api/user';
import { OverView } from '@/types/DashBoard';
const data = reactive<OverView>({
  articleCount: 0,
  categoryCount: 0,
  commentCount: 0,
  tagCount: 0
})

onMounted(async () => {
  const overview = await getOverview()
  Object.assign(data, overview)
})
</script>

<style scoped lang="less">
.info {
  padding-top: 24px;
  position: relative;
  height: 100vh;
}

.links {
  margin-top: 1.5rem;
  margin-bottom: 1.25rem;
  display: flex;
  justify-content: space-between;

  li {
    color: var(--grey-7);
    list-style: none;

    .num {
      font-weight: bold;
      font-size: 22px;
    }
  }

  span {
    display: block;
    border-left: 1px solid var(--grey-4);
  }
}

img {
  width: 9.375rem;
  height: 9.375rem;
  border-radius: 50%;
}

.info-text {
  line-height: 2.2em;
}

.external-links {
  text-align: center;

  li {
    display: inline-block;
    padding: 0 .9375rem;

  }
}
</style>