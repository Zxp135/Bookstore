<template>
    
</template>
<script>
import Cookie from 'js-cookie'
const base_url1 = "http://localhost:8088/u"       //登录
const base_url2 =  "http://localhost:8088/o"      //订单
const base_url3 = "http://localhost:8088/page"    //页面
const base_url4 = "http://localhost:8088/car"     //购物车
const base_url5 = "http://localhost:8088/search"  //搜索
const token = null;                     //登录状态
const U_name = null;
var result = null;
  function getElement(x){
            return document.getElementById(x)
      }
function getorder(x){  //订单
      if(Cookie.get("token") == null){
            alert("还未登录，请先登录")
      }else{
            x.$router.push("/order")
            
      }
}
function setfunctime(x){
    if(Cookie.get('token') == null){
        alert('登录已经过期')
        this.loginout(x,base_url1+'/loginout')
        x.$router.push('/')
    }
}
//首页购物车
   function toScar2(x){
    if(Cookie.get('token') == null){
        alert("请登录");
    }else {
        x.$router.push('/shopcar')
    }
}
function loginout(x,x2){ //退出
      var x1 = x
      if(Cookie.get("token") == null){
              alert("还未登录，请先登录")
      }else{
            var x3 = Cookie
        if(confirm("是否退出？")){
            x1.$axios.post(x2,JSON.stringify({
                username:Cookie.get('name')
            }),{
                headers:
                    {
                        'Content-Type':'application/json'
                    }
            })
                .then(function (response){
                    result = response.data
                    alert(result.code+result.resultRE)
                    x3.remove('token')
                    x3.remove('name')
                    x1.$router.push('/')
                  })
                .catch(function (error){
                    console.log(error)
                })
    }
      }
}
export default{
        getElement,
        getorder,
        loginout,
        toScar2,
        setfunctime,
        base_url1,
        base_url2,
        base_url3,
        base_url4,
        base_url5,
        token,
        U_name
}
</script>
