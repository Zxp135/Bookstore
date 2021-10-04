<template>
    <div>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<router-link to="/login"><a class="btn btn-link" type="button" style="color:blue;border:1px solid blue">登录</a></router-link>
			</li>
			<li class="nav-item active">
				<router-link to="/register"><a class="btn btn-link" style="color:blue;border:1px solid blue">注册</a></router-link>
			</li>
			<li class="nav-item active">
				<a class="btn btn-link" @click="getOrder()" style="color:blue;border:1px solid blue">我的订单</a>
			</li>
			<li class="nav-item active">
				<a class="btn btn-link" @click="loginout2()" style="color:blue;border:1px solid blue">退出</a>
			</li>
			<li class="nav-item active">
				<router-link to="/"><a class="btn btn-link" style="color:blue;border:1px solid blue">首页</a></router-link>
			</li>
			<li class="nav-item">
				<a class="nav-link disabled" id="dis_name">Disabled</a>
			</li>
		</ul>
	</nav>
	<div class="container mt-3">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<img src="@/Image/logo1.png" class="rounded" alt="Cinque Terre">
			</div>
			<div class="col-md-6 column">
				<div class="input-group search">
					<input id="searb" type="text" class="form-control" placeholder="请输入你要检索的书名" style="padding: 20px">
					<span @click="listsearch()" style="font-family: 微软雅黑;" class="input-group-text">
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
	<div class="nav" style="border-bottom: #cc0000">
		<div class="card text-black" style="font-size:20px;border-bottom: #cc0000;background-color: #cc0000; border-top-right-radius: 25px; width: 285px;margin-left: 15px">
			<div class="card-body" style="font-family: 微软雅黑;">全部图书分类 </div>
		</div>
		<div class="col-md-10 column marquee">
			<marquee  scrollamount="3"><span style="font-family: 微软雅黑;" class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
		</div>
	</div>
	<div class="col-md" style="width: 3000px">
		<div class="type-box row clearfix collapse on " id="typeMenu" >
			<dl>
				<dt>文学类:</dt>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
			</dl>
			<dl>
				<dt>文学类:</dt>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
			</dl>
			<dl>
				<dt>文学类:</dt>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
				<dd><a href="">文学类二级标题</a></dd>
			</dl>
		</div>
		<div id="box" class="row-cols-1">
			<dl>
				<dt>价格：</dt>
				<dd><button  @click="forprice" id="10-50" style="height: 19px;background-color: white;border: white solid 1px"><a>0-50</a></button></dd>
				<dd ><button @click="forprice" id="50-90" style="height: 19px;background-color: white;border: white solid 1px"> 50-90</button></dd>
				<dd ><button @click="forprice" id="90以上" style="height: 19px;background-color: white;border: white solid 1px">>90</button></dd>
			</dl>
			<dl class="select" style="height:55px;border-bottom-width: 0px;">
				<dt>已选条件：</dt>
			</dl>
		</div>
		<div style="text-align: center" class="row">
			<div class="row" style=" margin-left: 0px;height: 40px; border-bottom:1px solid #b3b7bb; background-color: white;width: 2000px">
				<ul class="breadcrumb" style="height: 100%">
					<li>
						<a href="index.html">首页</a>
					</li>
					<li class="active">
						/筛选结果
					</li>
				</ul>
				<div class="col" style="width:300px;height: 40px">
					<div class="container" style="width: 100%">
						<ul class="pagination">
							<li class="page-item active"><a class="page-link" onclick="listearly()" >上一页</a></li>
							<li class="page-item" onclick="" id = "ls1"></li>
							<li class="page-item " id = "ls2"></li>
							<li class="page-item" id = "ls3"></li>
							<li class="page-item" onclick="listnext()"><a  class="page-link" >下一页</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-3" style="margin-top: 5px" >
				<a >
					<img id = "de1" style="margin-left:30px;height: 300px" src="@/Image/default.jpg" />
					<h4 id="dde1">
						无
					</h4>
					<p id = "dee1">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
				
						<button style="width:90px;margin-left:10px" id="dl1" @click="listincar" class="btn btn-danger">加入书包</button>
					
					<a id="dd1"  @click="listpay" style="width:90px;margin-left: 10px"  class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3 " style="margin-top: 5px">
				<a >
					<img id = "de2" style="height: 300px" src="@/Image/default.jpg" />
					<h4 id="dde2">
						无
					</h4>
					<p id = "dee2">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
					
						<button style="width:90px;margin-left:10px" id="dl2" @click="listincar" class="btn btn-danger">加入书包</button>
				
					<a id="dd2" @click="listpay" style="width:90px;margin-left: 10px"  class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3" style="margin-top: 5px">
				<a >
					<img id = "de3" style="height: 300px" src="@/Image/default.jpg" />
					<h4 id="dde3">
						无
					</h4>
					<p id = "dee3">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
			
						<button style="width:90px;margin-left:10px" id="dl3" @click="listincar" class="btn btn-danger">加入书包</button>
					
					<a id="dd3"  @click="listpay" style="width:90px;margin-left: 10px" class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3 " style="margin-top: 5px">
				<a >
					<img  id = "de4" style="height: 300px"  src="@/Image/default.jpg" />
					<h4 id="dde4">
						无
					</h4>
					<p id = "dee4">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
				
						<button style="width:90px;margin-left:10px" id="dl4" @click="listincar" class="btn btn-danger">加入书包</button>
					
					<a id="dd4" @click="listpay" style="width:90px;margin-left: 10px" class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3 " style="margin-top: 5px">
				<a >
					<img id = "de5" style="height: 300px"  src="@/Image/default.jpg" />
					<h4 id="dde5">
						无
					</h4>
					<p id = "dee5">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
					
						<button style="width:90px;margin-left:10px" id="dl5" @click="listincar" class="btn btn-danger">加入书包</button>
					
					<a id="dd5" @click="listpay" style="width:90px;margin-left: 10px"  class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3 " style="margin-top: 5px">
				<a >
					<img id = "de6" style="height: 300px"  src="@/Image/default.jpg" />
					<h4 id="dde6">
						无
					</h4>
					<p id = "dee6">0</p>
				</a>
				<div class="row" style="margin-left: 129px">

						<button style="width:90px;margin-left:10px" id="dl6" @click="listincar" class="btn btn-danger">加入书包</button>

					<a id="dd6" @click="listpay" style="width:90px;margin-left: 10px"  class="btn btn-warning">立即购买</a>
				</div>
			</div>
			<div class="col-md-3 " style="margin-top: 5px">
				<a >
					<img id = "de7"  style="height: 300px"  src="@/Image/default.jpg" />
					<h4 id="dde7">
						无
					</h4>
					<p id = "dee7">0</p>
				</a>
				<div class="row" style="margin-left: 129px">
						<button style="width:90px;margin-left:10px" id="dl7" @click="listincar" class="btn btn-danger">加入书包</button>
					<a  id="dd7" @click="listpay" style="width:90px;margin-left: 10px"  class="btn btn-warning">立即购买</a>
				</div>
			</div>	<div class="col-md-3 " style="margin-top: 5px">
			<a >
				<img id = "de8" style="height: 300px"  src="@/Image/default.jpg" />
				<h4 id="dde8">
					无
				</h4>
				<p id = "dee8">0</p>
			</a>
			<div class="row" style="margin-left: 129px">
					<button style="width:90px;margin-left:10px" id="dl8" @click="listincar" class="btn btn-danger">加入书包</button>
				<a id="dd8" @click="listpay" style="width:90px;margin-left: 10px" class="btn btn-warning">立即购买</a>
			</div>
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
var result1 = null
var listall = 0;//总条数
var listnum = 0; //总页数
var listnow = 1;//当前页
export default {
	created(){
			let _this = this
			window.getindexlist = this.getindexlist
},
    mounted(){
        this.getUserinfo()
		this.listgetshow(this)
    },
     methods:{
		 toScar:function(){
			 	tool.toScar2(this)
		 },
	getUserinfo:function(){  //获取用户信息
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
		//列表页展示
 listgetshow:function (me){
    var num = listnow
    me.$axios.post(tool.base_url5+"/getforname",num, {
        headers: {
            'Content-Type': 'application/json',
            'charset':'utf-8'
        }
    }).then(function (res){
        result1 = res.data
		console.log(result1);
        if(result1!=null){
				 for(var i = 0;i<=7;i++){
           					var im = tool.getElement("de"+(i+1));
          					 var n = tool.getElement("dde"+(i+1))
        			   		var p = tool.getElement("dee"+(i+1))
        			  		 im.src = "/static/Image/default.jpg"
        			  		 n.innerHTML = ""
         			 		p.innerHTML = ""
     				  }
            for(var i = 0;i<result1.length;i++){
                var im = tool.getElement("de"+(i+1));
				console.log(im);
                var n = tool.getElement("dde"+(i+1))
                var p = tool.getElement("dee"+(i+1))
                im.src = "/static/"+result1[i].book_url
                n.innerHTML = result1[i].book_name
                p.innerHTML = result1[i].book_price+"￥"
            }
        }else if(result1.length == 0) {
            alert("没有相关书籍");
        }
    }).catch(function (err){
        console.log(err)
    })
},
//获取总数
 getalllist:function(){
    this.$axios.get(tool.book_url5+"/ln").then(
        function (res){
            listall = res.data
            if(listall === 0) return
            listnum = listall%8 == 0 ? listall/8 : listall/8+1
            for(var j = 1;j<=listnum;j++){
                var ww = "ls"+j
                x1 = tool.getElement(ww);
                x1.innerHTML =" "
            }
            if(listnum > 3 ){
                for(var i = 1;i<=3;i++){
                    var ww = "ls"+i
                    x1 = tool.getElement(ww);
                    x1.innerHTML += "<a class='page-link' onclick='getindexlist(this)' id = '"+i+"'>"+i+"</a>"
                }
            }else {
                for (var j = 1; j <= listnum; j++) {
                    var ww = "ls" + j
                    x1 = tool.getElement(ww);
                    x1.innerHTML += "<a  class='page-link' onclick='getindexlist(this)' id = '" + j + "'>" + j + "</a>"
                }
            }
        }
    ).catch(function (err){
        console.log(err)
    })
},//列表页下一页
 listnext:function(){
        if(listnow > listall ){
            alert("最后一页了")
        }else {
            var x2 = parseInt(listnow)
            listnow = x2 + 1
             this.$options.methods.listgetshow(this)
        }
},
//列表页上一页
 listearly:function (){
    if(listnow <= 1 ){
        alert("最前一页")
    }else {
        listnow -= 1
        this.$options.methods.listgetshow(this)
    }
},
//获取点击页
 getindexlist:function(x){
        listnow = x.id
         this.$options.methods.listgetshow(this)
},
//列表加入购物车
 listincar:function(x){
	 var x1 = x.currentTarget.id
    var x2 = x1[x1.length-1]-1
    if(Cookie.get('token')!=null && result1 != null){
    axios.post(tool.book_url4+"/incar",JSON.stringify({
        book_name:result1[x2].book_name,
        book_url:result1[x2].book_url,
        book_num:1,
        book_price:result1[x2].book_price,
        usernmae:name
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
}else {
    alert("未登录")
}
},
//列表购买
 listpay:function(x){
	 var x1 = x.currentTarget.id
    var sl = result1[x1[x1.length-1]-1]
    sl.book_num = 1
    if(sl!=null){
    axios.post(tool.book_url4+"/buy",JSON.stringify({
        book_price:sl.book_price,
        book_name:sl.book_name,
        book_url:sl.book_url,
        order_pay:sl.book_price*sl.book_num,
        book_num:1,
        username:name
    }),{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(function (res){

        if(res.data.TookenId===null){
            alert("购买失败")
        }
        alert(res.data.resultRE)
    }).catch(function (err){
        console.log(err)
    })
    }else {
        alert("请点击正确的商品")
    }
},
//列表页搜索
 listsearch:function(){
	 var _th = this
    var x = tool.getElement("searb")
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
				
                 _th.$options.methods.listgetshow(_th)
            } else {
                alert(res.data.resultRE);
            }
        }).catch(function (err) {
            console.log(err)
        })
    }
},
//价格区间
 forprice:function(x){
    var min = x.currentTarget.id
   this.$axios.post(tool.base_url5+"/getforprice",min,{
       headers: {
           'Content-Type': 'application/json',
           'charset':'utf-8'
       }
   }).then(function (res){
       result1 = res.data
       console.log(result1)
       for(var i = 0;i<=7;i++){
           var im = tool.getElement("de"+(i+1));
           var n = tool.getElement("dde"+(i+1))
           var p = tool.getElement("dee"+(i+1))
           im.src = "/static/Image/default.jpg"
           n.innerHTML = ""
           p.innerHTML = ""
       }
       for(var i = 0;i<result1.length;i++){
           console.log("wwwwwwwwwwwwwwww")
           console.log(result1[i+1])
           var im =tool. getElement("de"+(i+1));
           var n = tool.getElement("dde"+(i+1))
           var p = tool.getElement("dee"+(i+1))
           im.src = "/static/"+result1[i].book_url
           n.innerHTML = result1[i].book_name
           p.innerHTML = result1[i].book_price+"￥"
       }
   }).catch(function (err){
       console.log(err)
   })
},
loginout2:function(){
	tool.loginout(this,tool.base_url1+"/loginout")
},
getOrder:function(){
	tool.getorder(this)
}
}
}
</script>
<style>
				dl,
			    dd {
					margin: 0;
				}

				#box {
					background: rgba(255, 255, 255, 0.8);
					box-shadow: 0 0 10px rgba(73,66,66,.1);
					border: 1px solid #E5E5E5;
				}

				#box dl {
					height: 50px;
					line-height: 50px;
					border-bottom: 1px dashed #dadada;
					margin: 0 20px;
					display: block;
				}

				#box dt {
					display: inline-block;
					vertical-align: middle;
					color: #8a8a8a;
				}

				#box dd {
					display: inline-block;
					vertical-align: middle;
					color: #252525;
					margin: 0 10px;
					font-size: 14px;
					cursor: pointer;
				}

				#box dd.active {
					color: var(--color);
					font-weight: bold;
				}

				#box dl.select {
					background: #efefef;
					margin: 0;
					padding: 0 20px;
				}

				#box dl.select dd{
					border: 1px solid var(--color);
					height: 25px;
					line-height: 25px;
					margin-top: 13px;
					padding: 0 2px 0 10px;
					border-radius: 3px;background-color: #fff;
				}
				#box dl.select dd span{
					width: 20px;
					height: 20px;
					display: inline-block;
					text-align: center;
					line-height: 20px;
					background: #c4284d;
					color: #fff;
					margin-left: 10px;
					cursor: pointer;border-radius: 5px;
				}
</style>
