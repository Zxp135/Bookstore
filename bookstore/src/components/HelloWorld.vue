<template>
  <div class="hello">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
           <router-link to="/login">  <a style="color:blue;border:1px solid blue" class="btn btn-link" type="button">登录</a></router-link>
        </li>
        <li class="nav-item active">
           <router-link to="/register"> <a style="color:blue;border:1px solid blue" class="btn btn-link"  >注册</a></router-link>
        </li>
        <li class="nav-item active">
          <a style="color:blue;border:1px solid blue" class="btn btn-link"  @click="getOrder()" >我的订单</a>
        </li>
        <li class="nav-item active">
            <a  style="color:blue;border:1px solid blue" class="btn btn-link" @click="loginout2()" id="U_out" href="" >退出</a>
        </li>
        <li class="nav-item">
            <a id="dis_name" class="nav-link disabled"></a>
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
                <input id="sear" type="text" class="form-control" placeholder="请输入你要检索的书名" style="padding: 20px">
                <span @click="indexsearch()" style="font-family: 微软雅黑;" class="input-group-text">
                 搜索
                    </span>
            </div>
        </div>
        <div class="col-md-3" >
            <a @click="toScar()">
                <button  class="btn btn-danger" style="font-family: 微软雅黑;font-size: 30px" >
                    <i class="fa fa-truck" style="font-size:48px;color:black"></i>&nbsp;我的书包
                </button>
            </a>
        </div>
    </div>
</div>
<div class="nav">
    <div class="card text-black" style="background-color: #cc0000; border-top-right-radius: 25px; width: 285px;margin-left: 25px">
        <div class="card-body" style="font-family: 微软雅黑;">全部图书分类 </div>
    </div>
    <div class="col-md-10 column marquee">
        <marquee  scrollamount="3"><span style="font-family: 微软雅黑;" class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
    </div>
</div>
<div class="row clearfix" style="margin-left: 10px">
        <div class="col-md-2 column menu" >
            <div id="accordion">
                <div class="card">
                    <div class="card-header"><a class="card-link" data-toggle="collapse" href="#collapseOne">文学类</a></div>
                    <div  id="collapseOne" class="collapse" data-parent="#accordion" >
                    <div  class="card-body" style="height: 50px">
                        <a onclick="wait()"   class="card-link">诗歌</a>
                        <a  onclick="wait()"  class="card-link">散文</a>
                        <a onclick="wait()"  class="card-link"> 小说</a>
                    </div>
                    </div>
            </div>
            <div class="card">
                <div class="card-header"> <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">教育类</a></div>
                <div id="collapseTwo" class="collapse" data-parent="#accordion">
                    <div  class="card-body">
                        <a onclick="wait()" class="card-link" >学前</a>
                        <a onclick="wait()" class="card-link">小学</a>
                        <a onclick="wait()" class="card-link">初中</a>
                        <a onclick="wait()" class="card-link">高中</a>
                        <a onclick="wait()" class="card-link">大学</a>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header"><a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">计算机类</a></div>
                <div  id="collapseThree" class="collapse" data-parent="#accordion">
                    <div  class="card-body">
                       <router-link to="/list"> <a href="list.html">JAVA</a> </router-link>
                       <router-link to="/list">  <a href="list.html">JAVASCRIPT</a> </router-link>
                      <router-link to="/list">   <a href="list.html">PHP</a> </router-link>
                      <router-link to="/list">   <a href="list.html">C++</a> </router-link>
                     <router-link to="/list">    <a href="list.html">Zigbee</a> </router-link>
                     <router-link to="/list">    <a href="list.html">Android</a> </router-link>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header"> <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">儿童类</a></div>
                    <div id="collapseFour"  class="collapse" data-parent="#accordion">
                    <div  class="card-body">
                        <a onclick="wait()" class="card-link">益智</a>
                        <a onclick="wait()" class="card-link">生活</a>
                        <a onclick="wait()" class="card-link">特长</a>
                        <a onclick="wait()" class="card-link">画图</a>
                        <a onclick="wait()" class="card-link" >故事</a>
                    </div>
                    </div>
            </div>
            <div class="card">
                <div class="card-header"><a class="collapsed card-link" data-toggle="collapse" href="#collapseFive"> 漫画类</a></div>
                   <div id="collapseFive" class="collapse" data-parent="#accordion">
                    <div  class="card-body">
                        <a onclick="wait()" class="card-link" >科幻</a>
                        <a onclick="wait()" class="card-link">冒险</a>
                        <a onclick="wait()" class="card-link">灾难</a>
                        <a onclick="wait()" class="card-link" >语言</a>
                        <a onclick="wait()" class="card-link" >神话</a>
                    </div>
                   </div>
            </div>
            <div class="card">
               <div class="card-header"> <a class="collapsed card-link" data-toggle="collapse" href="#collapseSix">期刊类</a></div>
                    <div id="collapseSix" class="collapse" data-parent="#accordion">
                    <div class="card-body">
                        <a onclick="wait()" class="card-link" >农业</a>
                        <a onclick="wait()" class="card-link">金融</a>
                        <a onclick="wait()" class="card-link">医学</a>
                        <a onclick="wait()" class="card-link" >文学</a>
                        <a onclick="wait()" class="card-link">环艺</a>
                    </div>
                    </div>
            </div>
            <div class="card">
             <div class="card-header"><a class="card-link" data-toggle="collapse" href="#collapseSeven">工具书类</a></div>
                <div id="collapseSeven" class="collapse" data-parent="#accordion">
                    <div  class="card-body">
                        <a onclick="wait()" class="card-link">图像</a>
                        <a onclick="wait()" class="card-link">字典</a>
                        <a onclick="wait()" class="card-link">股市</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div class="col-md-8">
            <div class="carousel slide" data-slide="carousel" id="demo">
                <!-- 指示符 -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>
                <div class="carousel-inner" >
                    <div class="carousel-item active" >
                        <img alt="" style="width: 100%;height: 390px" src="@/Image/index2.jpg" />
                    </div>
                    <div class="carousel-item" >
                        <img alt="" style="width: 100%;height: 390px" src="@/Image/index2.jpg" />
                    </div>
                    <div class="carousel-item" >
                        <img alt=""  style="width: 100%;height:390px" src="@/Image/index2.jpg" />
                    </div>
                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-2 column message">
            <div class="row">
                <div class="col-md">
                    <img src="@/Image/logo1.png" class="rounded-circle">
                </div>
                <div style="font-family: 微软雅黑" class="col-md-9 column">
                    <p>hi~,欢迎来逛网上书城</p>
                </div>
            </div>
            <div class="row inner-line" style="margin-right: 1px">
                <div class="col-md-6 column ">
                    <button style="width: 100%" class="btn btn-info">新人福利</button>
                </div>
                <div class="col-md-6 column " >
                    <button style="width: 100% ;" class="btn btn-info">会员</button>
                </div>
            </div>
            <div style="margin-top: 10px" class="row inner-line">
                <ul class="list-group">
                    <li class="list-group-item list-group-item-action">
                        <div style="width: 100%">书只看不卖</div>
                    </li>
                    <li class="list-group-item list-group-item-action">
                        <div style="width: 100%">书只看不卖</div>
                    </li>
                    <li class="list-group-item list-group-item-action">
                        <div style="width: 200px">书只看不卖</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md" style="margin-left:10px;border-left: black" >
            <div class="card bg-danger text-white" style="height: 350px;" >
            <div class="row-cols-1" style="text-align:center;font-family: 微软雅黑;font-size: 45px">杰普秒杀</div>
            <div class="row-cols-1" style="font-size: 20px;font-family: 宋体;padding-top: 2em">距离结束还剩</div>
            <div style="padding-left: 65px;padding-top: 3em"><i class="fa fa-legal" style="font-size:45px;color:black"></i></div>
            <div  class="row-cols-1" style="margin-top:80px;padding-left: 65px;font-size: 25px">
                <span style="font-size: 30px" class="se-txt">00</span>:
                <span style="font-size: 30px" class="se-txt">00</span>:
                <span style="font-size: 30px" class="se-txt">00</span>
            </div>
            </div>
        </div>
        <div class="col-md" style="border-right: 1px solid black">
            <a>
                <img @click="toview" id = "im1" src="" style="width: 100%">
            </a>
            <div class="price" style="text-align: center;border-top-right-radius: 30px;border-bottom-left-radius: 30px;border:4px solid #cc0000 ;">
                <span id = "s1" style="width:100%;font-size: 35px;">0</span>
            </div>
        </div>
        <div class="col-md"  style="border-right: 1px solid black">
            <a>
                <img  @click="toview" id = "im2" src="#" style="width: 100%;border-bottom-left-radius: 30px;text-align: center">
            </a>
            <div class="row-cols-1" style="border-top-right-radius: 30px;text-align: center;border: 4px solid #cc0000 ;border-bottom-left-radius: 30px;">
                <span id = "s2" style="font-size: 35px; ">0</span>
            </div>
        </div>
        <div class="col-md"  style="border-right: 1px solid black">
            <a>
                <img   @click="toview" id = "im3" src="#" style="width: 100%">
            </a>
            <div class="row-cols-1" style="border-top-right-radius: 30px;text-align: center;border: 4px solid #cc0000 ;border-bottom-left-radius: 30px;">
                <span id = "s3" style="font-size: 35px;">0</span>
            </div>
        </div>
        <div class="col-md"  style="border-right: 1px solid black">
            <a >
                <img   @click="toview" id = "im4" src="#" style="width: 100%">
            </a>
            <div class="row-cols-1" style="border-top-right-radius: 30px;text-align: center;border: 4px solid #cc0000 ;border-bottom-left-radius: 30px;">
                <span id = "s4" style="font-size: 35px;">0</span>
            </div>
        </div>
        <div class="col-md">
            <a>
                <img  @click="toview" id = "im5" src="#" style="width: 100%">
            </a>
            <div class="row-cols-1" style="margin-top:2px;border-top-right-radius: 30px;text-align: center;border: 4px solid #cc0000 ;border-bottom-left-radius: 30px;">
                <span id = "s5" style="font-size: 35px;">0</span>
            </div>
        </div>
    </div>
    <div class="row-cols-6" style="border-bottom: 2px solid red;margin-top: 10px;">
        <h3 style=" text-align:center;font-family: 微软雅黑;border: 1px solid #cc0000 ; margin-bottom: 0px;background-color: #cc0000;border-top-right-radius: 35px">发 现 好 书</h3>
    </div>
    <div class="row">
        <div  class="col-md-2" style="margin-left: 140px">
                <img @click="toview" id ="am1" style="width: 100px;width: 200px" src="Image/book1.jpg" />
            <a href="#" >
                <h4 id = "h1">
                    JAVAEE轻量级框架
                </h4>
                <p id="p1">￥45.00</p>
            </a>
            <div  class="row">
 
                    <button  id="car1" style="width:90px" @click="incar" class="btn btn-danger">加入书包</button>
  
                <a style="width:90px;margin-left: 15px" id="b1" @click="buy"  class="btn btn-warning">立即购买</a>
            </div>
        </div>
        <div class="col-md-2" style="margin-left: 140px">

                <img @click="toview"  id ="am2" style="width: 100px;width: 200px;"  src="@/Image/book1.jpg" />
            <a href=""> <h4 id = "h2">
                    JAVAEE轻量级框架
                </h4>
                <p id="p2">￥45.00</p>
            </a>
            <div class="row">

                    <button id="car2" style="width:90px" @click="incar" class="btn btn-danger">加入书包</button>

                <a style="width:90px;margin-left: 15px" id="b2" @click="buy"  class="btn btn-warning">立即购买</a>
            </div>
        </div>
        <div class="col-md-2" style="margin-left: 140px">

                <img @click="toview" id ="am3" style="width: 100px;width: 200px"  src="@/Image/book1.jpg" />
            <a href="">  <h4 id = "h3">
                    JAVAEE轻量级框架
                </h4>
                <p id="p3">￥45.00</p>
            </a>
            <div class="row">
                  <button style="width:90px" id="car3" @click="incar" class="btn btn-danger">加入书包</button>
                <a style="width:90px;margin-left: 15px" id="b3" @click="buy" class="btn btn-warning">立即购买</a>
            </div>
        </div>
        <div class="col-md-2" style="margin-left: 140px">

                <img  @click="toview" id ="am4" style="width: 100px;width: 200px"  src="Image/book1.jpg" />
            <a href="">   <h4 id = "h4">
                    JAVAEE轻量级框架
                </h4>
                <p id="p4">￥45.00</p>
            </a>
            <div class="row">
                    <button style="width:90px" id="car4" @click="incar" class="btn btn-danger">加入书包</button>
                <a style="width:90px; margin-left: 15px" id="b4" @click="buy"  class="btn btn-warning">立即购买</a>
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
var result2 = null;
var result1 = null;
var tooken = null;
export default {
    created(){
        this.getUserinfo()
        setInterval(tool.setfunctime(this),1000*1000)
    },
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
  methods:{
    //获取首页书籍
    getindex1:function(){
        this.$axios.get(tool.base_url3+"/getindex1").then(function (response){
        result2=response.data
        var im;
        var sp;
        for(var i =0;i<5;i++){
            im = tool.getElement("im"+(i+1))
            sp = tool.getElement("s"+(i+1))
            im.src ="/static/" + result2[i].book_url
            sp.innerHTML = result2[i].book_price+".0￥"
        }
        }
    ).catch(function (error){
        console.log(error)
    })
    },
    getindex2:function(){
        this.$axios.get(tool.base_url3+"/getindex2").then(function (response){
            result1=response.data
            var am;
            var h;
            var p;
            for(var i =0;i<4;i++){
                am = tool.getElement("am"+(i+1))
                h = tool.getElement("h"+(i+1))
                p = tool.getElement("p"+(i+1))
                am.src = "/static/"+result1[i].book_url
                h.innerHTML = result1[i].book_name
                p.innerHTML = result1[i].book_price+".0￥"
            }
        }
    ).catch(function (error){
        console.log(error)
    })
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
    getOrder:function(){
        //   if(Cookie.get("token") == null){
        //         alert("还未登录，请先登录")
        //     }else{
        //          this.$router.replace("/order") }
            tool.getorder(this)
     
    },
    loginout2:function(){
           tool.loginout(this,tool.base_url1+'/loginout')
    },
    toview:function(event){
        //详情页
        console.log(event);
        console.log(event.currentTarget.id)
    var x = event.currentTarget.id;
    var xx ;
    if(x[0] === 'i'){
        xx = result2
    }else if(x[0] === 'a'){
        xx = result1
    }
    var b = x[x.length-1]-1
    this.$axios.post(tool.base_url3+"/touch",JSON.stringify({
        book_name:xx[b].book_name,
        book_url:xx[b].book_url,
        book_price:xx[b].book_price,
        book_where:xx[b].book_where
    }),{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(function (res){

    })
        .catch(function (err){
            console.log(err)
        })
       this.$router.push('/viewbook')
    },
   tes:function(){
       this.$router.push('/order')
   },
   toScar:function(){
       tool.toScar2(this)
   },
   //加入购物车
 incar:function(x){
    if(Cookie.get('token')!=null && result1 != null){
    var bid = x.currentTarget.id;
    var sid = bid[bid.length-1]-1
    console.log(sid)
    var carres = result1[sid]
    console.log(carres)
   this.$axios.post(tool.base_url4+"/incar",JSON.stringify({
        book_name:carres.book_name,
        book_url:carres.book_url,
        book_num:1,
        book_price:carres.book_price,
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
    }else {
        alert("未登录")
    }
    },//购买
        buy:function(x){
            var nth  =this
            var re = x.currentTarget.id
        var b = re[re.length-1]-1;
    this.$axios.post(tool.base_url3+"/touch",JSON.stringify({
        book_name:result1[b].book_name,
        book_url:result1[b].book_url,
        book_price:result1[b].book_price,
        book_where:result1[b].book_where
    }),{
        headers:{
            'Content-Type':'application/json'
        }
    }).then(function (res){

    })
        .catch(function (err){
            console.log(err)
        })
    nth.$router.push('/viewbook')
},//首页查询
indexsearch:function (){
    var _th = this
    var x = tool.getElement("sear")
    var x_name = x.value
    console.log(x_name)
    if(x_name === ""){
        alert("请输入查询的书名")
    }else {
        this.$axios.post(tool.base_url5+"/getfn",JSON.stringify({
                    book_name:x_name,
                    username:Cookie.get('name')
        }) , {
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
  
}
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
