var base_url = "http://localhost:8088"
var base_PageUrl = "../static/"
var result = null;
var tookenid = null
var U_name = null;
var Order_num = 0;   //订单总数
var nowpage = 1;  //当前页
var All_page = 1; //总页数
function  getElement(x){    //获取组件
    return document.getElementById(x)
}
function wait(){ //等待功能加强
    alert("正在加紧制作中!敬请期待!")
}
//获取订单数量
function getOrderNum(){
    axios.get(base_url+"/o/getnum").then(function (response){
        Order_num =  response.data;
        var x1
        All_page = Order_num%5 == 0 ? Order_num/5 : Order_num/5+1
        for(var j = 1;j<=All_page;j++){
            var ww = "lw"+j
            x1 = getElement(ww);
            x1.innerHTML =" "
        }
        if(All_page > 3 ){
        for(var i = 1;i<=3;i++){
            var ww = "lw"+i
           x1 = getElement(ww);
           x1.innerHTML += "<a class='page-link' onclick='tes2(id)' id = '"+i+"'>"+i+"</a>"
        }
    }else {
            for(var j = 1;j<=All_page;j++){
                var ww = "lw"+j
                x1 = getElement(ww);
                x1.innerHTML += "<a  class='page-link' onclick='tes2(id)' id = '"+j+"'>"+j+"</a>"
            }
        }
        console.log(Order_num)
    }).catch(function (error){
        console.log(error)
    })
}
//点击页
function tes2(x){
    console.log(x)
    var ss = x
    nowpage = ss
    tes()
}
//下一页
function nextpage(){
    if(nowpage > All_page){
        alert("最后一页")
    }else {
        var d = parseInt(nowpage)
    nowpage = d + 1
        console.log(nowpage)
    tes()
    }
}
//上一页
function  earlypage(){
    if (nowpage <= 1){
        nowpage = 1
        alert("第一页了")
    }else {
    nowpage -= 1

    tes()
    }
}
//获取当前页订单
function tes(nowpage){
    var x = (nowpage-1)*5
    axios.post(base_url+"/o/getorder",JSON.stringify({
       page_num : x,
        u_id:"sss"
   }),{
       headers:
           {
               'Content-Type':'application/json'
           }
   }).then(function (response){
       result  =response.data
        var x = getElement("Uer_Order")
        x.innerHTML = " "
       for(var i = 0;i<result.length;i++){
           x.innerHTML +=
               "<tr id='"+result[i].num+"' className='table-info' style='text-align: center' > <td><img style='height: 40px;width: 50px' src='../static/"+result[i].book_url+"'/><br><a>"+result[i].order_num+"</a></td><td><a>"+result[i].order_time+"</a></td><td><a>"+result[i].book_num+"</a></td><td><a>"+result[i].book_name+"</a></td><td><a>"+result[i].book_price+"</a></td><td><a>"+result[i].order_pay+"</a></td><td><button type='button' id='"+result[i].order_num+"' onclick='delorder(id)' className='btn btn-outline-dark'>删除</button>"+"</td></tr>"
       }
       getOrderNum()
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
   })
}
function getOrder(){
    if(tookenid != null){
        window.location.href = "../templates/order.html"
    }else {
        alert("请登录")
    }
}
function page(){
    window.location.href="order.html"
}
function gettoken2(){
    var username = U_name
    console.log(username+"wwwwwww")
    if(U_name!=null){
    axios.post(base_url+"/u/getid",username,{
        headers:
            {
                'Content-Type':'application/json'
            }
    }).then(function (response){
        console.log(response)
        result = response.data
        tookenid = result.tokenId
        U_name = result.username
    }).catch(function (error){
        console.log(error)
    })}
}
function  toPage(url){     //页面跳转
    window.location.href = url
}
function  getUserinfo(){  //记录登录
    var indexdis = "未登录";
    var titlename = getElement("dis_name")
    axios.get(base_url+"/u/getname").then(function (response){
        result = response.data
        if(result !="fail"){
            U_name = result
            console.log(U_name+"wsssss")
            titlename.style.color = "red"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = result
            gettoken2()
        }else {
            titlename.style.color = "grey"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = indexdis
            result = null
        }

    }).catch(function (error){
        console.log(error)
    })
}
function loginout2(){ //退出
    if(tookenid === null){
        alert("请先登录")
        window.location.href="../static/login.html"
    }else {
        if(confirm("是否退出？")){
            console.log(result)
            axios.post(base_url+"/u/loginout",JSON.stringify({
                username:U_name
            }),{
                headers:
                    {
                        'Content-Type':'application/json'
                    }
            })
                .then(function (response){
                    result = response.data
                    alert(result.code+result.resultRE)
                    result = null
                    tookenid = null;
                    window.location.href ="../static/index.html"
                })
                .catch(function (error){
                    console.log(error)
                })

        }else {}
    }
}
function toScar2(){
    if(tookenid === null){
        alert("请登录");
    }else {
        window.location.href="../static/shopCar.html"
    }
}
//删除订单
function delorder(x){
    console.log(x)
    var orderid =  x
    if(confirm("是否删除？")){
        axios.post(base_url+"/o/delorder",orderid,{
            headers:
                {
                    'Content-Type':'application/json'
                }
        }).then(function (res){
            if(res.data != null){
                console.log(res.data)
                   if(res.data.tokenId!=null){
                        tes()
                       getOrderNum()
                        alert("删除成功")
                    }else {
                       alert("删除失败")
                   }
            }
        }).catch(function (err){
            console.log(err)
        })}else {

    }
}
