var base_pageurl = "http://localhost:8088/page"
var result2;
var result1;
var nowres;
var allbnum = 1;
var name=null;
var view = null; //点击详情书
var bookcar = [];
var carnum = 0;
var Allcarnum = 0;
var nowcarnum = 1;
var res3;
var listnow = 1;
var listall = 0;
var listnum; //列表总页数
function  getElement(x){    //获取组件
    return document.getElementById(x)
}
function getindex1(){
    axios.get(base_pageurl+"/getindex1").then(function (response){
        result2=response.data
        console.log(result)
        var im;
        var sp;
        for(var i =0;i<5;i++){
            im = getElement("im"+(i+1))
            sp = getElement("s"+(i+1))
            im.src = result2[i].book_url
            sp.innerHTML = result2[i].book_price+".0￥"
        }
        }
    ).catch(function (error){
        console.log(error)
    })
}
function getindex2(){
    axios.get(base_pageurl+"/getindex2").then(function (response){
            result1=response.data
            console.log(result1)
            var am;
            var h;
            var p;
            for(var i =0;i<4;i++){
                am = getElement("am"+(i+1))
                h = getElement("h"+(i+1))
                p = getElement("p"+(i+1))
                am.src = result1[i].book_url
                h.innerHTML = result1[i].book_name
                p.innerHTML = result1[i].book_price+".0￥"
            }
        }
    ).catch(function (error){
        console.log(error)
    })
}
//详情页
function toview(x){
    var xx ;
    if(x[0] === 'i'){
        xx = result2
    }else if(x[0] === 'a'){
        xx = result1
    }
    var b = x[x.length-1]-1
    console.log(b)
    console.log(result2)
    axios.post(base_pageurl+"/touch",JSON.stringify({
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
   window.location.href="viewBook.html"
}
//获取详情
function getview(){
   axios.get(base_pageurl+"/gettouch").then(function (res){
       nowres = res.data;
     var vim ;
     var sp;
     var sp2;
       var sp3;
       sp = getElement("sp1")
       sp2 = getElement("sp2")
       sp3 = getElement("sp3")
       console.log(res.data)
       sp2.innerHTML = res.data.book_price
       sp.innerHTML=res.data.book_name
       sp3.innerHTML=res.data.book_where
      for(var i = 0;i<5;i++){
      vim = getElement("vim"+(i+1))
      vim.src = res.data.book_url
     }
   }).catch(function (err){
       console.log(err)
   })
}
//详情页加入购物车
function viewincar(){
    axios.post("http://localhost:8088/car/incar",JSON.stringify({
        book_name:nowres.book_name,
        book_url:nowres.book_url,
        book_num:1,
        book_price:nowres.book_price,
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
}
function getnnn(){
    axios.get("http://localhost:8088/u/getname").then(
        function (res){

            name = res.data
            console.log(name)
        }
    ).catch()
}
//购买
function buy(x){
        var b = x[x.length-1]-1;
    axios.post(base_pageurl+"/touch",JSON.stringify({
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
    window.location.href="viewBook.html"
}
//购买
function buy2(){
    console.log(nowres)
    var mon = nowres.book_price*allbnum
    axios.post("http://localhost:8088/car/buy",JSON.stringify({
            order_price:nowres.order_price,
            book_price:nowres.book_price,
            book_name:nowres.book_name,
            book_url:nowres.book_url,
            order_pay:mon,
            book_num:allbnum,
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

}
//加入购物车
function incar(x){
    if(tookenid!=null && result1 != null){
    var bid = x;
    var sid = bid[bid.length-1]-1
    console.log(sid)
    var carres = result1[sid]
    console.log(carres)
    axios.post("http://localhost:8088/car/incar",JSON.stringify({
        book_name:carres.book_name,
        book_url:carres.book_url,
        book_num:1,
        book_price:carres.book_price,
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
}
//获取购物车商品的数量
function  getcarnum(){
    axios.get("http://localhost:8088/car/carnum").then(function (response){
        carnum =  response.data;
        var x1
        if(carnum === 0) return
        Allcarnum = carnum%3 == 0 ? carnum/3 : carnum/3+1
        for(var j = 1;j<=Allcarnum;j++){
            var ww = "ss"+j
            x1 = getElement(ww);
            x1.innerHTML =" "
        }
        if(Allcarnum > 3 ){
            for(var i = 1;i<=3;i++){
                var ww = "ss"+i
                x1 = getElement(ww);
                x1.innerHTML += "<a class='page-link' onclick='getindexcar(id)' id = '"+i+"'>"+i+"</a>"
            }
            var wds = getElement("spsp")
            wds.innerHTML = 3
        }else {
            for(var j = 1;j<=Allcarnum;j++){
                var ww = "ss"+j
                x1 = getElement(ww);
                x1.innerHTML += "<a  class='page-link' onclick='getindexcar(id)' id = '"+j+"'>"+j+"</a>"
            }
        }
    }).catch(function (error){
        console.log(error)
    })
}
//获取当页的购物车
function getshowcar(){
    var s;
    var nowcar = nowcarnum;
    axios.post("http://localhost:8088/car/showcar",nowcar,{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
            if(res.data===null){
                var rd = getElement("cr1")
                rd.innerHTML="还没有添加购物车书籍"
            }else {
        res3 = res.data;
        var allmo = 0;
        for(var i = 1;i<=res3.length;i++) {
            var ds = "cr"+i
            s = getElement(ds)
            s.innerHTML += "<th><img className='col-md-4' style='width: 110px;height: 60px' src='"+res3[i-1].book_url+"'> <p style='width: 110px'>"+res3[i-1].book_name+"</p></th><th><div className='col-md-1' style='margin-top: 20px'>"+res3[i-1].book_price+"</div></th><th><div style='margin-top: 20px'><button onclick='addcarnum(id)' id='"+(i-1)+"' className='btn btn-info' style='width:25px;'>"+"+"+"</button><span id='num"+(i-1)+"' className='btn value'>"+res3[i-1].book_num+"</span><button onclick='clearcarnum(id)' id='"+(i-1)+"' style='width:25px;' className='btn btn-info'>"+ "-" +"</button></div></th><th><div id='pri"+(i-1)+"' className='col-md-2 ' style='margin-top: 20px'>"+res3[i-1].order_pay+"</div></th><th><div style='margin-top: 20px'><button onclick='delcars(id)' id='"+"del"+(i-1)+"' className='btn btn-danger'><i className='fa fa-times-circle'style='font-size:20px;color:black'>删除</i></button></div></th>"
            allmo+=res3[i-1].order_pay
        }
        var m = getElement("money")
        m.innerHTML = allmo
                var wds = getElement("spsp")
                wds.innerHTML = res3.length
            }
        }).catch(function (err){
            console.log(err)
    })
}
//下一页购物车
function nextcar(){
    if(res3 === null){
        alert("购物车为空");
    }else {
    if(nowcarnum > allbnum){
        alert("最后一页了")
        nowcarnum = 3
    }else {
        var ds;
        for(var i = 1;i<=res3.length;i++) {
             ds = "cr"+i
            s = getElement(ds)
            s.innerHTML = ""
        }
         nowcarnum +=1
        console.log(nowcarnum+"sssss")
        getshowcar()
    }
    }
}
//上一页购物车
function earlycar(){
    if(res3 === null){
        alert("购物车为空");
    }else {
    if(nowcarnum <= 1){
        alert("前面已经无了")
        nowcarnum = 1
    }else {
        var ds;
        for(var i = 1;i<=res3.length;i++) {
            ds = "cr"+i
            s = getElement(ds)
            s.innerHTML = ""
        }
        nowcarnum -= 1
        console.log(nowcarnum)
        getshowcar()
    }
    }
}
//点击页购物车
function getindexcar(x){
            var id = parseInt(x)
            nowcarnum = id
             var ds;
            for(var i = 1;i<=res3.length;i++) {
                  ds = "cr"+i
                         s = getElement(ds)
                   s.innerHTML = ""
             }
            getshowcar()
}
//增加购物车商品数量
function addcarnum(x){
        var x1 = getElement("num"+x);
         console.log(x1.innerHTML)
       var x2 =  x1.innerHTML
        var x3 = parseInt(x1.innerHTML)+1
        x1.innerHTML = x3
       res3[x].book_num = x3;
    axios.post("http://localhost:8088/car/upcar",JSON.stringify({
        book_name:res3[x].book_name,
        book_num:res3[x].book_num
    }),{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
        if(res.data.tokenId!=null){
            var m = getElement("money")
            var mm = parseInt(m.innerHTML)
            var m3 = getElement("pri"+x)
            var m3d = parseInt(m3.innerHTML)
            m3.innerHTML = m3d+parseInt(res3[x].book_price)
            m.innerHTML =mm+parseInt(res3[x].book_price)
            console.log(res.data.resultRE)
        }else {
        console.log(res.data.resultRE)
    }}).catch(function (err){
        console.log(err)
    })
}
//减少购物车商品数量
function  clearcarnum(x){
    var x1 = getElement("num"+x);
    console.log(x1.innerHTML)
    var x2 =  x1.innerHTML
    var x3 = parseInt(x1.innerHTML)-1
    x1.innerHTML = x3
    res3[x].book_num = x3;
    axios.post("http://localhost:8088/car/upcar",JSON.stringify({
        book_name:res3[x].book_name,
        book_num:res3[x].book_num
    }),{
        headers:{
            'Content-Type':'application/json'
        }}).then(function (res){
        if(res.data.tokenId!=null){
            console.log(res.data.resultRE)
            var m = getElement("money")
            var mm = parseInt(m.innerHTML)
            var m3 = getElement("pri"+x)
            m3.innerHTML -=parseInt(res3[x].book_price)
            m.innerHTML =mm-parseInt(res3[x].book_price)
        }else {
        console.log(res.data.resultRE)
    }}).catch(function (err){
        console.log(err)
    })
}
//删除购物车商品
function  delcars(x){
    console.log(x)
    var ss = x[x.length-1]
    console.log(res3[ss].book_name)
        axios.post("http://localhost:8088/car/delcar",JSON.stringify({
            book_name:res3[ss].book_name
        }),{
            headers:{
                'Content-Type':'application/json'
            }}).then(function (res){
            if(res.data.tokenId!=null){
                for(var i = 1;i<=res3.length;i++) {
                    ds = "cr"+i
                    s = getElement(ds)
                    s.innerHTML = ""
                }
                alert(res.data.resultRE)
                getshowcar()
                getcarnum()
            }else {
                alert(res.data.resultRE)
            }
        }).catch(function (err){
            console.log(err)
        })
}
//结算当页的购物车
function payindexcar(){
        axios.post("http://localhost:8088/car/paycar").then(function (res){
            if(res.data.tokenId!=null){
                alert(res.data.resultRE)
                getcarnum()
                getshowcar()
                window.location.href="../templates/order.html"
            }else {
            alert(res.data.resultRE)
            }
        }).catch(function (err){
        console.log(err)
    })
}
//首页查询
function indexsearch(){
    var x = getElement("sear")
    var x_name = x.value
    console.log(x_name)
    if(x_name === ""){
        alert("请输入查询的书名")
    }else {
        axios.post("http://localhost:8088/search/getfn", x_name, {
            headers: {
                'Content-Type': 'application/json',
                'charset':'utf-8'
            }
        }).then(function (res) {
            if (res.data.tokenId != null) {
                window.location.href = "list.html"
            } else {
                alert(res.data.resultRE);
            }
        }).catch(function (err) {
            console.log(err)
        })
    }
}
//列表页展示
function  listgetshow(){
    var num = listnow
    axios.post("http://localhost:8088/search/getforname",num, {
        headers: {
            'Content-Type': 'application/json',
            'charset':'utf-8'
        }
    }).then(function (res){
        result1 = res.data
        if(result1!=null){
            for(var i = 0;i<result1.length;i++){
                var im = getElement("de"+(i+1));
                var n = getElement("dde"+(i+1))
                var p = getElement("dee"+(i+1))
                im.src = result1[i].book_url
                n.innerHTML = result1[i].book_name
                p.innerHTML = result1[i].book_price+"￥"
            }
        }else if(result1.length == 0) {
            alert("没有相关书籍");
        }

    }).catch(function (err){
        console.log(err)
    })
}
//获取总数
function getalllist(){
    axios.get("http://localhost:8088/search/ln").then(
        function (res){
            listall = res.data
            if(listall === 0) return
            listnum = listall%8 == 0 ? listall/8 : listall/8+1
            for(var j = 1;j<=listnum;j++){
                var ww = "ls"+j
                x1 = getElement(ww);
                x1.innerHTML =" "
            }
            if(listnum > 3 ){
                for(var i = 1;i<=3;i++){
                    var ww = "ls"+i
                    x1 = getElement(ww);
                    x1.innerHTML += "<a class='page-link' onclick='getindexlist(id)' id = '"+i+"'>"+i+"</a>"
                }
            }else {
                for (var j = 1; j <= listnum; j++) {
                    var ww = "ls" + j
                    x1 = getElement(ww);
                    x1.innerHTML += "<a  class='page-link' onclick='getindexlist(id)' id = '" + j + "'>" + j + "</a>"
                }
            }
        }
    ).catch(function (err){
        console.log(err)
    })
}
//列表页下一页
function listnext(){
        if(listnow > listall ){
            alert("最后一页了")
        }else {
            var x2 = parseInt(listnow)
            listnow = x2 + 1
            listgetshow()
        }
}
//列表页上一页
function  listearly(){
    if(listnow <= 1 ){
        alert("最前一页")
    }else {
        listnow -= 1
        listgetshow()
    }
}
//获取点击页
function getindexlist(x){
        listnow = x
        listgetshow()
}
//列表加入购物车
function listincar(x){
    var x2 = x[x.length-1]-1
    if(tookenid!=null && result1 != null){
    axios.post("http://localhost:8088/car/incar",JSON.stringify({
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
}
//列表购买
function listpay(x){
    var sl = result1[x[x.length-1]-1]
    sl.book_num = 1
    if(sl!=null){
    axios.post("http://localhost:8088/car/buy",JSON.stringify({
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
}
//列表页搜索
function listsearch(){
    var x = getElement("searb")
    var x_name = x.value
    console.log(x_name)
    if(x_name === ""){
        alert("请输入查询的书名")
    }else {
        axios.post("http://localhost:8088/search/getfn", x_name, {
            headers: {
                'Content-Type': 'application/json',
                'charset':'utf-8'
            }
        }).then(function (res) {
            if (res.data.tokenId != null) {
                 listgetshow()
            } else {
                alert(res.data.resultRE);
            }
        }).catch(function (err) {
            console.log(err)
        })
    }
}
//价格区间
function forprice(x){
    var min = x
   axios.post("http://localhost:8088/search/getforprice",min,{
       headers: {
           'Content-Type': 'application/json',
           'charset':'utf-8'
       }
   }).then(function (res){
       result1 = res.data
       console.log(result1)
       for(var i = 0;i<=7;i++){
           var im = getElement("de"+(i+1));
           var n = getElement("dde"+(i+1))
           var p = getElement("dee"+(i+1))
           im.src = "Image/default.jpg"
           n.innerHTML = ""
           p.innerHTML = ""
       }
       for(var i = 0;i<result1.length;i++){
           console.log("wwwwwwwwwwwwwwww")
           console.log(result1[i+1])
           var im = getElement("de"+(i+1));
           var n = getElement("dde"+(i+1))
           var p = getElement("dee"+(i+1))
           im.src = result1[i].book_url
           n.innerHTML = result1[i].book_name
           p.innerHTML = result1[i].book_price+"￥"
       }
   }).catch(function (err){
       console.log(err)
   })
}