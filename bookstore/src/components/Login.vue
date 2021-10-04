<template>
   <div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item active">
		<router-link to="/">	<a class="btn btn-link" type="button" >首页</a></router-link>
		</li>
	</ul>
</nav>
	<div class="row-cols-1" >
		<div class="row-cols-2">
			<div class="col-md">
		<img style="border-radius: 50%" src="@/Image/logo1.png">
			</div>
		</div>
		<div class="row-cols-2" style="margin-top: 10px;border-bottom: 2px solid #cc0000" >
			<div class="col-md-3" style="border-bottom-right-radius: 90px;border-top-right-radius: 90px;background-color:#cc0000;border-bottom: 2px solid #cc0000">
			<h2 style="margin-left: 150px" class="title">欢迎登陆</h2>
			</div>
		</div>
	<div class="row-cols-1" style="text-align:center;font-size:20px;color:#cc0000;background-color: papayawhip"><i class="fa fa-location-arrow"  ></i>依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版《杰普隐私政策》已上线，将更有利于保护您的个人隐私。</div>
	<div class="row" style="height:575px;margin-left: 1px;background-color:darkseagreen;">
		<div class="col-md-4 column" style="height:100%" >
			<img src="@/Image/bg_login.png">
		</div>
		<div class="col-md-8" style="background-color:darkseagreen;" >
			<div class="col-md" style="border-top-right-radius: 50px;margin-left: 310px;width: 500px;margin-top:60px;background-color: honeydew;">
			<div style="font-size: 30px">
				<p>账号登录</p>
			</div>
				<div style="background-color: lightgoldenrodyellow">
			<p>公共场所请不要泄露您的密码，以防止账号丢失</p>
				</div>
			<div class="row" style="font-family: 微软雅黑;background-color: honeydew;" >
				<div class="container">
			<form class="form-horizontal" role="from" method="post">
				<div class="form-group">
					    <label style="font-family: 微软雅黑;font-size: 20px">账号:</label>
						<span class="input-group-addon glyphicon glyphicon-user"></span> <input  type="text" name="name"
						placeholder="邮箱/用户名/已验证手机号" class="form-control" id="uname" />
				</div>
				<div class="form-group " >
					<label style="font-family: 微软雅黑;font-size: 20px">密码:</label>
						<span class="input-group-addon  	glyphicon glyphicon-lock"></span> <input type="password"
						 placeholder="请输入密码" class="form-control" id="upass"/>
				</div>
				<div class="form-group">
						<input  @click="login()" value="登录" style="width: 100%" class="btn btn-success" />
				</div>
				<div class="treg">
					<router-link to="/register"> <a >&nbsp;立即注册</a></router-link>
					<span class=" 	glyphicon glyphicon-hand-right"></span>
				</div>
			</form>
				</div>
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
		<div class="links">
			<p>
				<span>关于我们</span>|
				<span>联系我们</span>|
				<span>加我我们</span>|
				<span>友情链接</span>
			</p>
		</div>
	</div>
</div>
    </div>
</template>
<script>
import tool from '@/components/publicTool'
import Cookie from 'js-cookie'
var result = null;
var pathis = null;
export default{
    data(){
            return{

            }
    },
    methods:{
        login:function (){//登录
				pathis = this
                if(Cookie.get("token") == null){
                        var u = tool.getElement("uname");
                        var p = tool.getElement("upass");
                        if( u.value ==="" || p.value==="" ){
                                alert("请输入完整")
                        }else {
                                this.$axios.post(tool.base_url1+"/login", {
                                         username: u.value,
                                         password: p.value
                                })
                                .then(function (response) { //成功
                                        result = response.data
                                        if(result.tokenId === null){
                                                 alert(result.code+result.resultRE)
                                         }else {
                                                 tool.U_name = result.username;
                                                 tool.token = result.tokenId
												 var mi = new Date().getTime();
												 var extime = new Date(mi+(60*1000*30))
												 Cookie.set("token",tool.token,{
													 expires:extime
												 })
												 Cookie.set("name",tool.U_name,{
													 expires:extime
												 })
                                                 alert(result.code+result.resultRE)
                                                pathis.$router.push("/")
                        }
                         })
                        .catch(function (error) {   //失败
                                 console.log(error);
                         });
                 }
                }else {
                        alert("你已登录，请退出后再登录")
                }
         }
    }
}
</script>

<style >

</style>