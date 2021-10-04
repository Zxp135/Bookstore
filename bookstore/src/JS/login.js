var base_url = "http://localhost:8088"
var base_PageUrl = "../static/"
var result = null;
var tookenid = null
var U_name = null;
function  getElement(x){    //获取组件
    return document.getElementById(x)
}
function  toPage(url){     //页面跳转
    window.location.href = url
}
function gettoken(){
    console.log(U_name)
    axios.post(base_url+"/u/getid",JSON.stringify({
        username:U_name
    }),{
        headers:
            {
                'Content-Type':'application/json'
            }
    }).then(function (response){
            result = response.data
            tookenid = result.tokenId
            U_name = result.username
        }).catch(function (error){
            console.log(error)
        })
}
function getOrdr(){
        if(tookenid != null){
            window.location.href = "../templates/order.html"
        }else {
            alert("请登录")
        }
}
function login(){//登录
    console.log(tookenid)
    if(tookenid == null){
    var url = base_url + "/u/login"
    var u = getElement("uname");
    var p = getElement("upass");
    if( u.value ==="" || p.value==="" ){
        alert("请输入完整")
    }else {
        axios.post(url, {
            username: u.value,
            password: p.value
    })
            .then(function (response) { //成功
                result = response.data
                if(result.tokenId === null){
                    alert(result.code+result.resultRE)
                }else {
                    U_name = result.username;
                    console.log(U_name)
                    tookenid = result.tokenId
                    alert(result.code+result.resultRE)
                    toPage(base_PageUrl+"index.html")
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
function registry(){  //注册
    var url = base_url+"/u/reginstry"
    var u = getElement("Username")
    var p = getElement("Password")
    var ph = getElement("U_phone")
    var em = getElement("U_email")
    if(u.value===""||p.value===""||ph.value===""||em.valueOf()==="")
        alert("请输入完整")
    else {
    axios.post(url, JSON.stringify({
        username:u.value,
        password:p.value,
        u_phone:ph.value,
        e_mail:em.value,
        sex:"男"
    }),{
       headers:
           {
           'Content-Type':'application/json'
             }
        })
        .then(function (response) { //成功
            result = response.data;
            if(result.code === 300) {
                alert(result.resultRE)
                toPage(url + "index.html")
            }
            else {
                alert(result.resultRE)
            }
        })
        .catch(function (error) {   //失败
            console.log(error);
        });
    }
}
function loginout(){//退出
    console.log(tookenid)
    if(tookenid === null){
        alert("还未登录")
    }else {
    if(confirm("是否退出？")){
        console.log(result)
        axios.post(base_url+"/u/loginout",JSON.stringify({
            username:result.username,
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
                window.location.href="../static/index.html"
            })
            .catch(function (error){
                console.log(error)
            })

    }else {}
    }
}
function  getUserinfo(){  //记录登录
    var indexdis = "未登录";
    var titlename = getElement("dis_name")
    axios.get(base_url+"/u/getname").then(function (response){
        result = response.data
        if(result !="fail"){
            console.log(result+"xxs1")
            U_name = result
            titlename.style.color = "red"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = result
            console.log(U_name)
        }else {
            titlename.style.color = "grey"
            titlename.style.fontSize="17px"
            titlename.style.fontFamily="楷体"
            titlename.innerHTML = indexdis
            result = null
        }

    }).catch(function (error){
        titlename.style.color = "grey"
        titlename.style.fontSize="17px"
        titlename.style.fontFamily="楷体"
        titlename.innerHTML = "网络异常"
        result = null
        console.log(error)
    })
}
function toScar(){
    if(tookenid === null){
        alert("请登录");
    }else {
        window.location.href=base_PageUrl+"shopCar.html"
    }
}
