<template>
    <div style="width:2000px">
    <div>
	<nav  class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<router-link to="/"><a class="btn btn-link" style="color:blue;border:1px solid blue" >首页</a></router-link>
			</li>
			<li class="nav-item">
				<a id="dis_name" class="nav-link disabled" ></a>
			</li>
		</ul>
	</nav>
	<div class="row-cols-1" style="border-bottom:2px solid #cc0000;margin-top: 100px;">
		<div class="col-md" style="border-top-right-radius: 45px;font-family:微软雅黑;font-size:35px;height:100%;width:200px;margin-left: 30px;background-color: #cc0000">
		欢迎注册
		</div>
	</div>
	<div class="row"  style="background-color:#009966;height: 600px;background-size: 100% 100%">
		<div class="col-md-12" style="text-align: center;background-color: antiquewhite">依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版《杰普隐私政策》已上线，将更有利于保护您的个人隐私。</div>
	<div class="col-md" style="width: 50px;height: 700px">
		<div class="row" style="height: 30px" ><p style="margin-left: 200px">用户注册:</p>
		<p style="margin-left: 100px">&nbsp;已经有账号<a href="login.html">去登录</a></p>
		</div>
		<div class="col-md" style="border-top-right-radius: 50px;border-bottom-right-radius: 50px;background-color:honeydew;margin-left:100px;height:460px;width: 900px">
			<form  role="from" method="post">
					<label class="col-sm-3 control-label">用户名：</label>
					<div class="col-sm-9">
						<input class="form-control" id="Username" type="text" placeholder="请输入您的用户名">
					</div>
					<label class="col-sm-3 control-label">密码：</label>
					<div class="col-sm-9">
						<input class="form-control" id="Password" type="password" placeholder="请设置您的密码">
					</div>
					<label class="col-sm-3 control-label">电话：</label>
					<div class="col-sm-9">
						<input class="form-control" id="U_phone" type="text" placeholder="请填写您的联系方式">
					</div>
					<label class="col-sm-3 control-label">电子邮箱：</label>
					<div class="col-sm-9">
						<input class="form-control" id="U_email" type="text" placeholder="请输入您的电子邮箱">
					</div>
					<div style="margin-top: 10px;margin-left: 20px;width: 30px" class="row">
						<input  type="checkbox">
					</div>
				<div class="row-col" style="margin-left: 20px;width: 300px" >
					我已阅读并同意《杰普隐私协议》
				</div>
					<div class="col-sm-12">
						<input onclick="registry()" style="width: 625px" class="form-control btn btn-danger" id="focusedInput"  value="立即注册">
					</div>
			</form>
		</div>
	</div>
	</div>
</div>
	<div style="border-top: 2px solid #cc0000;margin-top: 0px;text-align: center" class="row-cols-1">
		<div class="row">
			<div class="col-md-3 ">
				<img style="border-radius: 50%;" src="@/Image/icon_1_17.png">
				品目繁多 愉悦购物
			</div>
			<div class="col-md-3 ">
				<img style="border-radius: 50%;" src="@/Image/icon_1_20.png">
				正品保障 天天低价
			</div>
			<div class="col-md-3 ">
				<img style="border-radius: 50%;" src="@/Image/icon_1_23.png">
				极速物流 特色定制
			</div>
			<div class="col-md-3 ">
				<img style="border-radius: 50%;"  src="@/Image/icon_1_25.png">
				优质服务 以客为尊
			</div>
		</div>
		<div style="text-align: center">
			<p>
				<span>关于我们</span>|
				<span>联系我们</span>|
				<span>加我我们</span>|
				<span>友情链接</span>
			</p>
		</div>
	</div>
    </div>
</template>
<script>
import tool from '@/components/publicTool'
import Cookie from 'js-cookie'
export default {
  mounted(){
        this.getindex1()
        this.getindex2()
        this.getUserinfo()
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      im1:''
    }
  },
  }
</script>
<style scoped>

</style>