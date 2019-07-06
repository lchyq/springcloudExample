这是一个springCloud项目
1.编写springBoot版hello world,编写自测代码
2.增加天气预报系统子模块
3.增加根据城市id和城市名称获取天气信息的接口
4.使用redis缓存系统（单实例）来缓存天气数据，避免频繁调用第三方接口












疑问部分
1.了解一下mockMvc的作用
2.springBoot内置jacson序列化框架。
可以直接使用objectMapper来将json数据转化为对应的bean对象，需要注意属性名称需要一一对应
3.redis3.x版本可能链接时会出现保护模式，启动时使用 --protected-mode no参数即可