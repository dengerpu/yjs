window.onload = function() {
    var nav_left = document.getElementById('nav_left')
    var nav_item_box = document.getElementById('nav_item_box')
    nav_left.onmouseover = function() {
        nav_item_box.style.display = "block"
    }
    nav_left.onmouseout = function() {
        nav_item_box.style.display = "none"
    }

    //监听浏览器滚动事件
    window.onscroll = function(){
        var top=document.documentElement.scrollTop || document.body.scrollTop;
        var nav=document.getElementById('nav')
        // console.log(nav)
        if(top>=170){
           nav.classList.add("navmove")
        }else{
            nav.classList.remove("navmove")
        }
    }
}