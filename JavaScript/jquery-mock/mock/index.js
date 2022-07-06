if (MOCK == 'true') {
    Mock.mock('/user/userInfo', 'get', {
        id: "@id()", //得到随机的id
        username: "@cname()", //随机生成中文名字
        date: "@date()", //随机生成日期
        avator: "@image('200x200','#50B347','#fff','avatar')", //生成图片，参数：size,background,foreground,text
        description: "@paragraph()", //描述
        ip: "@ip()", //IP地址
        email: "@email()" //email
    })
}

