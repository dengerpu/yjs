<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>商品列表</el-breadcrumb-item>
    </el-breadcrumb>
    <vue-tinymce v-model="content" :setting="setting" />
  </el-card>
</template>

<script>
export default {
  name: 'Goods',
  data() {
    return {
      content: '',
      setting: {
        inline: false, // 设置内敛模式
        menubar: true, // 隐藏菜单栏
        // autosave_restore_when_empty: true,
        //  save_enablewhendirty : true,
        // min_height: 10000,
        autoresize_on_init: false,
        toolbar:
          'code undo redo restoredraft | cut copy paste pastetext | forecolor backcolor bold italic underline strikethrough link anchor | alignleft aligncenter alignright alignjustify outdent indent | \
        styleselect formatselect fontselect fontsizeselect | bullist numlist | blockquote subscript superscript removeformat | \
        table image media charmap emoticons hr pagebreak insertdatetime print preview | fullscreen | bdmap indent2em lineheight formatpainter axupimgs | myUpload | uploadimage',
        //工具栏，根据需要写对应的工具名称，顺序及分割线等等，这里的最后的 ‘myUpload’ 是下面setup里的自定义插件
        toolbar_mode: 'sliding', // 工具栏模式，这里是滑行模式（当屏幕过小时，多余的工具会隐藏，点击更多按钮会出现其他工具，这里配置出现的特效）
        // plugins:
        //   "print preview searchreplace autolink directionality visualblocks visualchars fullscreen image imagetools  link media template code codesample table charmap hr pagebreak nonbreaking anchor insertdatetime advlist lists wordcount imagetools textpattern help emoticons autosave bdmap indent2em autoresize formatpainter axupimgs uploadimage", // 需要用到的功能插件，如链接，列表等等
        plugins: 'link image media table lists fullscreen quickbars',
           language: 'zh_CN', // 语言，汉化
        height: 350,
        branding: false, // 隐藏品牌，隐藏状态栏中显示的“ Powered by Tiny ”链接
        resize: false, // 是否可以缩放编辑器
        elementpath: false, // 在编辑器底部的状态栏中禁用元素路径。
        fixed_toolbar_container: '#tinymceToolbar', // 可以设置元素选择器指定工具栏嵌套在哪个元素里面
        custom_ui_selector: 'body', // 聚焦的元素
        noneditable_noneditable_class: 'mceNonEditable', // 使用此选项，您可以指定TinyMCE将使用的类名称，以确定使用noneditable插件时可编辑哪些内容区域。主要用入你想以代码的形式添加某些内容，并给这些内容设置类名，使他们不可编辑，只能整个删除
        images_upload_url: '/demo/upimg.php',
        images_upload_base_path: '/demo',
        init_instance_callback: (editor) => {
          editor.focus() // 初始化聚焦，让内联模式的编辑器工具显示
        },
      },
    }
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>