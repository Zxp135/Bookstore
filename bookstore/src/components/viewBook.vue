<template>
    <div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item active">
		<router-link to="/login">		<a class="btn btn-link" style="color:blue;border:1px solid blue" >登录</a></router-link>
		</li>
		<li class="nav-item active">
		<router-link to="/register">	<a class="btn btn-link"  style="color:blue;border:1px solid blue">注册</a></router-link>
		</li>
		<li class="nav-item active">
			<router-link to="/">		<a class="btn btn-link" style="color:blue;border:1px solid blue">首页</a></router-link>
		</li>
		<li class="nav-item active">
			<a class="btn btn-link" @click="getOrder()" style="color:blue;border:1px solid blue">我的订单</a>
		</li>
		<li class="nav-item active">
			<a class="btn btn-link" @click="loginout()" style="color:blue;border:1px solid blue">退出</a>
		</li>
		<li class="nav-item">
			<a class="nav-link disabled" id="dis_name">Disabled</a>
		</li>
	</ul>
</nav>
<div class="container mt-3">
	<div class="row clearfix">
		<div class="col-md-3 column">
			<img src="Image/logo1.png" class="rounded" alt="Cinque Terre">
		</div>
		<div class="col-md-6 column">
			<div class="input-group search">
				<input id="sear" type="text" class="form-control" placeholder="请输入你要检索的书名" style="padding: 20px">
				<span @click="indexsearch()" style="font-family: 微软雅黑;" class="input-group-text">
                 搜索
                    </span>
			</div>
		</div>
		<div class="col-md-3" >
			<a @click="toScar()">
				<button class="btn btn-danger" style="font-family: 微软雅黑;font-size: 30px" >
					<i class="fa fa-truck" style="font-size:48px;color:black"></i>&nbsp;我的书包
				</button>
			</a>
		</div>
	</div>
</div>
<div class="row" style="border-bottom: 2px solid #cc0000">
	<div class="card text-black" style=" background-color: #cc0000; border-top-right-radius: 25px; width: 285px;margin-left: 25px">
		<div class="card-body" style="font-family: 微软雅黑;">书籍详情 </div>
	</div>
	<div class="col-md-10 column marquee">
		<marquee  scrollamount="3"><span style="font-family: 微软雅黑;" class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
	</div>
</div>
	<div class="row" style="background-color: white;width:1950px;height: 600px">
			<div class="col-md-5" style="border: 1px solid black;margin-left:120px;width: 650px;height: 607px;border:1px solid darkgray;">
				<div class="col-md" style="margin-top:10px;margin-left: 80px">
					<img id="vim1" class="img-thumbnail" src="Image/book1.jpg">
				</div>
				<div class="row" style="height:200px;margin-top:20px;margin-top: 20px">
					<div class="col-sm-6 col-md-3">
						<img id="vim2" class="img-thumbnail hover" src="Image/book1.jpg">
					</div>
					<div class="col-sm-6 col-md-3">
						<img id="vim3" class="img-thumbnail" src="Image/book1.jpg">

					</div>
					<div class="col-sm-6 col-md-3">
						<img id="vim4" class="img-thumbnail" src="Image/book1.jpg">

					</div>
					<div class="col-sm-6 col-md-3">
						<img id="vim5" class="img-thumbnail" src="Image/book1.jpg">
					</div>
				</div>
			</div>
			<div class="col-md-5" style="font-size: 20px;font-family:宋体;font-weight:700;margin-left:100px;background-color:white;height: 600px">
				<div class="row-cols-1" style="margin-top: 100px">
					<label class="col-md-3" >书名：</label>
					<span id="sp1">javaEE 轻量级框架</span>
				</div>
				<div class="row-cols-1 ">
					<label class="col-md-3 ">价格：</label>
					<span id="sp2">125.9</span>
				</div>
				<div class="row-cols-1 ">
					<label class="col-md-3 ">出版社：</label>
					<span id="sp3"></span>
				</div>
				<div class="row-cols">
					<label class="col-md-3">服务：</label>
					<img src="@/Image/service_03.png">
					<small>分期付款</small>
					<img src="@/Image/service_05.png">
					<small>免运费</small>
					<img src="@/Image/service_07.png">
					<small>送货上门</small>
					<img src="@/Image/service_09.png">
					<small>7天无理由退换</small>
				</div>
				<hr>
				<div class="row-cols-1" style="background-color: #cc0000">
					<div id="box" >
						<dl>
							<dt class="col-md-3" style="" >包装：</dt>
							<dd style="	margin-left: 10px;">简单装</dd>
							<dd style="	margin-left: 10px;">升级装</dd>
							<dd  style="	margin-left: 10px;">精品装</dd>
							<dd style="	margin-left: 10px;">至尊装</dd>
						</dl>
					</div>
				</div>
				<div class="row" style=" margin-left:200px;width: 100%;">
						<button @click="viewincar()" style="width:110px;font-size:20px;" class="btn btn-danger">加入书包</button>
						<p class="col-md-2"></p>
							<button @click="buy2()" style="width:110px;font-size:20px;" class="btn btn-warning">立即购买</button>
					</div>
				</div>

	</div>
<div style="border-top: 2px solid #cc0000;margin-top: 5px;text-align: center" class="row-cols-1">
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
var nowres = null;
var allbnum = 1
export default {
  mounted(){
      this.getview()  
	  this.getUserinfo()
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
    }
  }, 
  methods:{
	    //获取详情
  getview : function(){
	  this.$axios.get(tool.base_url3+"/gettouch").then(function (res){
     	  nowres = res.data;
    	  var vim ;
    	  var sp;
    	  var sp2;
     	  var sp3;
      	 sp = tool.getElement("sp1")
      	 sp2 = tool.getElement("sp2")
      	 sp3 = tool.getElement("sp3")
     	  sp2.innerHTML = res.data.book_price
     	  sp.innerHTML=res.data.book_name
      	  sp3.innerHTML=res.data.book_where
     	 for(var i = 0;i<5;i++){
     	 vim = tool.getElement("vim"+(i+1))
     	 vim.src = "/static/"+res.data.book_url
    	 }
  	 }).catch(function (err){
       console.log(err)
  	 })
  },
 getOrder:function(){ //订单
	  tool.getorder(this)
 } 
  ,
 loginout:function(){
	 tool.loginout(this,tool.base_url1+"/loginout")
 } 
  ,
  getUserinfo:function(){  //获取用户信息
		console.log("啦啦啦啦啦");
        var indexdis = "未登录";
        var titlename = tool.getElement("dis_name")
        var t = Cookie.get("token")
        if(t!=null){
            titlename.style.color = "red"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = Cookie.get("name")
        }else{
            titlename.style.color = "grey"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = indexdis
            }
    },
	//详情页加入购物车
 viewincar:function(){
    this.$axios.post(tool.base_url4+"/incar",JSON.stringify({
        book_name:nowres.book_name,
        book_url:nowres.book_url,
        book_num:1,
        book_price:nowres.book_price,
		username:Cookie.get('name')
    }),{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(function (res){
        if(res.data.tokenId!=null){
            alert(res.data.resultRE)
        }
        else {
            alert("加入失败")
        }
    }).catch(function (err){
        console.log(err)
    })
},//购买
 buy2:function(){
    console.log(nowres)
    var mon = nowres.book_price*allbnum
    this.$axios.post(tool.base_url4+"/buy",JSON.stringify({
            order_price:nowres.order_price,
            book_price:nowres.book_price,
            book_name:nowres.book_name,
            book_url:nowres.book_url,
            order_pay:mon,
            book_num:allbnum,
            username:Cookie.get('name')
    }),{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(function (res){
		if(res == null){
			alert("没有登陆信息")
		}else if(res.data.TookenId===null){
            alert("购买失败")
        }else{
        	alert(res.data.resultRE)
			}
    }).catch(function (err){
        console.log(err)
    })

},
//首页查询
indexsearch:function (){
    var _th = this
    var x = tool.getElement("sear")
    var x_name = x.value
    console.log(x_name)
    if(x_name === ""){
        alert("请输入查询的书名")
    }else {
        this.$axios.post(tool.base_url5+"/getfn", x_name, {
            headers: {
                'Content-Type': 'application/json',
                'charset':'utf-8'
            }
        }).then(function (res) {
            if (res.data.tokenId != null) {
                _th.$router.push('/list')
            } else {
                alert(res.data.resultRE);
            }
        }).catch(function (err) {
            console.log(err)
        })
    }
},
toScar:function(){
	tool.toScar2(this)
}
  
  }
  }
</script>
<style scoped>
.body ul.breadcrumb{
		font-size: 16px;
		font-weight: bolder;
		padding: 20px 0px 10px 50px;
		margin-bottom: 0px;
		background: #fff;
		border-radius: 0px;
		border-bottom: 1px solid #eee;
	}
	.body ul.breadcrumb a{
		color: #2c49e5 !important;
	}
	dl{
		clear: left;
	}
	dd,dt{
		float: left;

	}
</style>