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
			<a class="btn btn-link" @click="loginout()" style="color:blue;border:1px solid blue">退出</a>
		</li>
		<li class="nav-item active">
			<router-link to="/"><a class="btn btn-link" style="color:blue;border:1px solid blue">首页</a></router-link>
		</li>
		<li class="nav-item">
			<a class="nav-link disabled" id="dis_name">Disabled</a>
		</li>
	</ul>
</nav>
		<div class="row" style="border-bottom: 2px solid #cc0000;margin-top:150px;width: 100%">
			<div class="col-md-2"  style="border-top-right-radius: 50px;font-size:30px;margin-left:50px;text-align:center;background-color: #cc0000">
			我的书包
			</div>
			<div class="col-md">
				<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
			</div>
		</div>
<div class="row" style="height: 500px">
		<div class="col-md-7" >
			<div class="container" style="margin-top: 15px">
				<table class="table table-hover" >
					<thead style="color:white;background-color: #cc0000;font-size: 15px">
					<tr>
						<th>商品</th>
						<th>单价(元)</th>
						<th>数量</th>
						<th>小计(元)</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<tr style="height: 100px" id="cr1" >
<!--						<th><img className='col-md-4' style='width: 110px;height: 60px' src='"+res3[i-1].book_url+"'> <p style='width: 110px'>"+res3[i-1].book_name+"</p></th>-->
<!--						<th><div className='col-md-1' style='margin-top: 20px'>"+res3[i-1].book_price+"</div></th>-->
<!--						<th><div style='margin-top: 20px'><button className='btn btn-info'><i className='fa fa-plus' style='font-size:15px;color:black'></i></button><span id='num‘"+i+"' className='btn value'>"+res3[i-1].book_num+"</span><button className='btn btn-info'><i className='fa fa-window-minimize' style='font-size:15px;color:black'></i></button></div></th>-->
<!--						<th><div className='col-md-2 ' style='margin-top: 20px'>"+res3[i-1].order_pay+"</div></th>-->
<!--						<th><div style='margin-top: 20px'><button className='btn btn-danger'><i className='fa fa-times-circle'style='font-size:20px;color:black'></i></button></div></th>-->
					</tr>
					<tr style="height: 100px" id="cr2">

					</tr>
					<tr style="height: 100px" id="cr3">

					</tr>
					</tbody>
				</table>
			</div>
		</div>
			<div class="col-md-3" style="margin-left: 30px">
				<p >
					<a style="font-size: 30px" >	<button @click="payindexcar()" style="height:150px;margin-top: 50px;width: 300px" class="btn btn-info"><i class="fa fa-credit-card" style="font-size:30px;color:black"></i>结算</button></a>
				</p>
				<div style="margin-top: 100px">
				<p >
					已选择<a id ="spsp"></a>件商品，总价: <span  id="money" style="color: red">0</span>
				</p>
				</div>
				<div class="row" style="margin-top:105px;width: 100%">
					<div class="container" style="width: 100%">
						<ul class="pagination">
							<li class="page-item active"><a class="page-link" @click="earlycar()" >上一页</a></li>
							<li class="page-item" onclick="" id = "ss1"></li>
							<li class="page-item " id = "ss2"></li>
							<li class="page-item" id = "ss3"></li>
							<li class="page-item" @click="nextcar()"><a class="page-link" >下一页</a></li>
						</ul>
					</div>
				</div>
	</div>
	</div>
		<div style="border-top: 1px solid #cc0000;margin-top:60px;text-align: center" class="row-cols-1">
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
var carnum = 0; //购物车总数
var Allcarnum = 0;//购物车总页数
var nowcarnum = 1; //购物车当前页
var res3 = null; //当前页购物车
export default {
    created(){
        let _this = this
        window.getindexcar = _this.getindexcar
        window.clearcarnum= _this.clearcarnum
        window.addcarnum = _this.addcarnum
        window.delcars = _this.delcars
    },
  mounted(){
      this.getcarnum()
        this.getUserinfo()
		this.getshowcar(this)
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
    }
  },
  methods:{
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
	//获取购物车商品的数量
 		getcarnum:function (){
    		this.$axios.get(tool.base_url4+"/carnum").then(function (response){
      		  carnum =  response.data;
       		 	var x1
        		if(carnum === 0) return
       			 Allcarnum = carnum%3 == 0 ? carnum/3 : carnum/3+1
       		 	for(var j = 1;j<=Allcarnum;j++){
           		 var ww = "ss"+j
           		 x1 = tool.getElement(ww);
           		 x1.innerHTML =" "
     	   }
      	  if(Allcarnum > 3 ){
           	 for(var i = 1;i<=3;i++){
                var ww = "ss"+i
                var ind = i
                x1 = tool.getElement(ww);
                x1.innerHTML += "<a class='page-link' onclick='getindexcar(this)' id='"+ind+"'>"+ind+"</a>"
            }
            var wds = getElement("spsp")
            wds.innerHTML = 3
       	 }else {
            for(var j = 1;j<=Allcarnum;j++){
                var ww = "ss"+j
                var jnd = j
                x1 = tool.getElement(ww);
                x1.innerHTML += "<a  class='page-link' onclick='getindexcar(this)' id='"+jnd+"'>"+jnd+"</a>"
            }
        }
    }).catch(function (error){
        console.log(error)
    })
  },
  //获取当页的购物车
 getshowcar:function(me){
    var s;
    var nowcar = nowcarnum;
    me.$axios.post(tool.base_url4+"/showcar",JSON.stringify({
                book_num:nowcar,
                username:Cookie.get('name')
    }) ,{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
            if(res.data===null){
                var rd = tool.getElement("cr1")
                rd.innerHTML="还没有添加购物车书籍"
            }else {
       		res3 = res.data;
       		 var allmo = 0;
        for(var i = 1;i<=res3.length;i++) {
            var ds = "cr"+i
            s = tool.getElement(ds)
            s.innerHTML += "<th><img className='col-md-4' style='width: 110px;height: 60px' src='/static/"+res3[i-1].book_url+"'> <p style='width: 110px'>"+res3[i-1].book_name+"</p></th><th><div className='col-md-1' style='margin-top: 20px'>"+res3[i-1].book_price+"</div></th><th><div style='margin-top: 20px'><button onclick='addcarnum(this)' id='"+(i-1)+"' className='btn btn-info' style='width:25px;'>"+"+"+"</button><span id='num"+(i-1)+"' className='btn value'>"+res3[i-1].book_num+"</span><button onclick='clearcarnum(this)' id='"+(i-1)+"' style='width:25px;' className='btn btn-info'>"+ "-" +"</button></div></th><th><div id='pri"+(i-1)+"' className='col-md-2 ' style='margin-top: 20px'>"+res3[i-1].order_pay+"</div></th><th><div style='margin-top: 20px'  ><button href='' onclick='delcars(this)' id='"+"del"+(i-1)+"' className='btn btn-danger'><i className='fa fa-times-circle'style='font-size:20px;color:black'>删除</i></button></div></th>"
            allmo+=res3[i-1].order_pay
        }
        var m = tool.getElement("money")
        m.innerHTML = allmo
                var wds = tool.getElement("spsp")
                wds.innerHTML = res3.length
            }
        }).catch(function (err){
            console.log(err)
    })
},
  //下一页购物车
 nextcar:function(){
    if(res3 === null){
        alert("购物车为空");
    }else {
    if(nowcarnum > Allcarnum){
        alert("最后一页了")
        nowcarnum = 3
    }else {
        var ds;
        var s;
        for(var i = 1;i<=res3.length;i++) {
             ds = "cr"+i
            s = tool.getElement(ds)
            s.innerHTML = ""
        }
		var ddd = parseInt(nowcarnum)
         nowcarnum = ddd + 1
        console.log(nowcarnum+"sssss")
        this.$options.methods.getshowcar(this)
    }
    }
},
//上一页购物车
 earlycar:function(){
    if(res3 === null){
        alert("购物车为空");
    }else {
    if(nowcarnum <= 1){
        alert("前面已经无了")
        nowcarnum = 1
    }else {
        var ds;
        var s;
        for(var i = 1;i<=res3.length;i++) {
            ds = "cr"+i
            s = tool.getElement(ds)
            s.innerHTML = ""
        }
        nowcarnum -= 1
        console.log(nowcarnum)
        this.$options.methods.getshowcar(this)
    }
    }
},
//点击页购物车
 getindexcar:function(x){
            var sid = parseInt(x.id)
            nowcarnum = sid
             var ds;
             var s;
            for(var i = 1;i<=res3.length;i++) {
                  ds = "cr"+i
                s = tool.getElement(ds)
                   s.innerHTML = ""
             }
            this.$options.methods.getshowcar(this)
			},
			//增加购物车商品数量
 addcarnum:function(x){
        var x1 = tool.getElement("num"+x.id);
         console.log(x1.innerHTML)
       var x2 =  x1.innerHTML
        var x3 = parseInt(x1.innerHTML)+1
        x1.innerHTML = x3
       res3[x.id].book_num = x3;
    this.$axios.post(tool.base_url4+"/upcar",JSON.stringify({
        book_name:res3[x.id].book_name,
        book_num:res3[x.id].book_num,
        username:Cookie.get('name')
    }),{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
        if(res.data.tokenId!=null){
            var m = tool.getElement("money")
            var mm = parseInt(m.innerHTML)
            var m3 = tool.getElement("pri"+x.id)
            var m3d = parseInt(m3.innerHTML)
            m3.innerHTML = m3d+parseInt(res3[x.id].book_price)
            m.innerHTML =mm+parseInt(res3[x.id].book_price)
            console.log(res.data.resultRE)
        }else {
        console.log(res.data.resultRE)
    }}).catch(function (err){
        console.log(err)
    })
},
//减少购物车商品数量
 clearcarnum:function (x){
    var x1 = tool.getElement("num"+x.id);
    console.log(x1.innerHTML)
    var x2 =  x1.innerHTML
    var x3 = parseInt(x1.innerHTML)-1
    if(x3 == 0) {
        alert('不能再减了')
    }else {
    x1.innerHTML = x3
    res3[x.id].book_num = x3;
    this.$axios.post(tool.base_url4+"/upcar",JSON.stringify({
        book_name:res3[x.id].book_name,
        book_num:res3[x.id].book_num,
         username:Cookie.get('name')
    }),{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
        if(res.data.tokenId!=null){
            console.log(res.data.resultRE)
            var m = tool.getElement("money")
            var mm = parseInt(m.innerHTML)
            var m3 = tool.getElement("pri"+x.id)
            m3.innerHTML -=parseInt(res3[x.id].book_price)
            m.innerHTML =mm-parseInt(res3[x.id].book_price)
        }else {
        console.log(res.data.resultRE)
    }}).catch(function (err){
        console.log(err)
    })}
},
//删除购物车商品
 delcars:function (x){
    var swx = x.id
    var ss = swx[swx.length-1]
	var dthis = this
    console.log(res3[ss].book_name)
        this.$axios.post(tool.base_url4+"/delcar",JSON.stringify({
            book_name:res3[ss].book_name,
            username:Cookie.get('name')
        }),{
            headers:{
                'Content-Type':'application/json'
            }}).then(function (res){
                console.log(res);
            if(res.data.tokenId!=null){
                var ds;
                var s;
                for(var i = 1;i<=res3.length;i++) {
                    ds = "cr"+i
                    s = tool.getElement(ds)
                    s.innerHTML = ""
                }
                alert(res.data.resultRE)
                dthis.$options.methods.getshowcar(dthis)
                dthis.$options.methods.getcarnum(dthis)
            }else {
                alert(res.data.resultRE)
            }
        }).catch(function (err){
            console.log(err)
        })
},
//结算当页的购物车
 payindexcar:function(){
	 var ss = this
       this.$axios.post(tool.base_url4+"/paycar",JSON.stringify({
           username:Cookie.get('name')
       }),{
            headers:{
                'Content-Type':'application/json'
            }}).then(function (res){
            if(res.data.tokenId!=null){
                alert(res.data.resultRE)
                ss.$options.methods.getcarnum(ss)
                ss.$options.methods.getshowcar(ss)
            }else {
           		 alert(res.data.resultRE)
            }
        }).catch(function (err){
        console.log(err)
    })
},
loginout :function(){
    tool.loginout(this,tool.base_url1+"/loginout")
},
getOrder:function(){
    tool.getorder(this)
}	
}
}
</script>
<style >

</style>