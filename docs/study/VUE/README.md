
  2019-10-15
================================================================================

## 环境搭建

### vue-cli

   npm install -g @vue/cli

   vue create vue-learn

   cd vue-learn

   npm run serve

## 模板语法

### 文本

  <span>Message:{{msg}}</span>

#### 原始HTML

  <p>User mustaches:{{ rawHtml }}</p>
  <p>Using v-html directive: <span v-html="rawHtml"></span></p>

#### 特性

  {{number + 1}}
  {{ok? "YES" "NO"}}

#### 表达式

### 指令

  <p v-if="see">现在看到了我把</p>

## 问题

###  props data区别

  data() {} 为什么是个函数
