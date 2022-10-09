<template>
<div style="height:100%" xmlns:span="http://xmlns.jcp.org/xml/ns/persistence">
<el-container style="height:100%; border: 1px solid #eee">
  <el-aside :width="sidewidth + 'px' " style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']" style="min-height:100%;overflow-x:hidden"
              background-color="rgb(48,65,86)"
              text-color="#fff"
              active-text-color="#ffd04b"
              :collapse-transition="false"
              :collapse="isCollapse">
      <div style="height: 60px;line-height:60px;text-align: center">
        <img src="../assets/logo.png" alt="" style="width:30px;position: relative;top:5px;margin-left: 5px">
        <b style="color:white" v-show="logoTextShow">后台管理系统</b>
      </div>
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>
        <span slot="title">导航一</span>
        </template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>
          <span slot="title">导航二</span></template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>
          <span slot="title">导航三</span></template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="3-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="3-4">
          <template slot="title">选项4</template>
          <el-menu-item index="3-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </el-aside>

  <el-container>
      <el-header style="font-size: 12px;border-bottom:1px solid #ccc;line-height:60px;display: flex">
        <div style="flex:1;font-size:18px">
          <span  :class="collapseBtnClass" style="cursor:pointer" @click="collapse"></span>
        </div>
      <el-dropdown style="width: 50px; cursor:pointer">
        <i class="el-icon-arrow-down"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item></el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>

    <el-main>
      <div style="padding: 10px 0">
        <el-input style="width:200px" placeholder="请输入名称" suffix-icon="el-icon-search" ></el-input><el-button style="margin-left: 5px" type="primary">搜索</el-button>
      </div>
      <div style="margin:10px 0">
        <el-button type="primary">新增<i class="el-icon-circle-plus-outline"></i></el-button >
        <el-button type="primary">批量删除<i class="el-icon-circle-remove-outline"></i></el-button >
        <el-button type="primary">导入<i class="el-icon-bottom"></i> </el-button>
        <el-button type="primary">导入<i class="el-icon-top" ></i></el-button>
      </div>
      <el-table :data="tableData" border stripe="">
        <el-table-column prop="id" label="ID" width="80"></el-table-column>
        <el-table-column prop="username" label="用户名" width="140"></el-table-column>
        <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button type="warning">编辑<i class="el-icon-edit"></i></el-button>
            <el-button type="danger">删除<i class="el-icon-remove-outline"></i> </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="padding: 10px 0">
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2, 5, 10, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
      </el-pagination>
      </div>
    </el-main>
  </el-container>
</el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
data() {
  const item = {
    date: '2016-05-02',
    name: '王小虎',
    address: '上海市普陀区金沙江路 1518 弄'
  };
  return {
    total:0,
    pageNum:1,
    PageSize:2,
    tableData: [],
    collapseBtnClass:'el-icon-s-fold',
    isCollapse:false,
    logoTextShow:true,
    sideWidth:200
  }
},
  created(){
    this.load()
  },
  methods:{
    load(){
      fetch("http://localhost:9090/user/page?pageNum="+this.pageNum+"&pageSize="+this.pageSize).then(res=>res.json()).then(res=> {
        console.log(res)
        this.tableData = res.data
        this.total = res.total
      })
    },
    collapse(){
      this.isCollapse = !this.isCollapse
      if (this.isCollapse){
        this.sideWidth = 64

        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      }
      else {
        this.sideWidth = 200

        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum = pageNum
      this.load()
    }
  }
};
</script>
