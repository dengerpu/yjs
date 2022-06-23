window.onload = function(){
    //Tab栏切换
    var login = document.getElementById('login')
    var register = document.getElementById('register')
    var login_box = document.getElementById('login_box')
    var register_box = document.getElementById('register_box')
    // console.log(login)
    login.onclick = function(){
        login.setAttribute('style','border-bottom:3px solid #ff5c00;')
        login_box.style.display = 'block'
        register.setAttribute('style','border-bottom:0px solid #ff5c00;')
        register_box.style.display = 'none'
    }
    register.onclick = function(){
        login_box.style.display = 'none'
        login.setAttribute('style','border-bottom:0px solid #ff5c00;')
        register_box.style.display = 'block'
        register.setAttribute('style','border-bottom:3px solid #ff5c00;')
    }

    var flag1 = false
    var flag2 = false

    //用户名输入框聚焦事件
    var user_input = document.querySelector('#user_input')
    var email_tip = document.getElementById('email_tip')
    var e_tip = document.getElementById('e_tip')  //邮箱合法提示
    user_input.onfocus = function(){
    user_input.setAttribute('style','background-color:#FCF2F3; border-color:#ff5c00;box-shadow: 0 0 0 2px rgb(255 92 0 / 20%);')
    email_tip.setAttribute('style','top:5px;font-size:12px;color:#ff5c00;transition-timing-function: ease-in;') 
    }
    email_tip.onclick = function(){
        user_input.focus()
    }
    user_input.onblur = function(){
        if (this.value.length == 0){
            e_tip.style.display = 'block'
            e_tip.innerText = '请输入账号'
            flag1 = false
        }else{
            if(/^[\w\-\.]{5,}\@[\w]+\.[\w]{2,4}$/.test(this.value)){
                user_input.setAttribute('style','background-color:#F9F9F9')
                email_tip.setAttribute('style','top:5px;font-size:12px;color:#666666;transition-timing-function: ease-in;')
                e_tip.style.display = 'none'
                flag1 = true
            }else{
                e_tip.style.display = 'block'
                e_tip.innerText = '邮箱不合法'
                flag1 = false
            }
        }
    }

    //密码输入框聚焦事件
    var pwd_input = document.querySelector('#pwd_input')
    var pwd_tip = document.getElementById('pwd_tip')  
    var p_tip = document.getElementById('p_tip') //密码错误信息提示
    pwd_input.onfocus = function(){
        pwd_input.setAttribute('style','background-color:#FCF2F3; border-color:#ff5c00;box-shadow: 0 0 0 2px rgb(255 92 0 / 20%);')
        pwd_tip.setAttribute('style','top:5px;font-size:12px; color:#ff5c00;transition-timing-function: ease-in;') 
    }
    pwd_tip.onclick = function(){
        pwd_input.focus()
    }
    //离开输入框
    pwd_input.onblur = function(){
        if (this.value.length == 0){
            p_tip.style.display = 'block'
            p_tip.innerText = '请输入密码'
            flag2 = false
        }else if(this.value.length<6 || this.value.length>18){
            p_tip.style.display = 'block'
            p_tip.innerText = '密码长度应该在6-18位'
            flag2 = false
        }
        else{
            if(/^[a-zA-Z0-9_\-$]{6,18}$/.test(this.value)){
                pwd_input.setAttribute('style','background-color:#F9F9F9;')
                pwd_tip.setAttribute('style','top:5px;font-size:12px;color:#666666;transition-timing-function: ease-in;')
                p_tip.style.display = 'none'
                flag2 = true
            }else{
                p_tip.style.display = 'block'
                p_tip.innerText = '密码不合法，提示：不能包含特殊字符'
                flag2 = false
            }
        }
    }


    $('#loginform').on('submit',function(){
        if (flag1&&flag2){
            var params = serializeObject($(this))
            console.log(params)
            $.ajax({
                type:'post',
                url:'http://localhost:8080/xmlogin',
                data:params,
                contentType: 'application/json',
                success:function(res){
                    if (res.status == 200){
                        alert('登陆成功')
                    }else{
                        alert('登录失败，用户名或者面错误')
                    }
                }
            })
        }else{
            alert('输入的信息不合法')
        }
        return false
    })

    //将表单中用户输入的内容转化为对象类型
    function serializeObject(obj){
        //处理结果对象
        var result = {}
        var params = obj.serializeArray()
        //循环数组，将数组转换为对象类型
        $.each(params, function(index, value){
            result[value.name] = value.value
        })
        return result
    }
}
