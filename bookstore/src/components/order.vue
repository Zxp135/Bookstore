<template>
    <div>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<router-link to="/login"><a class="btn btn-link" type="button" style="color:blue;border:1px solid blue">登录</a></router-link>
			</li>
			<li class="nav-item active">
				<router-link to="/register"><a class="btn btn-link" style="color:blue;border:1px solid blue" >注册</a></router-link>
			</li>
			<li class="nav-item active">
				<a class="btn btn-link" @click="loginout2()" style="color:blue;border:1px solid blue">退出</a>
			</li>
			<li class="nav-item active">
				<router-link to="/"><a class="btn btn-link" style="color:blue;border:1px solid blue">首页</a></router-link>
			</li>
			<li class="nav-item">
				<a class="nav-link disabled" id="dis_name"></a>
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
					<input id="searor" type="text" class="form-control" placeholder="请输入你要检索的订单的书名" style="padding: 20px">
					<span @click="getorderforname()" style="font-family: 微软雅黑;" class="input-group-text">
                 搜索
                    </span>
				</div>
			</div>
			<div class="col-md-3" >
				<a >
					<button @click="toScar()" class="btn btn-danger" style="font-family: 微软雅黑;font-size: 30px" >
						<i class="fa fa-truck" style="font-size:48px;color:black"></i>&nbsp;我的书包
					</button>
				</a>
			</div>
		</div>
	</div>
	<div class="nav" style="border-bottom: 2px solid #cc0000">
		<div class="card text-black" style="background-color: #cc0000; border-top-right-radius: 25px; width: 285px;margin-left: 25px">
			<div class="card-body" style="font-family: 微软雅黑;">全部订单 </div>
		</div>
		<div class="col-md-10 column marquee">
			<marquee  scrollamount="3"><span style="font-family: 微软雅黑;" class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
		</div>
	</div>
    <div class="row" style="background-color:honeydew;height: 600px">
		<div class="col-md-8" style="text-align: center;background-color:white;height: 100%;margin-left:325px;">
			<p>订单管理</p>
			<table class="table table-hover">
				<thead>
				<tr class="table-danger">
					<th>订单编号</th>
					<th>订单时间</th>
					<th>商品数量</th>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>订单总价</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody id = "Uer_Order">
				</tbody>
			</table>
			<div class="row" style="width: 100% ;margin-top:10px">
				<div class="container">
					<ul class="pagination" style="width: 100%">
						<li class="page-item"><a class="page-link" @click="earlypage()">上一页</a></li>
						<li class="page-item" id="lw1"></li>
						<li class="page-item" id="lw2"></li>
						<li class="page-item" id="lw3"></li>
						<li class="page-item"><a class="page-link" @click="nextpage()">下一页</a></li>
					</ul>
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
</template>

<script>
import tool from '@/components/publicTool'
import Cookie from 'js-cookie'
var Order_num = 0; //订单总数
var All_page  = 0; //总页数
var nowpage = 1; //当前页
var result = null; //当页订单
export default {
    created(){
            let _this = this
            window.delorder = _this.delorder
            window.tes2 = _this.tes2
    },
  mounted(){
        this.getUserinfo()
		this.getOrderNum(this)
		this.tes(this)
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      im1:''
    }
  },
  methods:{
 //获取订单数量
 getOrderNum:function(me){
   me.$axios.post(tool.base_url2+"/getnum",JSON.stringify({
       u_id:'ssss',
       username:Cookie.get('name')
   }),{
       headers:
           {
               'Content-Type':'application/json'
           }
   }).then(function (response){
        Order_num =  response.data;
        var x1
        All_page = Order_num%5 == 0 ? Order_num/5 : Order_num/5+1
        for(var j = 1;j<=All_page;j++){
            var ww = "lw"+j
            x1 = tool.getElement(ww);
            x1.innerHTML =" "
        }
        if(All_page > 3 ){
        for(var i = 1;i<=3;i++){
            var ww = "lw"+i
           x1 = getElement(ww);
           x1.innerHTML += "<a class='page-link' onclick='tes2(this)' id = '"+i+"'>"+i+"</a>"
        }
    }else {
            for(var j = 1;j<=All_page;j++){
                var ww = "lw"+j
                x1 = tool.getElement(ww);
                x1.innerHTML += "<a  class='page-link' onclick='tes2(this)' id = '"+j+"'>"+j+"</a>"
            }
        }
        console.log(Order_num)
    }).catch(function (error){
        console.log(error)
    })
	}, 
//点击页
 tes2:function(x){
    console.log(x.id)
    var ss = x.id
    nowpage = ss
    this.$options.methods.tes(this)
},
//下一页
 nextpage:function(){
    if(nowpage > All_page){
        alert("最后一页")
    }else {
		console.log(nowpage);
        var d = parseInt(nowpage)
   		 nowpage = d + 1
        console.log(nowpage)
    	this.$options.methods.tes(this)
    }
},
//上一页
 earlypage:function (){
    if (nowpage <= 1){
        nowpage = 1
        alert("第一页了")
    }else {
    nowpage -= 1
    this.$options.methods.tes(this)
    }
}
  ,
  //获取当前页订单
 tes:function(me){
     if(Cookie.get('token')!=null){
    var x = (nowpage-1)*5
    me.$axios.post(tool.base_url2+"/getorder",JSON.stringify({
       page_num : x,
       username:Cookie.get('name')
   }),{
       headers:
           {
               'Content-Type':'application/json'
           }
   }).then(function (response){
       result  =response.data
        var x = tool.getElement("Uer_Order")
        x.innerHTML = " "
       for(var i = 0;i<result.length;i++){
           x.innerHTML +=
               "<tr id='"+result[i].num+"' className='table-info' style='text-align: center' > <td><img style='height: 40px;width: 50px' src='/static/"+result[i].book_url+"'/><br><a>"+result[i].order_num+"</a></td><td><a>"+result[i].order_time+"</a></td><td><a>"+result[i].book_num+"</a></td><td><a>"+result[i].book_name+"</a></td><td><a>"+result[i].book_price+"</a></td><td><a>"+result[i].order_pay+"</a></td><td><button type='button' id='"+result[i].order_num+"' onclick='delorder(this)' className='btn btn-outline-dark'>删除</button>"+"</td></tr>"
       }
	   me.$options.methods.getOrderNum(me)
       // //订单编号
       // private String order_num;
       // //商品名称
       // private String book_name;
       // //商品数量
       // private int book_num;
       // //订单总价
       // private int order_pay;
       // //付款时间
       // private String order_time;
       // //商品单价
       // private String  book_price;
   }).catch(function (error){
        console.log(error)
   })}else{
       alert('登录已过期')
   }
},
//删除订单
delorder:function (x){
	var x1 = this
    console.log(x.id);
    var orderid =  x.id
    if(confirm("是否删除？")){
        this.$axios.post(tool.base_url2+"/delorder",JSON.stringify({
                    order_num:orderid,
                    username:Cookie.get('name')
}),{
            headers:
                {
                    'Content-Type':'application/json'
                }
        }).then(function (res){
            if(res.data != null){
                console.log(res.data)
                   if(res.data.tokenId!=null){
                        x1.$options.methods.tes(x1)
                         x1.$options.methods.getOrderNum(x1)
                        alert("删除成功")
                    }else {
                       alert("删除失败")
                   }
            }
        }).catch(function (err){
            console.log(err)
        })}else {}
}
,
 getUserinfo:function(){
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
 } 
  ,
 loginout2:function(){
	 tool.loginout(this,tool.base_url1+"/loginout")
 } 
  ,
  getorderforname :function(){
      var x2 = this
      var x = tool.getElement('searor')
      console.log("啦啦啦啦啦");
      this.$axios.post(tool.base_url2+"/getorderforname",JSON.stringify({
          username:Cookie.get('name'),
          book_name:x.value
      }),{
            headers:
                {
                    'Content-Type':'application/json'
                }
        }).then(function(res){
            if(res.data!=null){
                result = res.data
                var x = tool.getElement("Uer_Order")
                x.innerHTML = " "
                 for(var i = 0;i<result.length;i++){
                       x.innerHTML +=
                      "<tr id='"+result[i].num+"' className='table-info' style='text-align: center' > <td><img style='height: 40px;width: 50px' src='/static/"+result[i].book_url+"'/><br><a>"+result[i].order_num+"</a></td><td><a>"+result[i].order_time+"</a></td><td><a>"+result[i].book_num+"</a></td><td><a>"+result[i].book_name+"</a></td><td><a>"+result[i].book_price+"</a></td><td><a>"+result[i].order_pay+"</a></td><td><button type='button' id='"+result[i].order_num+"' onclick='delorder(this)' className='btn btn-outline-dark'>删除</button>"+"</td></tr>"
              }
	             me.$options.methods.getOrderNum(x2)
            }else{
                alert("没有相关订单")
            }
            
      }).catch(function(err){

      })
  },
  toScar:function(){
      tool.toScar2(this)
  }
  
  }
  }
</script>
<style >

</style>